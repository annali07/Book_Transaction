package data_access.add_book_repository;
import entity.book.Book;

public interface BookRepositoryDataAccessInterface {
    void saveBook(Book book);
}
