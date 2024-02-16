package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JButton signin,clr,signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setLayout(null);
        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
        setTitle("BANK MANAGEMENT SYSTEM BY SAKSHAM SINGHAL");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        add(label);
        label.setBounds(100, 10, 100, 100);
        getContentPane().setBackground(Color.decode("#fefef4"));

        JLabel text = new JLabel("Welcome To SL Bank");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(230, 40, 400, 40);
        add(text);

        JLabel cardno = new JLabel("Card No.: ");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120, 150, 150, 30);
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        cardTextField.setBounds(300,150,230,30);
        add(cardTextField);

        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120, 220, 250, 40);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        pinTextField.setBounds(300,220,230,30);
        add(pinTextField);

        signin = new JButton("SignIn");
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.decode("#fefef4"));
        signin.setBounds(300,300,100,30);
        signin.addActionListener(this);
        add(signin);

        clr = new JButton("Clear");
        clr.setBackground(Color.BLACK);
        clr.setForeground(Color.decode("#fefef4"));
        clr.setBounds(430,300,100,30);
        clr.addActionListener(this);
        add(clr);

        signup = new JButton("Sign Up");
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.decode("#fefef4"));
        signup.setBounds(300,350,230,30);
        signup.addActionListener(this);
        add(signup);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clr){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(ae.getSource()==signin){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = String.valueOf(pinTextField.getPassword());
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource()==signup){
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
    }

    public static void main(String args[]){
        new Login();
    }
}
