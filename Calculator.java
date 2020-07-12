package javaapplication1;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Calculator implements ActionListener {
    
    String str, printStr;
    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, plus, minus, mul, div, equals, recentOperator, back, inverse, root, square, decimal, clear;
    JButton operationSeleted;
    JFrame f;
    JLabel resultArea;
    double number1, number2, result;
    boolean numberOneTaken, numberTwoTaken, operatorSelected, operatorJustSelected;
    
    public Calculator() {
        f = new JFrame();
        resultArea = new JLabel();
        resultArea.setBounds(80, 10, 240, 40);
        
        JPanel forEquals = new JPanel();
        forEquals.setBounds(280, 75, 75, 35);
        forEquals.setLayout(new GridLayout(1, 1));
        
        JPanel numbers = new JPanel();
        numbers.setBounds(20, 120, 340, 200);
        numbers.setLayout(new GridLayout(5, 4, 5, 5));
//        numbers.setBackground(Color.red)

        JButton[] buttons = new JButton[9];

        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        
        plus = new JButton("+");
        minus = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        decimal = new JButton(".");
        clear = new JButton("C");
        back = new JButton("back");
        inverse = new JButton("1/x");
        root = new JButton("root");
        square = new JButton("x*x");
        equals = new JButton("=");
        
        
        forEquals.add(equals);
        numbers.add(clear);
        numbers.add(b1);
        numbers.add(b2);
        numbers.add(b3);
        
        numbers.add(div);
        numbers.add(b4);
        numbers.add(b5);
        numbers.add(b6);
        
        numbers.add(minus);
        numbers.add(b7);
        numbers.add(b8);
        numbers.add(b9);
        
        numbers.add(plus);
        numbers.add(mul);
        numbers.add(b0);
        numbers.add(decimal);
        numbers.add(back);
        numbers.add(inverse);
        numbers.add(root);
        numbers.add(square);
        
        b1.setBackground(Color.white);
        b2.setBackground(Color.white);
        b3.setBackground(Color.white);
        b4.setBackground(Color.white);
        b5.setBackground(Color.white);
        b6.setBackground(Color.white);
        b7.setBackground(Color.white);
        b8.setBackground(Color.white);
        b9.setBackground(Color.white);
        
        b0.setBackground(Color.white);
        
        plus.setBackground(Color.white);
        minus.setBackground(Color.white);
        mul.setBackground(Color.white);
        div.setBackground(Color.white);
        decimal.setBackground(Color.white);
        clear.setBackground(Color.blue);
        clear.setForeground(Color.WHITE);
        back.setBackground(Color.white);
        inverse.setBackground(Color.white);
        root.setBackground(Color.white);
        square.setBackground(Color.white);
        equals.setBackground(Color.BLUE);
        equals.setForeground(Color.WHITE);
        
        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        
        plus.addActionListener(this);
        minus.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        equals.addActionListener(this);
        clear.addActionListener(this);
        back.addActionListener(this);
        root.addActionListener(this);
        inverse.addActionListener(this);
        square.addActionListener(this);
        decimal.addActionListener(this);
        
        
        f.add(resultArea);
        f.add(forEquals);
        f.add(numbers);
        
        
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        clearEverything();
    }
    
    public static void main(String args[]){
        Calculator calculator = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton tempButtonReference = (JButton)e.getSource();
        if(tempButtonReference == clear)
            clearEverything();
        
        else if(tempButtonReference == back)
        {
            int length = printStr.length();
            if(length <= 1){
                clearEverything();
                return;
            }
            char ch = printStr.charAt(length-1);
            printStr = printStr.substring(0, length - 1);
            
            if((ch == '+') || (ch == '-') || (ch == '*') || (ch == '/')){
                operatorSelected = false;
            }
            
            
        }
        
        else if((tempButtonReference == b0) || (tempButtonReference == b1) || (tempButtonReference == b2) || (tempButtonReference == b3) || (tempButtonReference == b4) || (tempButtonReference == b5) || (tempButtonReference == b5) || (tempButtonReference == b6) || (tempButtonReference == b7) || (tempButtonReference == b8) || (tempButtonReference == b6) || (tempButtonReference == b7) || (tempButtonReference == b8) || (tempButtonReference == b9) || (tempButtonReference == decimal)){
            str += tempButtonReference.getText();
            printStr += tempButtonReference.getText();
            operatorJustSelected = false;
        }
        
        else{
            if(operatorJustSelected == true){
                invalidOperationMessage();
            }
            else if(operatorSelected == true){

                String operationToBePerformed = operationSeleted.getText();
                int operationIndex = printStr.indexOf(operationToBePerformed);
                String numberOne = printStr.substring(0, operationIndex);
                int firstIndex = numberOne.indexOf('.');
                if((firstIndex != -1) && (numberOne.indexOf('.', firstIndex+1) != -1))
                {
                    invalidOperationMessage();
                    clearEverything();
                    return;
                }
                number1 = Double.parseDouble(numberOne);
                numberOneTaken = true;
                String numberTwo = printStr.substring(operationIndex + 1);
                
                firstIndex = numberTwo.indexOf('.');
                if((firstIndex != -1) && (numberTwo.indexOf('.', firstIndex) != -1))
                {
                    invalidOperationMessage();
                    clearEverything();
                    return;
                }
                
                number2 = Double.parseDouble(numberTwo);
                numberTwoTaken = true;
                result = 0.0;
                
                if(operationSeleted == plus){
                    result = number1 + number2;
                }
                else if(operationSeleted == minus)
                    result = number1 - number2;
                else if(operationSeleted == mul)
                    result = number1 * number2;
                else if(operationSeleted == div)
                    result = number1 / number2;
                
                printStr = result + "";
                if(tempButtonReference == equals){
                    operatorSelected = false;
                }
                else{
                    printStr += tempButtonReference.getText();
                    operatorJustSelected = true;
                    operationSeleted = tempButtonReference;
                }
                
            }
            else{
                if(tempButtonReference == inverse){
                    
                }
                
                else if(tempButtonReference != equals){
                    operatorSelected = true;
                    operationSeleted = tempButtonReference;
                    
                    printStr += operationSeleted.getText();
                    
                }
            }
        }
        
        resultArea.setText(printStr);
    }
    
    public void invalidOperationMessage(){
        JOptionPane.showMessageDialog(f, "Invalid Operation");
    }
    
    private void clearEverything(){
        numberOneTaken = false;
        numberTwoTaken = false;
        operatorSelected = false;
        operatorJustSelected = false;
        str = "";
        printStr = "";
        resultArea.setText("0.0");
    }
    
}
