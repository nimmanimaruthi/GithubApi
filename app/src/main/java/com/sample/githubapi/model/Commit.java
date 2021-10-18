package com.sample.githubapi.model;

public class Commit {
    private String message;
    private Author author;
    public String getMessage() {
        return message;
    }

    public Author getAuthor() {
        return author;
    }

    public class Author {
        String name;

        public String getName() {
            return name;
        }
    }
}
