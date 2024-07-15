package use_case.rent_book.ReturnBook;

import data_access.data_base_return_book.DatabaseReturnInterface;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ReturnBookInteractor implements ReturnBookInputBoundary {

    private final DatabaseReturnInterface userGateway;
    private final ReturnBookOutputBoundary presenter;

    public ReturnBookInteractor(DatabaseReturnInterface userGateway, ReturnBookOutputBoundary presenter) {
        this.userGateway = userGateway;
        this.presenter = presenter;
    }

    @Override
    public void execute(ReturnBookInputData borrowBookInputData) {
        // We could use entity here to calculate the charge
        Date endDate = borrowBookInputData.getEndDate();
        Date returnDate = borrowBookInputData.getReturnDate();
        int charge = 0;
        if (returnDate.after(endDate)){
            long diffInMillies = Math.abs(returnDate.getTime() - endDate.getTime());
            long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            charge = (int)diffInDays;
        }
        userGateway.editBookFile(borrowBookInputData.getBookID());
        userGateway.writeReturnFile(borrowBookInputData.getBookID(), charge);
        ReturnBookOutputData response = new ReturnBookOutputData(borrowBookInputData.getBookID(), charge);
        presenter.prepareSuccessView(response);
        System.out.println("I have returned the book");
    }

    @Override
    public void cancel() {
        presenter.prepareCancelView();
    }
}
