package data_access.database_book;

import entity.Book;

public interface DatabaseBookDataAccessInterface {
    public Book getBook(int bookID);
    public boolean updateBook(Book book);
}
