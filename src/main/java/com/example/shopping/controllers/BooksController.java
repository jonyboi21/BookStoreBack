package com.example.shopping.controllers;


import com.example.shopping.model.Books;
import com.example.shopping.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/api/v1")
public class BooksController {

    @Autowired
    BooksService booksService;

    @PostMapping(path = "/books")
    public void addBook(@RequestBody Books books){
        this.booksService.addBook(books);
    }

    @GetMapping(path = "/books")
    public List<Books> getAllBooks(){
        return booksService.getAllBooks();
    }

    @GetMapping(path = "/books/{id}")
    public Books getBookById(@PathVariable Long id){
        return booksService.getBookById(id);
    }

    @PutMapping(path = "/books/{id}")
    public void updateBook(@RequestBody Books books, @PathVariable Long id){
        booksService.updateBook(books,id);
    }


    @DeleteMapping(path = "/books")
    public void deleteBooks(){
    booksService.deleteAllBooks();
    }

}
