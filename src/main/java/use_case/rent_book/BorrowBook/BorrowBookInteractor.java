package use_case.rent_book.BorrowBook;

import data_access.database_borrow_book.DatabaseBorrowInterface;

import java.util.Date;

public class BorrowBookInteractor implements BorrowBookInputBoundary {

    private final DatabaseBorrowInterface userGateway;
    private final BorrowBookOutputBoundary presenter;

    public BorrowBookInteractor(DatabaseBorrowInterface userGateway, BorrowBookOutputBoundary presenter) {
        this.userGateway = userGateway;
        this.presenter = presenter;
    }

    @Override
    public void execute(BorrowBookInputData returnBookInputData) {
        int bookID = returnBookInputData.getBookID();
        Date startDate = returnBookInputData.getStartDate();
        Date endDate = returnBookInputData.getEndDate();
        String borrowerName = returnBookInputData.getBorrowerName();
        String borrowerNumber = returnBookInputData.getBorrowerNumber();

        userGateway.writeBorrowFile(bookID, startDate,endDate,borrowerName,borrowerNumber);
        BorrowBookOutputData borrowBookOutputData = new BorrowBookOutputData(bookID, startDate, endDate, borrowerName, borrowerNumber);
        presenter.prepareSuccessView(borrowBookOutputData);
        System.out.println("I have borrowed the book");
    }

    @Override
    public void cancel() {
        presenter.prepareCancelView();
    }
}
