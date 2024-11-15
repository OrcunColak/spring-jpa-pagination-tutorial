package com.colak.springtutorial.controller;

import com.colak.springtutorial.controller.dto.AuthorDto;
import com.colak.springtutorial.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorRepository repository;

    // http://localhost:8080/api/authors
    // http://localhost:8080/api/authors?page=0&size=5
    @GetMapping
    public Page<AuthorDto> getAuthors(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        return repository.findAll(pageable)
                .map(author -> {
                    AuthorDto dto = new AuthorDto();
                    dto.setId(author.getId());
                    dto.setName(author.getName());
                    return dto;
                });
    }
}

