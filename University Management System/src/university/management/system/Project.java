package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener{
    
    Project(){
       
       getContentPane().setBackground(Color.WHITE);
        
       setSize(1540, 850);
        
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/project.jpg"));    
       Image i2 = i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       add(image);
       
       JMenuBar mb = new JMenuBar();
       
       //new information
       JMenu newInformation = new JMenu("New Information");
       newInformation.setForeground(Color.BLUE);
       mb.add(newInformation);
       
       JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
       facultyInfo.setBackground(Color.WHITE);
       facultyInfo.addActionListener(this);
       newInformation.add(facultyInfo);
       
       JMenuItem studentInfo = new JMenuItem("New Student Information");
       facultyInfo.setBackground(Color.WHITE);
       studentInfo.addActionListener(this);
       newInformation.add(studentInfo);
       
       //details
       JMenu details = new JMenu("View Details");
       details.setForeground(Color.BLUE);
       mb.add(details);
       
       JMenuItem facultyDetails = new JMenuItem("View Faculty Details");
       facultyDetails.setBackground(Color.WHITE);
       facultyDetails.addActionListener(this);
       details.add(facultyDetails);
       
       JMenuItem studentDetails = new JMenuItem("View Student Details");
       studentDetails.setBackground(Color.WHITE);
       studentDetails.addActionListener(this);
       details.add(studentDetails);
       
       //leave
       JMenu leave = new JMenu("Apply Leave");
       leave.setForeground(Color.BLUE);
       mb.add(leave);
       
       JMenuItem facultyLeave = new JMenuItem("Apply Faculty Leave");
       facultyLeave.setBackground(Color.WHITE);
       facultyLeave.addActionListener(this);
       leave.add(facultyLeave);
       
       JMenuItem studentLeave = new JMenuItem("Apply Student Leave");
       studentLeave.setBackground(Color.WHITE);
       studentLeave.addActionListener(this);
       leave.add(studentLeave);
       
       //leave details
       JMenu leaveDetails = new JMenu("Leave Details");
       leaveDetails.setForeground(Color.BLUE);
       mb.add(leaveDetails);
       
       JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
       facultyLeaveDetails.setBackground(Color.WHITE);
       facultyLeaveDetails.addActionListener(this);
       leaveDetails.add(facultyLeaveDetails);
       
       JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
       studentLeaveDetails.setBackground(Color.WHITE);
       studentLeaveDetails.addActionListener(this);
       leaveDetails.add(studentLeaveDetails);
       
       //exam
       JMenu exam = new JMenu("Examination");
       exam.setForeground(Color.BLUE);
       mb.add(exam);
       
       JMenuItem examinationDetails = new JMenuItem("Examination Result");
       examinationDetails.setBackground(Color.WHITE);
       examinationDetails.addActionListener(this);
       exam.add(examinationDetails);
       
       JMenuItem enterMarks = new JMenuItem("Enter Marks");
       enterMarks.setBackground(Color.WHITE);
       enterMarks.addActionListener(this);
       exam.add(enterMarks);
       
       //update info
       JMenu updateInfo = new JMenu("Update Details");
       updateInfo.setForeground(Color.BLUE);
       mb.add(updateInfo);
       
       JMenuItem updateFacultyInfo = new JMenuItem("Update Faculty Details");
       updateFacultyInfo.setBackground(Color.WHITE);
       updateFacultyInfo.addActionListener(this);
       updateInfo.add(updateFacultyInfo);
       
       JMenuItem updateStudentInfo = new JMenuItem("Update Student Details");
       updateStudentInfo.setBackground(Color.WHITE);
       updateStudentInfo.addActionListener(this);
       updateInfo.add(updateStudentInfo);
       
       //fees info
       JMenu feesInfo = new JMenu("Fee Details");
       feesInfo.setForeground(Color.BLUE);
       mb.add(feesInfo);
       
       JMenuItem feesStructure = new JMenuItem("Fee Structure");
       feesStructure.setBackground(Color.WHITE);
       feesStructure.addActionListener(this);
       feesInfo.add(feesStructure);
       
       JMenuItem feesForm = new JMenuItem("Student Fee Form");
       feesForm.setBackground(Color.WHITE);
       feesForm.addActionListener(this);
       feesInfo.add(feesForm);
       
       //utility
       JMenu utility = new JMenu("Utility");
       utility.setForeground(Color.BLUE);
       mb.add(utility);
       
       JMenuItem notepad = new JMenuItem("Notepad");
       notepad.setBackground(Color.WHITE);
       notepad.addActionListener(this);
       utility.add(notepad);
       
       JMenuItem calculator = new JMenuItem("Calculator");
       calculator.setBackground(Color.WHITE);
       calculator.addActionListener(this);
       utility.add(calculator);
       
       //about
       JMenu about = new JMenu("About");
       about.setForeground(Color.BLUE);
       mb.add(about);
       
       JMenuItem ab = new JMenuItem("About");
       ab.setBackground(Color.WHITE);
       ab.addActionListener(this);
       about.add(ab);
       
       //exit
       JMenu exit = new JMenu("Exit");
       exit.setForeground(Color.BLUE);
       mb.add(exit);
       
       JMenuItem ex = new JMenuItem("Exit");
       ex.setBackground(Color.WHITE);
       ex.addActionListener(this);
       exit.add(ex);
       
       setJMenuBar(mb);
       
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String msg = ae.getActionCommand();
        
        if(msg.equals("Exit")){
            setVisible(false);
        }else if(msg.equals("Calculator")){
            try{
               Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){
                
            }
        }else if(msg.equals("Notepad")){
            try{
               Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){
                
            }
        }else if(msg.equals("New Faculty Information")){
            new AddFaculty();
        }else if(msg.equals("New Student Information")){
            new AddStudent();
        }else if(msg.equals("View Student Details")){
            new StudentDetails();
        }else if(msg.equals("View Faculty Details")){
            new FacultyDetails();
        }else if(msg.equals("Apply Faculty Leave")){
            new FacultyLeave();
        }else if(msg.equals("Apply Student Leave")){
            new StudentLeave();
        }else if(msg.equals("Student Leave Details")){
            new StudentLeaveDetails();
        }else if(msg.equals("Faculty Leave Details")){
            new FacultyLeaveDetails();
        }else if(msg.equals("Update Student Details")){
            new UpdateStudent();
        }else if(msg.equals("Update Faculty Details")){
            new UpdateFaculty();
        }else if(msg.equals("Enter Marks")){
            new EnterMarks();
        }else if(msg.equals("Examination Result")){
            new ExaminationDetails();
        }else if(msg.equals("Fee Structure")){
            new FeeStructure();
        }else if(msg.equals("Student Fee Form")){
            new StudentFeeForm();
        }else if(msg.equals("About")){
            new About();
        }
    }
    
    public static void main(String args[]){
        new Project();
    }
}
