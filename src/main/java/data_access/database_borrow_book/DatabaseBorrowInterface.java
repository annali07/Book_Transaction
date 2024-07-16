package data_access.database_borrow_book;

import java.util.Date;

public interface DatabaseBorrowInterface {
    public void writeBorrowFile(int bookID, Date startDate, Date endDate, String borrowerName,String borrowerNumber);
}
