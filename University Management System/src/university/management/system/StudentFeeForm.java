package university.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class StudentFeeForm extends JFrame implements ActionListener{

    Choice crollno;
    JComboBox cbcourse, cbbranch, cbsemester;
    JLabel labeltotal;
    JButton update, pay, back;

    StudentFeeForm() {

        setSize(900, 700);
        setLocation(350, 50);

        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(460, 110, 450, 300);
        add(image);

        JLabel subHeading = new JLabel("Search by Roll Number");
        subHeading.setBounds(40, 60, 200, 30);
        subHeading.setFont(new Font("serif", Font.BOLD, 20));
        add(subHeading);

        crollno = new Choice();
        crollno.setBounds(250, 70, 200, 30);
        crollno.setBackground(Color.WHITE);
        add(crollno);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Student Name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40, 100, 100, 20);
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(160, 100, 200, 20);
        add(labelname);

        //Student's Father Name
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(40, 130, 100, 20);
        add(lblfname);

        JLabel labelfname = new JLabel();
        labelfname.setBounds(160, 130, 200, 20);
        add(labelfname);

        //Student's Mother Name
        JLabel lblmname = new JLabel("Mother's Name");
        lblmname.setBounds(40, 160, 100, 20);
        add(lblmname);

        JLabel labelmname = new JLabel();
        labelmname.setBounds(160, 160, 200, 20);
        add(labelmname);

        try {
            Conn c = new Conn();
            String query = "select * from student where rollno = '" + crollno.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labelmname.setText(rs.getString("mname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        crollno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from student where rollno = '" + crollno.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));
                        labelmname.setText(rs.getString("mname"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        //Course name
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(40, 190, 100, 20);
        add(lblcourse);
        
        String course[] = {"B.Tech", "M.Tech", "BBA", "MBA", "BCA", "MCA", "BSc", "MSc"}; 
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(160, 190, 200, 20);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);
        
        //Branch name
        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(40, 220, 100, 20);
        add(lblbranch);
        
        String branch[] = {"Computer Science", "Information Technology", "Electronics and Communication", "Electrical", "Civil", "Mechanical", "Industrial and Production"}; 
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(160, 220, 200, 20);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);
        
        JLabel lblSemester = new JLabel("Semester");
        lblSemester.setBounds(40, 250, 200, 20);
        add(lblSemester);
        
        String semester[]= {"Semester1", "Semester2", "Semester3", "Semester4", "Semester5", "Semester6", "Semester7", "Semester8"};
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(160, 250, 200, 20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);
        
        JLabel lbltotal = new JLabel("Total Payable");
        lbltotal.setBounds(40, 280, 200, 30);
        add(lbltotal);
        
        labeltotal = new JLabel();
        labeltotal.setBounds(260, 280, 200, 20);
        add(labeltotal);
        
        //Update button
        update = new JButton("Update");
        update.setBounds(80, 330, 100, 20);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(update);
        
        //Pay button
        pay = new JButton("Pay Fee");
        pay.setBounds(190, 330, 100, 20);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        pay.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(pay);
        
        //Back button
        back = new JButton("Back");
        back.setBounds(300, 330, 100, 20);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(back);

        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == update){
          String course = (String) cbcourse.getSelectedItem();
          String semester = (String) cbsemester.getSelectedItem();
          try{
              Conn c = new Conn();
              ResultSet rs = c.s.executeQuery("select * from fee where course = '"+course+"'");
              while(rs.next()){
                  labeltotal.setText(rs.getString(semester));
              }
          }catch (Exception e){
             e.printStackTrace();
          }
        }else if(ae.getSource() == pay){
            String rollno = crollno.getSelectedItem();
            String course = (String) cbcourse.getSelectedItem();
            String semester = (String) cbsemester.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();
            String total = labeltotal.getText();
            try{
              Conn c = new Conn();
              String query = "insert into collegefee values('"+rollno+"', '"+course+"', '"+branch+"', '"+semester+"', '"+total+"')";
              c.s.executeUpdate(query);
              
              JOptionPane.showMessageDialog(null, "College Fee Submitted Succesfully");
              setVisible(false);
            }catch (Exception e){
             e.printStackTrace();
            }
        }else{
           setVisible(false); 
        }
    }

    public static void main(String args[]) {
        new StudentFeeForm();
    }
}
