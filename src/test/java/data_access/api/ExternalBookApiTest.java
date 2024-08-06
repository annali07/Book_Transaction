package data_access.api;

import entity.api.ApiResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExternalBookApiTest {

    private ExternalBookApi externalBookApi;

    @BeforeEach
    void setUp() {
        externalBookApi = new ExternalBookApi();
    }

    @Test
    void testFetchBookDetailsSuccess() {
        String isbn = "9780140328721";  // A valid ISBN for testing
        ApiResponse response = externalBookApi.fetchBookDetails(isbn);
        assertNotNull(response);
        assertEquals("Fantastic Mr. Fox", response.getBookName());
        assertEquals("Roald Dahl", response.getAuthor());
    }

    @Test
    void testFetchBookDetailsInvalidISBN() {
        String invalidIsbn = "0000000000";  // An invalid ISBN
        ApiResponse response = externalBookApi.fetchBookDetails(invalidIsbn);
        assertNull(response);
    }

    @Test
    void testFetchBookDetailsEmptyISBN() {
        String emptyIsbn = "";  // An empty ISBN
        ApiResponse response = externalBookApi.fetchBookDetails(emptyIsbn);
        assertNull(response);
    }

    @Test
    void testFetchBookDetailsException() {
        String isbn = "invalid_isbn_format";  // An invalid ISBN format to trigger an exception
        ApiResponse response = externalBookApi.fetchBookDetails(isbn);
        assertNull(response);
    }
}
