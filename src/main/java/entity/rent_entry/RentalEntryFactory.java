package entity.rent_entry;

import java.util.Date;

public interface RentalEntryFactory {

    public CommonRentalEntry createRentalHistory(int bookId, Date rentalStartDate, Date rentalEndDate, Date returnDate);

    public CommonRentalEntry createRentalHistory(int rentalId, int bookId, int charge, Date rentalStartDate, Date rentalEndDate, Date returnDate, int maxCharge);

}
