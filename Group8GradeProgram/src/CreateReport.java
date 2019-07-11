import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class CreateReport extends GradeChange {
	
	 String reportFileName = ""; //user entered string for file name
	 protected JFrame createReportFrame;
	 
	 public String printFinalGrades(ArrayList<Student> updatedStudentList)
		{
		 ArrayList<Student> finalGradesList = new ArrayList<>();
		 finalGradesList = updatedStudentList;
		 
		for (Student individualStudent:  finalGradesList)
		{
			finalGrades += "Student ID: " + individualStudent.getID() + " Student Score: " + 
		individualStudent.getScore() + "  Letter Grade: " + individualStudent.getLetterGrade() + "\n";
			
		}
		return finalGrades;	
		}	  
	
	 
	public void createReport()
	{
	
	System.out.println("Create Grade Report Button Clicked"); //prints to console
	
	//Creates frame for create report
	JFrame createReportFrame = new JFrame("Create Grade Report");
	createReportFrame.setSize(500,90); 
	createReportFrame.setDefaultCloseOperation(createReportFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
	createReportFrame.setVisible(true); 
	createReportFrame.setResizable(false);
	createReportFrame.setBounds(850,350,500,90);
	
	//Creates panel
	JPanel createReportPanel = new JPanel();
	createReportPanel.setBackground(Color.orange);
	
	//Creates text field
	JTextField reportNameTextField = new JTextField(20);
	
	//Creates label
	JLabel nameReportPrompt = new JLabel("Please Enter a Name for the Grade Report.");
	JLabel nameLabel = new JLabel("Grade Report Name : ");
	
	//Creates "Enter" button
	JButton createReportEnter = new JButton("Enter");
	
	//Add text field and button to panel
	createReportPanel.add(nameLabel);
	createReportPanel.add(Box.createHorizontalStrut(50));
	createReportPanel.add(reportNameTextField);
	createReportPanel.add(createReportEnter);
			
	
	createReportPanel.setLayout(new BoxLayout(createReportPanel, BoxLayout.X_AXIS));
			
			
	//Adds prompt and panel to frame
	createReportFrame.add(nameReportPrompt,BorderLayout.NORTH);
	createReportFrame.add(createReportPanel,BorderLayout.SOUTH);
	//createReportFrame.add(createReportPanel);
			

	
//Action listener for createReportEnter button
	createReportEnter.addActionListener(new ActionListener() 
	{
		 public void actionPerformed(ActionEvent e)
		 {
			 
			 reportFileName = reportNameTextField.getText();
			 System.out.println("Create Report File Name: " + reportFileName); //prints input by user in reportNameTextField text field
			 
			 writeToTextFile(reportFileName, printFinalGrades(updatedStudentList)); //calls on method to create text file
			
			 createReportFrame.dispose(); //closes createReportFrame after enter clicked
		 }
	});
	}
	
	
//Method to Write Grades to a Text File
	public void writeToTextFile(String reportFileName, String finalGrades) 
	{
			
		try {
			FileWriter fw = new FileWriter(reportFileName);
			
			fw.write(finalGrades); //writes updated array list to file
			fw.close(); //close text file
			
		} catch (IOException e) {
			System.out.println("Text File Not Created.");
		}
		
		
		JOptionPane.showMessageDialog(createReportFrame, "Grade Report Created.", "Create Grade Report Status",JOptionPane.INFORMATION_MESSAGE); //notifies user that text file was created
	

	}

} //End of CreateReport.java
