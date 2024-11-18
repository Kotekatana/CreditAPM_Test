package ru.test.creditapm.repositories.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.springframework.stereotype.Repository;
import ru.test.creditapm.EntityProvider.EntityManagerProvider;
import ru.test.creditapm.models.CreditContract;
import ru.test.creditapm.models.CreditRequest;

import java.util.List;
@Repository
public class CreditRequestRepository implements ru.test.creditapm.repositories.CreditRequestRepository {
    private final EntityManager entityManager = EntityManagerProvider.getEntityManager();
    @Override
    public void save(CreditRequest entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
    }

    @Override
    public List<CreditRequest> findAll() {
        return entityManager.createQuery("select creditRequest from CreditRequest creditRequest",CreditRequest.class).getResultList();
    }

    @Override
    public CreditRequest findById(Long id) {
        return entityManager.find(CreditRequest.class, id);
    }

    public List<CreditRequest> findApprovedRequests(){
        return entityManager.createQuery("select cr from CreditRequest cr where cr.isApproved = :isApproved",CreditRequest.class).setParameter("isApproved",true).getResultList();
    }
}
