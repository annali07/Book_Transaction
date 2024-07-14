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

/**
 * A data access object (DAO) implementation for saving books to a JSON file.
 */
public class BookRepositoryDataAccessObject implements BookRepositoryDataAccessInterface {

    private static final String FILE_PATH = "/Users/nana/Desktop/BookTransaction/src/main/java/data/TotalBooks.json";

    private final Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
            .create();

    /**
     * Saves the given book to the JSON file.
     *
     * @param book the book to be saved
     */
    @Override
    public void saveBook(Book book) {
        Map<String, JsonObject> books = readBooksFromFile();
        books.put(String.valueOf(book.getBookID()), gson.toJsonTree(book).getAsJsonObject());
        writeBooksToFile(books);
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
    private void writeBooksToFile(Map<String, JsonObject> books) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(books, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
