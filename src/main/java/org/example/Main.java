package org.example;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.Highlighter;
import javax.swing.text.NumberFormatter;
import javax.swing.border.LineBorder;

public class Main extends JFrame implements ActionListener, FocusListener{
    JLabel title, text1;
    JButton Add, Exit, remove, sumAll, sumEven, sumOdd;
    JTextField input, console;
    TextArea textList;
    int[] list = new int [20];
    int currentIndex = 0;
    public Main() throws FontFormatException {
        this.setSize(1000, 750);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        title = new JLabel("Integer Sums", JLabel.CENTER);
        title.setFont(new Font("Century Gotchic",Font.BOLD | Font.ITALIC, 25 ));
        title.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0xBB0808), 6, true), "David's", TitledBorder.LEFT, TitledBorder.TOP, new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24)));

        Exit = new JButton("Exit");
        Exit.addActionListener(this);
        Add = new JButton ("Add");
        Add.addActionListener(this);
        remove = new JButton("Remove");
        remove.addActionListener(this);
        sumAll = new JButton("Sum All");
        sumAll.addActionListener(this);
        sumEven = new JButton("Sum Even");
        sumEven.addActionListener(this);
        sumOdd = new JButton("Sum Odd");
        sumOdd.addActionListener(this);

        input = new JTextField("Input integer");
        input.addFocusListener(this);
        text1 = new JLabel("Enter Integers: ");
        text1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        textList = new TextArea("input goes here");
        textList.setEditable(false);
        console = new JTextField("This is the console");
        console.setFont(new Font("Ariel", Font.BOLD, 12));
        console.setEditable(false);

        this.add(sumAll);
        sumAll.setBounds(450, 300, 100, 30);
        this.add(sumEven);
        sumEven.setBounds(450, 350, 100, 30);
        this.add(sumOdd);
        sumOdd.setBounds(450, 400, 100, 30);
        this.add(remove);
        remove.setBounds(300, 300, 100, 30);
        this.add(console);
        console.setBounds(200, 525, 300, 50);
        this.add(Add);
        Add.setBounds(200, 300, 75, 30);
        this.add(textList);
        textList.setBounds(600, 200, 200, 300);
        this.add(input);
        input.setBounds(315, 200, 100, 50);
        this.add(text1);
        text1.setBounds(200, 200, 100, 50);
        this.add(title);
        title.setBounds(300, 50, 400, 100);
        this.add(Exit);
        Exit.setBounds(750, 600, 100, 50);
        this.setVisible(true);
    }

    public static void main(String[] args) throws FontFormatException {
        new Main();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String idk = input.getText();

        try {

            if (e.getSource() == Add) {

                int num = Integer.parseInt(idk);
                if (currentIndex < 19 && num >= 0) {
                    list[currentIndex] = num;
                    currentIndex++;
                    textList.setText("");
                    for (int x = 0; x < currentIndex; x++) {
                        textList.append(list[x] + "\n");
                    }
                } else if (currentIndex == 19) {
                    console.setText("List is full bro");
                } else if (num < 0) {
                    console.setText("Enter a positive integer number");
                }
            } else if (e.getSource() == sumAll) {
                int sum = 0;
                for (int x = 0; x < currentIndex; x++) {
                    sum += list[x];
                    String yeaBro = String.valueOf(sum);
                    console.setText(yeaBro);
                }
            } else if (e.getSource() == sumEven) {
                int sum = 0;
                for (int x = 0; x < currentIndex; x++) {
                    if (list[x] % 2 == 0) {
                        sum += list[x];
                        console.setText(String.valueOf(sum));
                    }
                    break;
                }
            } else if (e.getSource() == sumOdd) {
                int sum = 0;
                for (int x = 0; x < currentIndex; x++) {
                    if (list[x] % 2 == 1) {
                        sum += list[x];
                        String yeaBro3 = String.valueOf(sum);
                        console.setText(yeaBro3);
                    }
                }
            } else if (e.getSource() == remove) {
                int num = Integer.parseInt(idk);
                try {
                    if (num > 0) {
                        for (int x = 0; x < currentIndex; x++) {
                            if (num == list[x]) {
                                list[x] = 0;
                                for (int y = 1; y < currentIndex; y++) {
                                    if (list[y-1] == 0){
                                        list [y-1] = list[y];
                                        list [y] = 0;
                                    }
                                }
                                currentIndex--;
                                break;
                            }

                        }
                        textList.setText("");
                        for (int x = 0; x<currentIndex;x++){
                            textList.append(list[x]+ "\n");
                        }
                    }
                }catch (NumberFormatException y) {
                    console.setText("Didn't find number");
                }
            }
        }catch (NumberFormatException x) {
        console.setText("Enter a VALID POSITIVE integer value. ");
        }

      if (e.getSource() == Exit){
            System.exit(0);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == input){
            input.setText("");
//            currentIndex++; this fucking line costed me a whole ass 2 hours to fix

        }
    }

    @Override
    public void focusLost(FocusEvent e) {

    }
}