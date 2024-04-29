import model.Book;
import model.Publisher;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PublisherTest {

    @Test
    public void testPublisherNameSetterAndGetter() {
        Publisher publisher = new Publisher();
        publisher.setName("O'Reilly Media");
        assertEquals("O'Reilly Media", publisher.getName(), "The name should match the one set.");
    }

    @Test
    public void testPublisherIdSetterAndGetter() {
        Publisher publisher = new Publisher();
        publisher.setId(1);
        assertEquals(1, publisher.getId(), "The ID should match the one set.");
    }

    @Test
    public void testPublisherBooksRelation() {
        Book book1 = new Book();
        book1.setTitle("Learning Java");

        Book book2 = new Book();
        book2.setTitle("Mastering Hibernate");

        Publisher publisher = new Publisher();
        publisher.setBooks(List.of(book1, book2));

        assertEquals(2, publisher.getBooks().size(), "There should be two books related to the publisher.");
        assertTrue(publisher.getBooks().contains(book1) && publisher.getBooks().contains(book2),
                   "The publisher's books should include 'Learning Java' and 'Mastering Hibernate'.");
    }
}