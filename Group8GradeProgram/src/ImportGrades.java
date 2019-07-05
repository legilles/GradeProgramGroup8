import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

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
	double computedStudentScore; 		// studentScore divided by totalPointsPossible value
	double roundedComputedScore;
	
	
	
//Method to prompt user and retrieve the totalPointsPossible value to apply to student scores
	public void getTotalPointsPossible()
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
	
				totalPointsPossible = pointsPossibleField.getText(); //sets totalPointsPossible equal to contents entered in text field
				System.out.println("Total Points Possible: " + totalPointsPossible); //prints to console total points possible value entered
				
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
		
	} //End of getTotalPointsPossible
	
	
//Method to compute the score earned by student	out of total points possible
public void computeStudentScore()
{
	for (int listIndex = 0; listIndex < studentScoreList.size(); listIndex++)
	{
		computedStudentScore = (studentScoreList.get(listIndex) /  Double.parseDouble(totalPointsPossible)) * 100.0; //converts variables to double than computes student score earned
		
		roundedComputedScore = Math.round((computedStudentScore * 100) / 100); //rounds computed Score list to 1 decimal place
		
		computedScoreList.add(roundedComputedScore); //adds rounded computed score to computed score array list
	}
	
	//defaultLetterGrade(); 	//calls defaultLetterGrade() method to get Letter Grade equivalent

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
			System.out.println(lineValue); //prints line of text file to console

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
} //End of importGrades()



//Method to Print out all Array Lists with Student ID's/Scores/Letter Grades
public void printGrades()
	{
		System.out.println( "Student ID's: " + studentIDList); //prints studentIDList to console
		System.out.println("Student Scores: " + studentScoreList); //prints studentScoreList to console
		System.out.println("Computed Scores: " + computedScoreList); //prints computedScoreList to console
		//System.out.println("Letter Grades: " + studentLetterList);
	

//Prints studentIDList/studentScoreList/studentLetterList in a friendly format in console
			for (int listIndex = 0; listIndex < computedScoreList.size(); listIndex++)
		{
			textResults += "Student ID: " + studentIDList.get(listIndex) + "  Grade Score: " + studentScoreList.get(listIndex) 
			+  "  Calculated Score: " + Math.round(computedScoreList.get(listIndex)) + "%" + "\n" + "\n";
			
		}
			//System.out.println(textResults); //prints text results to console
			
			//Creates text area and places textResults onto area
			JTextArea area = new JTextArea();
			area.setText(textResults); //set text of area to textResults
			area.setBackground(Color.yellow);
			area.setEditable(false); //text area not able to be edited
			
			//Creates new window to display grade results
			JFrame resultsFrame = new JFrame("Student Grades");
			resultsFrame.setSize(500,500);
			resultsFrame.setDefaultCloseOperation(resultsFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
			resultsFrame.setVisible(true);
			resultsFrame.add(area, BorderLayout.NORTH);
			resultsFrame.setLocationRelativeTo(null); //
			
} //End of printGrades()


	
//Method to loop through computedScoreList and assign student scores with corresponding letter grade value (includes rounding values)
	public void defaultLetterGrade()
	{
		
		for (int listIndex = 0; listIndex < computedScoreList.get(listIndex); listIndex++)
		{
			//Default A Letter Range
			if (computedScoreList.get(listIndex) >= 90.0 ) 
			{
				studentLetterList.add('A');
			}
			//Default B Letter Range
			if (computedScoreList.get(listIndex) >= 80.0  )
			{
				studentLetterList.add('B');
			}
			//Default C Letter Range
			if (computedScoreList.get(listIndex) >= 70.0 )
			{
				studentLetterList.add('C');
			}
			//Default D Letter Range
			if (computedScoreList.get(listIndex) >=  60.0 )
			{
				studentLetterList.add('D');
			}
			//Default F Letter Range
			if (computedScoreList.get(listIndex) <= 59.0 )
			{
				studentLetterList.add('F');
			}
			else
			{
				studentLetterList.add(' ');
			}
			
		}
		//*/
	} //End of defaultLetterGrades()



}//End of ImportGrades.java
