package com.example.pratice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //Generates constructor with all fields
@NoArgsConstructor //Generates constructor with no fields
public class BookDTO {

    private Long id;

    private String title;

    private String author;
}
