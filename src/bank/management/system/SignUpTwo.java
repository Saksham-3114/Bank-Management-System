package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener {

    JTextField pan, aadhar; 
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox<String> religion, category, income, education, occupation;

    String formno;

SignUpTwo(String formno){
    this.formno = formno;

    setTitle("NEW APPLICATION FORM - PAGE 2");
    setLayout(null);
    setSize(850,800);
    setVisible(true);
    setLocation(350,10);
    getContentPane().setBackground(Color.decode("#fefef4"));

    JLabel additionalDetails = new JLabel("Page 2: Additional Details");
    additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
    additionalDetails.setBounds(290,80,400,30);
    add(additionalDetails);

    JLabel name = new JLabel("Religion : ");
    name.setFont(new Font("Raleway",Font.BOLD,20));
    name.setBounds(100,140,100,30);
    add(name);
    
    JLabel fname = new JLabel("Category : ");
    fname.setFont(new Font("Raleway",Font.BOLD,20));
    fname.setBounds(100,190,200,30);
    add(fname);
    
    JLabel dob = new JLabel("Income : ");
    dob.setFont(new Font("Raleway",Font.BOLD,20));
    dob.setBounds(100,240,200,30);
    add(dob);
    
    JLabel gen = new JLabel("Educational ");
    gen.setFont(new Font("Raleway",Font.BOLD,20));
    gen.setBounds(100,290,200,30);
    add(gen);
    
    JLabel email = new JLabel("Qualification : ");
    email.setFont(new Font("Raleway",Font.BOLD,20));
    email.setBounds(100,315,200,30);
    add(email);
    
    JLabel marital = new JLabel("Occupation : ");
    marital.setFont(new Font("Raleway",Font.BOLD,20));
    marital.setBounds(100,390,200,30);
    add(marital);
    
    JLabel address = new JLabel("PAN Number : ");
    address.setFont(new Font("Raleway",Font.BOLD,20));
    address.setBounds(100,440,200,30);
    add(address);
    
    JLabel city = new JLabel("Aadhar Number : ");
    city.setFont(new Font("Raleway",Font.BOLD,20));
    city.setBounds(100,490,200,30);
    add(city);
    
    JLabel state = new JLabel("Senior Citizen : ");
    state.setFont(new Font("Raleway",Font.BOLD,20));
    state.setBounds(100,540,200,30);
    add(state);
    
    JLabel pincode = new JLabel("Existing Account : ");
    pincode.setFont(new Font("Raleway",Font.BOLD,20));
    pincode.setBounds(100,590,200,30);
    add(pincode);

    String valReligion[]={"Hindu","Christian","Sikh","Muslim","Other"};
    religion = new JComboBox<>(valReligion);
    religion.setFont(new Font("Raleway",Font.BOLD,14));
    religion.setBounds(300, 140, 400, 30);
    religion.setBackground(Color.WHITE);
    add(religion);
    
    String valCategory[]={"General","SC","ST","OBC","Other"};
    category = new JComboBox<>(valCategory);
    category.setFont(new Font("Raleway",Font.BOLD,14));
    category.setBounds(300, 190, 400, 30);
    category.setBackground(Color.WHITE);
    add(category);
    
    String valincome[]={"Null","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000",">10,00,000"};
    income = new JComboBox<>(valincome);
    income.setFont(new Font("Raleway",Font.BOLD,14));
    income.setBounds(300, 240, 400, 30);
    income.setBackground(Color.WHITE);
    add(income);
    
    String valEducation[]={"None","Non-Graduate","Graduate","Post-Graduate","Doctorate","Other"};
    education = new JComboBox<>(valEducation);
    education.setFont(new Font("Raleway",Font.BOLD,14));
    education.setBounds(300, 315, 400, 30);
    education.setBackground(Color.WHITE);
    add(education);
    
    String valOccu[]={"Salaried","Self-Employed","Business","Student","Retired","Other"};
    occupation = new JComboBox<>(valOccu);
    occupation.setFont(new Font("Raleway",Font.BOLD,14));
    occupation.setBounds(300, 390, 400, 30);
    occupation.setBackground(Color.WHITE);
    add(occupation);

    pan = new JTextField();
    pan.setFont(new Font("Raleway",Font.BOLD,14));
    pan.setBounds(300, 440, 400, 30);
    add(pan);
    
    aadhar = new JTextField();
    aadhar.setFont(new Font("Raleway",Font.BOLD,14));
    aadhar.setBounds(300, 490, 400, 30);
    add(aadhar);
    
    syes = new JRadioButton("Yes");
    syes.setBounds(300,540,100,30);
    syes.setBackground(Color.decode("#fefef4"));
    add(syes);
    sno = new JRadioButton("No");
    sno.setBounds(480,540,100,30);
    sno.setBackground(Color.decode("#fefef4"));
    add(sno);
    ButtonGroup senior = new ButtonGroup();
    senior.add(syes);
    senior.add(sno);
    
    eyes = new JRadioButton("Yes");
    eyes.setBounds(300,590,100,30);
    eyes.setBackground(Color.decode("#fefef4"));
    add(eyes);
    eno = new JRadioButton("No");
    eno.setBounds(480,590,100,30);
    eno.setBackground(Color.decode("#fefef4"));
    add(eno);
    ButtonGroup exist = new ButtonGroup();
    exist.add(eyes);
    exist.add(eno);
    
    next = new JButton("Next");
    next.setBackground(Color.BLACK);
    next.setForeground(Color.WHITE);
    next.setFont(new Font("Raleway",Font.BOLD,14));
    next.setBounds(620,660,80,30);
    next.addActionListener(this);
    add(next);

}

public void actionPerformed(ActionEvent ae){
    String sreligion = (String) religion.getSelectedItem();
    String scategory = (String) category.getSelectedItem();
    String sincome = (String) income.getSelectedItem();
    String seducation = (String) education.getSelectedItem();
    String soccupation = (String) occupation.getSelectedItem();
    String span = pan.getText();
    String saadhar = aadhar.getText();
    String seniorCitizen = null;
    if(syes.isSelected()){
        seniorCitizen="Yes";
    }else if (sno.isSelected()){
        seniorCitizen="No";
    }
    String exist=null;
    if(eyes.isSelected()){
        exist="Yes";
    }else if (eno.isSelected()){
        exist="No";
    }

    try{
        
        Conn c = new Conn();
        String query = "INSERT INTO signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorCitizen+"','"+exist+"')";
        c.s.executeUpdate(query);
        
        setVisible(false);
        new SignUpThree(formno).setVisible(true);
    }catch(Exception e){
        System.out.println(e);
    }
}

    public static void main(String args[]){
        new SignUpTwo("");
    }
}