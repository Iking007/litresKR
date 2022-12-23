package com.example.Litres.Model;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    
    private String title, img, download, str, writer;

    public Book() {
    }

    public Book(String title, String str, String writer) {
        this.title = title;
        this.str = str;
        this.writer = writer;
    }
}



