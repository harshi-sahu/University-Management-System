package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateFaculty extends JFrame implements ActionListener{
    
    JTextField tfaddress, tfphone, tfemail, tfqualification, tfdept;
    JLabel labelempid;
    JButton update, cancel;
    Choice cempid;
    
    UpdateFaculty(){
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(900, 700);
        setLocation(350, 50);
        
        setLayout(null);
        
        JLabel heading = new JLabel("Update Faculty Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30)); 
        add(heading);
        
        JLabel subHeading = new JLabel("Search by Roll Number");
        subHeading.setBounds(40, 85, 200, 30);
        subHeading.setFont(new Font("serif", Font.BOLD, 20)); 
        add(subHeading);
        
        cempid = new Choice();
        cempid.setBounds(300, 90, 200, 30);
        cempid.setBackground(Color.WHITE);
        add(cempid);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from faculty");
            while(rs.next()){
                cempid.add(rs.getString("empid"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        
        //Teacher Name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40, 120, 100, 20);
        add(lblname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(160, 120, 200, 20);
        add(labelname);
        
        //Teacher's Father Name
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(40, 140, 100, 20);
        add(lblfname);
        
        JLabel labelfname = new JLabel();
        labelfname.setBounds(160, 140, 200, 20);
        add(labelfname);
        
        //Teacher's Mother Name
        JLabel lblmname = new JLabel("Mother's Name");
        lblmname.setBounds(40, 160, 100, 20);
        add(lblmname);
        
        JLabel labelmname = new JLabel();
        labelmname.setBounds(160, 160, 200, 20);
        add(labelmname);
        
        //Teacher's Roll No.
        JLabel lblempid = new JLabel("Employee Id");
        lblempid.setBounds(40, 180, 100, 20);
        add(lblempid);
        
        JLabel labelempid = new JLabel();
        labelempid.setBounds(160, 180, 200, 20);
        add(labelempid);
        
        //Teacher's DOB
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(40, 200, 100, 20);
        add(lbldob);
        
        JLabel labeldob = new JLabel();
        labeldob.setBounds(160, 200, 200, 20);
        add(labeldob);
        
        //Teacher's Address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(40, 220, 100, 20);
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(160, 220, 200, 20);
        add(tfaddress);
        
        //Teacher's Phone
        JLabel lblphone = new JLabel("Phone No.");
        lblphone.setBounds(40, 240, 100, 20);
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(160, 240, 200, 20);
        add(tfphone);
        
        //Email Id
        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(40, 260, 100, 20);
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(160, 260, 200, 20);
        add(tfemail);
        
        //10 Percentage
        JLabel lbl10percent = new JLabel("Class X (%)");
        lbl10percent.setBounds(40, 280, 100, 20);
        add(lbl10percent);
        
        JLabel label10percent = new JLabel();
        label10percent.setBounds(160, 280, 200, 20);
        add(label10percent);
        
        //12 Percentage
        JLabel lbl12percent = new JLabel("Class XII (%)");
        lbl12percent.setBounds(40, 300, 100, 20);
        add(lbl12percent);
        
        JLabel label12percent = new JLabel();
        label12percent.setBounds(160, 300, 200, 20);
        add(label12percent);
        
        //Aadhaar
        JLabel lblaadhaar = new JLabel("Aadhar No.");
        lblaadhaar.setBounds(40, 320, 100, 20);
        add(lblaadhaar);
        
        JLabel labelaadhaar = new JLabel();
        labelaadhaar.setBounds(160, 320, 200, 20);
        add(labelaadhaar);
        
        //Qualification
        JLabel lblqualification = new JLabel("Qualification");
        lblqualification.setBounds(40, 340, 100, 20);
        add(lblqualification);
        
        tfqualification = new JTextField();
        tfqualification.setBounds(160, 340, 200, 20);
        add(tfqualification);
        
        //Department name
        JLabel lbldept = new JLabel("Department");
        lbldept.setBounds(40, 360, 100, 20);
        add(lbldept);
        
        tfdept = new JTextField();
        tfdept.setBounds(160, 360, 200, 20);
        add(tfdept);
        
        try{
          Conn c = new Conn();
          String query = "select * from faculty where empid = '"+cempid.getSelectedItem()+"'";
          ResultSet rs = c.s.executeQuery(query);  
          while(rs.next()){
             labelname.setText(rs.getString("name"));
             labelfname.setText(rs.getString("fname"));
             labelmname.setText(rs.getString("mname"));
             labelempid.setText(rs.getString("empid"));
             labeldob.setText(rs.getString("dob"));
             tfaddress.setText(rs.getString("address"));
             tfphone.setText(rs.getString("phone"));
             tfemail.setText(rs.getString("email"));
             label10percent.setText(rs.getString("class10"));
             label12percent.setText(rs.getString("class12"));
             labelaadhaar.setText(rs.getString("aadhar"));
             tfqualification.setText(rs.getString("qualification"));
             tfdept.setText(rs.getString("dept"));
          }
        }
            catch (Exception e){
              e.printStackTrace();      
            }
        
        cempid.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent ie){
            try{
          Conn c = new Conn();
          String query = "select * from faculty where empid = '"+cempid.getSelectedItem()+"'";
          ResultSet rs = c.s.executeQuery(query);  
          while(rs.next()){
             labelname.setText(rs.getString("name"));
             labelfname.setText(rs.getString("fname"));
             labelmname.setText(rs.getString("mname"));
             labelempid.setText(rs.getString("empid"));
             labeldob.setText(rs.getString("dob"));
             tfaddress.setText(rs.getString("address"));
             tfphone.setText(rs.getString("phone"));
             tfemail.setText(rs.getString("email"));
             label10percent.setText(rs.getString("class10"));
             label12percent.setText(rs.getString("class12"));
             labelaadhaar.setText(rs.getString("aadhar"));
             tfqualification.setText(rs.getString("qualification"));
             tfdept.setText(rs.getString("dept"));
          }
        }
            catch (Exception e){
              e.printStackTrace();      
            }
        }
        });
        
        //Update button
        update = new JButton("Update");
        update.setBounds(80, 480, 100, 20);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(update);
        
        //Cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(190, 480, 100, 20);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == update){
            String empid = labelempid.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String qualification = tfqualification.getText();
            String dept = tfdept.getText();
            
            try{
               String query = "update faculty set address = '"+address+"', phone = '"+phone+"', email = '"+email+"', qualification = '"+qualification+"', dept = '"+dept+"' where empid = '"+empid+"'";
                
                Conn con = new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Faculty details updated successfully"); 
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
    
    public static void main(String args[]){
        new UpdateFaculty();
    }
}

