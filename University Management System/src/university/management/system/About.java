package university.management.system;

import java.awt.*;
import javax.swing.*;

public class About extends JFrame{
    
    About(){
        
    setSize(900, 700);
    setLocation(350, 50);
        
    setLayout(null);
        
    getContentPane().setBackground(Color.WHITE);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/about.jpeg"));    
    Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(350, 0, 300, 200);
    add(image);
    
    JLabel heading = new JLabel("<html>University<br>Management System</html>");
    heading.setBounds(50, 0, 500, 150);
    heading.setFont(new Font("serif", Font.BOLD, 30)); 
    add(heading);
    
    JLabel name = new JLabel("Developed By: Harshita Sahu");
    name.setBounds(70, 220, 500, 30);
    name.setFont(new Font("serif", Font.BOLD, 30)); 
    add(name);
    
    JLabel rollno = new JLabel("Roll Number: 02012010XX");
    rollno.setBounds(70, 260, 500, 30);
    rollno.setFont(new Font("serif", Font.PLAIN, 30)); 
    add(rollno);
    
    JLabel contact = new JLabel("Contact: abc@gmail.com");
    contact.setBounds(70, 260, 500, 30);
    contact.setFont(new Font("serif", Font.PLAIN, 30)); 
    add(rollno);
    
    setVisible(true);
    }
   
    public static void main(String args[]){
       new About();
    } 
}