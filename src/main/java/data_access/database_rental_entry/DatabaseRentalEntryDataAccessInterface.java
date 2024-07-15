package data_access.database_rental_entry;

import entity.rent_entry.RentalEntry;

import java.util.Date;

import java.util.ArrayList;

public interface DatabaseRentalEntryDataAccessInterface {
    public ArrayList<RentalEntry> getRentalEntriesBetweenDate(Date startDate, Date endDate);

}
