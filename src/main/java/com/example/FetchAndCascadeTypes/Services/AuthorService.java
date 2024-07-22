package com.example.FetchAndCascadeTypes.Services;

import com.example.FetchAndCascadeTypes.Models.Author;
import com.example.FetchAndCascadeTypes.Models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    public Author createAuthor(String name, String gmail, List<Book> books);
    public void deleteAuthor(long id);
    public Author getAuthor(long id);
    public List<Author> getAuthors();
    public Author updateGmail(long id, String gmail);
}
