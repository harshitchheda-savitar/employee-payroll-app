package com.capgemini.employeepayroll.services;

import com.capgemini.employeepayroll.dtos.UserDTO;
import com.capgemini.employeepayroll.interfaces.IUser;
import com.capgemini.employeepayroll.models.User;
import com.capgemini.employeepayroll.repositories.UserRepository;
import com.capgemini.employeepayroll.utils.Constants;
import com.capgemini.employeepayroll.utils.Message;
import com.capgemini.employeepayroll.utils.Response;
import com.capgemini.employeepayroll.utils.TokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * UserService class for service related to system-users
 *
 * @author Harshit Chheda
 * @date 2020/12/13
 */
@Service
public class UserService implements IUser {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenHelper tokenHelper;

    @Autowired
    private Environment environment;

    /**
     * Service method for fetching active system-user details while login and generating jwt-token for future authorization
     *
     * @return Response object containing jwt-authorization token
     */
    @Override
    public Response loginUser(UserDTO userDTO) {
        Optional<User> user = userRepository.findFirstByUserNameAndPasswordAndIsActive(userDTO.getUserName(), userDTO.getPassword(), Constants.ONE);
        if (!user.isPresent())
            return new Response(HttpStatus.NO_CONTENT.value(), Message.USER_NOT_FOUND);

        String jwtTokenString = tokenHelper.generateToken(user.get().getId() + user.get().getUserName(), environment.getProperty("token.issuer"), environment.getProperty("token.subject"), Long.parseLong(environment.getProperty("token.expirationTime")));
        return  new Response(HttpStatus.OK.value(), jwtTokenString, Message.USER_LOGGED_IN);
    }
}
