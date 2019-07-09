import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChangeGradeDistribution extends SeeStatistics {
	
	String newMaxPointsPossible; 
	String newMinPointsPossible;
	String reCalcGrades = "";
	double doubleMaxPointsPossible;
	double doubleMinPointsPossible;
	double newRoundedComputedScore;
	double newComputedScore;
	
	//Variables for new grade ranges
	String a;
	String b;
	String c;
	String d;
	String f;
	
   	double redefinedGrade_A;
	double redefinedGrade_B;
	double redefinedGrade_C;
	double redefinedGrade_D;
	
	ArrayList<Double> newComputedScoreList = new ArrayList<Double>();	//array list to store new grades with changed point scale
	
	public void changeGradeDistribution()
	{
		System.out.println("Change Grade Distribution Button Clicked");
		
		
		//Creating frame
		JFrame gradeDisFrame = new JFrame("Change Grade Distribution");
		gradeDisFrame.setDefaultCloseOperation(gradeDisFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
		gradeDisFrame.setVisible(true); 
		gradeDisFrame.setResizable(false);
		gradeDisFrame.setBounds(750,350,400,90);
		
		//Creating Panel
		JPanel gradeDisPanel = new JPanel();
		gradeDisPanel.setBackground(Color.red);
		
		//Creating buttons
		JButton changeButton = new JButton("Change Grade Distribution Based on Lowest/Highest Scores");
		//JButton changeGradeRangeButton = new JButton("Change Grade Distribution Based on Lowest/Highest Scores");
		//JButton changeMaxPointsButton = new JButton("Change Maximum Points Possible");
		//JButton changeMinPointsButton = new JButton("Change Minimum Points Possible");
		
		gradeDisPanel.setLayout(new BoxLayout(gradeDisPanel, BoxLayout.X_AXIS));
		
		//Adding buttons to panel and spacing
		gradeDisPanel.add(Box.createHorizontalStrut(10));
		gradeDisPanel.add(changeButton);
		//gradeDisPanel.add(changeGradeRangeButton);
		gradeDisPanel.add(Box.createHorizontalStrut(10));
		//gradeDisPanel.add(changeMaxPointsButton);
		gradeDisPanel.add(Box.createHorizontalStrut(10));
		//gradeDisPanel.add(changeMinPointsButton);
		
		gradeDisFrame.add(gradeDisPanel);
		
//Change Min Points Possible JButton Action Listener
		/*
		changeMinPointsButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//Creating frame
				JFrame changeMinFrame = new JFrame("Change Total Points");
				changeMinFrame.setSize(500,100);
				changeMinFrame.setDefaultCloseOperation(changeMinFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
				changeMinFrame.setVisible(true); 
				changeMinFrame.setResizable(false);
				changeMinFrame.setBounds(850,350,500,100);
				
				//Creating Panel
				JPanel changeMinPanel = new JPanel();
				changeMinPanel.setBackground(Color.red);
				
				//Creating label,text field, button
				JLabel setMinTotalLabel = new JLabel("Out of How Many Minimum Total Points?");
				JTextField newMinTotalField = new JTextField(10);
				JButton newMinPointsEnterButton = new JButton("Enter");

				//Adding components to panel
				changeMinPanel.add(setMinTotalLabel);
				changeMinPanel.add(newMinTotalField);
				changeMinPanel.add(newMinPointsEnterButton);
				
				//Panel layout
				changeMinPanel.setLayout(new BoxLayout(changeMinPanel, BoxLayout.X_AXIS));
				
				//Add panel to frame
				changeMinFrame.add(changeMinPanel);
				
//Action Listener for newTotalField
				newMinTotalField.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						newMinPointsPossible = newMinTotalField.getText(); 
						doubleMinPointsPossible = Double.parseDouble(newMinPointsPossible); //converts string to double
						System.out.println("New Point Total: " + newMinPointsPossible);
						setMinPosScore(doubleMinPointsPossible);
					
//Action Listener for newPointsEnterButton
				newMinPointsEnterButton.addActionListener(new ActionListener() //window only closes if user entered new point value into text field
				{
					public void actionPerformed(ActionEvent e)
					{
						changeMinFrame.dispose(); //closes window
						
						//calculateNewStudentGrades(); //calls method to re-calculate scores
						//printNewGrades(); //prints out new grade results
						
							}	
						}); 
					}	
				}); 
			}
		});
		
				
//Change Max Points Possible JButton Action Listener
				changeMaxPointsButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						//Creating frame
						JFrame changeMaxFrame = new JFrame("Change Total Points");
						changeMaxFrame.setSize(500,100);
						changeMaxFrame.setDefaultCloseOperation(changeMaxFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
						changeMaxFrame.setVisible(true); 
						changeMaxFrame.setResizable(false);
						changeMaxFrame.setLocationRelativeTo(null);
						
						//Creating Panel
						JPanel changeMaxPanel = new JPanel();
						changeMaxPanel.setBackground(Color.red);
						
						//Creating label,text field, button
						JLabel setMaxTotalLabel = new JLabel("Out of How Many Maximum Total Points?");
						JTextField newMaxTotalField = new JTextField(10);
						JButton newMaxPointsEnterButton = new JButton("Enter");

						//Adding components to panel
						changeMaxPanel.add(setMaxTotalLabel);
						changeMaxPanel.add(newMaxTotalField);
						changeMaxPanel.add(newMaxPointsEnterButton);
						
						//Panel layout
						changeMaxPanel.setLayout(new BoxLayout(changeMaxPanel, BoxLayout.X_AXIS));
						
						//Add panel to frame
						changeMaxFrame.add(changeMaxPanel);
						
		//Action Listener for newTotalField
						newMaxTotalField.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								newMaxPointsPossible = newMaxTotalField.getText(); 
								doubleMaxPointsPossible = Double.parseDouble(newMaxPointsPossible); //converts string to double
								System.out.println("New Point Total: " + newMaxPointsPossible);
								setMaxPosScore(doubleMaxPointsPossible);
							
		//Action Listener for newPointsEnterButton
						newMaxPointsEnterButton.addActionListener(new ActionListener() //window only closes if user entered new point value into text field
						{
							public void actionPerformed(ActionEvent e)
							{
								changeMaxFrame.dispose(); //closes window
								
								//calculateNewStudentGrades(); //calls method to re-calculate scores
								//printNewGrades(); //prints out new grade results
								
									}	
								}); 
							}	
						}); 	
					}
				});
	/*/			
						
				
		//Change Max Points Possible JButton Action Listener
		changeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//Creating frame
				JFrame changeFrame = new JFrame("Change Total Points");
				changeFrame.setSize(500,400);
				changeFrame.setDefaultCloseOperation(changeFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
				changeFrame.setVisible(true); 
				changeFrame.setResizable(false);
				changeFrame.setBounds(750,350,600,400);
				
				//Creating Panel
				JPanel changePanel = new JPanel();
				changePanel.setBackground(Color.red);
				
				gradeRecalculator(studentList);
				
				//Add panel to frame
				changeFrame.add(changePanel);
				
				JButton disGradeClose = new JButton("Close");
				
				JTextArea disResults = new JTextArea();
				disResults.setText(reCalcGrades);
				disResults.setBackground(Color.red);
				
					changeFrame.add(disGradeClose, BorderLayout.SOUTH);	
					changeFrame.add(disResults, BorderLayout.CENTER);
				
						disGradeClose.addActionListener(new ActionListener() 
						{
							public void actionPerformed(ActionEvent e)
							{ 
								changeFrame.dispose();
							}
						});
					
						
					}
				});
	}
		/*
//Change Grade Letter Ranges JButton Action Listener
		changeGradeRangeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
		JFrame gradeRangeFrame = new JFrame("Change Grade Distribution");
		gradeRangeFrame.setSize(200,300);
		gradeRangeFrame.setDefaultCloseOperation(gradeDisFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
		gradeRangeFrame.setVisible(true); 
		gradeRangeFrame.setBounds(850,350,200,300);
		gradeRangeFrame.setResizable(false);
		
		//Creating Panel
		JPanel gradeRangePanel = new JPanel();
		gradeRangePanel.setBackground(Color.red);
		
		//Grade Letter Labels
		//JLabel letterChangeTitle = new JLabel("Change Grade Letter Ranges");
		JLabel letterALabel = new JLabel("A  >=");
		JLabel letterBLabel = new JLabel("B  >=");
		JLabel letterCLabel = new JLabel("C >=");
		JLabel letterDLabel = new JLabel("D >=");
		JLabel letterFLabel = new JLabel("F  <");
	
		//Creating enter button
		JButton rangeEnterButton = new JButton("Enter");
		
		//Adding letter labels to gradeChangerPanel
		gradeRangePanel.setLayout(new BoxLayout(gradeRangePanel, BoxLayout.Y_AXIS));
		gradeRangePanel.add(letterALabel);
		gradeRangePanel.add(Box.createVerticalGlue());
		gradeRangePanel.add(letterBLabel);
		gradeRangePanel.add(Box.createVerticalGlue());
		gradeRangePanel.add(letterCLabel);
		gradeRangePanel.add(Box.createVerticalGlue());
		gradeRangePanel.add(letterDLabel);
		gradeRangePanel.add(Box.createVerticalGlue());
		gradeRangePanel.add(letterFLabel);
		
		
		//Adding low/high text fields for each letter
		JTextField ALowTextField = new JTextField(4);
		//JTextField AHighTextField = new JTextField(4);
		JTextField BLowTextField = new JTextField(4);
		//JTextField BHighTextField = new JTextField(4);
		JTextField CLowTextField = new JTextField(4);
		//JTextField CHighTextField = new JTextField(4);
		JTextField DLowTextField = new JTextField(4);
		//JTextField DHighTextField = new JTextField(4);
		JTextField FLowTextField = new JTextField(4);
		//JTextField FHighTextField = new JTextField(4);
		
	
		//Low grade ranges panel
		JPanel lowTextPanel = new JPanel();
		lowTextPanel.setLayout(new BoxLayout(lowTextPanel, BoxLayout.Y_AXIS));
		

		//High grade ranges panel
		JPanel highTextPanel = new JPanel();
		highTextPanel.setLayout(new BoxLayout(highTextPanel, BoxLayout.Y_AXIS));
		
		//Adding low letter ranges to panel;
		lowTextPanel.add(ALowTextField);
		lowTextPanel.add(Box.createVerticalGlue());
		lowTextPanel.add(BLowTextField);
		lowTextPanel.add(Box.createVerticalGlue());
		lowTextPanel.add(CLowTextField);
		lowTextPanel.add(Box.createVerticalGlue());
		lowTextPanel.add(DLowTextField);
		lowTextPanel.add(Box.createVerticalGlue());
		lowTextPanel.add(FLowTextField);
				
		//Add components to panel
		gradeRangeFrame.add(gradeRangePanel, BorderLayout.WEST);
		gradeRangePanel.add(Box.createRigidArea(new Dimension(100,0)));
		gradeRangeFrame.add(lowTextPanel, BorderLayout.CENTER);
		gradeRangeFrame.add(highTextPanel, BorderLayout.EAST);
		gradeRangeFrame.add(rangeEnterButton, BorderLayout.SOUTH);
		
		
		//Action Listener for A
				ALowTextField.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						double a = Double.parseDouble(ALowTextField.getText());
						System.out.println("A: " + a);
						redefinedGrade_A = a;
					}
				});
		
		//Action Listener for B
				BLowTextField.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						double b = Double.parseDouble(BLowTextField.getText());
						System.out.println("B: " + b);
						redefinedGrade_B = b;
					}
				});
		
	
		//Action Listener for C
				CLowTextField.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						double c = Double.parseDouble(BLowTextField.getText());
						System.out.println("C: " + c);
						redefinedGrade_C = c;
					}
				});
	
				
//Action Listener for D
				DLowTextField.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						double d = Double.parseDouble(DLowTextField.getText());
						System.out.println("D: " + d);
						redefinedGrade_D = d;
					}
				});
		

				
//Action Listener for F
				//FLowTextField.addActionListener(new ActionListener()
				//{
					//public void actionPerformed(ActionEvent e)
					//{
						//f = Double.parseDouble(FLowTextField.getText());
						//System.out.println("F" + f);
						//redefinedGrade_F= f;
					//}
				//});			
				
						
//Action Listener for rangeEnterButton
			rangeEnterButton.addActionListener(new ActionListener() //enter button only closes window if value entered into high f text field
			{
				public void actionPerformed(ActionEvent e)
				{
					gradeRangeFrame.dispose(); //closes window	
				}
			}); 
			
			}
		}); 
		
		
		
	//	}	
//	}); //CHANGE GRADE LETTER RANGES ACTION LISTENER
}
	/*/
		
	public String gradeRecalculator (ArrayList<Student> pStudentList)
	{
		
		Collections.sort(pStudentList);
		System.out.println("Size of the studentList: " + pStudentList.size());
		
		for (Student individualStudent: pStudentList)
    	{
    		System.out.println("Student ID: " + individualStudent.getID() + ", Student Score: " + 
    	individualStudent.getScore() + ", Percentage: " + individualStudent.getScore()/doubleMaxPointsPossible
    	+ ", Percentile: " + individualStudent.getPercentile() + ", Grade: " + individualStudent.getLetterGrade());
    	}
 
    	System.out.println("Max Score: " + getMaxPosScore());
    	//setMinPosScore(70);
    	System.out.println("Min Score: " + getMinPosScore());
    	//setMaxPosScore(70);
    	//System.out.println("Max Score: " + mMaxPosScore);
    	
    	double minScore = Double.POSITIVE_INFINITY;
		for (Student individualStudent: pStudentList)
    	{
    		if (individualStudent.getScore() < minScore)
    		{
    			minScore = individualStudent.getScore();
    		}
    	}
		double addingScore;
		double modifiedScore=0;
		double redefinedPercentage;
    	for (Student individualStudent: pStudentList)
    	{
    		
    		if (minScore < getMinPosScore())
    			addingScore = 0;
    		else
    			addingScore = Math.abs(getMinPosScore() - minScore);
    		modifiedScore = (individualStudent.getScore() + addingScore);
    		System.out.println(modifiedScore);
    		individualStudent.setScore(modifiedScore);
    		
    		double redefinedPercentile = percentileScore(pStudentList, individualStudent.getScore());
    		individualStudent.setPercentile( redefinedPercentile );
    		System.out.println("redefinedPercentile: " + redefinedPercentile);
    		
    		redefinedPercentage = Math.round(modifiedScore/getMaxPosScore() * 100);
    		Character grade = redefinedLetterGrade(redefinedPercentage, redefinedGrade_A, redefinedGrade_B, redefinedGrade_C, redefinedGrade_D);
    		individualStudent.setLetterGrade(grade);
    		//System.out.println("Redefined");
    		System.out.println("Student ID: " + individualStudent.getID() + 
    				" Student Score: " + individualStudent.getScore() + 
    				" Percentage: " + individualStudent.getScore()/doubleMaxPointsPossible 
    				+ " Percentile: " + individualStudent.getPercentile() 
    				+ " Grade: " + individualStudent.getLetterGrade());
    		
    	}
    	System.out.println("Student List Size: " + pStudentList.size());
    	for (Student individualStudent: pStudentList)
    	{
    		double percentileForEach = percentileScore(pStudentList, individualStudent.getScore());
    		System.out.println("RawScore: " + individualStudent.getScore());
    		System.out.println("Percentile: " + percentileForEach);
    		//System.out.println("Student ID: " + individualStudent.getID() + ", Student Score: " + individualStudent.getRawScore() + ", Percentage: " + individualStudent.getRawScore()/getMaxPosScore() + ", Percentile: " + individualStudent.getPercentile() + ", Grade: " + individualStudent.getGrade());
    		//double redefinedPercentile = percentileScore(pStudentList, individualStudent.getRawScore());
    		//System.out.println("redefinedPercentile: " + redefinedPercentile);
    		//individualStudent.setPercentile( redefinedPercentile );
    		//System.out.println("Student ID: " + individualStudent.getID() + ", Student Score: " + individualStudent.getRawScore() + ", Modified Score: " + df2.format(modifiedScore) + ", Percentage: " + df2.format(individualStudent.getRawScore()/getMaxPosScore()) + " , Percentile: " + individualStudent.getPercentile() + ", Grade: " + individualStudent.getGrade());
    	}
    	for (Student individualStudent: pStudentList)
    	{
    		System.out.println("Student ID: " + individualStudent.getID() 
    		+ " Student Score: " + individualStudent.getScore() 
    		+ " Percentage: " + individualStudent.getScore()/doubleMaxPointsPossible  
    		+ " Percentile: " + individualStudent.getPercentile() 
    		+ " Grade: " + individualStudent.getLetterGrade());
    		
    		
    		
    		reCalcGrades += "Student ID: " + individualStudent.getID() 
    		+ " Student Score: " + individualStudent.getScore() 
    		+ " Percentage: " + individualStudent.getScore()/doubleMaxPointsPossible  
    		+ " Percentile: " + individualStudent.getPercentile() 
    		+ " Grade: " + individualStudent.getLetterGrade() + "\n";
    	}
    	
	
    	Collections.sort(pStudentList, new SortbyID());
		return reCalcGrades;
  

	}
	

	public Character redefinedLetterGrade (double pScoreEarned, double redefinedGrade_A, double redefinedGrade_B, double redefinedGrade_C, double redefinedGrade_D)
	{
		//Default A Letter Range
		if (pScoreEarned >= redefinedGrade_A )
		{
			return 'A';
		}
		//Default B Letter Range
		if (pScoreEarned < redefinedGrade_A && pScoreEarned >= redefinedGrade_B )
		{
			return 'B';
		}
		//Default C Letter Range
		if (pScoreEarned < redefinedGrade_B && pScoreEarned >= redefinedGrade_C )
		{
			return 'C';
		}
		//Default D Letter Range
		if (pScoreEarned < redefinedGrade_C && pScoreEarned >= redefinedGrade_D )
		{
			return 'D';
		}
		//Default F Letter Range
		if (pScoreEarned < redefinedGrade_D )
		{
			return 'F';
		}
		else
		{
			System.out.println("Wrong input for score is computed.");
			System.exit(-200);
			return 'I'; // I for invalid.
		}
	}


	
	
	
}  //End of ChangeGradeDistribution.java
