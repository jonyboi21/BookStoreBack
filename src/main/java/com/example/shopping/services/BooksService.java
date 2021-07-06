package com.example.shopping.services;

import com.example.shopping.model.Books;
import com.example.shopping.repositories.BooksRepo;
import org.hibernate.service.spi.InjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BooksService {

    private static final Logger logger = LoggerFactory.getLogger(BooksService.class);

    @Autowired
    BooksRepo booksRepo;


    public void addBook(Books book) {
        logger.info("CUSTOMER MADE WITH ID OF : " + book.getId());
        booksRepo.save(book);
    }


    public List<Books> getAllBooks() {
        if (!(booksRepo.findAll().iterator().hasNext())) {
            logger.info("FAILED TO RETRIEVE ALL BOOKS");
            throw new RuntimeException("Resource Not Found");
        } else {
            List<Books> listOfBooks = new ArrayList<Books>();
            booksRepo.findAll()
                    .forEach(listOfBooks::add);
            logger.info("SUCCESSFULLY RETRIEVED ALL BOOKS");
            return listOfBooks;
        }
    }


    public Books getBookById(Long id){
       if (!(booksRepo.existsById(id))) {
           logger.info("BOOK WITH ID OF " + id + " DOESNT EXIST");
            throw new RuntimeException("Resource Not Found");
       }else
        return booksRepo.findById(id).get();
        }


    public void updateBook(Books books, Long id){
        if(!(booksRepo.existsById(books.getId()))){
           logger.info("BOOK ID DOESNT EXIST");
        }
        logger.info("SUCCESSFULLY UPDATED BOOK");
        booksRepo.save(books);
    }

    public void deleteBook(Books book){
        if(!(booksRepo.existsById((book.getId())))){
            logger.info("BOOK WITH ID OF " + book.getId() + " DOESNT EXIST");
            throw new RuntimeException("Resource Not Found");
            }else booksRepo.delete(book);
        }


    public void deleteAllBooks() {
        booksRepo.deleteAll();
    }
}