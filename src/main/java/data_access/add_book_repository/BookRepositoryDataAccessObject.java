package data_access.add_book_repository;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import entity.book.Book;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class BookRepositoryDataAccessObject implements BookRepositoryDataAccessInterface {

    private static final String FILE_PATH = "/Users/nana/Desktop/BookTransaction/src/main/java/data/TotalBooks.json";
    private final Gson gson = GsonConfig.getGson();

    @Override
    public void saveBook(Book book) {
        Map<String, JsonObject> books = readBooksFromFile();
        books.put(String.valueOf(book.getBookID()), gson.toJsonTree(book).getAsJsonObject());
        writeBooksToFile(books);
    }

    private Map<String, JsonObject> readBooksFromFile() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type type = new TypeToken<HashMap<String, JsonObject>>() {}.getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            // If file does not exist or is empty, return a new map
            return new HashMap<>();
        }
    }

    private void writeBooksToFile(Map<String, JsonObject> books) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(books, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
