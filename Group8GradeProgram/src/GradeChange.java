import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GradeChange extends gradeAnalyticsGUI {
	
	String IDString;
	 String ScoreString;

	//Method to add addStudentID and addGradeScore text field inputs into array list
	public void addGrade()
	{
		//Creating new window for "add a grade"
		JFrame addGradeFrame = new JFrame("Add a Grade");
		addGradeFrame.setSize(400,100);
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
		
		//Add confirmation "Enter" button
		JButton addEnterButton = new JButton("Enter");
		
		//Add enter button to panel
		addGradePanel.add(addEnterButton);
		
		//add a grade panel layout
		addGradePanel.setLayout(new BoxLayout(addGradePanel, BoxLayout.X_AXIS));
		
		//adding panel to frame
		addGradeFrame.add(addGradePanel);
		
		
		
		//Text Field Action Listener for addStudentIDField
		 addStudentIDField.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e)
			 {
				 System.out.println(" Add Student ID: " +  addStudentIDField.getText()); //prints user Student ID input to console
				 IDString = addStudentIDField.getText();
			 }
		});
	
		//Text Field Action Listener for addGradeScoreField	
		 addGradeScoreField.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e)
			 {
				 System.out.println(" Add Student Score: " +  addGradeScoreField.getText()); //prints user Student score input to console
				 ScoreString = addGradeScoreField.getText();
			 }
		});
		 
		 //Button clicked Action Listener for addEnterButton
		 addEnterButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{ 
					studentIDList.add(IDString); //add Student ID to studentIDList array list
					
					studentScoreList.add(ScoreString);//add Student Score to studentScoreList
					
					new ImportGrades().printGrades();
				}
				}); //values inputed only get added if user clicks "Enter"
		 	 
	} //End of addGrade()
	
	//Method to replace
	public void replaceGrade()
	{

		//Creating new window for "replace a grade"
		JFrame replaceGradeFrame = new JFrame("Replace a Grade");
		replaceGradeFrame.setSize(400,100);
		replaceGradeFrame.setDefaultCloseOperation(makeChangesFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
		replaceGradeFrame.setVisible(true);
		
		//Creating panel
		JPanel replaceOldGradePanel = new JPanel();
		replaceOldGradePanel.setBackground(Color.cyan);
		
		JPanel replaceNewGradePanel = new JPanel();
		replaceNewGradePanel.setBackground(Color.cyan);
		
		//Add confirmation "Enter" button
		JButton replaceEnterButton = new JButton("Enter");
		
		//Creating labels
		JLabel replaceOldStudentLabel = new JLabel("Student/ID:");
		JLabel replaceOldGradeScoreLabel = new JLabel("Old Score: ");
		//JLabel replaceNewStudentLabel = new JLabel("New Student/ID:");
		JLabel replaceNewGradeScoreLabel = new JLabel("New Score: ");
		
		//Creating text fields 
		JTextField replaceOldStudentID = new JTextField(20);
		JTextField replaceOldGradeScore = new JTextField(20);
		//JTextField replaceNewStudentID = new JTextField(20);
		JTextField replaceNewGradeScore = new JTextField(20);
		
		//Adding labels/text fields to panel
		replaceOldGradePanel.add(replaceOldStudentLabel);
		replaceOldGradePanel.add(replaceOldStudentID);
		replaceOldGradePanel.add(replaceOldGradeScoreLabel);
		replaceOldGradePanel.add(replaceOldGradeScore);
		
		//replaceNewGradePanel.add(replaceNewStudentLabel);
		//replaceNewGradePanel.add(replaceNewStudentID);
		replaceNewGradePanel.add(replaceNewGradeScoreLabel);
		replaceNewGradePanel.add(replaceNewGradeScore);
		
		//Adding replaceEnterButton to panel
		replaceNewGradePanel.add(replaceEnterButton);
		
		//add a grade panel layout
		replaceOldGradePanel.setLayout(new BoxLayout(replaceOldGradePanel, BoxLayout.X_AXIS));
		replaceNewGradePanel.setLayout(new BoxLayout(replaceNewGradePanel, BoxLayout.X_AXIS));
		
		//adding panel to frame
		replaceGradeFrame.add(replaceOldGradePanel,BorderLayout.NORTH);
		replaceGradeFrame.add(replaceNewGradePanel,BorderLayout.SOUTH);
		
	}
	
	//Method to delete addStudentID and addGradeScore text field inputs from array lists
	public void deleteGrade()
	{
		//Creating new window for "delete a grade"
		JFrame deleteGradeFrame = new JFrame("Delete a Grade");
		deleteGradeFrame.setSize(400,90);
		deleteGradeFrame.setDefaultCloseOperation(makeChangesFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
		deleteGradeFrame.setVisible(true);
		
		//Creating panel 
		JPanel deleteGradePanel = new JPanel();
		deleteGradePanel.setBackground(Color.cyan);
		
		//Add confirmation "Enter" button
		JButton deleteEnterButton = new JButton("Enter");
		
		//Creating labels
		JLabel whichToDeleteLabel = new JLabel("Which grade do you want to delete?");
		JLabel deleteStudentLabel = new JLabel("Student/ID:");
		JLabel deleteGradeScoreLabel = new JLabel("Score: ");
		
		//Creating text fields 
		JTextField deleteStudentID = new JTextField(20);
		JTextField deleteGradeScore = new JTextField(20);
		
		//Adding labels/text fields to panel
		deleteGradePanel.add(whichToDeleteLabel);
		deleteGradePanel.add(deleteStudentLabel);
		deleteGradePanel.add(deleteStudentID);
		deleteGradePanel.add(deleteGradeScoreLabel);
		deleteGradePanel.add(deleteGradeScore);
		
		//Adding deleteEnterButton to panel
		deleteGradePanel.add(deleteEnterButton);
		
		//add a grade panel layout
		deleteGradePanel.setLayout(new BoxLayout(deleteGradePanel, BoxLayout.X_AXIS));
		
		
		//adding panel to frame
		deleteGradeFrame.add(whichToDeleteLabel,BorderLayout.NORTH);
		deleteGradeFrame.add(deleteGradePanel,BorderLayout.SOUTH);
		
	} //End of deleteGrade()
	
	
	
	
} //End of GradeChange.java
