package com.hsbc.bookmanagement.controller.request;

import java.util.Objects;

public class UpdateBookRequest {
    String title;
    String author;
    String publicationYear;
    String isbn;

    public UpdateBookRequest() {
    }

    public UpdateBookRequest(String title, String author, String publicationYear, String isbn) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpdateBookRequest that = (UpdateBookRequest) o;
        return Objects.equals(title, that.title) && Objects.equals(author, that.author) &&
                Objects.equals(publicationYear, that.publicationYear) && Objects.equals(isbn, that.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, publicationYear, isbn);
    }
}
