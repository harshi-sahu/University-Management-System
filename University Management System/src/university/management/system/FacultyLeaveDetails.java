package university.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class FacultyLeaveDetails extends JFrame implements ActionListener{
    
    Choice cempid;
    JTable table;
    JButton search, print, cancel;
    
    FacultyLeaveDetails(){
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(900, 700);
        setLocation(350, 50);
        
        setLayout(null);
        
        JLabel heading = new JLabel("Faculty Leave Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30)); 
        add(heading);
        
        JLabel subHeading = new JLabel("Search by Employee Id");
        subHeading.setBounds(40, 85, 200, 30);
        subHeading.setFont(new Font("serif", Font.BOLD, 20)); 
        add(subHeading);
        
        cempid = new Choice();
        cempid.setBounds(300, 90, 200, 30);
        cempid.setBackground(Color.WHITE);
        add(cempid);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from facultyleave");
            while(rs.next()){
                cempid.add(rs.getString("empid"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from facultyleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 200, 900, 600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20, 150, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print Details");
        print.setBounds(110, 150, 120, 20);
        print.addActionListener(this);
        add(print);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(240, 150, 80, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == search){
            String query = "select * from facultyleave where empid = '"+cempid.getSelectedItem()+"'";
            try{
               Conn c = new Conn(); 
               ResultSet rs = c.s.executeQuery(query);
               table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == print){
            
            try{
                table.print();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String args[]){
        new FacultyLeaveDetails();
    }
}

