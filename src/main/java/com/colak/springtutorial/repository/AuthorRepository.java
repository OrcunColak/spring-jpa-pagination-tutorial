package com.colak.springtutorial.repository;

import com.colak.springtutorial.jpa.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    // Books is not fetched
    @Override
    Page<Author> findAll(Pageable pageable);

    // Books is fetched and pagination happens in memory
    @EntityGraph(attributePaths = {"books"})
    Page<Author> findAllBy(Pageable pageable);

}
