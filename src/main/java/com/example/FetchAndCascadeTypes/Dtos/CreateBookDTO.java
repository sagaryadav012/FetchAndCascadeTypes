package com.example.FetchAndCascadeTypes.Dtos;

import com.example.FetchAndCascadeTypes.Models.Author;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
public class CreateBookDTO {
    private String name;
    private Date published_date;
}
