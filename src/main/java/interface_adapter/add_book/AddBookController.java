package interface_adapter.add_book;


import use_case.add_book.AddBookInputBoundary;
import use_case.add_book.AddBookInputData;
import use_case.login.LoginInputData;
import use_case.login.LoginInputDataBoundary;

public class AddBookController {
    final AddBookInputBoundary addbookUsecaseInteractor;
    public AddBookController(AddBookInputBoundary addbookUsecaseInteractor) {
        this.addbookUsecaseInteractor = addbookUsecaseInteractor;
    }

    public void execute (String isbn){
        AddBookInputData addBookInputData = new AddBookInputData(isbn);
        addbookUsecaseInteractor.addBook(addBookInputData);
    }
}
