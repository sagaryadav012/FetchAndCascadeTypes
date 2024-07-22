package com.example.FetchAndCascadeTypes.Dtos;

import lombok.Data;

import java.util.List;

@Data
public class CreateAuthorDTO {
    private String name;
    private String gmail;
    private List<CreateBookDTO> books;
}
