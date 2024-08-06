package data_access.api;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import entity.api.ApiResponse;

public class ExternalCommonBookApiTest {

    @InjectMocks
    private ExternalBookApi externalBookApi;

    @Mock
    private HttpURLConnection mockConnection;

    @Before
    public void setUp() {
        try {
            MockitoAnnotations.initMocks(this);
            URL url = mock(URL.class);
            when(url.openConnection()).thenReturn(mockConnection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testFetchBookDetailsSuccess() throws Exception {
        // Prepare mocked response
        String fakeResponse = "{\"ISBN:9783161484100\":{\"title\":\"Test CommonBook\",\"authors\":[{\"name\":\"John Doe\"}]}}";
        InputStream fakeInput = new ByteArrayInputStream(fakeResponse.getBytes());

        when(mockConnection.getResponseCode()).thenReturn(HttpURLConnection.HTTP_OK);
        when(mockConnection.getInputStream()).thenReturn(fakeInput);

        // Execute the method
        ApiResponse result = externalBookApi.fetchBookDetails("9788301123376");

        // Verify and assert results
        assertNotNull(result);
        assertEquals("Tractatus logico-philosophicus", result.getBookName());
    }

}
