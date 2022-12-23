package com.example.Litres.Controller;

import com.example.Litres.Model.User;
import com.example.Litres.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/login")
    public String login(@AuthenticationPrincipal User user, Model model){
        if (user != null){
            return "redirect:/prof";
        }
        model.addAttribute("namePage", "Вход");
        return "login";

    }
    @PostMapping("/login")
    public String bookAdd(@RequestParam String username, @RequestParam String password, Model model) {
        User user = new User(username, password);
        User userFromBD = usersRepository.findByUsername(user.getUsername());
        String password1 = userFromBD.getPassword();
        if (userFromBD == null) {
            model.addAttribute("namePage", "Вход");
            model.addAttribute("error", "Ошибка, пользователя с такой почтой не сущёствует");
            return "login";
        }
        else if (password == password1) {
            return "redirect:/prof";
        }
        else {
            model.addAttribute("namePage", "Вход");
            model.addAttribute("error", "Ошибка, неверный пароль или почта");
            return "login";
        }
    }
}
