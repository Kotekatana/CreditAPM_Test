package ru.test.creditapm.services;

import ru.test.creditapm.DTO.FormData;
import ru.test.creditapm.models.CreditContract;
import ru.test.creditapm.models.CreditRequest;

import java.util.List;

public interface CreditService {
    void saveCreditRequest(FormData formData);
    List<CreditRequest> getApprovedCreditRequests();
    List<CreditContract> getUnsignedCreditContracts();
    void signContract(Long id);
    void createCreditContract(CreditRequest creditRequest);
    Integer calcApprovedAmount();
    Integer calcApprovedDaysPeriod();

    Boolean approveOrDeny();
}
