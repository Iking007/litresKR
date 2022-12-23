package com.example.Litres.Controller;

import com.example.Litres.Model.Role;
import com.example.Litres.Model.User;
import com.example.Litres.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
public class RegController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/reg")
    public String reg(@AuthenticationPrincipal User user, Model model){
        if (user != null){
            return "redirect:/prof";
        }
        model.addAttribute("pr", null);
        return "reg";
    }

    @PostMapping("/reg")
    public String bookAdd(@RequestParam String username, @RequestParam String password,
                          @RequestParam String password2, Model model){
        User user = new User(username,password);
        User userFromBD = usersRepository.findByUsername(user.getUsername());
        if(userFromBD != null) {
            model.addAttribute("error", "Ошибка, пользователь с такой почтой существует");
            return "reg";
        }
        else if (!password.equals(password2)){
            model.addAttribute("error", "Ошибка, пароли не совпадают");
            return "reg";
        }

        user.setRoles(Collections.singleton(Role.USER));
        usersRepository.save(user);

        return "redirect:/login";
    }
}
