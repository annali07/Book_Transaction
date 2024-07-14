package view.helper_functions;

import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.AttributeSet;

/**
 * A custom DocumentFilter that allows only integer input.
 * This filter can be applied to a JTextField to ensure that only numeric
 * values are entered by the user.
 */
public class IntegerDocumentFilter extends DocumentFilter {

    /**
     * Inserts the string into the document if it is numeric.
     *
     * @param fb the FilterBypass that can be used to mutate the Document
     * @param offset the offset into the document to insert the content >= 0
     * @param string the string to insert
     * @param attr the attributes to associate with the inserted content. This may be null if there are no attributes.
     * @throws BadLocationException if the insertion fails
     */
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (isNumeric(string)) {
            super.insertString(fb, offset, string, attr);
        }
    }

    /**
     * Replaces the text in the document with the specified text if it is numeric.
     *
     * @param fb the FilterBypass that can be used to mutate the Document
     * @param offset the offset into the document to insert the content >= 0
     * @param length the length of text to replace, may be 0
     * @param text the text to insert, null indicates no text to insert
     * @param attrs the attributes to associate with the inserted content. This may be null if there are no attributes.
     * @throws BadLocationException if the replacement fails
     */
    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (isNumeric(text)) {
            super.replace(fb, offset, length, text, attrs);
        }
    }

    /**
     * Removes the specified text from the document.
     *
     * @param fb the FilterBypass that can be used to mutate the Document
     * @param offset the offset from the beginning >= 0
     * @param length the number of characters to remove >= 0
     * @throws BadLocationException if the removal fails
     */
    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        super.remove(fb, offset, length);
    }

    /**
     * Checks if the given string is a numeric value.
     *
     * @param str the string to check
     * @return true if the string is numeric, false otherwise
     */
    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
