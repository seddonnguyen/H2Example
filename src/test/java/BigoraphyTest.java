import model.Biography;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigoraphyTest {

    @Test
    @DisplayName("Test adding a biography")
    public void testSetBio() {
        Biography bio = new Biography();
        bio.setBio("This is a biography.");
        assertEquals("This is a biography.", bio.getBio(), "The biography should match the one set.");
    }
}