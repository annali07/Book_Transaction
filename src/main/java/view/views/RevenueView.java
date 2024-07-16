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

public class RevenueView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "Calculate Revenue";
    private final RevenueViewModel revenueViewModel;
    private final RevenueController revenueController;

    /**
     * Input ISBN given to the manager
     */
    final JTextField startDateField = new JTextField(15);
    final JTextField endDateField = new JTextField(15);
    private final JLabel dateErrorField = new JLabel();

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
                new JLabel("Start Date in yyyy/mm/dd"), startDateField);
        LabelTextPanel endDate = new LabelTextPanel(
                new JLabel("End Date in yyyy/mm/dd"), endDateField);
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
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 250);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if ("Total Revenue".equals(evt.getActionCommand())) {
            System.out.println("Total Revenue button clicked");
            RevenueState state = revenueViewModel.getState();
            if (state == null) {
                throw new IllegalStateException("RevenueViewModel is null");
            }
            String startDate1 = state.getStartDateString();
            String endDate1 = state.getEndDateString();
            if (startDate1 == null || startDate1.isEmpty() || endDate1 == null || endDate1.isEmpty()) {
                System.out.println("Date is empty or null");
                return;
            }
            Date startDate = stringToDate(startDate1);
            Date endDate = stringToDate(endDate1);
            revenueController.execute(startDate, endDate, true, true);
        } else if ("Purchase Revenue".equals(evt.getActionCommand())) {
            System.out.println("Purchase Revenue button clicked");
            RevenueState state = revenueViewModel.getState();
            if (state == null) {
                throw new IllegalStateException("RevenueViewModel is null");
            }
            String startDate1 = state.getStartDateString();
            String endDate1 = state.getEndDateString();

            if (startDate1 == null || startDate1.isEmpty() || endDate1 == null || endDate1.isEmpty()) {
                System.out.println("Date is empty or null");
                return;
            }
            Date startDate = stringToDate(startDate1);
            Date endDate = stringToDate(endDate1);
            revenueController.execute(startDate, endDate, false, true);
        } else if ("Rental Revenue".equals(evt.getActionCommand())) {
            System.out.println("Rental Revenue button clicked");
            RevenueState state = revenueViewModel.getState();
            if (state == null) {
                throw new IllegalStateException("RevenueViewModel is null");
            }
            String startDate1 = state.getStartDateString();
            String endDate1 = state.getEndDateString();
            if (startDate1 == null || startDate1.isEmpty() || endDate1 == null || endDate1.isEmpty()) {
                System.out.println("Date is empty or null");
                return;
            }
            Date startDate = stringToDate(startDate1);
            Date endDate = stringToDate(endDate1);
            revenueController.execute(startDate, endDate, true, false);
        } else if ("Cancel".equals(evt.getActionCommand())) {
            revenueController.cancel();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        RevenueState state = (RevenueState) evt.getNewValue();
        setFields(state);
    }
    private void setFields(RevenueState state) {
        startDateField.setText(state.getStartDateString());
        endDateField.setText(state.getEndDateString());
    }

    public static Date stringToDate( String dateStr ) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

        try {
            Date date = formatter.parse(dateStr);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
