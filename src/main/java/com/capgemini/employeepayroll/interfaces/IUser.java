package com.capgemini.employeepayroll.interfaces;

import com.capgemini.employeepayroll.dtos.UserDTO;
import com.capgemini.employeepayroll.utils.Response;

/**
 * IUser interface for valid-system user related methods
 *
 * @author Harshit Chheda
 * @date 2020/12/13
 */
public interface IUser {

    /**
     * Method for handling login process for valid user
     *
     * @return Response object
     */
    Response loginUser(UserDTO userDTO);
}
