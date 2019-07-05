import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChangeGradeDistribution extends gradeAnalyticsGUI {
	
	String newPointsPossible; 
	double doublenewPointsPossible;
	double newRoundedComputedScore;
	double newComputedScore;
	
	ArrayList<Double> newComputedScoreList = new ArrayList<Double>();	//array list to store new grades with changed point scale
	
	public void changeGradeDistribution()
	{
		System.out.println("Change Grade Distribution Button Clicked");
		
		
		//Creating frame
		JFrame gradeDisFrame = new JFrame("Change Grade Distribution");
		gradeDisFrame.setSize(450,90);
		gradeDisFrame.setDefaultCloseOperation(gradeDisFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
		gradeDisFrame.setVisible(true); 
		gradeDisFrame.setResizable(false);
		gradeDisFrame.setLocationRelativeTo(null);
		
		//Creating Panel
		JPanel gradeDisPanel = new JPanel();
		gradeDisPanel.setBackground(Color.red);
		
		//Creating buttons
		JButton changeGradeRangeButton = new JButton("Change Letter Grade Ranges");
		JButton changeTotalPointsButton = new JButton("Change Total Points Possible");
		
		gradeDisPanel.setLayout(new BoxLayout(gradeDisPanel, BoxLayout.X_AXIS));
		
		//Adding buttons to panel and spacing
		gradeDisPanel.add(Box.createHorizontalStrut(10));
		gradeDisPanel.add(changeGradeRangeButton);
		gradeDisPanel.add(Box.createHorizontalStrut(10));
		gradeDisPanel.add(changeTotalPointsButton);
		
		gradeDisFrame.add(gradeDisPanel);
		
//Change Total Points Possible JButton Action Listener
		changeTotalPointsButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//Creating frame
				JFrame changePointFrame = new JFrame("Change Total Points");
				changePointFrame.setSize(500,100);
				changePointFrame.setDefaultCloseOperation(changePointFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
				changePointFrame.setVisible(true); 
				changePointFrame.setResizable(false);
				changePointFrame.setLocationRelativeTo(null);
				
				//Creating Panel
				JPanel changePointPanel = new JPanel();
				changePointPanel.setBackground(Color.red);
				
				//Creating label,text field, button
				JLabel setTotalLabel = new JLabel("Out of How Many Points?");
				JTextField newTotalField = new JTextField(10);
				JButton newPointsEnterButton = new JButton("Enter");

				//Adding components to panel
				changePointPanel.add(setTotalLabel);
				changePointPanel.add(newTotalField);
				changePointPanel.add(newPointsEnterButton);
				
				//Panel layout
				changePointPanel.setLayout(new BoxLayout(changePointPanel, BoxLayout.X_AXIS));
				
				//Add panel to frame
				changePointFrame.add(changePointPanel);
				
//Action Listener for newTotalField
				newTotalField.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						newPointsPossible = newTotalField.getText(); 
						doublenewPointsPossible = Double.parseDouble(newPointsPossible); //converts string to double
						System.out.println("New Point Total: " + newPointsPossible);
					
//Action Listener for newPointsEnterButton
				newPointsEnterButton.addActionListener(new ActionListener() //window only closes if user entered new point value into text field
				{
					public void actionPerformed(ActionEvent e)
					{
						changePointFrame.dispose(); //closes window
						
						calculateNewStudentGrades(); //calls method to re-calculate scores
						printNewGrades(); //prints out new grade results
						
							}	
						}); 
					}	
				}); 
				
			}	
		}); //CHANGE TOTAL POINTS POSSIBLE ACTION LISTENER
		
	}
	
	
