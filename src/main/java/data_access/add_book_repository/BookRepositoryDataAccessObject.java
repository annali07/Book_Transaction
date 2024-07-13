package data_access.add_book_repository;

import entity.book.Book;

public class BookRepositoryDataAccessObject implements  BookRepositoryDataAccessInterface{
    @Override
    public void saveBook(Book book) {
        System.out.println("Book saved: " + book);
    }
}
