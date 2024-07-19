package view.views;

import interface_adapter.calculate_revenue.RevenueController;
import interface_adapter.calculate_revenue.RevenueState;
import interface_adapter.calculate_revenue.RevenueViewModel;
import view.helper_functions.LabelTextPanel;
import view.helper_functions.LabelTextPanelInt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The RevenueView class represents the user interface for calculating revenue.
 * It handles user input and interactions for calculating total, purchase, and rental revenue.
 *
 */
public class RevenueView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "Calculate Revenue";
    private final RevenueViewModel revenueViewModel;
    private final RevenueController revenueController;

    /**
     * Input field for the start date.
     */
    final JTextField startDateField = new JTextField(15);
    /**
     * Input field for the end date.
     */
    final JTextField endDateField = new JTextField(15);

    /**
     * Constructs a RevenueView object with the specified view model and controller.
     *
     * @param revenueViewModel the view model for calculating revenue
     * @param revenueController the controller for calculating revenue
     */
    public RevenueView(RevenueViewModel revenueViewModel, RevenueController revenueController) {
        this.revenueViewModel = revenueViewModel;
        this.revenueViewModel.addPropertyChangeListener(this);
        this.revenueController = revenueController;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("Calculate Revenue");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        this.add(title);

        LabelTextPanel startDate = new LabelTextPanel(
                new JLabel("Start Date in yyyy-mm-dd"), startDateField);
        LabelTextPanel endDate = new LabelTextPanel(
                new JLabel("End Date in yyyy-mm-dd"), endDateField);
        this.add(startDate);
        this.add(endDate);

        this.add(Box.createRigidArea(new Dimension(0, 20))); // Add space between title and buttons

        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton totalButton = new JButton("Total Revenue");
        buttons.add(totalButton);
        JButton purchaseOnlyButton = new JButton("Purchase Revenue");
        buttons.add(purchaseOnlyButton);
        JButton rentalOnlyButton = new JButton("Rental Revenue");
        buttons.add(rentalOnlyButton);
        JButton cancelButton = new JButton("Cancel");
        buttons.add(cancelButton);

        totalButton.addActionListener(this);
        purchaseOnlyButton.addActionListener(this);
        rentalOnlyButton.addActionListener(this);
        cancelButton.addActionListener(this);

        this.add(buttons);
        this.add(Box.createVerticalGlue());

        startDateField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                RevenueState currentState = revenueViewModel.getState();
                currentState.setStartDateString(startDateField.getText());
                revenueViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        endDateField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                RevenueState currentState = revenueViewModel.getState();
                currentState.setEndDateString(endDateField.getText());
                revenueViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

    }

    /**
     * Gets the preferred size for this component.
     *
     * @return the preferred size
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 250);
    }

    /**
     * Handles action events for the total revenue, purchase revenue, rental revenue, and cancel buttons.
     *
     * @param evt the action event
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (revenueViewModel.CANCEL.equals(evt.getActionCommand())) {
            revenueController.cancel();
        }

        RevenueState state = revenueViewModel.getState();
        if (state == null) {
            throw new IllegalStateException("RevenueViewModel is null");
        }

        String startDate = startDateField.getText();
        String endDate = endDateField.getText();
        if (startDate == null || startDate.isEmpty() || endDate == null || endDate.isEmpty()) {
            System.out.println("Date is empty or null");
            return;
        }

        if (revenueViewModel.TOTAL_REVENUE.equals(evt.getActionCommand())) {
            System.out.println("Total Revenue button clicked");
            revenueController.execute(startDate, endDate, true, true);

        } else if (revenueViewModel.PURCHASE_REVENUE.equals(evt.getActionCommand())) {
            System.out.println("Purchase Revenue button clicked");
            revenueController.execute(startDate, endDate, false, true);

        } else if (revenueViewModel.RENT_REVENUE.equals(evt.getActionCommand())) {
            System.out.println("Rental Revenue button clicked");
            revenueController.execute(startDate, endDate, true, false);

        }
    }

    /**
     * Handles property change events from the view model.
     *
     * @param evt the property change event
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        RevenueState state = (RevenueState) evt.getNewValue();
        setFields(state);
    }

    /**
     * Sets the fields in the view based on the given state.
     *
     * @param state the current state of the view model
     */
    private void setFields(RevenueState state) {
        startDateField.setText(state.getStartDateString());
        endDateField.setText(state.getEndDateString());
    }

}
