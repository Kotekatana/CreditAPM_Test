package ru.test.creditapm.repositories;

import ru.test.creditapm.models.CreditRequest;

import java.util.List;

public interface CreditRequestRepository extends CrudRepository<CreditRequest> {
    List<CreditRequest> findApprovedRequests();
}
