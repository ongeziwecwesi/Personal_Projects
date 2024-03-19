
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    JTextField text;
    JButton[] numberButtons;
    JButton add, subtract, multiply, divide, clear, equal, dot, delete;
    JPanel panel;

     double num1 , num2 , result;
     char operator;

    Calculator() {
        setTitle("Basic Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        text = new JTextField();
        text.setBounds(10, 10, 270, 50);

        numberButtons = new JButton[10]; //array for digits 0-9
        

        panel = new JPanel();
        panel.setBounds(10, 70, 270, 280);
        panel.setLayout(new GridLayout(6, 3, 10, 10));

// for loop for digits, an array inside the loop that creates an object with the label set to the current value of i
        for (int i = 0; i < 10; i++) { 
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this); // add an action listener to each button
        }

        add = new JButton("+");
        subtract = new JButton("-");
        multiply = new JButton("*");
        divide = new JButton("/");
        equal = new JButton("=");
        clear = new JButton("C");
        dot = new JButton(".");
        delete = new JButton("Del");

        add.addActionListener(this);
        subtract.addActionListener(this);
        multiply.addActionListener(this);
        divide.addActionListener(this);
        clear.addActionListener(this);
        dot.addActionListener(this);
        delete.addActionListener(this);
        equal.addActionListener(this);

        panel.add(clear);
        panel.add(delete);
        panel.add(divide);
        panel.add(multiply);
        panel.add(subtract);
        panel.add(add);
        panel.add(equal);
        panel.add(dot);

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
        if (e.getSource() == dot) {
            text.setText(text.getText().concat("."));
        }
        if (e.getSource() == clear) {
            text.setText("");
        }
        if (e.getSource() == delete) {
            String str = text.getText();
            text.setText("");
            for (int i = 0; i < str.length() - 1; i++) {
                text.setText(text.getText() + str.charAt(i));
            }
        }
        if (e.getSource() == add) {
            num1 = Double.parseDouble(text.getText());
            operator = '+';
           text.setText("");
        }
        if (e.getSource() == subtract) {
            num1 = Double.parseDouble(text.getText());
            operator = '-';
            text.setText("");
        }
        if (e.getSource() == multiply) {
            num1 = Double.parseDouble(text.getText());
            operator = '*';
           text.setText("");
        }
        if (e.getSource() == divide) {
            num1 = Double.parseDouble(text.getText());
            operator = '/';
            text.setText("");
        }
        if (e.getSource() == equal) {
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

