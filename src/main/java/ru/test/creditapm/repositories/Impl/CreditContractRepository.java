package ru.test.creditapm.repositories.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.springframework.stereotype.Repository;
import ru.test.creditapm.EntityProvider.EntityManagerProvider;
import ru.test.creditapm.models.CreditContract;
import ru.test.creditapm.models.User;

import java.util.List;
@Repository
public class CreditContractRepository implements ru.test.creditapm.repositories.CreditContractRepository {
    private final EntityManager entityManager = EntityManagerProvider.getEntityManager();
    @Override
    public void save(CreditContract entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
    }

    @Override
    public List<CreditContract> findAll() {
        return entityManager.createQuery("select creditContract from CreditContract creditContract",CreditContract.class).getResultList();
    }

    @Override
    public CreditContract findById(Long id) {
        return entityManager.find(CreditContract.class, id);
    }

    @Override
    public List<CreditContract> findUnsignedCreditContracts() {
        return entityManager.createQuery("select cc from CreditContract cc where cc.isSigned = :signed",CreditContract.class).setParameter("signed",false).getResultList();
    }
}
