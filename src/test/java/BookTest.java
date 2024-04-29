import model.Author;
import model.Book;
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
}