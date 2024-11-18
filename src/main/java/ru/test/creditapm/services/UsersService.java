package ru.test.creditapm.services;

import ru.test.creditapm.models.User;

import java.util.List;

public interface UsersService {
    public List<User> getAllUsers();

    public List<User> getUsersByParams(String firstName, String lastName, String patronymic, Integer contactPhoneNumber, Integer passportNumber);

}
