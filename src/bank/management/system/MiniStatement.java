package bank.management.system;
import java.awt.Color;
import java.sql.*;
import javax.swing.*;
public class MiniStatement extends JFrame {
    int bal=0;
    MiniStatement(String pinnumber){
        setTitle("Mini Statement");
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setLayout(null);

        JLabel mini = new JLabel();
        mini.setBounds(20,200,400,200);
        add(mini);

        JLabel bank = new JLabel("SL Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,140,300,20);
        add(balance);

        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"' ");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    bal+=Integer.parseInt(rs.getString("amount"));
                }else{
                    bal-=Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current balance is ₹"+bal);
        }catch(Exception e){
            System.out.println(e);
        }

        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while (rs.next()) {
                card.setText("Card Number: "+ rs.getString("cardNumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardNumber").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }

        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br>");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }    
}
