package ru.test.creditapm.repositories.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.test.creditapm.EntityProvider.EntityManagerProvider;
import ru.test.creditapm.models.User;
import ru.test.creditapm.repositories.UsersRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UsersRepositoryJpaImpl implements UsersRepository {

    private final EntityManager entityManager = EntityManagerProvider.getEntityManager();

    private  static final String SQL_SELECT_ALL = "select u from User u";

    @Override
    public void save(User entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery(SQL_SELECT_ALL,User.class).getResultList();
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> findAllByParams(String firstName, String lastName, String patronymic, Integer contactPhoneNumber, Integer passportNumber) {
        String resultQuery ="select u from User u " +
                "where u.firstName like :firstName " +
                "and u.lastName like :lastName " +
                "and u.patronymic like :patronymic ";

        if (contactPhoneNumber != null){
            resultQuery += "and u.contactPhoneNumber = :contactPhoneNumber ";
        }
        if (passportNumber != null){
            resultQuery += "and u.passport = :passportNumber";
        }

        Query query = entityManager.createQuery(resultQuery,User.class)
                .setParameter("firstName","%"+firstName+"%")
                .setParameter("lastName","%"+lastName+"%")
                .setParameter("patronymic","%"+patronymic+"%");

        if (contactPhoneNumber != null){
            query.setParameter("contactPhoneNumber",contactPhoneNumber);
        }
        if (passportNumber != null){
            query.setParameter("passportNumber",passportNumber);
        }
        return query.getResultList();
    }

    @Override
    public User findByPassportNumber(Integer passportNumber) {
        String query ="select user from User user where user.passport = :passportNumber";
        User user = null;
        try{
            user = entityManager.createQuery(query,User.class).setParameter("passportNumber",passportNumber).getSingleResult();
        }catch (NoResultException e){

        }

        return user;

    }

}
