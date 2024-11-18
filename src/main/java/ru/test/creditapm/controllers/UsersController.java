package ru.test.creditapm.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import ru.test.creditapm.DTO.FormData;
import ru.test.creditapm.models.User;
import ru.test.creditapm.services.impl.UsersServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class UsersController {
    @Autowired
    private UsersServiceImpl usersService;

    @GetMapping("/users")
    public String getUsersPage(Model model){
        List<User> users = usersService.getAllUsers();
        model.addAttribute("userList", users);
        return "users_page";
    }
    @GetMapping("/users/search")
    public String searchUser(@RequestParam(value="firstName",required = false) String firstName,
                             @RequestParam(value="lastName",required = false) String lastName,
                             @RequestParam(value="patronymic",required = false) String patronymic,
                             @RequestParam(value="passport",required = false) Integer passport,
                             @RequestParam(value="contactPhoneNumber",required = false) Integer contactPhoneNumber,
                             Model model){
        List<User> userList= usersService.getUsersByParams(firstName,lastName,patronymic,contactPhoneNumber,passport);
        model.addAttribute("userList", userList);
        return "users_page";
    }

}
