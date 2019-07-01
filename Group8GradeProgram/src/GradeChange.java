import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GradeChange extends gradeAnalyticsGUI {

	//Method to add addStudentID and addGradeScore text field inputs into array list
	public void addGrade()
	{
		//Creating new window for "add a grade"
		JFrame addGradeFrame = new JFrame("Add a Grade");
		addGradeFrame.setSize(400,90);
		addGradeFrame.setDefaultCloseOperation(makeChangesFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
		addGradeFrame.setVisible(true);
		
		//Creating panel for "add a grade"
		JPanel addGradePanel = new JPanel();
		addGradePanel.setBackground(Color.cyan);
		
		//Creating labels for "add a grade"
		JLabel addStudentLabel = new JLabel("Student/ID:");
		JLabel addGradeScoreLabel = new JLabel("Score: ");
		
		//Creating text fields for "add a grade"
		JTextField addStudentIDField = new JTextField(20);
		JTextField addGradeScoreField = new JTextField(20);
		
		//Adding labels/text fields to panel
		addGradePanel.add(addStudentLabel);
		addGradePanel.add(addStudentIDField);
		addGradePanel.add(addGradeScoreLabel);
		addGradePanel.add(addGradeScoreField);
		
		//add a grade panel layout
		addGradePanel.setLayout(new BoxLayout(addGradePanel, BoxLayout.X_AXIS));
		
		//adding panel to frame
		addGradeFrame.add(addGradePanel);
		
		
		
		//Text Field Action Listener for addStudentIDField
		
		 addStudentIDField.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e)
			 {
				 System.out.println(" Add Student ID: " +  addStudentIDField.getText()); //prints user Student ID input to console
				 
				 //add Student ID to studentIDList array list
			 }
		});
	
		//Text Field Action Listener for addGradeScoreField
			
		 addGradeScoreField.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e)
			 {
				 System.out.println(" Add Student Score: " +  addGradeScoreField.getText()); //prints user Student score input to console
				 
				 //add Student Score to studentScoreList
			 }
		});
		 
		 
	} //End of addGrade()
	
	
	
	
	
	
	
} //End of GradeChange.java
