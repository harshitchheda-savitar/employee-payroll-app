package com.capgemini.employeepayroll.dtos;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * UserDTO class for receiving/forwarding required fields of system-user as request/response
 *
 * @author Harshit Chheda
 * @date 2020/12/13
 */
@Getter
public class UserDTO {

    @NotNull
    @Size(min = 4, message = "Username cannot  be less than 4 characters")
    private String userName;
    @NotNull
    @Size(min = 4, message = "Password cannot  be less than 4 characters")
    private String password;
}
