package com.hsbc.bookmanagement.controller.request;

import jakarta.validation.constraints.NotBlank;
import java.util.Objects;

public class CreateBookRequest {
    @NotBlank
    String title;
    @NotBlank
    String author;
    @NotBlank
    String publicationYear;
    String isbn;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public CreateBookRequest() {
    }

    public CreateBookRequest(String title, String author, String publicationYear, String isbn) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateBookRequest that = (CreateBookRequest) o;
        return Objects.equals(title, that.title) && Objects.equals(author, that.author) &&
                Objects.equals(publicationYear, that.publicationYear) && Objects.equals(isbn, that.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, publicationYear, isbn);
    }
}
