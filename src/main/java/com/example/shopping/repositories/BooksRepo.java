package com.example.shopping.repositories;

import com.example.shopping.model.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface BooksRepo extends CrudRepository<Books, Long> {
}
