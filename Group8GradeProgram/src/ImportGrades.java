import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class ImportGrades extends gradeAnalyticsGUI {
	
	BufferedReader reader = null;
	int lineIndex = 0; 				//index of the text file
	String totalPointsPossible; 	//max value score can be out of
	String lineValue; 				//value of the text line at a single line
	String textResults = ""; 			//string value that holds value of array lists
	double computedStudentScore = 0.0; 		// studentScore divided by totalPointsPossible value
	
	double scoreToLetter = 0.0; 
	
	ArrayList<Double> computedScoreList = new ArrayList<Double>(); //array list to hold computed scores
	
//Method to prompt user and retrieve the totalPointsPossible value to apply to student scores
	public void getTotalPointsPossible()
	{
		//creates window
		JFrame pointsPossibleFrame = new JFrame("Total Points Possible"); //creates new window
		pointsPossibleFrame.setSize(300, 100); //sets size of frame
		pointsPossibleFrame.setDefaultCloseOperation(makeChangesFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
		pointsPossibleFrame.setVisible(true);
		
		//creates label, text field, button
		JLabel promptPointsLabel = new JLabel("Out of how many point?");
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
				totalPointsPossible = pointsPossibleField.getText(); //sets totalPointsPossible equal to contents entered in text field
				System.out.println("Total Points Possible: " + totalPointsPossible); //prints to console total points possible value entered
			 }
		});
		
		//Action Listener for pointsPossibleEnterButton
		pointsPossibleEnterButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e)
			 {
				 pointsPossibleFrame.dispose(); //closes point prompt window after "Enter" is clicked
				 importGrades(); //calls on importGrades() method after enter is clicked
			 }
		});
				
	}
//Method to compute the score earned by student	out of total points possible
public void computeStudentScore()
{

	for (int listIndex = 0; listIndex < studentScoreList.size(); listIndex++)
	{
		computedStudentScore = studentScoreList.get(listIndex) +  Double.parseDouble(totalPointsPossible); //converts variables to double than computes student score earned
		computedScoreList.add(computedStudentScore); //adds computed score to computed score array list
	}
	
	//defaultLetterGrade(computedStudentScore); //calls defaultLetterGrade() method to get Letter Grade equivalent
}
	
	
	
	
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
		reader = new BufferedReader(new FileReader(selectedFile));
	
		while ((lineValue = reader.readLine()) != null)
		{
			System.out.println(lineValue); //print results to console

			lineIndex++;
			if (lineIndex % 2 != 0) // odd line number is Student ID and not last number which is total points possible
			{
				studentIDList.add(lineValue); //store in Student ID Array List
			}
			if (lineIndex % 2 == 0) //even line number is Student Score
			{
				double doubleLineValue = Double.parseDouble(lineValue); //converts lineValue to double
				studentScoreList.add(doubleLineValue); 	//stores doubleLineValue in studentScoreList
			}
	
		}
		
		reader.close(); //closes text file
		
		System.out.println("File Uploaded"); //check console if file uploaded
		JOptionPane.showMessageDialog(screenFrame, "File Uploaded.", "File Status",JOptionPane.INFORMATION_MESSAGE); //tells user text file was uploaded
		
		computeStudentScore(); //calls to compute student score to determine letter grade
		printGrades(); //calls to print out results from text file
		
	} catch (IOException ioe)
	{
		System.out.println("File Not Uploaded"); //check console if file didn't load
		JOptionPane.showMessageDialog(screenFrame, "File Not Uploaded.", "File Status",JOptionPane.ERROR_MESSAGE); //warns user if file not uploaded
	
	}
	}	
}



//Method to Print out all Array Lists with Student ID's/Scores/Letter Grades
public void printGrades()
	{
		System.out.println( "Student ID's: " + studentIDList); //prints studentIDList to console
		System.out.println("Student Scores: " + studentScoreList); //prints studentScoreList to console
		System.out.println("Computed Scores: " + computedScoreList); //prints computedScoreList to console
	
	
//Prints studentIDList/studentScoreList/studentLetterList in a friendly format in console
			for (int listIndex = 0; listIndex < studentIDList.size(); listIndex++)
		{
			textResults += "Student ID: " + studentIDList.get(listIndex) + "  Grade Score: " + studentScoreList.get(listIndex);// + "  Letter Grade: " + studentLetterList.get(listIndex) + "\n" + "\n";
			
	
		}
			//Creates text area and places textResults onto area
			JTextArea area = new JTextArea();
			area.setText(textResults); //set text of area to textResults
			area.setEditable(false); //text area not able to be edited
			
			//Creates new window to display grade results
			JFrame resultsFrame = new JFrame("Student Grades");
			resultsFrame.setSize(300,500);
			resultsFrame.setDefaultCloseOperation(resultsFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
			resultsFrame.setVisible(true);
			resultsFrame.add(area, BorderLayout.NORTH);
}



	
//Method to assign student score with corresponding letter grade value (includes rounding values)
	public void defaultLetterGrade(double scoreToLetter)
	{
		//Default A Letter Range
		if (scoreToLetter <= 1 || scoreToLetter >= 0.85 )
		{
			studentLetterList.add('A');
		}
		//Default B Letter Range
		if (scoreToLetter <= 0.89 || scoreToLetter >= 0.79 )
		{
			studentLetterList.add('B');
		}
		//Default C Letter Range
		if (scoreToLetter <= 0.79 || scoreToLetter >= 0.69 )
		{
			studentLetterList.add('C');
		}
		//Default D Letter Range
		if (scoreToLetter <= 0.69 || scoreToLetter >= 0.59 )
		{
			studentLetterList.add('D');
		}
		//Default F Letter Range
		if (scoreToLetter <= 0.49 || scoreToLetter >= 0.39 )
		{
			studentLetterList.add('F');
		}
		//Default E Letter Range
		if (scoreToLetter <= 0.39 )
		{
			studentLetterList.add('E');
		}
		return;
	}



}//End of ImportGrades.java
