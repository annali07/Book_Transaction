package data_access;

import entity.Book;

public interface DatabaseBookDataAccessInterface {
    public Book getBook(int bookID);
    public boolean updateBook(Book book);
}
