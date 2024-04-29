package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Publisher {

    @Id
    private int id;

    @NonNull
    private String name;

    @ManyToMany
    @JoinTable(name = "book_publisher", joinColumns = @JoinColumn(name = "publisher_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books = new ArrayList<>();

    public Publisher(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addBook(Book book) {
        books.add(book);
        if (!book.getPublishers().contains(this)) {
            book.getPublishers().add(this);
        }
    }

    public void removeBook(Book book) {
        books.remove(book);
        book.getPublishers().remove(this);
    }
}