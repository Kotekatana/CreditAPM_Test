package ru.test.creditapm.repositories.Impl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.test.creditapm.EntityProvider.EntityManagerProvider;
import ru.test.creditapm.models.Work;
import ru.test.creditapm.repositories.WorksRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class WorksRepositoryJpaImpl implements WorksRepository {
    private final EntityManager entityManager = EntityManagerProvider.getEntityManager();
    @Override
    public void save(Work entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
    }

    @Override
    public List<Work> findAll() {
        return entityManager.createQuery("select work from Work work", Work.class).getResultList();
    }

    @Override
    public Work findById(Long id) {
        return entityManager.find(Work.class, id);
    }
}
