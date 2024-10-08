package com.colak.springtutorial.repository;

import com.colak.springtutorial.jpa.Author;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository repository;

    @Test
    void findAll() {

        int pageNumber = 0;
        int pageSize = 1;
        Page<Author> authorPage;

        do {
            Pageable pageable = PageRequest.of(pageNumber, pageSize);
            log.info("Requesting page: {}", pageNumber);
            authorPage = repository.findAll(pageable);

            for (Author author : authorPage.getContent()) {
                log.info("Author: {}", author.getName());
            }

            pageNumber++;
        } while (authorPage.hasNext());
    }

    @Test
    void findAllBy() {

        int pageNumber = 0;
        int pageSize = 1;
        Page<Author> authorPage;

        do {
            Pageable pageable = PageRequest.of(pageNumber, pageSize);
            log.info("Requesting page: {}", pageNumber);
            authorPage = repository.findAllBy(pageable);

            for (Author author : authorPage.getContent()) {
                log.info("Author: {}", author.getName());
            }

            pageNumber++;
        } while (authorPage.hasNext());
    }
}