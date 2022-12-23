package com.example.Litres.Repository;

/**
 * @author Pavel
 */

import com.example.Litres.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface BooksRepository extends JpaRepository<Book, Long> {

    List<Book> findAll();
    List<Book> findById(long id);

    @Query("""
            select b from Book b
            where upper(b.title) like upper(concat(?1, '%')) or upper(b.writer) like upper(concat(?2, '%')) or upper(b.title) like upper(concat('%', ?3)) or upper(b.writer) like upper(concat('%', ?4))""")
    List<Book> search(String title, String writer, String title1, String writer1);
    
    




}

