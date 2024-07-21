package data_access.add_book_repository;

import com.google.gson.JsonObject;
import data.misc_info.FilePathConstants;
import entity.book.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryDataAccessObjectTest {

    private static final String TEST_FILE_PATH = FilePathConstants.TEST_FILE;
    private BookRepositoryDataAccessObject dao;

    @BeforeEach
    void setUp() throws IOException {
        dao = new BookRepositoryDataAccessObject() {
            private String getFilePath() {
                return TEST_FILE_PATH;
            }
        };
        // Initialize the test file
        try (FileWriter writer = new FileWriter(TEST_FILE_PATH)) {
            writer.write("{}");
        }
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(new File(TEST_FILE_PATH).toPath());
    }

    @Test
    void getBook() {
        JsonObject retrievedBook = dao.getBook(1);
        assertNotNull(retrievedBook);
        assertEquals(77, Double.parseDouble(retrievedBook.get("bookPrice").getAsString()));
    }
}
