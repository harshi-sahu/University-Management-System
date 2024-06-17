package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStudent extends JFrame implements ActionListener {

    JTextField tfaddress, tfphone, tfemail, tfcourse, tfbranch;
    JLabel labelrollno;
    JButton update, cancel;
    Choice crollno;

    UpdateStudent() {

        getContentPane().setBackground(Color.WHITE);

        setSize(900, 700);
        setLocation(350, 50);

        setLayout(null);

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel subHeading = new JLabel("Search by Roll Number");
        subHeading.setBounds(40, 85, 200, 30);
        subHeading.setFont(new Font("serif", Font.BOLD, 20));
        add(subHeading);

        crollno = new Choice();
        crollno.setBounds(300, 90, 200, 30);
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
        lblname.setBounds(40, 120, 100, 20);
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(160, 120, 200, 20);
        add(labelname);

        //Student's Father Name
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(40, 140, 100, 20);
        add(lblfname);

        JLabel labelfname = new JLabel();
        labelfname.setBounds(160, 140, 200, 20);
        add(labelfname);

        //Student's Mother Name
        JLabel lblmname = new JLabel("Mother's Name");
        lblmname.setBounds(40, 160, 100, 20);
        add(lblmname);

        JLabel labelmname = new JLabel();
        labelmname.setBounds(160, 160, 200, 20);
        add(labelmname);

        //Student's Roll No.
        JLabel lblrollno = new JLabel("Roll No.");
        lblrollno.setBounds(40, 180, 100, 20);
        add(lblrollno);

        JLabel labelrollno = new JLabel();
        labelrollno.setBounds(160, 180, 200, 20);
        add(labelrollno);

        //Student's DOB
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(40, 200, 100, 20);
        add(lbldob);

        JLabel labeldob = new JLabel();
        labeldob.setBounds(160, 200, 200, 20);
        add(labeldob);

        //Student's Address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(40, 220, 100, 20);
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(160, 220, 200, 20);
        add(tfaddress);

        //Student's Phone
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
        JLabel lblaadhar = new JLabel("Aadhar No.");
        lblaadhar.setBounds(40, 320, 100, 20);
        add(lblaadhar);

        JLabel labelaadhar = new JLabel();
        labelaadhar.setBounds(160, 320, 200, 20);
        add(labelaadhar);

        //Course name
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(40, 340, 100, 20);
        add(lblcourse);

        tfcourse = new JTextField();
        tfcourse.setBounds(160, 340, 200, 20);
        add(tfcourse);

        //Branch name
        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(40, 360, 100, 20);
        add(lblbranch);

        tfbranch = new JTextField();
        tfbranch.setBounds(160, 360, 200, 20);
        add(tfbranch);

        try {
            Conn c = new Conn();
            String query = "select * from student where rollno = '" + crollno.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labelmname.setText(rs.getString("mname"));
                labelrollno.setText(rs.getString("rollno"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                label10percent.setText(rs.getString("class10"));
                label12percent.setText(rs.getString("class12"));
                labelaadhar.setText(rs.getString("aadhar"));
                tfcourse.setText(rs.getString("course"));
                tfbranch.setText(rs.getString("branch"));
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
                        labelrollno.setText(rs.getString("rollno"));
                        labeldob.setText(rs.getString("dob"));
                        tfaddress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        label10percent.setText(rs.getString("class10"));
                        label12percent.setText(rs.getString("class12"));
                        labelaadhar.setText(rs.getString("aadhar"));
                        tfcourse.setText(rs.getString("course"));
                        tfbranch.setText(rs.getString("branch"));
                    }
                } catch (Exception e) {
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

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == update) {
            String rollno = labelrollno.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String course = tfcourse.getText();
            String branch = tfbranch.getText();

            try {
                String query = "update student set address = '" + address + "', phone = '" + phone + "', email = '" + email + "', course = '" + course + "', branch = '" + branch + "' where rollno = '" + rollno + "'";

                Conn con = new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Student details updated successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String args[]) {
        new UpdateStudent();
    }
}
