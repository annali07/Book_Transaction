package entity.rent_entry;

import java.util.Date;

public interface RentalEntry {
    public void setRentalID();

    public int getRentalId();

    public void setRentalId(int rentalId);

    public int getBookId();

    public void setBookId(int bookId);

    public int getCharge();

    public void setCharge(int charge);

    public Date getRentalStartDate();

    public void setRentalStartDate(Date rentalStartDate);

    public Date getRentalEndDate();

    public void setRentalEndDate(Date rentalEndDate);

    public Date getReturnDate();

    public int getMaxCharge();

    public int getBookID();

    /**
     * Return StartDate of the entry
     *
     * @return start date
     */

    public Date getStartDate();

    /**
     * Return EndDate of the entry
     *
     * @return end date
     */

    public Date getEndDate();
}
