package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUpOne extends JFrame implements ActionListener {

    long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pincodeTextField; 
    JButton next;
    JRadioButton male,female,married,unmarried,other;
    JDateChooser dateChooser;

SignUpOne(){
    setTitle("NEW APPLICATION FORM - PAGE 1");
    setLayout(null);
    setSize(850,800);
    setVisible(true);
    setLocation(350,10);
    getContentPane().setBackground(Color.decode("#fefef4"));

    Random ran =new Random();
    random = Math.abs(ran.nextLong()%9000l+1000l);

    JLabel formno = new JLabel("APPLICATION FORM NO. "+random);
    formno.setFont(new Font("Raleway",Font.BOLD,38));
    formno.setBounds(140,20,600,40);
    add(formno);

    JLabel personDetails = new JLabel("Page 1: Personal Details");
    personDetails.setFont(new Font("Raleway",Font.BOLD,22));
    personDetails.setBounds(290,80,400,30);
    add(personDetails);

    JLabel name = new JLabel("Name : ");
    name.setFont(new Font("Raleway",Font.BOLD,20));
    name.setBounds(100,140,100,30);
    add(name);
    
    JLabel fname = new JLabel("Father's Name : ");
    fname.setFont(new Font("Raleway",Font.BOLD,20));
    fname.setBounds(100,190,200,30);
    add(fname);
    
    JLabel dob = new JLabel("Date of Birth : ");
    dob.setFont(new Font("Raleway",Font.BOLD,20));
    dob.setBounds(100,240,200,30);
    add(dob);
    
    JLabel gen = new JLabel("Gender : ");
    gen.setFont(new Font("Raleway",Font.BOLD,20));
    gen.setBounds(100,290,200,30);
    add(gen);
    
    JLabel email = new JLabel("Email Address : ");
    email.setFont(new Font("Raleway",Font.BOLD,20));
    email.setBounds(100,340,200,30);
    add(email);
    
    JLabel marital = new JLabel("Marital Status : ");
    marital.setFont(new Font("Raleway",Font.BOLD,20));
    marital.setBounds(100,390,200,30);
    add(marital);
    
    JLabel address = new JLabel("Address : ");
    address.setFont(new Font("Raleway",Font.BOLD,20));
    address.setBounds(100,440,200,30);
    add(address);
    
    JLabel city = new JLabel("City : ");
    city.setFont(new Font("Raleway",Font.BOLD,20));
    city.setBounds(100,490,200,30);
    add(city);
    
    JLabel state = new JLabel("State : ");
    state.setFont(new Font("Raleway",Font.BOLD,20));
    state.setBounds(100,540,200,30);
    add(state);
    
    JLabel pincode = new JLabel("Pincode : ");
    pincode.setFont(new Font("Raleway",Font.BOLD,20));
    pincode.setBounds(100,590,200,30);
    add(pincode);

    nameTextField = new JTextField();
    nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
    nameTextField.setBounds(300, 140, 400, 30);
    add(nameTextField);
    
    fnameTextField = new JTextField();
    fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
    fnameTextField.setBounds(300, 190, 400, 30);
    add(fnameTextField);
    
    emailTextField = new JTextField();
    emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
    emailTextField.setBounds(300, 340, 400, 30);
    add(emailTextField);
    
    addressTextField = new JTextField();
    addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
    addressTextField.setBounds(300, 440, 400, 30);
    add(addressTextField);
    
    cityTextField = new JTextField();
    cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
    cityTextField.setBounds(300, 490, 400, 30);
    add(cityTextField);
    
    stateTextField = new JTextField();
    stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
    stateTextField.setBounds(300, 540, 400, 30);
    add(stateTextField);
    
    pincodeTextField = new JTextField();
    pincodeTextField.setFont(new Font("Raleway",Font.BOLD,14));
    pincodeTextField.setBounds(300, 590, 400, 30);
    add(pincodeTextField);

    dateChooser = new JDateChooser();
    dateChooser.setBounds(300,240,400,30);
    dateChooser.setForeground(new Color(105,105,105));
    add(dateChooser);

    male = new JRadioButton("Male");
    male.setBounds(300,290,60,30);
    male.setBackground(Color.decode("#fefef4"));
    add(male);
    female = new JRadioButton("Female");
    female.setBounds(450,290,120,30);
    female.setBackground(Color.decode("#fefef4"));
    add(female);
    ButtonGroup gendergroup = new ButtonGroup();
    gendergroup.add(male);
    gendergroup.add(female);
    
    married = new JRadioButton("Married");
    married.setBounds(300,390,100,30);
    married.setBackground(Color.decode("#fefef4"));
    add(married);
    unmarried = new JRadioButton("Unmarried");
    unmarried.setBounds(450,390,100,30);
    unmarried.setBackground(Color.decode("#fefef4"));
    add(unmarried);
    other = new JRadioButton("Other");
    other.setBounds(630,390,100,30);
    other.setBackground(Color.decode("#fefef4"));
    add(other);
    ButtonGroup maritalgroup = new ButtonGroup();
    maritalgroup.add(married);
    maritalgroup.add(unmarried);
    maritalgroup.add(other);

    next = new JButton("Next");
    next.setBackground(Color.BLACK);
    next.setForeground(Color.WHITE);
    next.setFont(new Font("Raleway",Font.BOLD,14));
    next.setBounds(620,660,80,30);
    next.addActionListener(this);
    add(next);

}

public void actionPerformed(ActionEvent ae){
    String formno = ""+random;
    String name = nameTextField.getText();
    String fname = fnameTextField.getText();
    String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
    String gender = null;
    if(male.isSelected()){
        gender="Male";
    }else if (female.isSelected()){
        gender="Female";
    }
    String email = emailTextField.getText();
    String marital=null;
    if(married.isSelected()){
        marital="Married";
    }else if (unmarried.isSelected()){
        marital="Unmarried";
    }else if (other.isSelected()){
        marital="Other";
    }
    String address = addressTextField.getText();
    String city = cityTextField.getText();
    String state = stateTextField.getText();
    String pincode = pincodeTextField.getText();

    try{
        if(name.equals("")){
            JOptionPane.showMessageDialog(null,"Name is Required !!");
        }else{
            Conn c = new Conn();
            String query = "INSERT INTO signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
            c.s.executeUpdate(query);

            setVisible(false);
            new SignUpTwo(formno).setVisible(true);
        }
    }catch(Exception e){
        System.out.println(e);
    }
}

    public static void main(String args[]){
        new SignUpOne();
    }
}
