package university.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class FacultyLeave extends JFrame implements ActionListener{
    Choice cempid, ctime;
    JDateChooser dcdate;
    JButton submit, cancel;
    
    FacultyLeave(){
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(900, 700);
        setLocation(350, 50);
        
        setLayout(null);
        
        JLabel heading = new JLabel("Apply Leave (for Faculty)");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30)); 
        add(heading);
        
        JLabel subHeading = new JLabel("Search by Employee Id");
        subHeading.setBounds(40, 85, 200, 30);
        subHeading.setFont(new Font("serif", Font.PLAIN, 18)); 
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
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(40, 115, 200, 30);
        lbldate.setFont(new Font("serif", Font.PLAIN, 18)); 
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(300, 120, 200, 20);
        add(dcdate);
        
        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(40, 140, 200, 30);
        lbltime.setFont(new Font("serif", Font.PLAIN, 18)); 
        add(lbltime);
        
        ctime = new Choice();
        ctime.setBounds(300, 145, 200, 20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);
        
        //Submit button
        submit = new JButton("Submit");
        submit.setBounds(80, 190, 100, 20);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(submit);
        
        //Cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(190, 190, 100, 20);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String empid = (String) cempid.getSelectedItem();
            String date = ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
            String duration = (String) ctime.getSelectedItem();
            
            String query = "insert into facultyleave values('"+empid+"', '"+date+"', '"+duration+"')";
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Applied");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String args[]){
        new FacultyLeave();
    }
}
