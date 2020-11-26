package com.api.book.bootrestbook.service;
import com.api.book.bootrestbook.entitiesmodels.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private static List<Book> list = new ArrayList<>();

    static{
        list.add(new Book(12,"Geography Complete Reference","Luv"));
        list.add(new Book(13,"History Complete Reference","Rajiv"));
        list.add(new Book(14,"Chemistry Complete Reference","tanmay"));
    }
    //get all books
    public List<Book> getAllBooks() {
        return list;
    }
    //get single book by id
    public Book getBookById(int id){
        Book book = null;
        //list.stream->to take the stream

        book = list.stream().filter(e->e.getId()==id).findFirst().get();
        return book;
    }
    //adding the book as well as returning it
    public Book addBook(Book b){
        list.add(b);
        return b;
    }

    //delete book
    public void deleteBook(int bid)
    {
      list = list.stream().filter(book -> book.getId()!=bid).collect(Collectors.toList());
    /*{
                if(book.getId()!=bid)
                {
                    return true;
                }
                else {
                    return false;
                }
        }*/


    }
    //update the book
    public void updateBook(Book book,int bookId)
    {
        list.stream().map(b->{
            if(b.getId()==bookId)
            {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
                return b;
        }).collect(Collectors.toList());
    }


}


