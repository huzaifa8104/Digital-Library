package com.example.Digital_Library.repository;

import com.example.Digital_Library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    //native Query -> sql query and hibernate will not interact with it
    @Query(value = "select * from author where email = :email", nativeQuery = true)
    Author getAuthorByEmail(String email);

}
