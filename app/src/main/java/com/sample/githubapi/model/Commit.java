package com.sample.githubapi.model;

public class Commit {
    private Author author;

    public Author getAuthor() {
        return author;
    }

    class Author {
        String name;

        public String getName() {
            return name;
        }
    }
}
