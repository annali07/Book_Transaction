package use_case.rent_book.ReturnBook;

/**
 * Interface representing the input boundary for the use case of returning book.
 */
public interface ReturnBookInputBoundary {

    /**
     * Executes the return book process using the provided input data.
     *
     * @param returnBookInputData The input data containing the relevant book information.
     */
    public void execute(ReturnBookInputData returnBookInputData);

    /**
     * Cancel the current operation
     */
    public void cancel();
}
