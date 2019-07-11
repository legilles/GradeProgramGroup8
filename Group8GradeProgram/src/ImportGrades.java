import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
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
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;



public class ImportGrades extends gradeAnalyticsGUI {
	
	BufferedReader reader = null;
	int lineIndex = 0; 				//index of the text file
	//String totalPointsPossible; 	//max value score can be out of
	//String lineValue; 				//value of the text line at a single line
	String textResults = ""; 			//string value that holds value of array lists
	

	//creates object of GUI
		gradeAnalyticsGUI GUIObj = new gradeAnalyticsGUI();
		
		
		//Method to prompt user and retrieve the totalPointsPossible value to apply to student scores
			public ArrayList<Student> getTotalPointsPossible(ArrayList<Student> pStudentList)
			{
				//creates window
				JFrame pointsPossibleFrame = new JFrame("Total Points Possible"); //creates new window
				pointsPossibleFrame.setSize(300, 100); //sets size of frame
				pointsPossibleFrame.setDefaultCloseOperation(makeChangesFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
				pointsPossibleFrame.setVisible(true);
				pointsPossibleFrame.setResizable(false); //user can't re-size frame
				pointsPossibleFrame.setBounds(800,350,300,100); //opens window to center of screen
				
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
					
				//Action Listener for pointsPossibleEnterButton
						pointsPossibleEnterButton.addActionListener(new ActionListener() { //user can't move on until value is entered for points possible
							 public void actionPerformed(ActionEvent e)
							 {

								 totalPointsPossible = Double.parseDouble(pointsPossibleField.getText()); //sets totalPointsPossible equal to contents entered in text field
									
									//sets total points possible
									GUIObj.setTotal(totalPointsPossible);
									
									System.out.println("Total Points Possible: " + GUIObj.getTotal()); //prints to console total points possible value entered
									
									setMaxPosScore(totalPointsPossible);
								 
								 pointsPossibleFrame.dispose(); //closes point prompt window after "Enter" is clicked
								 
								 studentList = importGrades(pStudentList); //calls on importGrades() method after enter is clicked
							 }
						});
						return studentList;			
				
			} //End of getTotalPointsPossible
		
	
//Method to import a text file and separate data line by line into array lists
public ArrayList<Student> importGrades(ArrayList<Student> pStudentList)
{

	final JFileChooser gradeFileFinder = new JFileChooser();
	int returnFile = gradeFileFinder.showOpenDialog(screenFrame); //dialog opens on screen frame
	gradeFileFinder.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); //user can look for file using directory
	
	if (returnFile == JFileChooser.APPROVE_OPTION)
	{
		File selectedFile = gradeFileFinder.getSelectedFile();
		System.out.println(selectedFile.getAbsolutePath()); //prints file path to console

	//File file = new File("gradeAnalyticsTester.txt");

	
	try  {
		
		Scanner line = new Scanner(new FileReader(selectedFile));
		//Scanner line = new Scanner(file);
		//studentList = new ArrayList<>();

		while (line.hasNext())
		{
			String id = line.next(); //reads in ID
			Student studentObj = new Student(id);
			studentObj.setID(id); //set ID
			System.out.println(id);
			
			double score = line.nextDouble(); //reads in score
			studentObj.setScore(score); //sets student score
			System.out.println(score);
		
			computedScore = Math.round((studentObj.getScore() / GUIObj.getTotal()) * 100);
			//System.out.println(computedScore);
					
			studentObj.setLetterGrade(studentObj.defaultLetterGrade(computedScore)); //sets letter grade for score
			
			
			studentList.add(studentObj); 
		}
		line.close(); //closes scanner
		
		System.out.println("File Uploaded"); //check console if file uploaded
		JOptionPane.showMessageDialog(screenFrame, "File Uploaded.", "File Status",JOptionPane.INFORMATION_MESSAGE); //tells user text file was uploaded
		 
		printGrades(studentList); //calls to print out results from text file
		
		//new SeeStatistics().findMinScore(studentList);
		//new SeeStatistics().findMaxScore(studentList);
		
	} catch (IOException ioe)
	{
		System.out.println("File Not Uploaded"); //check console if file didn't load
		JOptionPane.showMessageDialog(screenFrame, "File Not Uploaded.", "File Status",JOptionPane.ERROR_MESSAGE); //warns user if file not uploaded
	
	}
	}
	return studentList;
}	
//} //End of importGrades()



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
	printGradesToPanel(textResults);
	}

public void printGradesToPanel(String textReults) 
{
			//Creates text area and places textResults onto area
			JTextArea area = new JTextArea();
			area.setText(textResults); //set text of area to textResults
			area.setBackground(Color.yellow);
			area.setEditable(false); //text area not able to be edited
			
			JFrame gradeResultsFrame = new JFrame();
			gradeResultsFrame.setSize(500,450); //sets frame size
			gradeResultsFrame.setDefaultCloseOperation(screenFrame.DISPOSE_ON_CLOSE); //program will quit if user clicks "x"
			gradeResultsFrame.setVisible(true);  
			
			//gradeResultsFrame.setLocationRelativeTo(null); //displays window in center of screen
			gradeResultsFrame.setBounds(70,150,430,600);
			//gradeResultsFrame.setResizable(false); //user can't resize window
			gradeResultsFrame.add(area);
			
}



	

}//End of ImportGrades.java
