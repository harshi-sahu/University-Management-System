package university.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class ExaminationDetails extends JFrame implements ActionListener{
    
    JTextField search;
    JButton searchResult, cancel;
    JTable table;
    
    ExaminationDetails(){
       
        setSize(900, 700);
        setLocation(350, 50);
        
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Check Result");
        heading.setBounds(50, 0, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30)); 
        add(heading);
        
        JLabel subHeading = new JLabel("Enter Roll Number");
        subHeading.setBounds(40, 70, 200, 30);
        subHeading.setFont(new Font("serif", Font.BOLD, 20)); 
        add(subHeading);
        
        search = new JTextField();
        search.setBounds(250, 70, 200, 30);
        add(search);
        
        searchResult = new JButton("Search Result");
        searchResult.setBounds(460, 70, 200, 20);
        searchResult.setBackground(Color.BLACK);
        searchResult.setForeground(Color.WHITE);
        searchResult.addActionListener(this);
        add(searchResult);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(670, 70, 120, 20);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }
        
        table.addMouseListener(new MouseAdapter(){
           public void mouseClicked(MouseEvent me){
               int row = table.getSelectedRow();
               search.setText(table.getModel().getValueAt(row, 3).toString());
           }
        });
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == searchResult){
            setVisible(false);
            new Marks(search.getText());
        }
        else{
            setVisible(false);
        }
    }
    
    public static void main(String args[]){
       new ExaminationDetails();
    }
}
