package data_access.database_borrow_book;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import data.misc_info.FilePathConstants;

/**
 * A data access object (DAO) implementation for borrowing book.
 */
public class DatabaseBorrowObject implements DatabaseBorrowInterface{
    private static final String FILE_PATH_BOOK = FilePathConstants.TOTAL_BOOKS_FILE;

    /**
     * Update book information; set EndDate, StartDate to startDate, endDate, isRented to ture,
     * BorrowerName, BorrowerNumber to borrowerName, borrowerNumber
     *
     * @param bookID the bookID of the book
     * @param startDate the start date of the borrow
     * @param endDate the end date of the borrow
     * @param borrowerName the name of the borrower
     * @param borrowerNumber the phone number of the borrower
     *
     */
    @Override
    public void writeBorrowFile(int bookID, Date startDate, Date endDate, String borrowerName, String borrowerNumber) {
        JSONObject bookData = readBookData(FILE_PATH_BOOK);
        if (bookData == null) return;

        Set keys = bookData.keySet();  // Get all keys from the JSONObject
        Iterator<String> it = keys.iterator();
        boolean bookFound = false;

        while (it.hasNext()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String key = it.next();
            JSONObject book = (JSONObject) bookData.get(key);
            Long bookIDLong = (long) book.get("bookID");
            int bookID1 = bookIDLong.intValue();
            if (bookID == bookID1) {
                book.put("End Date", dateFormat.format(endDate));
                book.put("Start Date", dateFormat.format(startDate));
                book.put("isRented", "true");
                book.put("BorrowerName", borrowerName);
                book.put("BorrowerNumber", borrowerNumber);
                bookFound = true;
                break;
            }
        }
        if (!bookFound) {
            System.out.println("Book with ID " + bookID + " not found.");
            return;
        }
        try (FileWriter writer = new FileWriter(FILE_PATH_BOOK)) {
            writer.write(bookData.toJSONString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    /**
     * helper method to read file
     *
     * @param filePath filePath
     */
    public JSONObject readBookData(String filePath) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(filePath));
            return (JSONObject) obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
