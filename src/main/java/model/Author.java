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
public class Author {

    @Id
    private int id;

    @NonNull
    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "biography_id", referencedColumnName = "id")
    private Biography biography;

    public Author(int id, @NonNull String name) {
        this.id = id;
        this.name = name;
    }

    public void addBook(Book book) {
        this.books.add(book);
        book.setAuthor(this); // Maintain bidirectional relationship
    }
}