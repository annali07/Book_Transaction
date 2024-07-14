package interface_adapter.add_book;


import use_case.add_book.AddBookInputBoundary;
import use_case.add_book.AddBookInputData;

public class AddBookController {
    final AddBookInputBoundary addBookUsecaseInteractor;
    public AddBookController(AddBookInputBoundary addBookUsecaseInteractor) {
        this.addBookUsecaseInteractor = addBookUsecaseInteractor;
    }

    public void execute (String isbn, int price){
        AddBookInputData addBookInputData = new AddBookInputData(isbn, price);
        addBookUsecaseInteractor.addBook(addBookInputData);
    }
    public void cancel(){
        addBookUsecaseInteractor.cancel();
    }
}
