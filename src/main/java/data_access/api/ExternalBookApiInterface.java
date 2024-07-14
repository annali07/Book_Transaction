package data_access.api;

import entity.api.ApiResponse;
/**
 * Interface for fetching book details from an external API.
 */
public interface ExternalBookApiInterface {
    /**
     * Fetches book details from an external API using the provided ISBN.
     *
     * @param isbn the ISBN of the book to fetch details for
     * @return an ApiResponse object containing the title and author of the book, or null if the request fails
     */
    ApiResponse fetchBookDetails(String isbn);
}
