package ru.test.creditapm.repositories;

import ru.test.creditapm.models.CreditContract;

import java.util.List;

public interface CreditContractRepository extends CrudRepository<CreditContract>{
    List<CreditContract> findUnsignedCreditContracts();
}
