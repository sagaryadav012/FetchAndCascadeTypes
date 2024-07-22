package com.example.FetchAndCascadeTypes.Services;

import com.example.FetchAndCascadeTypes.Models.Author;
import com.example.FetchAndCascadeTypes.Models.Book;
import com.example.FetchAndCascadeTypes.Repositories.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{

    private AuthorRepo authorRepo;

    @Autowired
    public AuthorServiceImpl(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public Author createAuthor(String name, String gmail, List<Book> books){
        Author author = new Author();
        author.setName(name);
        author.setGmail(gmail);
        author.setBooks(books);

        for (Book book : books) {
            book.setAuthor(author);
        }

        return authorRepo.save(author);
    }

    @Override
    public void deleteAuthor(long id) {
        Author author = getAuthor(id);
        authorRepo.delete(author);
    }

    @Override
    public Author getAuthor(long id) {
        return authorRepo.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
    }

    @Override
    public List<Author> getAuthors() {
        return authorRepo.findAll();
    }

    @Override
    public Author updateGmail(long id, String gmail) {
        Author author = getAuthor(id);
        author.setGmail(gmail);
        return authorRepo.save(author);
    }
}
