package com.example.Digital_Library.service;

import com.example.Digital_Library.controller.AuthorController;
import com.example.Digital_Library.model.Author;
import com.example.Digital_Library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Author getAuthorData(String email) {
        return authorRepository.getAuthorByEmail(email);
    }
}
