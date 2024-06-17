package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class Marks extends JFrame implements ActionListener{
    
    String rollno;
    JButton back;
    
    Marks(String rollno){
        this.rollno = rollno;
        
        setSize(900, 700);
        setLocation(350, 50);
        
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Jabalpur Engineering College");
        heading.setBounds(100, 0, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30)); 
        add(heading);
        
        JLabel subHeading = new JLabel("Result of Examination");
        subHeading.setBounds(80, 70, 200, 30);
        subHeading.setFont(new Font("serif", Font.BOLD, 20)); 
        add(subHeading);
        
        JLabel lblrollno = new JLabel("Roll Number "+ rollno);
        lblrollno.setBounds(20, 110, 200, 30);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(lblrollno);
        
        JLabel lblsemester = new JLabel();
        lblsemester.setBounds(20, 150, 200, 30);
        lblsemester.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(lblsemester);
        
        JLabel sub1 = new JLabel();
        sub1.setBounds(20, 190, 500, 30);
        sub1.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
        add(sub1);
        
        JLabel sub2 = new JLabel();
        sub2.setBounds(20, 230, 500, 30);
        sub2.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
        add(sub2);
        
        JLabel sub3 = new JLabel();
        sub3.setBounds(20, 270, 500, 30);
        sub3.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
        add(sub3);
        
        JLabel sub4 = new JLabel();
        sub4.setBounds(20, 310, 500, 30);
        sub4.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
        add(sub4);
        
        JLabel sub5 = new JLabel();
        sub5.setBounds(20, 350, 500, 30);
        sub5.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
        add(sub5);
        
        try{
            Conn c = new Conn();
            
            ResultSet rs1 = c.s.executeQuery("select * from subject where rollno = '"+rollno+"'");
            while(rs1.next()){
                sub1.setText(rs1.getString("subject1"));
                sub2.setText(rs1.getString("subject2"));
                sub3.setText(rs1.getString("subject3"));
                sub4.setText(rs1.getString("subject4"));
                sub5.setText(rs1.getString("subject5"));
            }
            
            ResultSet rs2 = c.s.executeQuery("select * from marks where rollno = '"+rollno+"'");
            while(rs2.next()){
                sub1.setText(sub1.getText() + "--------------" + rs2.getString("marks1"));
                sub2.setText(sub2.getText() + "--------------" + rs2.getString("marks2"));
                sub3.setText(sub3.getText() + "--------------" + rs2.getString("marks3"));
                sub4.setText(sub4.getText() + "--------------" + rs2.getString("marks4"));
                sub5.setText(sub5.getText() + "--------------" + rs2.getString("marks5"));
                lblsemester.setText("Semester " + rs2.getString("semester"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBounds(300, 390, 120, 20);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false); 
    }
    
    public static void main(String args[]){
        new Marks("");
    }
}
