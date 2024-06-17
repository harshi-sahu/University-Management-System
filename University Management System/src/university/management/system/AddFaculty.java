package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddFaculty extends JFrame implements ActionListener{
    
    JTextField tfname, tffname, tfmname, tfaddress, tfphone, tfemail, tf10percent, tf12percent, tfaadhar;
    JLabel labelempid;
    JDateChooser dcdob;
    JComboBox cbqualification, cbdept;
    JButton submit, cancel;
    
    Random ran = new Random();
    long last4 = Math.abs((ran.nextLong() % 9000L) + 1000L);
    
    AddFaculty(){
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(900, 700);
        setLocation(350, 50);
        
        setLayout(null);
        
        JLabel heading = new JLabel("New Faculty Information");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30)); 
        add(heading);
        
        //teacher Name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40, 90, 100, 20);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(160, 90, 200, 20);
        add(tfname);
        
        //teacher's Father Name
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(40, 120, 100, 20);
        add(lblfname);
        
        tffname = new JTextField();
        tffname.setBounds(160, 120, 200, 20);
        add(tffname);
        
        //teacher's Mother Name
        JLabel lblmname = new JLabel("Mother's Name");
        lblmname.setBounds(40, 150, 100, 20);
        add(lblmname);
        
        tfmname = new JTextField();
        tfmname.setBounds(160, 150, 200, 20);
        add(tfmname);
        
        //teacher's id
        JLabel lblempid = new JLabel("Employee Id");
        lblempid.setBounds(40, 180, 100, 20);
        add(lblempid);
        
        labelempid = new JLabel("2163"+last4);
        labelempid.setBounds(160, 180, 200, 20);
        add(labelempid);
        
        //teacher's DOB
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(40, 210, 100, 20);
        add(lbldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(160, 210, 200, 20);
        add(dcdob);
        
        //teacher's Address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(40, 240, 100, 20);
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(160, 240, 200, 20);
        add(tfaddress);
        
        //teacher's Phone
        JLabel lblphone = new JLabel("Phone No.");
        lblphone.setBounds(40, 270, 100, 20);
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(160, 270, 200, 20);
        add(tfphone);
        
        //Email Id
        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(40, 300, 100, 20);
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(160, 300, 200, 20);
        add(tfemail);
        
        //10 Percentage
        JLabel lbl10percent = new JLabel("Class X (%)");
        lbl10percent.setBounds(40, 330, 100, 20);
        add(lbl10percent);
        
        tf10percent = new JTextField();
        tf10percent.setBounds(160, 330, 200, 20);
        add(tf10percent);
        
        //12 Percentage
        JLabel lbl12percent = new JLabel("Class XII (%)");
        lbl12percent.setBounds(40, 360, 100, 20);
        add(lbl12percent);
        
        tf12percent = new JTextField();
        tf12percent.setBounds(160, 360, 200, 20);
        add(tf12percent);
        
        //Aadhaar
        JLabel lblaadhar = new JLabel("Aadhar No.");
        lblaadhar.setBounds(40, 390, 100, 20);
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(160, 390, 200, 20);
        add(tfaadhar);
        
        //qalification
        JLabel lblqualification = new JLabel("Highest Qualification");
        lblqualification.setBounds(40, 420, 100, 20);
        add(lblqualification);
        
        String qualification[] = {"B.Tech", "M.Tech", "BBA", "MBA", "BCA", "MCA", "BSc", "MSc"}; 
        cbqualification = new JComboBox(qualification);
        cbqualification.setBounds(160, 420, 200, 20);
        cbqualification.setBackground(Color.WHITE);
        add(cbqualification);
        
        //department
        JLabel lbldept = new JLabel("Department");
        lbldept.setBounds(40, 450, 100, 20);
        add(lbldept);
        
        String dept[] = {"Computer Science", "Information Technology", "Electronics and Communication", "Electrical", "Civil", "Mechanical", "Industrial Production"}; 
        cbdept = new JComboBox(dept);
        cbdept.setBounds(160, 450, 200, 20);
        cbdept.setBackground(Color.WHITE);
        add(cbdept);
        
        //Submit button
        submit = new JButton("Submit");
        submit.setBounds(80, 480, 100, 20);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(submit);
        
        //Cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(240, 480, 100, 20);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == submit){
            String name = tfname.getText();
            String fname = tffname.getText();
            String mname = tfmname.getText();
            String empid = labelempid.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String class10 = tf10percent.getText();
            String class12 = tf12percent.getText();
            String aadhar = tfaadhar.getText();
            String qualification = (String) cbqualification.getSelectedItem();
            String dept = (String) cbdept.getSelectedItem();
            
            try{
                String query = "insert into faculty values('"+name+"', '"+fname+"', '"+mname+"', '"+empid+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"', '"+class10+"', '"+class12+"', '"+aadhar+"', '"+qualification+"', '"+dept+"')";
                
                Conn c = new Conn();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Faculty details inserted successfully"); 
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
    
    public static void main(String args[]){
        new AddFaculty();
    }
}
