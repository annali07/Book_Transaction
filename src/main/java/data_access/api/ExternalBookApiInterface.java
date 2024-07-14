package data_access.api;

import entity.api.ApiResponse;

public interface ExternalBookApiInterface {
    ApiResponse fetchBookDetails(String isbn);
}
