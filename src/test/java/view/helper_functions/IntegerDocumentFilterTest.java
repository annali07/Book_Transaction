package view.helper_functions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.text.*;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerDocumentFilterTest {

    private IntegerDocumentFilter filter;
    private Document document;

    @BeforeEach
    void setUp() {
        filter = new IntegerDocumentFilter();
        document = new PlainDocument();
        ((AbstractDocument) document).setDocumentFilter(filter);
    }

    @Test
    void testInsertStringValidInput() throws BadLocationException {
        filter.insertString(new FilterBypassImpl(document), 0, "123", null);
        assertEquals("123", document.getText(0, document.getLength()));
    }

    @Test
    void testInsertStringInvalidInput() throws BadLocationException {
        filter.insertString(new FilterBypassImpl(document), 0, "abc", null);
        assertEquals("", document.getText(0, document.getLength()));
    }

    @Test
    void testReplaceValidInput() throws BadLocationException {
        document.insertString(0, "123", null);
        filter.replace(new FilterBypassImpl(document), 0, document.getLength(), "456", null);
        assertEquals("456", document.getText(0, document.getLength()));
    }

    @Test
    void testReplaceInvalidInput() throws BadLocationException {
        document.insertString(0, "123", null);
        filter.replace(new FilterBypassImpl(document), 0, document.getLength(), "abc", null);
        assertEquals("123", document.getText(0, document.getLength()));
    }

    @Test
    void testRemove() throws BadLocationException {
        document.insertString(0, "123", null);
        filter.remove(new FilterBypassImpl(document), 0, document.getLength());
        assertEquals("", document.getText(0, document.getLength()));
    }

    private static class FilterBypassImpl extends DocumentFilter.FilterBypass {
        private final Document document;

        public FilterBypassImpl(Document document) {
            this.document = document;
        }

        @Override
        public Document getDocument() {
            return document;
        }

        @Override
        public void remove(int offset, int length) throws BadLocationException {
            document.remove(offset, length);
        }

        @Override
        public void insertString(int offset, String string, AttributeSet attr) throws BadLocationException {
            document.insertString(offset, string, attr);
        }

        @Override
        public void replace(int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            
        }
    }
}
