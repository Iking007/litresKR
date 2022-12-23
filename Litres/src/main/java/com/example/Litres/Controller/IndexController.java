package com.example.Litres.Controller;

import com.example.Litres.Model.Book;
import com.example.Litres.Model.Role;
import com.example.Litres.Model.User;
import com.example.Litres.Repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Objects;


/**
 * @author Pavel
 */
@Controller
public class IndexController{
    @Autowired
    BooksRepository booksRepository;


    @GetMapping("/")
    public String index(@AuthenticationPrincipal User user,Model model){
        model.addAttribute("namePage", "Главная");
        if(user == null){
            model.addAttribute("pr", null);
        }
        else if( Objects.equals(user.getRoles(), Collections.singleton(Role.USER))){
            model.addAttribute("pr", 0);
        }
        else if(!Objects.equals(user.getRoles(), Collections.singleton(Role.ADMIN))){
            model.addAttribute("pr", 1);
        }
        else {
            model.addAttribute("pr", 2);
        }
        return "index";
    }
    @GetMapping("/books")
    public String books(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("namePage", "Книги");
        if(user == null){
            model.addAttribute("pr", null);
        }
        else if( Objects.equals(user.getRoles(), Collections.singleton(Role.USER))){
            model.addAttribute("pr", 0);
        }
        else if(!Objects.equals(user.getRoles(), Collections.singleton(Role.ADMIN))){
            model.addAttribute("pr", 1);
        }
        else {
            model.addAttribute("pr", 2);
        }
        Iterable<Book> books = booksRepository.findAll();
        model.addAttribute("books", books);
        return "index";
    }
    @GetMapping("/books/query")
    public String books(@AuthenticationPrincipal User user,@RequestParam String filter, Model model){
        Iterable<Book> books = booksRepository.search(filter, filter, filter, filter);

        if (books.toString().isEmpty()) {
            return "redirect:/books";
        }
        if(user == null){
            model.addAttribute("pr", null);
        }
        else if( Objects.equals(user.getRoles(), Collections.singleton(Role.USER))){
            model.addAttribute("pr", 0);
        }
        else if(!Objects.equals(user.getRoles(), Collections.singleton(Role.ADMIN))){
            model.addAttribute("pr", 1);
        }
        else {
            model.addAttribute("pr", 2);
        }
        model.addAttribute("namePage", "Книги");
        model.addAttribute("books", books);
        return "index";
    }

    @GetMapping("/books/{id}")
    public String bookId(@AuthenticationPrincipal User user, @PathVariable(value = "id") long id, Model model){
        Iterable<Book> book = booksRepository.findById(id);
        if (book == null){
            model.addAttribute("namePage", "404");
            return "index";
        }
        if(user == null){
            model.addAttribute("pr", null);
        }
        else if( Objects.equals(user.getRoles(), Collections.singleton(Role.USER))){
            model.addAttribute("pr", 0);
        }
        else if(!Objects.equals(user.getRoles(), Collections.singleton(Role.ADMIN))){
            model.addAttribute("pr", 1);
        }
        else {
            model.addAttribute("pr", 2);
        }
        model.addAttribute("namePage", "Книга");
        model.addAttribute("book", book);
        return "book";
    }
    @GetMapping("/prof")
    public String prof(@AuthenticationPrincipal User user, Model model){
        if(user == null){
            model.addAttribute("pr", null);
        }
        else if( Objects.equals(user.getRoles(), Collections.singleton(Role.USER))){
            model.addAttribute("pr", 0);
        }
        else if(!Objects.equals(user.getRoles(), Collections.singleton(Role.ADMIN))){
            model.addAttribute("pr", 1);
        }
        else {
            model.addAttribute("pr", 2);
        }
        model.addAttribute("username", user.getUsername());
        return "prof";
    }
    }
