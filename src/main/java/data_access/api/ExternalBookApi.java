package data_access.api;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.api.ApiResponse;

/**
 * A class that implements ExternalBookApiInterface to fetch book details from an external API.
 */
public class ExternalBookApi implements ExternalBookApiInterface {

    /**
     * Fetches book details from an external API using the provided ISBN.
     *
     * @param isbn the ISBN of the book to fetch details for
     * @return an ApiResponse object containing the title and author of the book, or null if the request fails
     */
    @Override
    public ApiResponse fetchBookDetails(String isbn) {
        String url = "https://openlibrary.org/api/books?bibkeys=ISBN:" + isbn + "&jscmd=data&format=json";
        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                // Parse JSON response
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode rootNode = objectMapper.readTree(response.toString());

                // Access the JSON object using the ISBN as the key
                JsonNode bookNode = rootNode.path("ISBN:" + isbn);

                // Extract fields from the JSON object
                String title = bookNode.path("title").asText();
                String author = bookNode.path("authors").get(0).path("name").asText();

                // Print extracted details
                ApiResponse apiResponse = new ApiResponse(title, author);
                System.out.println(title);
                return apiResponse;
            } else {
                System.out.println("GET request failed");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
