package entity.rent_entry;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import data.misc_info.FilePathConstants;
import entity.book.CommonBook;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonRentalEntry implements RentalEntry {
    private static final String FILE_PATH = FilePathConstants.BOOK_COUNT_FILE;
    private static final Gson gson = new Gson();
    private static final int chargePerDay = CommonBook.RENTAL_PRICE;
    private static final int overdueChargePerDay = 5;

    private int rentalId;
    private int bookId;
    private int charge;
    private Date rentalStartDate;
    private Date rentalEndDate;
    private Date returnDate;
    private int maxCharge;

    public CommonRentalEntry(int bookId, Date rentalStartDate, Date rentalEndDate, Date returnDate) {
        this.bookId = bookId;
        this.rentalStartDate = rentalStartDate;
        this.rentalEndDate = rentalEndDate;
        this.returnDate = returnDate;
        setRentalID();
        calculateCharge();
    }

    public CommonRentalEntry(int rentalId, int bookId, int charge, Date rentalStartDate, Date rentalEndDate, Date returnDate, int maxCharge) {
        this.rentalId = rentalId;
        this.bookId = bookId;
        this.charge = charge;
        this.rentalStartDate = rentalStartDate;
        this.rentalEndDate = rentalEndDate;
        this.returnDate = returnDate;
        this.maxCharge = maxCharge;
    }

    public void setRentalID() {
        this.rentalId = readRentalCount();
        writeRentalCount(rentalId+1);
    }

    @Override
    public int getRentalId() {
        return rentalId;
    }

    @Override
    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    @Override
    public int getBookId() {
        return bookId;
    }

    @Override
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public int getCharge() {
        return charge;
    }

    @Override
    public void setCharge(int charge) {
        this.charge = charge;
    }

    @Override
    public Date getRentalStartDate() {
        return rentalStartDate;
    }

    @Override
    public void setRentalStartDate(Date rentalStartDate) {
        this.rentalStartDate = rentalStartDate;
    }

    @Override
    public Date getRentalEndDate() {
        return rentalEndDate;
    }

    @Override
    public void setRentalEndDate(Date rentalEndDate) {
        this.rentalEndDate = rentalEndDate;
    }

    @Override
    public Date getReturnDate(){
        return this.returnDate;
    }

    @Override
    public int getMaxCharge() {
        return maxCharge;
    }

    /**
     * Return bookID
     *
     * @return bookID
     */
    @Override
    public int getBookID() {
        return this.bookId;
    }

    /**
     * Return StartDate of the entry
     *
     * @return start date
     */
    @Override
    public Date getStartDate() {
        return this.rentalStartDate;
    }

    /**
     * Return EndDate of the entry
     *
     * @return end date
     */
    @Override
    public Date getEndDate() {
        return this.rentalEndDate;
    }

    /**
     * Reads the current rental count from the file.
     *
     * @return the current rental count, or 0 if an error occurs
     */
    public static int readRentalCount() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            return jsonObject.get("rentCount").getAsInt();
        } catch (IOException e) {
            return 0;
        }
    }

    /**
     * Writes the updated rental count to the file.
     *
     * @param rentalCount the updated rental count
     */
    static void writeRentalCount(int rentalCount) {
        JsonObject jsonObject;

        // Read the existing file and parse it as a JsonObject
        try {
            String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
            jsonObject = JsonParser.parseString(content).getAsJsonObject();
        } catch (IOException e) {
            jsonObject = new JsonObject();
            jsonObject.addProperty("transactionCount", 0);
        }

        jsonObject.addProperty("rentCount", rentalCount);
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(jsonObject, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Calculates the rental and overdue charges based on the rental period and return date.
     * The total charge is the sum of the rental charge and any overdue charge, capped at a maximum charge.
     */
    public void calculateCharge(){
        long diffInMillies = Math.abs(rentalEndDate.getTime() - rentalStartDate.getTime());
        long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        int rental_charge = (int) diffInDays * chargePerDay;
        int overdue_charge = 0;
        if (returnDate.after(rentalEndDate)){
            long diffInMilliesOverdue = Math.abs(returnDate.getTime() - rentalEndDate.getTime());
            long diffInDaysOverdue = TimeUnit.DAYS.convert(diffInMilliesOverdue, TimeUnit.MILLISECONDS);
            overdue_charge = (int) diffInDaysOverdue * overdueChargePerDay;
        }
        this.maxCharge = rental_charge * 5;
        this.charge = Math.min(maxCharge, overdue_charge + rental_charge);
    }
}
