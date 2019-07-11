import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GradeChange extends gradeAnalyticsGUI {
	
	String IDString;		 //entered student ID value from user
	String ScoreString;			//entered student score from user
	

	//ArrayList<Student> updatedStudentList = new ArrayList<Student>(studentList); 	//creates a copy of studentList and is a dynamic array list
	String finalGrades = "";
	
	
	
	//Method to add addStudentID and addGradeScore text field inputs into array list
	public void addGrade(ArrayList<Student> studentList)
	{
		//Creating new window for "add a grade"
		JFrame addGradeFrame = new JFrame("Add a Grade");
		addGradeFrame.setDefaultCloseOperation(makeChangesFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
		addGradeFrame.setVisible(true);
		addGradeFrame.setResizable(false);
		addGradeFrame.setBounds(850,350,400,100);
		
		//addGradeFrame.setLocationRelativeTo(null);
		
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
		
		//Add confirmation "Enter" button
		JButton addEnterButton = new JButton("Enter");
		
		//Add enter button to panel
		addGradePanel.add(addEnterButton);
		
		//add a grade panel layout
		addGradePanel.setLayout(new BoxLayout(addGradePanel, BoxLayout.X_AXIS));
		
		//adding panel to frame
		addGradeFrame.add(addGradePanel);
		
		//Text Field Action Listener for addStudentIDField
		// addStudentIDField.addActionListener(new ActionListener() {
			// public void actionPerformed(ActionEvent e)
			// {
				 
				 
		//	 }
		//});
	
	//Text Field Action Listener for addGradeScoreField	
		 //addGradeScoreField.addActionListener(new ActionListener() {
			// public void actionPerformed(ActionEvent e)
			 //{
				 			
	//Button clicked Action Listener for addEnterButton
				 addEnterButton.addActionListener(new ActionListener() //user can only close window if a new score is entered into text field
					{
						public void actionPerformed(ActionEvent e)
						{ 
							String id = addStudentIDField.getText();
							Student studentObj = new Student(id);
							System.out.println("Add Student ID: " +  id); //prints user Student ID input to console
						 	
							double score = Double.parseDouble(addGradeScoreField.getText()); //converts string into double
							studentObj.setScore(score); //sets student score
							System.out.println("Add Student Score: " +  studentObj.getScore()); //prints user Student score input to console
						 
							computedScore = Math.round((studentObj.getScore() / totalPointsPossible) * 100);
							System.out.println("Computed Score: " + computedScore + "%");
							
							studentObj.setLetterGrade(studentObj.defaultLetterGrade(computedScore)); //sets letter grade for score
							
							
							updatedStudentList.add(studentObj); //add to dynamic updatedList
							
							
							JOptionPane.showMessageDialog(screenFrame, "Grade Added.", "Add Grade Status",JOptionPane.INFORMATION_MESSAGE);
							System.out.println("Student Grade Added");
							//System.out.println(studentList); //text file student list
							//System.out.println(updatedStudentList); //prints list to console to check if added
										
							addGradeFrame.dispose(); //closes add grade window
						}
						});  	 
			// }
		//});	 
	} //End of addGrade()
	
	
	
	
//Method to replace a grade
	public void replaceGrade(ArrayList<Student> studentList)
	{

		//Creating new window for "replace a grade"
		JFrame replaceGradeFrame = new JFrame("Replace a Grade");
		replaceGradeFrame.setSize(400,100);
		replaceGradeFrame.setDefaultCloseOperation(makeChangesFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
		replaceGradeFrame.setVisible(true);
		replaceGradeFrame.setResizable(false);
		//replaceGradeFrame.setLocationRelativeTo(null);
		replaceGradeFrame.setBounds(850,350,400,100);
		
		//Creating panel
		JPanel replaceGradePanel = new JPanel();
		replaceGradePanel.setBackground(Color.cyan);

		
		//Add confirmation "Enter" button
		JButton replaceEnterButton = new JButton("Enter");
		
		//Creating labels
		JLabel replaceOldStudentLabel = new JLabel("Student/ID:");
		JLabel replaceNewGradeScoreLabel = new JLabel("New Score: ");
		
		//Creating text fields 
		JTextField replaceOldStudentIDField = new JTextField(20);
		JTextField replaceNewGradeScoreField = new JTextField(20);
		
		//Adding labels/text fields to panel
		replaceGradePanel.add(replaceOldStudentLabel);
		replaceGradePanel.add(replaceOldStudentIDField);
		
		//Adding label, field to panel
		replaceGradePanel.add(replaceNewGradeScoreLabel);
		replaceGradePanel.add(replaceNewGradeScoreField);
		
		//Adding replaceEnterButton to panel
		replaceGradePanel.add(replaceEnterButton);
		
		//add a grade panel layout
		replaceGradePanel.setLayout(new BoxLayout(replaceGradePanel, BoxLayout.X_AXIS));

		
		//adding panel to frame
		replaceGradeFrame.add(replaceGradePanel);
	
	
		//Text Field Action Listener for replaceOldStudentIDField
		//replaceOldStudentIDField.addActionListener(new ActionListener() {
			// public void actionPerformed(ActionEvent e)
			 //{
				 
		//	 }
		//});
	
	//Text Field Action Listener for replaceNewGradeScoreField
		//replaceNewGradeScoreField.addActionListener(new ActionListener() {
			// public void actionPerformed(ActionEvent e)
			 //{
				
				 
	//Button clicked Action Listener for replaceEnterButton
				 replaceEnterButton.addActionListener(new ActionListener() //replace window closes only if new score is entered into text field
					{
						public void actionPerformed(ActionEvent e)
						{ 
							System.out.println("Student ID to Replace Grade: " +  replaceOldStudentIDField.getText()); //prints user Student ID input to console
							 String ID = replaceOldStudentIDField.getText();
							 
							 System.out.println("Student Score to Replace " +  replaceNewGradeScoreField.getText()); //prints user Student ID input to console
							 double newScore = Double.parseDouble(replaceNewGradeScoreField.getText());
							
							for (Student individualStudent: updatedStudentList)
							{
								
								if (individualStudent.getID().equals(ID)) //search through studenIDList to find matching ID
								{
									
									individualStudent.setScore(newScore); //sets matching student grade with a new set score
									System.out.println(totalPointsPossible);
									computedScore = Math.round((studentObj.getScore() / totalPointsPossible) * 100);
									System.out.println(computedScore);
											
									individualStudent.setLetterGrade(individualStudent.defaultLetterGrade(computedScore)); 	//sets letter grade for score
									
									//JOptionPane.showMessageDialog(screenFrame, "Grade Replaced.", "Replaced Grade Status",JOptionPane.INFORMATION_MESSAGE);
									System.out.println("Student Grade Replaced.");
									System.out.println(updatedStudentList); //prints to show if student grade replaced
								}
							else
							{
								//JOptionPane.showMessageDialog(screenFrame, "Grade not Replaced.", "Remove Grade Status",JOptionPane.ERROR_MESSAGE);
								//System.out.println("Student Grade Not Replaced.");
								replaceGradeFrame.dispose();
							}
							
							replaceGradeFrame.dispose(); //closes add grade window
						}
						}
						}); 
						
			// }
		//});
		 
	
	} //End of replaceGrade()
	
	
	
//Method to delete addStudentID input and corresponding addGradeScore from array lists
	public void deleteGrade(ArrayList<Student> studentList)
	{
		//Creating new window for "delete a grade"
		JFrame deleteGradeFrame = new JFrame("Delete a Grade");
		deleteGradeFrame.setSize(500,90);
		deleteGradeFrame.setDefaultCloseOperation(makeChangesFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
		deleteGradeFrame.setVisible(true);
		deleteGradeFrame.setResizable(false); //user can't resize window
		//deleteGradeFrame.setLocationRelativeTo(null);
		deleteGradeFrame.setBounds(850,350,500,90);
		
		//Creating panel 
		JPanel deleteGradePanel = new JPanel();
		deleteGradePanel.setBackground(Color.cyan);
		
		//Add confirmation "Enter" button
		JButton deleteEnterButton = new JButton("Enter");
		
		//Creating labels
		JLabel whichToDeleteLabel = new JLabel("Which Student Grade do you want to Delete?  ");
		JLabel deleteStudentLabel = new JLabel("Student/ID:");

		
		//Creating text fields 
		JTextField deleteStudentIDField = new JTextField(20);

		
		//Adding labels/text fields to panel
		deleteGradePanel.add(whichToDeleteLabel);
		deleteGradePanel.add(deleteStudentLabel);
		deleteGradePanel.add(deleteStudentIDField);
	
		
		//Adding deleteEnterButton to panel
		deleteGradePanel.add(deleteEnterButton);
		
		//add a grade panel layout
		deleteGradePanel.setLayout(new BoxLayout(deleteGradePanel, BoxLayout.X_AXIS));
		
		
		//adding panel to frame
		//deleteGradeFrame.add(whichToDeleteLabel,BorderLayout.NORTH);
		//deleteGradeFrame.add(deleteGradePanel,BorderLayout.SOUTH);
		deleteGradeFrame.add(deleteGradePanel);

				 
				 
	//Button clicked Action Listener for deleteEnterButton
				 deleteEnterButton.addActionListener(new ActionListener() //delete window only closes if a ID is entered into the text field
					{
						public void actionPerformed(ActionEvent e)
						{ 
							System.out.println("Delete Student ID: " +  deleteStudentIDField.getText()); //prints user Student ID input to console
							 String ID = deleteStudentIDField.getText();
							
							 
							for (Student individualStudent: updatedStudentList)
							{
								if (individualStudent.getID().equals(ID)) //search through studenIDList to find match
								{
									updatedStudentList.remove(individualStudent); 		//removes student from updated list
									
									JOptionPane.showMessageDialog(screenFrame, "Grade Deleted.", "Delete Grade Status",JOptionPane.INFORMATION_MESSAGE);
									System.out.println("Student Grade Deleted.");
									System.out.println(updatedStudentList); 			//prints to console to check if value was deleted
								}
								else
								{
									//JOptionPane.showMessageDialog(screenFrame, "Grade not Deleted.", "Delete Grade Status",JOptionPane.ERROR_MESSAGE);
									deleteGradeFrame.dispose();
									
								}
							}
							
							deleteGradeFrame.dispose(); //closes delete window
						}
						}); //grade gets deleted only if user clicks "Enter"		
	
	} //End of deleteGrade()
	
	
	
	
	
} //End of GradeChange.java
