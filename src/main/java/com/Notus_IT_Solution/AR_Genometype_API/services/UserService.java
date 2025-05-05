package com.Notus_IT_Solution.AR_Genometype_API.services;

import com.Notus_IT_Solution.AR_Genometype_API.entity.Users;

import java.util.List;

public interface UserService {
    List<Users> findAll();
    Users findById(long id);
    List<Users> findRandomUsers(int num);
    Users findRandomUser();
    Users save(Users user);

}
