package com.example.Litres.Controller;

import com.example.Litres.Model.Book;
import com.example.Litres.Repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


/**
 * @author Pavel
 */
@Controller
public class SecretController {

    @Autowired
    BooksRepository booksRepository;

    @GetMapping("/menu")
    private String secretMenu(Model model){
        model.addAttribute("pr", 2);
        return "menu";
    }
    @GetMapping("/menu/all")
    private String all(Model model){
        model.addAttribute("pr", 2);
        System.out.println(booksRepository);
        Iterable<Book> books = booksRepository.findAll();

        model.addAttribute("books", books);

        return "secretAll";
    }


    @GetMapping("/menu/del/{id}")
    private String delBook(@PathVariable(value = "id") long id, Model model){
        model.addAttribute("pr", 2);
        booksRepository.deleteById(id);

        return "redirect:/menu/all";
    }

    @GetMapping("/menu/update/{id}")
    private String updateBook(@PathVariable(value = "id") long id, Model model){
        model.addAttribute("pr", 2);
        if (!booksRepository.existsById(id)){
            model.addAttribute("namePage", "404");
            return "404";
        }
        model.addAttribute("namePage", booksRepository.findById(id).get(0).getTitle());
        Iterable<Book> book = booksRepository.findById(id);
        ArrayList<Book> res = new ArrayList<>();
        model.addAttribute("book", book);

        return "update";
    }

    @PostMapping("/menu/update/{id}/up")
    private String upBook( @PathVariable(value = "id") long id,
                          @RequestParam String title, @RequestParam String img,
                          @RequestParam String download, @RequestParam String writer,
                          @RequestParam String str, Model model){
            model.addAttribute("pr", 2);
            Book book = booksRepository.findById(id).get(0);
            book.setTitle(title);
            book.setImg(img);
            book.setDownload(download);
            book.setWriter(writer);
            book.setStr(str);
            booksRepository.save(book);


        return "redirect:/menu";
    }

    @GetMapping("/menu/form")
    public String form(Model model){
        model.addAttribute("pr", 2);
        return "new";
    }
    @PostMapping("/menu/form")
    public String newBook(@RequestParam String title, @RequestParam String img,
                          @RequestParam String download, @RequestParam String writer, @RequestParam String str,
                          Model model){
        model.addAttribute("pr", 2);
        Book book = new Book(title, str, writer);
        book.setDownload(download);
        book.setImg(img);
        System.out.println(book);
        booksRepository.save(book);
        return "redirect:/menu";
    }
}
