package com.example.Digital_Library.dto;

import com.example.Digital_Library.model.Author;
import com.example.Digital_Library.model.Book;
import com.example.Digital_Library.model.BookType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BookRequest {

    @NotBlank(message = "Book title should not be blank")
    private String bookTitle;

    @NotBlank(message = "Book number should not be blank")
    private String bookNo;

    @NotBlank(message = "Author name should not be blank")
    private String authorName;

    @NotBlank(message = "Author Email should not be blank")
    private String authorEmail;

    @NotNull(message = "Book Type should not be blank")
    private BookType type;

    @Positive(message = "Security Amount should not be blank")
    private int securityAmount;

    public Author toAuthor() {
        return Author.
                builder().
                email(this.authorEmail).
                name(this.authorName).
                build();
    }

    public Book toBook() {
        return Book.
                builder().
                bookNo(this.bookNo).
                title(this.bookTitle).
                securityAmount(this.securityAmount).
                bookType(this.type).
                build();
    }
}
