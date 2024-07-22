package com.example.FetchAndCascadeTypes.Controllers;

import com.example.FetchAndCascadeTypes.Dtos.CreateAuthorDTO;
import com.example.FetchAndCascadeTypes.Dtos.CreateBookDTO;
import com.example.FetchAndCascadeTypes.Dtos.UpdateAuthorGmailDTO;
import com.example.FetchAndCascadeTypes.Models.Author;
import com.example.FetchAndCascadeTypes.Models.Book;
import com.example.FetchAndCascadeTypes.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/createAuthor")
    public ResponseEntity<Author> createAuthor(@RequestBody CreateAuthorDTO authorDTO){

        List<Book> books = new ArrayList<>();
        for (CreateBookDTO bookDTO : authorDTO.getBooks()) {
            Book book = new Book();
            book.setName(bookDTO.getName());
            book.setPublished_date(bookDTO.getPublished_date());
            books.add(book);
        }

        Author author = authorService.createAuthor(authorDTO.getName(), authorDTO.getGmail(), books);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @GetMapping("/fetchAuthor/{id}")
    public ResponseEntity<Author> fetchAuthor(@PathVariable long id){
        Author author = authorService.getAuthor(id);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @GetMapping("/fetchAuthors")
    public ResponseEntity<List<Author>> fetchAuthors(){
        List<Author> authors = authorService.getAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable long id){
        authorService.deleteAuthor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/updateGmail/{id}")
    public ResponseEntity<Author> updateId(@PathVariable long id, @RequestBody UpdateAuthorGmailDTO authorGmailDTO){
        Author author = authorService.updateGmail(id, authorGmailDTO.getGmail());
        return new ResponseEntity<>(author, HttpStatus.CREATED);
    }
}
