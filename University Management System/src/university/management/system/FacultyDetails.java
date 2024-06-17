package university.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class FacultyDetails extends JFrame implements ActionListener{
    
    Choice cempid;
    JTable table;
    JButton search, print, update, add, cancel;
    
    FacultyDetails(){
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(900, 700);
        setLocation(350, 50);
        
        setLayout(null);
        
        JLabel heading = new JLabel("Teacher Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30)); 
        add(heading);
        
        JLabel subHeading = new JLabel("Search by Employee id");
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
        
        table = new JTable();
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from faculty");
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
        
        update = new JButton("Update Details");
        update.setBounds(240, 150, 120, 20);
        update.addActionListener(this);
        add(update);
        
        add = new JButton("Add Details");
        add.setBounds(370, 150, 120, 20);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(500, 150, 80, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == search){
            String query = "select * from faculty where empid = '"+cempid.getSelectedItem()+"'";
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
        }else if(ae.getSource() == update){
            setVisible(false);
            new UpdateFaculty();
        }else if(ae.getSource() == add){
            setVisible(false);
            new AddFaculty();
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String args[]){
        new FacultyDetails();
    }
}
