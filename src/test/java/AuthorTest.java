import model.Author;
import model.Biography;
import model.Book;
import model.Publisher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AuthorTest {

    private static SessionFactory sessionFactory;

    @BeforeAll
    public static void setup() {
        sessionFactory = new Configuration().configure("hibernate-test.cfg.xml") // Test specific config
                                            .buildSessionFactory();
    }

    @AfterAll
    public static void closeSession() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }


    @Test
    public void testSaveAuthor() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            // Create author with related entities and manually assign IDs
            Book book1 = new Book(1, "Book Title 1");
            Book book2 = new Book(2, "Book Title 2");

            Author author = new Author(1, "John Doe");
            author.addBook(book1);
            author.addBook(book2);

            book1.setAuthor(author);
            book2.setAuthor(author);

            Biography biography = new Biography(1, "This is a biography of John Doe.");
            author.setBiography(biography);

            Publisher publisher = new Publisher(4, "Amazing Publishing");
            // Establish relationship between Book and Publisher
            book1.addPublisher(publisher);
            book2.addPublisher(publisher);

            // Persist entities
            session.save(author);  // Persist Author first

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}