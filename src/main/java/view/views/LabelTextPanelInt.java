package view.views;

import javax.swing.*;
import javax.swing.text.PlainDocument;

/**
 * A panel containing a label and a text field that only allows integer input.
 * This class extends JPanel and applies an IntegerDocumentFilter to the text field,
 * ensuring that only numeric values can be entered by the user.
 */
public class LabelTextPanelInt extends JPanel {

    /**
     * Constructs a LabelTextPanelInt with the specified label and text field.
     * The text field is filtered to only allow integer input.
     *
     * @param label the JLabel to be displayed alongside the text field
     * @param textField the JTextField that will only accept integer input
     */
    public LabelTextPanelInt(JLabel label, JTextField textField) {
        super();
        this.add(label);
        this.add(textField);

        // Apply IntegerDocumentFilter to the text field
        ((PlainDocument) textField.getDocument()).setDocumentFilter(new IntegerDocumentFilter());
    }
}
