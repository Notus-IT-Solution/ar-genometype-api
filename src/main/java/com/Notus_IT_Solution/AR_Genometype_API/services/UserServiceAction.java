package com.Notus_IT_Solution.AR_Genometype_API.services;

import com.Notus_IT_Solution.AR_Genometype_API.entity.Users;
import com.Notus_IT_Solution.AR_Genometype_API.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserServiceAction implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceAction(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Users findById(long id) {
        Optional<Users> user = userRepository.findById(id);
        Users data = null;
        if (user.isPresent()) {
            data = user.get();
        } else {
            throw new RuntimeException("User not found");
        }
        return data;
    }

    @Override
    public List<Users> findRandomUsers() {
        int getRandomUser = 5;
        List<Users> randomUserList = new ArrayList<>();
        List<Users> allUsers = userRepository.findAll();
        int totalUserSize = allUsers.size();
        Random random = new Random();

        while (randomUserList.size() < getRandomUser) {
            Users randomUser = allUsers.get(random.nextInt(totalUserSize));
            if (!randomUserList.contains(randomUser)) {
                randomUserList.add(randomUser);
            }
        }
        return randomUserList;
    }

    @Override
    public Users save(Users user) {
        return userRepository.save(user);
    }
}


