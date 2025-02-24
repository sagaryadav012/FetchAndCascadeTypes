package com.example.FetchAndCascadeTypes.Repositories;

import com.example.FetchAndCascadeTypes.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {
}
