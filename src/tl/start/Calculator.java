package tl.start;

import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {
    /************North********************/
    private JPanel jp_north = new JPanel();
    private JTextField input_text = new JTextField();
    private JButton c_Btn = new JButton("C");

    /************center********************/
    private JPanel jp_center = new JPanel();
    public Calculator() throws HeadlessException {
        this.init();
        this.addNorthComponent();
        this.addCenterButton();
    }

    public void init(){
        this.setTitle("Calculator");
        this.setSize(300,300);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);


    }

    public void addNorthComponent(){
        this.input_text.setPreferredSize(new Dimension(200,30));
        jp_north.add(input_text);
        this.c_Btn.setForeground(Color.RED);
        jp_north.add(c_Btn);

        this.add(jp_north,BorderLayout.NORTH);
    }

    public  void addCenterButton() {
        String btn_text = "123+456-789*0.=/";
        String regex ="[+\\-*/.=]";
        this.jp_center.setLayout(new GridLayout(4,4));
        for(int i=0; i<16; i++){
            String temp = btn_text.substring(i,i+1);
            JButton btn = new JButton();
            btn.setText(temp);
            if(temp.matches(regex)) {
                btn.setFont(new Font("bold",Font.BOLD,16));
                btn.setForeground(Color.RED);
            }
            //if(temp.equals("+") ||temp.equals("-") ||temp.equals("/")||temp.equals(".")||temp.equals("=")) {
            //    ;
            //}
            jp_center.add(btn);
        }
        this.add(jp_center,BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setVisible(true);
    }
}
