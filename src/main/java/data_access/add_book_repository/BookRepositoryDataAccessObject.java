package data_access.add_book_repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import entity.book.Book;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import data.misc_info.FilePathConstants;

/**
 * A data access object (DAO) implementation for saving books to a JSON file.
 */
public class BookRepositoryDataAccessObject implements BookRepositoryDataAccessInterface {

    private static final String FILE_PATH = FilePathConstants.TOTAL_BOOKS_FILE;

    private final Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
            .create();

    /**
     * Saves the given book to the JSON file.
     *
     * @param book the book to be saved
     */
    @Override
    public boolean saveBook(Book book) {
        Map<String, JsonObject> books = readBooksFromFile();
        books.put(String.valueOf(book.getBookID()), gson.toJsonTree(book).getAsJsonObject());
        return writeBooksToFile(books);
    }

    /**
     * Updates an existing book in the repository.
     *
     * @param book the book object containing updated information
     * @return true if the book was successfully updated, false otherwise
     */
    @Override
    public boolean updateBook(Book book) {
        // #TODO Implementation
        return true;
    }

    /**
     * Deletes a book from the repository.
     *
     * @param bookId the ID of the book to delete
     * @return true if the book was successfully deleted, false otherwise
     */
    @Override
    public boolean deleteBook(int bookId) {
        // #TODO Implementation
        return true;
    }

    /**
     * Retrieves a book from the repository.
     *
     * @param bookId the ID of the book to retrieve
     * @return a JsonObject representing the book, or null if the book is not found
     */
    @Override
    public JsonObject getBook(int bookId) {
        Map<String, JsonObject> books = readBooksFromFile();
        return books.get(String.valueOf(bookId));
    }

    /**
     * Reads the books from the JSON file.
     *
     * @return a map of books with their IDs as keys and their JSON representations as values
     */
    private Map<String, JsonObject> readBooksFromFile() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type type = new TypeToken<HashMap<String, JsonObject>>() {}.getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            return new HashMap<>();
        }
    }

    /**
     * Writes the given books map to the JSON file.
     *
     * @param books the map of books to be written to the file
     */
    private boolean writeBooksToFile(Map<String, JsonObject> books) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(books, writer);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
