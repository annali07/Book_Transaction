package data_access.database_rental_entry;

import entity.rent_entry.RentalEntry;

import java.util.ArrayList;
import java.util.Date;

public class DatabaseRentalEntryDataAccessObject implements DatabaseRentalEntryDataAccessInterface {
    @Override
    public ArrayList<RentalEntry> getRentalEntriesBetweenDate(Date startDate, Date endDate){
        return null;
    }
}
