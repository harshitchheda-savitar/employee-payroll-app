package com.capgemini.employeepayroll.utils;

import com.capgemini.employeepayroll.exceptions.JWTException;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.function.Function;

/**
 * TokenHelper class for generating and validating jwt tokens for autherization purpose
 *
 * @author Harshit Chheda
 * @date 2020/12/13
 */
public class TokenHelper {

    @Autowired
    private Environment environment;

    public String generateToken(String id, String issuer, String subject, long ttlMillis) {

        // The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        // We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(environment.getProperty("token.key"));
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        // Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now).setSubject(subject).setIssuer(issuer)
                .signWith(signatureAlgorithm, signingKey);

        // if it has been specified, let's add the expiration
        if (ttlMillis > 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        // Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }

    private Claims extractAllClaims(String token) {
        try {
            if (token == null)
                throw new RequiredTypeException(token);
            return Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(environment.getProperty("token.key"))).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException ex) {
            throw new JWTException(HttpStatus.UNAUTHORIZED.value(), Message.JWT_TOKEN_EXPIRED);
        } catch (RequiredTypeException reqEx) {
            throw new JWTException(HttpStatus.UNAUTHORIZED.value(), Message.JWT_TOKEN_REQUIRED);
        } catch (Exception e) {
            throw new JWTException(HttpStatus.UNAUTHORIZED.value(), Message.INVALID_JWT_TOKEN);
        }
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String extractId(String token) {
        return extractClaim(token, Claims::getId);
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public boolean validateToken(String token) {
        return !isTokenExpired(token);
    }
}
