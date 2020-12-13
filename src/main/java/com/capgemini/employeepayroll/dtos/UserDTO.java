package com.capgemini.employeepayroll.dtos;

import lombok.Getter;

import javax.validation.constraints.NotNull;

/**
 * UserDTO class for receiving/forwarding required fields of system-user as request/response
 *
 * @author Harshit Chheda
 * @date 2020/12/13
 */
@Getter
public class UserDTO {

    @NotNull
    private String userName;
    @NotNull
    private String password;
}
