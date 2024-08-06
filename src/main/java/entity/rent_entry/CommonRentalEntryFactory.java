package entity.rent_entry;

import java.util.Date;

public class CommonRentalEntryFactory implements RentalEntryFactory{

    @Override
    public CommonRentalEntry createRentalHistory(int bookId, Date rentalStartDate, Date rentalEndDate, Date returnDate) {
        return new CommonRentalEntry(bookId, rentalStartDate, rentalEndDate, returnDate);
    }

    @Override
    public CommonRentalEntry createRentalHistory(int rentalId, int bookId, int charge, Date rentalStartDate, Date rentalEndDate, Date returnDate, int maxCharge){
        return new CommonRentalEntry(rentalId, bookId, charge, rentalStartDate, rentalEndDate, returnDate, maxCharge);
    }

}
