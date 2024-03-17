
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    private JTextField text;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subButton, mulButton, divButton, clrButton, eqlButton, dotButton, delButton;
    private JPanel panel;

    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    Calculator() {
        setTitle("Basic Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        text = new JTextField();
        text.setBounds(10, 10, 270, 50);

        numberButtons = new JButton[10]; //array for digits 0-9
        functionButtons = new JButton[8]; // array for operations

        panel = new JPanel();
        panel.setBounds(10, 70, 270, 280);
        panel.setLayout(new GridLayout(6, 3, 10, 10));

// for loop for digits, an array inside the loop that creates an object with the label set to the current value of i
        for (int i = 0; i < 10; i++) { 
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this); // add an action listener to each button
        }

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        eqlButton = new JButton("=");
        clrButton = new JButton("C");
        dotButton = new JButton(".");
        delButton = new JButton("Del");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = eqlButton;
        functionButtons[5] = clrButton;
        functionButtons[6] = dotButton;
        functionButtons[7] = delButton;

        for (JButton button : functionButtons) {
            button.addActionListener(this);
        }

        panel.add(clrButton);
        panel.add(delButton);
        panel.add(divButton);
        panel.add(mulButton);
        panel.add(subButton);
        panel.add(addButton);
        panel.add(eqlButton);
        panel.add(dotButton);

        for (int i = 0; i < 10; i++) {
            panel.add(numberButtons[i]);
        }
        add(text);
        add(panel);
        setLayout(null); // enables me to be able to position and size components
        setVisible(true);
    }

    //implementation of the action listener
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                text.setText(text.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == dotButton) {
            text.setText(text.getText().concat("."));
        }
        if (e.getSource() == clrButton) {
            text.setText("");
        }
        if (e.getSource() == delButton) {
            String str = text.getText();
            text.setText("");
            for (int i = 0; i < str.length() - 1; i++) {
                text.setText(text.getText() + str.charAt(i));
            }
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(text.getText());
            operator = '+';
            text.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(text.getText());
            operator = '-';
            text.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(text.getText());
            operator = '*';
            text.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(text.getText());
            operator = '/';
            text.setText("");
        }
        if (e.getSource() == eqlButton) {
            num2 = Double.parseDouble(text.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
           
            text.setText(String.valueOf(result));
            num1 = result;
            text.setEditable(false);
        
        }
      
    }
    

    public static void main(String[] args) {
        new Calculator();
    }
}

