package com.capgemini.employeepayroll.models;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

/**
 * User Model class for system-user details
 *
 * @author Harshit Chheda
 * @date 2020/12/13
 */
@Entity
@Table(name = "admin_dtls")
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "last_updated")
    private Date lastUpdated;

    @Column(name = "is_active")
    private int isActive;

}
