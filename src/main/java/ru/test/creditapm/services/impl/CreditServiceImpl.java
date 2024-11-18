package ru.test.creditapm.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.test.creditapm.DTO.FormData;
import ru.test.creditapm.models.CreditContract;
import ru.test.creditapm.models.CreditRequest;
import ru.test.creditapm.models.User;
import ru.test.creditapm.models.Work;
import ru.test.creditapm.repositories.CreditContractRepository;
import ru.test.creditapm.repositories.CreditRequestRepository;
import ru.test.creditapm.repositories.UsersRepository;
import ru.test.creditapm.services.CreditService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CreditServiceImpl implements CreditService {
    @Autowired
    private CreditRequestRepository creditRequestRepository;
    @Autowired
    private CreditContractRepository creditContractRepository;
    @Autowired
    private UsersRepository usersRepository;
    private final Random random = new Random();
    @Override
    public List<CreditRequest> getApprovedCreditRequests(){
        return creditRequestRepository.findApprovedRequests();
    }
    @Override
    public List<CreditContract> getUnsignedCreditContracts(){
        return creditContractRepository.findUnsignedCreditContracts();
    }
    @Override
    public void signContract(Long id) {
        CreditContract creditContract = creditContractRepository.findById(id);
        creditContract.setIsSigned(true);
        creditContractRepository.save(creditContract);
    }
    @Override
    public void saveCreditRequest(FormData formData) {
        User user = usersRepository.findByPassportNumber(formData.getPassport());
        CreditRequest creditRequest;

        if (user != null){
            user.setFirstName(formData.getFirstName());
            user.setLastName(formData.getLastName());
            user.setPatronymic(formData.getPatronymic());
            user.setMaritalStatus(formData.getMaritalStatus());
            user.setContactPhoneNumber(formData.getContactPhoneNumber());
            user.setAddress(formData.getAddress());
        }else {
           user = User.builder()
                .firstName(formData.getFirstName())
                .lastName(formData.getLastName())
                .patronymic(formData.getPatronymic())
                .passport(formData.getPassport())
                .maritalStatus(formData.getMaritalStatus())
                .contactPhoneNumber(formData.getContactPhoneNumber())
                .address(formData.getAddress())
                .build();
        }

        Work work = Work.builder()
                .user(user)
                .companyName(formData.getCompanyName())
                .position(formData.getPosition())
                .dateWorkFrom(formData.getDateWorkFrom())
                .dateWorkTo(formData.getDateWorkTo())
                .build();

        List<Work> workList = new ArrayList<>();
        workList.add(work);

        user.setWorkList(workList);

        creditRequest = CreditRequest.builder()
                .user(user)
                .requestDate(LocalDate.now())
                .desiredAmount(formData.getDesiredAmount())
                .isApproved(this.approveOrDeny())
                .build();

        if(creditRequest.getIsApproved()){
            this.createCreditContract(creditRequest);
        }
        creditRequestRepository.save(creditRequest);
    }
    @Override
    public void createCreditContract(CreditRequest creditRequest){
        CreditContract creditContract = CreditContract.builder()
                .isSigned(false)
                .creditRequest(creditRequest)
                .approvedDaysPeriod(this.calcApprovedDaysPeriod())
                .approvedAmount(this.calcApprovedAmount())
                .build();

        creditContractRepository.save(creditContract);
    }
    @Override
    public Integer calcApprovedAmount(){
        return  random.nextInt(200000+1-1000)+1000;
    }
    @Override
    public Integer calcApprovedDaysPeriod(){
        return (random.nextInt(12)+1)*30;
    }
    @Override
    public Boolean approveOrDeny(){
        return random.nextBoolean();
    }

}
