package data_access.data_base_return_book;

public interface DatabaseReturnInterface {
    public void editBookFile(int bookID);
    public void writeReturnFile(int bookID, int Charge);
}
