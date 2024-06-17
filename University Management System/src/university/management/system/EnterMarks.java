package university.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class EnterMarks extends JFrame implements ActionListener{
    
    Choice crollno;
    JComboBox cbsemester;
    JTextField tfsub1, tfsub2, tfsub3, tfsub4, tfsub5, tfmarks1, tfmarks2, tfmarks3, tfmarks4, tfmarks5; 
    JButton submit, cancel;
    
    EnterMarks(){
        
        setSize(900, 700);
        setLocation(350, 50);
        
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));    
        Image i2 = i1.getImage().getScaledInstance(250, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(600,200, 250, 300);
        add(image);
        
        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(50, 0, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30)); 
        add(heading);
        
        JLabel subHeading = new JLabel("Search by Roll Number");
        subHeading.setBounds(40, 70, 200, 30);
        subHeading.setFont(new Font("serif", Font.BOLD, 20)); 
        add(subHeading);
        
        crollno = new Choice();
        crollno.setBounds(260, 75, 200, 30);
        crollno.setBackground(Color.WHITE);
        add(crollno);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        
        JLabel lblSemester = new JLabel("Select Semester");
        lblSemester.setBounds(40, 110, 200, 30);
        add(lblSemester);
        
        String semester[]= {"1st Semester", "2nd Semester", "3rd Semester", "4th Semester", "5th Semester", "6th Semester", "7th Semester", "8th Semester"};
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(260, 110, 200, 30);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);
        
        JLabel lblentersubject = new JLabel("Enter Subject");
        lblentersubject.setBounds(80, 150, 200, 30);
        add(lblentersubject);
        
        JLabel lblentermarks = new JLabel("Enter Marks");
        lblentermarks.setBounds(320, 150, 200, 30);
        add(lblentermarks);
        
        tfsub1 = new JTextField();
        tfsub1.setBounds(40, 190, 200, 30);
        add(tfsub1);
        
        tfsub2 = new JTextField();
        tfsub2.setBounds(40, 230, 200, 30);
        add(tfsub2);
        
        tfsub3 = new JTextField();
        tfsub3.setBounds(40, 270, 200, 30);
        add(tfsub3);
        
        tfsub4 = new JTextField();
        tfsub4.setBounds(40, 310, 200, 30);
        add(tfsub4);
        
        tfsub4 = new JTextField();
        tfsub4.setBounds(40, 350, 200, 30);
        add(tfsub4);
        
        tfmarks1 = new JTextField();
        tfmarks1.setBounds(260, 190, 200, 30);
        add(tfmarks1);
        
        tfmarks2 = new JTextField();
        tfmarks2.setBounds(260, 230, 200, 30);
        add(tfmarks2);
        
        tfmarks3 = new JTextField();
        tfmarks3.setBounds(260, 270, 200, 30);
        add(tfmarks3);
        
        tfmarks4 = new JTextField();
        tfmarks4.setBounds(260, 310, 200, 30);
        add(tfmarks4);
        
        tfmarks5 = new JTextField();
        tfmarks5.setBounds(260, 350, 200, 30);
        add(tfmarks5);
        
        submit = new JButton("Submit");
        submit.setBounds(80, 390, 120, 20);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(320, 390, 120, 20);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
  
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
           try{
              Conn c = new Conn(); 
              
              String query1 = "insert into subject values('"+crollno.getSelectedItem()+"', '"+cbsemester.getSelectedItem()+"', '"+tfsub1.getText()+"', '"+tfsub2.getText()+"', '"+tfsub3.getText()+"', '"+tfsub4.getText()+"', '"+tfsub5.getText()+"')";
              String query2 = "insert into marks values('"+crollno.getSelectedItem()+"', '"+cbsemester.getSelectedItem()+"', '"+tfmarks1.getText()+"', '"+tfmarks2.getText()+"', '"+tfmarks3.getText()+"', '"+tfmarks4.getText()+"', '"+tfmarks5.getText()+"')";
           
              c.s.executeUpdate(query1);
              c.s.executeUpdate(query2);
              
              JOptionPane.showMessageDialog(null, "Marks Inserted Successfully");
              
           }catch(Exception e){
             e.printStackTrace();
           } 
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String args[]){
        new EnterMarks();
    }
}
