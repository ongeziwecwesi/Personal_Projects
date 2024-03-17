
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ScieCalculator extends JFrame implements ActionListener {
    private JTextField text;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subButton, mulButton, divButton, clrButton, eqlButton, dotButton, delButton,
     sinButton, cosButton, tanButton, squareButton, cubeButton, sqrtButton;
    private JPanel panel;

    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    ScieCalculator() {
        setTitle("Scientific Calculator");
        setSize(310, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        text = new JTextField();
        text.setBounds(10, 10, 270, 50);
        text.setEditable(false);

        numberButtons = new JButton[10]; //array for digits 0-9
        functionButtons = new JButton[14]; // array for operations

        panel = new JPanel();
        panel.setBounds(10, 70, 270, 280);
        panel.setLayout(new GridLayout(8, 3, 10, 10));

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
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");
        squareButton = new JButton("x^2");
        cubeButton = new JButton("x^3");
        sqrtButton = new JButton("sqrt");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = eqlButton;
        functionButtons[5] = clrButton;
        functionButtons[6] = dotButton;
        functionButtons[7] = delButton;
        functionButtons[8] = sinButton;
        functionButtons[9] = cosButton;
        functionButtons[10] = tanButton;
        functionButtons[11] = squareButton;
        functionButtons[12] = cubeButton;
        functionButtons[13] = sqrtButton;

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
        panel.add(sinButton);
        panel.add(cosButton);
        panel.add(tanButton);
        panel.add(squareButton);
        panel.add(cubeButton);
        panel.add(sqrtButton);

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
        if (e.getSource() == sinButton) {
            num1 = Double.parseDouble(text.getText());
            double result = Math.sin(Math.toRadians(num1)); // Calculate sin value in radians
            text.setText(String.valueOf(result));
        }
        if (e.getSource() == cosButton) {
            num1 = Double.parseDouble(text.getText());
            double result = Math.cos(Math.toRadians(num1)); // Calculate cos value in radians
            text.setText(String.valueOf(result));
        }
        if (e.getSource() == tanButton) {
            num1 = Double.parseDouble(text.getText());
            double result = Math.tan(Math.toRadians(num1)); // Calculate tan value in radians
            text.setText(String.valueOf(result));
        }
        if (e.getSource() == squareButton) {
            num1 = Double.parseDouble(text.getText());
            double result = Math.pow(num1, 2); // Calculate square
            text.setText(String.valueOf(result));
        }
        if (e.getSource() == cubeButton) {
            num1 = Double.parseDouble(text.getText());
            double result = Math.pow(num1, 3); // Calculate cube
            text.setText(String.valueOf(result));
        }
        if (e.getSource() == sqrtButton) {
            num1 = Double.parseDouble(text.getText());
            double result = Math.sqrt(num1); // Calculate square root
            text.setText(String.valueOf(result));
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
        }
    }

    public static void main(String[] args) {
        new ScieCalculator();
    }
}

