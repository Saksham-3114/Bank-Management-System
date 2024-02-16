package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class fastCash extends JFrame implements ActionListener{

    JButton deposit,withdrawal,miniStatement,pinChange,fastCash,balanceEnquiry,exit;
    String pinnumber;
    fastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        getContentPane().setBackground(Color.decode("#fefef4"));
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Select withdrawal amount");
        text.setBounds(165,225,700,35);
        text.setFont(new Font("System", Font.BOLD, 38));
        image.add(text);

        deposit = new JButton("₹100");
        deposit.setBounds(170,415,150,30);
        deposit.setBackground(Color.BLACK);
        deposit.setForeground(Color.WHITE);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal = new JButton("₹500");
        withdrawal.setBounds(570,415,150,30);
        withdrawal.setBackground(Color.BLACK);
        withdrawal.setForeground(Color.WHITE);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastCash = new JButton("₹1000");
        fastCash.setBounds(170,450,150,30);
        fastCash.setBackground(Color.BLACK);
        fastCash.setForeground(Color.WHITE);
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        miniStatement = new JButton("₹2000");
        miniStatement.setBounds(570,450,150,30);
        miniStatement.setBackground(Color.BLACK);
        miniStatement.setForeground(Color.WHITE);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        pinChange = new JButton("₹5000");
        pinChange.setBounds(170,485,150,30);
        pinChange.setBackground(Color.BLACK);
        pinChange.setForeground(Color.WHITE);
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        balanceEnquiry = new JButton("₹10000");
        balanceEnquiry.setBounds(570,485,150,30);
        balanceEnquiry.setBackground(Color.BLACK);
        balanceEnquiry.setForeground(Color.WHITE);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);
        
        exit = new JButton("Back");
        exit.setBounds(170,520,150,30);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        image.add(exit);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(1);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"' ");
                int balance =0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource()!=exit && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawal','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "₹"+amount+" debited from account successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String args[]){
        new fastCash("");
    }
}
