package ru.test.creditapm.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.test.creditapm.models.User;
import ru.test.creditapm.repositories.UsersRepository;
import ru.test.creditapm.services.UsersService;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersRepository usersRepository;
    @Override
    public List<User> getAllUsers(){
        return usersRepository.findAll();
    }

    @Override
    public List<User> getUsersByParams(String firstName, String lastName, String patronymic, Integer contactPhoneNumber, Integer passportNumber) {
        return usersRepository.findAllByParams(firstName,lastName,patronymic,contactPhoneNumber,passportNumber);
    }



}
