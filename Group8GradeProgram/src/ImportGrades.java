import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class ImportGrades extends gradeAnalyticsGUI {
	
	BufferedReader reader = null;
	int lineIndex = 0; 				//index of the text file
	//String totalPointsPossible; 	//max value score can be out of
	//String lineValue; 				//value of the text line at a single line
	String textResults = ""; 			//string value that holds value of array lists
	
	//creates object of GUI
	gradeAnalyticsGUI GUIObj = new gradeAnalyticsGUI();
	

	
//Method to prompt user and retrieve the totalPointsPossible value to apply to student scores
	public double getTotalPointsPossible()
	{
		//creates window
		JFrame pointsPossibleFrame = new JFrame("Total Points Possible"); //creates new window
		pointsPossibleFrame.setSize(300, 100); //sets size of frame
		pointsPossibleFrame.setDefaultCloseOperation(makeChangesFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
		pointsPossibleFrame.setVisible(true);
		pointsPossibleFrame.setResizable(false); //user can't re-size frame
		pointsPossibleFrame.setLocationRelativeTo(null); //opens window to center of screen
		
		//creates label, text field, button
		JLabel promptPointsLabel = new JLabel("Out of how many points?");
		JTextField pointsPossibleField = new JTextField(20);
		JButton pointsPossibleEnterButton = new JButton("Enter");
		
		//creates panel
		JPanel pointsPossiblePanel = new JPanel();
		pointsPossiblePanel.setBackground(Color.yellow);
		
		//panel layout
		pointsPossiblePanel.setLayout(new BoxLayout(pointsPossiblePanel, BoxLayout.X_AXIS));
		
		//adds components to panel
		pointsPossiblePanel.add(promptPointsLabel);
		pointsPossiblePanel.add(pointsPossibleField);
		pointsPossiblePanel.add(pointsPossibleEnterButton);
		
		//adds panel to frame
		pointsPossibleFrame.add(pointsPossiblePanel);
		
		
	
		
		//Action Listener for pointsPossibleField to retrieve points possible value
		pointsPossibleField.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e)
			 {
				totalPointsPossible = Double.parseDouble(pointsPossibleField.getText()); //sets totalPointsPossible equal to contents entered in text field
		
				
				
				//sets total points possible
				GUIObj.setTotal(totalPointsPossible);
				
				System.out.println("Total Points Possible: " + GUIObj.getTotal()); //prints to console total points possible value entered
				
		//Action Listener for pointsPossibleEnterButton
				pointsPossibleEnterButton.addActionListener(new ActionListener() { //user can't move on until value is entered for points possible
					 public void actionPerformed(ActionEvent e)
					 {
						 pointsPossibleFrame.dispose(); //closes point prompt window after "Enter" is clicked
						 
						 importGrades(); //calls on importGrades() method after enter is clicked
					 }
				});			
			} 
		});
		return totalPointsPossible;
	} //End of getTotalPointsPossible
	
		
//Method to import a text file and separate data line by line into array lists
public void importGrades()
{
	final JFileChooser gradeFileFinder = new JFileChooser();
	int returnFile = gradeFileFinder.showOpenDialog(screenFrame); //dialog opens on screen frame
	gradeFileFinder.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); //user can look for file using directory
	
	if (returnFile == JFileChooser.APPROVE_OPTION)
	{
		File selectedFile = gradeFileFinder.getSelectedFile();
		System.out.println(selectedFile.getAbsolutePath()); //prints file path to console

	try  {
		
		Scanner line = new Scanner(new FileReader(selectedFile));
		studentList = new ArrayList<>();
		
		while (line.hasNext())
		{
			
			String id = line.next(); //gets ID
			Student studentObj = new Student(id);
			System.out.println(id);
			
			double score = line.nextDouble();
			studentObj.setScore(score); //sets student score
			System.out.println(score);
		
			computedScore = Math.round((studentObj.getScore() / totalPointsPossible) * 100);
			System.out.println(computedScore);
					
			studentObj.setLetterGrade(studentObj.defaultLetterGrade(computedScore)); //sets letter grade for score
			
			
			studentList.add(studentObj); 
		}
		line.close(); //closes scanner
		
		System.out.println("File Uploaded"); //check console if file uploaded
		JOptionPane.showMessageDialog(screenFrame, "File Uploaded.", "File Status",JOptionPane.INFORMATION_MESSAGE); //tells user text file was uploaded
		 
		printGrades(studentList); //calls to print out results from text file
		
	} catch (IOException ioe)
	{
		System.out.println("File Not Uploaded"); //check console if file didn't load
		JOptionPane.showMessageDialog(screenFrame, "File Not Uploaded.", "File Status",JOptionPane.ERROR_MESSAGE); //warns user if file not uploaded
	
	}
	}	
} //End of importGrades()



//Method to Print out all Array Lists with Student ID's/Scores/Letter Grades
private void printGrades(ArrayList<Student> studentList)
	{
	for (Student individualStudent: studentList)
	{
		
		System.out.println("Student ID: " + individualStudent.getID() + " Student Score: " + 
	individualStudent.getScore() + "  Percent Score: " + Math.round(individualStudent.getScore()/totalPointsPossible * 100) + "%   "  + "  Letter Grade: " + individualStudent.getLetterGrade());
		
		textResults += "Student ID: " + individualStudent.getID() + "  Student Score: " + 
		individualStudent.getScore() + "  Percent Score: " + Math.round(individualStudent.getScore()/totalPointsPossible * 100 ) + "%   " + "  Letter Grade: " + individualStudent.getLetterGrade() + "\n" + "\n";
	
	}	
	}

public void printGradesWindow(String textReults) 
{
			//Creates text area and places textResults onto area
			JTextArea area = new JTextArea();
			area.setText(textResults); //set text of area to textResults
			area.setBackground(Color.yellow);
			area.setEditable(false); //text area not able to be edited
			
			JPanel gradeResultsPanel = new JPanel();
			gradeResultsPanel.add(area);
			
			//Creates new window to display grade results
			JFrame resultsFrame = new JFrame("Student Grades");
			resultsFrame.setSize(500,500);
			resultsFrame.setDefaultCloseOperation(resultsFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
			resultsFrame.setVisible(true);
			resultsFrame.add(area, BorderLayout.NORTH);
			resultsFrame.setLocationRelativeTo(null); 
}




	

}//End of ImportGrades.java
