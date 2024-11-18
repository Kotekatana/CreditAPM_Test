package ru.test.creditapm.repositories;

import ru.test.creditapm.models.User;

import java.util.List;

public interface UsersRepository extends CrudRepository<User>{
    List<User> findAllByParams (String firstName, String lastName, String patronymic, Integer contactPhoneNumber, Integer passportNumber);

    User findByPassportNumber(Integer passportNumber);
}
