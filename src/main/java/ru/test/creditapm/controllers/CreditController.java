package ru.test.creditapm.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.test.creditapm.DTO.FormData;
import ru.test.creditapm.models.CreditContract;
import ru.test.creditapm.models.CreditRequest;
import ru.test.creditapm.models.User;
import ru.test.creditapm.models.Work;
import ru.test.creditapm.repositories.UsersRepository;
import ru.test.creditapm.repositories.WorksRepository;
import ru.test.creditapm.services.CreditService;
import ru.test.creditapm.services.UsersService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class CreditController {
    @Autowired
    CreditService creditService;
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    WorksRepository worksRepository;
    @GetMapping("/createCreditRequest")
    public String getCreationCreditPage(Model model){
        return "create_credit_request_page";
    }

    @PostMapping("/createCreditRequest")
    public String createCreditRequest(@ModelAttribute FormData formData){
        creditService.saveCreditRequest(formData);
        return "create_credit_request_page";
    }
    @GetMapping("/approvedCreditRequest")
    public String getApprovedCreditRequest(Model model){
        List<CreditRequest> creditRequestList = creditService.getApprovedCreditRequests();
        model.addAttribute("creditRequestList", creditRequestList);
        return "credit_requests_page";
    }

    @GetMapping("/creditContracts")
    public String getUnsignedCreditContracts(Model model){
        List<CreditContract> creditContractList = creditService.getUnsignedCreditContracts();
        model.addAttribute("creditContractsList", creditContractList);
        return "credit_contracts_page";
    }
    @GetMapping("/creditContracts/{id}/sign")
    public String signContract(@PathVariable("id") Long id, Model model){
        creditService.signContract(id);
//        List<CreditContract> creditContractList = creditService.getUnsignedCreditContracts();
//        model.addAttribute("creditContractsList", creditContractList);
        return "redirect:/creditContracts";
    }
}