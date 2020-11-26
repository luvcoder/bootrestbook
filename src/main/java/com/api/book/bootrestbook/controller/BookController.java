package com.api.book.bootrestbook.controller;
import com.api.book.bootrestbook.entitiesmodels.Book;
import com.api.book.bootrestbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/books")
    public List<Book> getBooks() {
        return this.bookService.getAllBooks();

    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id) {
        return bookService.getBookById(id);
    }

    //Create a new book handler
    @PostMapping("/books")
    //RequestBody binds and converts json into object
    public Book addBook(@RequestBody Book book) {
        Book b = this.bookService.addBook(book);
        return b;
    }

    //delete book handler
    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId) {
        this.bookService.deleteBook(bookId);
    }

    //update book handler
    @PutMapping("/books/{bookId}")
    public Book updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
        this.bookService.updateBook(book, bookId);
        return book;
    }

}



    /*books call kroge tab data ajayega.Jo data requestbody mei ayega,wo book ki object
   /* public Book getBooks()
    {
        
         Book book = new Book();
    book.setId(123424);
    book.setTitle("Java Complete Reference");
    book.setAuthor("XYZ");

        return book;
    }*/

