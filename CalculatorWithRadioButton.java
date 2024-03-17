import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorWithRadioButton extends JFrame implements ActionListener {
    private JRadioButton basicCalculatorRadioButton; // radio button for the basic calculator
    private JRadioButton scientificCalculatorRadioButton; // radio button for the scientific calculator
    private Calculator basicCalculator; //basic calculator class
    private ScieCalculator scientificCalculator; // scientific calculator class
    private JPanel panel;

    CalculatorWithRadioButton() {
        setTitle("Calculator Selection");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       

        basicCalculatorRadioButton = new JRadioButton("Basic Calculator");
        basicCalculatorRadioButton.addActionListener(this);

        scientificCalculatorRadioButton = new JRadioButton("Scientific Calculator");
        scientificCalculatorRadioButton.addActionListener(this);

        ButtonGroup buttonGroup = new ButtonGroup(); // enables the program to select one radio button at a time
        buttonGroup.add(basicCalculatorRadioButton);
        buttonGroup.add(scientificCalculatorRadioButton);

        panel = new JPanel();
        panel.add(basicCalculatorRadioButton);
        panel.add(scientificCalculatorRadioButton);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == basicCalculatorRadioButton) {
            if (basicCalculator == null) {
                basicCalculator = new Calculator();
            } else {
                basicCalculator.setVisible(true);
            }
        } else if (e.getSource() == scientificCalculatorRadioButton) {
            if (scientificCalculator == null) {
                scientificCalculator = new ScieCalculator();
            } else {
                scientificCalculator.setVisible(true);
            }
        }
    }

    public static void main(String[] args) {
        new CalculatorWithRadioButton();
    }
}
