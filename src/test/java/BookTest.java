import model.Author;
import model.Book;
import model.Publisher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {

    @Test
    public void testBookTitleSetterAndGetter() {
        Book book = new Book();
        book.setTitle("Effective Java");
        assertEquals("Effective Java", book.getTitle(), "The title should match the one set.");
    }

    @Test
    @DisplayName("Book author relation")
    public void testBookAuthorRelation() {
        Author author = new Author();
        author.setName("Joshua Bloch");

        Book book = new Book();
        book.setAuthor(author);
        assertEquals("Joshua Bloch", book.getAuthor().getName(), "The book's author should be Joshua Bloch.");
    }

    @Test
    @DisplayName("Adding a publisher to a book")
    public void testAddPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Addison-Wesley");
        Book book = new Book();

        book.addPublisher(publisher);
        assertEquals("Addison-Wesley", book.getPublishers().getFirst().getName(), "The book's publisher should be Addison-Wesley.");
    }

    @Test
    @DisplayName("Removing a publisher from a book")
    public void testRemovePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Addison-Wesley");

        
        Book book = new Book();
        book.addPublisher(publisher);

        book.removePublisher(publisher);
        assertEquals(0, book.getPublishers().size(), "The book should have no publishers.");
    }
}