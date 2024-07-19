package data_access.data_base_return_book;

import entity.rent_entry.RentalEntry;

import java.util.Date;

public interface DatabaseReturnInterface {
    public void editBookFile(int bookID);
    public void writeReturnFile(RentalEntry rentalEntry);
}