/*
//Change Grade Letter Ranges JButton Action Listener
		changeGradeRangeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
		JFrame gradeRangeFrame = new JFrame("Change Grade Distribution");
		gradeRangeFrame.setSize(450,90);
		gradeRangeFrame.setDefaultCloseOperation(gradeDisFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
		gradeRangeFrame.setVisible(true); 	
		
		//Creating Panel
		JPanel gradeRangePanel = new JPanel();
		gradeRangePanel.setBackground(Color.red);
		
		//Grade Letter Labels
		JLabel letterChangeTitle = new JLabel("Change Grade Letter Ranges");
		JLabel letterALabel = new JLabel("A:");
		JLabel letterBLabel = new JLabel("B:");
		JLabel letterCLabel = new JLabel("C:");
		JLabel letterDLabel = new JLabel("D:");
		JLabel letterFLabel = new JLabel("F:");
		JLabel letterELabel = new JLabel("E:");
		
		//Adding letter labels to gradeChangerPanel
		gradeRangePanel.setLayout(new BoxLayout(gradeRangePanel, BoxLayout.Y_AXIS));
		gradeRangePanel.add(letterChangeTitle);
		gradeRangePanel.add(letterALabel);
		gradeRangePanel.add(letterBLabel);
		gradeRangePanel.add(letterCLabel);
		gradeRangePanel.add(letterDLabel);
		gradeRangePanel.add(letterFLabel);
		gradeRangePanel.add(letterELabel);
		
		
		//Adding text fields for each letter
		JTextField letterATextField = new JTextField(20);
		JTextField letterBTextField = new JTextField(20);
		JTextField letterCTextField = new JTextField(20);
		JTextField letterDTextField = new JTextField(20);
		JTextField letterFTextField = new JTextField(20);
		JTextField letterETextField = new JTextField(20);
		
		
		JPanel letterTextFields = new JPanel();
		letterTextFields.setLayout(new BoxLayout(letterTextFields, BoxLayout.Y_AXIS));
		
		
		//Adding letter text fields to letterTextFields Panel
		letterTextFields.add(letterATextField);
		letterTextFields.add(letterBTextField);
		letterTextFields.add(letterCTextField);
		letterTextFields.add(letterDTextField);
		letterTextFields.add(letterFTextField);
		letterTextFields.add(letterETextField);
		
		
		gradeRangeFrame.add(gradeRangePanel, BorderLayout.WEST);
		gradeRangeFrame.add(letterTextFields, BorderLayout.EAST);
		}	
	}); //CHANGE GRADE LETTER RANGES ACTION LISTENER
}
	//*/
	
	
	
	
	
	
//Method to re-calculate scores with doubleNewPointsPossible value	
	public void calculateNewStudentGrades()
	{
		for (int listIndex = 0; listIndex < studentScoreList.size(); listIndex++)
		{
			 newComputedScore = (studentScoreList.get(listIndex) /  doublenewPointsPossible) * 100.0; //converts variables to double than computes student score earned
			
			newRoundedComputedScore = Math.round((newComputedScore * 100) / 100); //rounds computed Score list to 1 decimal place
			
			newComputedScoreList.add(newRoundedComputedScore); //adds new rounded computed score to computed score array list
		}
		
	}

//Prints out grades with new point scale
	public void printNewGrades()
	{
		System.out.println( "Student ID's: " + studentIDList); //prints studentIDList to console
		System.out.println("Student Scores: " + studentScoreList); //prints studentScoreList to console
		System.out.println("Computed Scores: " + computedScoreList); //prints computedScoreList to console
		//System.out.println("Letter Grades: " + studentLetterList);
	
	
//Prints studentIDList/studentScoreList/studentLetterList in a friendly format in console
			for (int listIndex = 0; listIndex < computedScoreList.size(); listIndex++)
		{
			textResults += "Student ID: " + studentIDList.get(listIndex) + "  Grade Score: " + studentScoreList.get(listIndex) 
			+  "  Calculated Score: " + Math.round(newComputedScoreList.get(listIndex)) + "%" + "\n" + "\n";
			
		}
			System.out.println(textResults); //prints text results to console
			
			//Creates text area and places textResults onto area
			JTextArea newArea = new JTextArea();
			newArea.setText(textResults); //set text of area to textResults
			newArea.setBackground(Color.yellow);
			newArea.setEditable(false); //text area not able to be edited
			
			//Creates new window to display grade results
			JFrame newResultsFrame = new JFrame("Student Grades");
			
			newResultsFrame.setSize(500,500);
			newResultsFrame.setDefaultCloseOperation(newResultsFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
			newResultsFrame.setVisible(true);
			newResultsFrame.add(newArea, BorderLayout.NORTH);
	}




	
	
} //End of ChangeGradeDistribution.java
