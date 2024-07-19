//package entity.rent_entry;
//
//import java.util.Date;
//
//public class RentalEntryFactory {
//
//    public static RentalEntry createRentalHistory(int rentalId, int bookId, String bookName, String borrowerName, String borrowerPhoneNumber, int charge, Date rentalStartDate, Date rentalEndDate) {
//        if (!validate(bookId, rentalId, rentalStartDate, rentalEndDate, charge)) {
//            throw new IllegalArgumentException("Invalid arguments for creating RentalHistory");
//        }
//        return new RentalEntry(rentalId, bookId, charge, bookName, borrowerName, borrowerPhoneNumber, rentalStartDate, rentalEndDate);
//    }
//
//
//    public static boolean validate(int bookId, int rentalId, Date rentalStartDate, Date rentalEndDate, double charge) {
//        return bookId > 0 && rentalId > 0 && rentalEndDate.after(rentalStartDate) && charge > 0;
//    }
//}
