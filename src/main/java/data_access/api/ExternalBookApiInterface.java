package data_access.api;

import entity.ApiResponse;

public interface ExternalBookApiInterface {
    ApiResponse fetchBookDetails(String isbn);
}
