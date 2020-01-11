package main;

import javax.swing.*;
import java.awt.*;

public class MortgageForm {
    private JTextField principalTextField;
    private JTextField interestTextField;
    private JTextField yearsTextField;
    private JButton makeMonthlyPaymentButton;
    private JButton mortgageButton;
    private JLabel totalPaid;
    private JLabel totalPaidLabel;
    private JPanel mainPanel;
    private JLabel remainingPrincipalLabel;
    private JLabel remainingPrincipal;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mortgage Form");
        frame.setContentPane(new MortgageForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private Mortgage mortgage;

    public MortgageForm() {
        this.mainPanel.setPreferredSize(new Dimension(600,600));
        setInitialState();

        mortgageButton.addActionListener(actionEvent -> {
            double principal = Double.parseDouble(principalTextField.getText());
            double interest = Double.parseDouble(interestTextField.getText());
            double years = Double.parseDouble(yearsTextField.getText());

            disableMortgageInputFields();

            this.mortgage = new Mortgage(principal, interest, years);
            remainingPrincipal.setText(String.valueOf(this.mortgage.getRemainingPrincipal()));

            makeMonthlyPaymentButton.setVisible(true);
            mortgageButton.setVisible(false);

            showMortgageComponents();
        });

        makeMonthlyPaymentButton.addActionListener(actionEvent -> {
            this.mortgage.makeMonthlyPayments();
            totalPaid.setText(String.valueOf(this.mortgage.getTotalPaid()));
            remainingPrincipal.setText(String.valueOf(this.mortgage.getRemainingPrincipal()));
            if (this.mortgage.getRemainingPrincipal() <= 0) {
                makeMonthlyPaymentButton.setVisible(false);
            }
        });
    }

    private void disableMortgageInputFields() {
        principalTextField.setEnabled(false);
        interestTextField.setEnabled(false);
        yearsTextField.setEnabled(false);
    }

    private void showMortgageComponents() {
        totalPaid.setVisible(true);
        totalPaidLabel.setVisible(true);
        remainingPrincipal.setVisible(true);
        remainingPrincipalLabel.setVisible(true);
    }

    private void setInitialState() {
        makeMonthlyPaymentButton.setVisible(false);
        totalPaid.setVisible(false);
        totalPaidLabel.setVisible(false);
        remainingPrincipalLabel.setVisible(false);
        remainingPrincipal.setVisible(false);
    }
}
