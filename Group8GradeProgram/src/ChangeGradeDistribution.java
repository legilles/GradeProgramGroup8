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

public class ChangeGradeDistribution extends SeeStatistics 
{
	
	String newMaxPointsPossible; 
	String newMinPointsPossible;
	String reCalcGrades = "";
	//double doubleMaxPointsPossible = 0.0;
	//double doubleMinPointsPossible = 0.0;
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
	
	double pScoreEarned = 0.0;
	//double redefinedPercentage = 0.0;
	
	ArrayList<Double> newComputedScoreList = new ArrayList<Double>();	//array list to store new grades with changed point scale
	

	public void changeGradeDistribution()
	{

	
		System.out.println("Change Grade Distribution Button Clicked");
		
		
		//Creating frame
		JFrame gradeDisFrame = new JFrame("Change Grade Distribution");
		gradeDisFrame.setDefaultCloseOperation(gradeDisFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
		gradeDisFrame.setVisible(true); 
		//gradeDisFrame.setResizable(false);
		gradeDisFrame.setBounds(800,300,600,90);
		
		//Creating Panel
		JPanel gradeDisPanel = new JPanel();
		gradeDisPanel.setBackground(Color.red);
		
		
		//Creating buttons
		JButton closeButton = new JButton("Close");
		JButton changeLetters = new JButton("Change Letter Grade Ranges");
		JButton changeMinMaxPointsButton = new JButton("Change Lowest/Highest Points Possible");
		
		gradeDisPanel.setLayout(new BoxLayout(gradeDisPanel, BoxLayout.X_AXIS));
		
		//Adding buttons to panel and spacing
		gradeDisPanel.add(Box.createHorizontalStrut(10));
		gradeDisPanel.add(changeLetters);
		
		
		gradeDisPanel.add(Box.createHorizontalStrut(10));
		gradeDisPanel.add(changeMinMaxPointsButton);
		gradeDisPanel.add(Box.createHorizontalStrut(10));
		gradeDisPanel.add(closeButton);
		
		
		gradeDisFrame.add(gradeDisPanel);
		
		
		closeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				gradeDisFrame.dispose();
			}	
		}); 
		
	
	

		
		
	changeMinMaxPointsButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//Creating frame
				JFrame changeMinMaxFrame = new JFrame("Change Total Min/Max Points");
				changeMinMaxFrame.setDefaultCloseOperation(changeMinMaxFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
				changeMinMaxFrame.setVisible(true); 
				changeMinMaxFrame.setResizable(false);
				changeMinMaxFrame.setBounds(850,350,500,100);
				
				//Creating Panel
				JPanel changeMinMaxPanel = new JPanel();
				changeMinMaxPanel.setBackground(Color.red);
				
				//Creating label,text field, button
				JLabel setMinMaxTotalLabel = new JLabel("Out of How Many Minimum/Maximum Total Points?");
				JTextField newMinTotalField = new JTextField(10);
				JTextField newMaxTotalField = new JTextField(10);
				JButton newMinMaxPointsEnterButton = new JButton("Enter");

				//Adding components to panel
				changeMinMaxPanel.add(setMinMaxTotalLabel);
				changeMinMaxPanel.add(newMinTotalField);
				changeMinMaxPanel.add(newMaxTotalField);
				changeMinMaxPanel.add(newMinMaxPointsEnterButton);
				
				//Panel layout
				changeMinMaxPanel.setLayout(new BoxLayout(changeMinMaxPanel, BoxLayout.X_AXIS));
				
				//Add panel to frame
				changeMinMaxFrame.add(changeMinMaxPanel);
				

				
//Min/Max Enter button clicked
				newMinMaxPointsEnterButton.addActionListener(new ActionListener() //window only closes if user entered new point value into text field
				{
					public void actionPerformed(ActionEvent e)
					{
								newMinPointsPossible = newMinTotalField.getText(); 
								double doubleMinPointsPossible = Double.parseDouble(newMinPointsPossible); //converts string to double
								System.out.println("New Lowest Point Range: " + newMinPointsPossible);
								setMinPosScore(doubleMinPointsPossible);
								
								
								newMaxPointsPossible = newMaxTotalField.getText(); 
								double doubleMaxPointsPossible = Double.parseDouble(newMaxPointsPossible); //converts string to double
								System.out.println("New Highest Point Range: " + newMaxPointsPossible);
								setMaxPosScore(doubleMaxPointsPossible);
								
						gradeRecalculator (updatedStudentList); //calls
						changeMinMaxFrame.dispose(); //closes window
	
						JTextArea area = new JTextArea();
						area.setText("Grade Distribution: "+ "/n" +  gradeRecalculator(studentList));
						area.setBackground(Color.red);
						area.setEditable(false);
						
						
						JButton close = new JButton("Close");
						
						JFrame tempA = new JFrame();
						tempA.add(area, BorderLayout.CENTER);
						tempA.setDefaultCloseOperation(screenFrame.DISPOSE_ON_CLOSE); //program will quit if user clicks "x"
						tempA.setVisible(true);
						tempA.setBounds(850,350,800,400); //displays window in center of screen
						tempA.add(close, BorderLayout.SOUTH);
						
						close.addActionListener(new ActionListener() 
								{
									public void actionPerformed(ActionEvent e)
									{	
										tempA.dispose();
									}
								});
						
						
					}
				}); //End of change Min/Max Enter Button
				
			}
		});
	
		
	
	
	
	
	
	
	
	
	
	
			
//Change Grade Letter Ranges JButton Action Listener
	changeLetters.addActionListener(new ActionListener()
	{
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e)
			{
				
		JFrame gradeRangeFrame = new JFrame("Change Grade Distribution");
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
		//JLabel letterFLabel = new JLabel("F  <");
	
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
		//gradeRangePanel.add(letterFLabel);
		
		
		//Adding low/high text fields for each letter
		JTextField ALowTextField = new JTextField(4);
		//JTextField AHighTextField = new JTextField(4);
		JTextField BLowTextField = new JTextField(4);
		//JTextField BHighTextField = new JTextField(4);
		JTextField CLowTextField = new JTextField(4);
		//JTextField CHighTextField = new JTextField(4);
		JTextField DLowTextField = new JTextField(4);
		//JTextField DHighTextField = new JTextField(4);
		//JTextField FLowTextField = new JTextField(4);
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
		//lowTextPanel.add(FLowTextField);
				
		//Add components to panel
		gradeRangeFrame.add(gradeRangePanel, BorderLayout.WEST);
		gradeRangePanel.add(Box.createRigidArea(new Dimension(100,0)));
		gradeRangeFrame.add(lowTextPanel, BorderLayout.CENTER);
		gradeRangeFrame.add(highTextPanel, BorderLayout.EAST);
		gradeRangeFrame.add(rangeEnterButton, BorderLayout.SOUTH);
		
				
//Action Listener for rangeEnterButton
			rangeEnterButton.addActionListener(new ActionListener() //enter button only closes window if value entered into high f text field
			{
				public void actionPerformed(ActionEvent e)
				{
					

					double a = Double.parseDouble(ALowTextField.getText());
					System.out.println("A: " + a);
					redefinedGrade_A = a;	
					
					
					double b = Double.parseDouble(BLowTextField.getText());
					System.out.println("B: " + b);
					redefinedGrade_B = b;
					
					double c = Double.parseDouble(BLowTextField.getText());
					System.out.println("C: " + c);
					redefinedGrade_C = c;
					
					
					double d = Double.parseDouble(DLowTextField.getText());
					System.out.println("D: " + d);
					redefinedGrade_D = d;
					
					gradeRecalculator(updatedStudentList);
					gradeRangeFrame.dispose(); //closes window	
					
					
					JTextArea areaL = new JTextArea();
					areaL.setText("Grade Distribution By New Letter Ranges: " + "/n" + gradeRecalculator(updatedStudentList));
					areaL.setBackground(Color.red);
					areaL.setEditable(false);
					
					
					JButton close = new JButton("Close");
					
					JFrame tempL = new JFrame();
					tempL.add(areaL, BorderLayout.CENTER);
					tempL.setDefaultCloseOperation(screenFrame.DISPOSE_ON_CLOSE); //program will quit if user clicks "x"
					tempL.setVisible(true);  
					tempL.setBounds(850,350,500,400); //displays window in center of screen
					tempL.add(close, BorderLayout.SOUTH);
					
					close.addActionListener(new ActionListener() 
							{
								public void actionPerformed(ActionEvent e)
								{	
									tempL.dispose();
								}
							});
					
					
					
					
					
			
				}
			});
			
			}
			
			});
	
	}
		
					
		
///////////////////////////////////////////////////////////////////////////////////////////
	public String gradeRecalculator (ArrayList<Student> pStudentList)
	{
		Collections.sort(pStudentList);
		System.out.println("Size of the studentList: " + pStudentList.size());
		/*
		for (Student individualStudent: pStudentList)
    	{
    		System.out.println("Student ID: " + individualStudent.getID() + ", Student Score: " + 
    	individualStudent.getScore() + ", Percentage: " + individualStudent.getScore()/getMaxPosScore()
    	+ ", Percentile: " + individualStudent.getPercentile() + ", Grade: " + individualStudent.getLetterGrade());
    	}
 */
    	//System.out.println("Max Score: " + getMaxPosScore());
    	//setMinPosScore(70);
    	//	System.out.println("Min Score: " + getMinPosScore());
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
		
    	for (Student individualStudent: pStudentList)
    	{
    		
    		if (minScore > getMinPosScore())
    			addingScore = 0;
    		else
    			addingScore = Math.abs(getMinPosScore() - minScore);
    		
    		modifiedScore = (individualStudent.getScore() + addingScore);
    		System.out.println(modifiedScore);
    		individualStudent.setScore(modifiedScore);
    		
    		double redefinedPercentile = percentileScore(pStudentList, individualStudent.getScore());
    		individualStudent.setPercentile( redefinedPercentile );
    		System.out.println("redefinedPercentile: " + redefinedPercentile);
    		
    		double redefinedPercentage = Math.round((modifiedScore/getMaxPosScore()) * 100);
    		Character grade = redefinedLetterGrade(redefinedPercentage, redefinedGrade_A, redefinedGrade_B, redefinedGrade_C, redefinedGrade_D);
    		individualStudent.setLetterGrade(grade);
    		System.out.println("Max Possible Score================" + getMaxPosScore());
    		System.out.println("Student ID: " + individualStudent.getID() + 
    				" Student Score: " + individualStudent.getScore() + 
    				" Percentage: " + individualStudent.getScore()/getMaxPosScore() 
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
    		/*
    		System.out.println("Student ID: " + individualStudent.getID() 
    		+ " Student Score: " + individualStudent.getScore() 
    		+ " Percentage: " + individualStudent.getScore()/getMaxPosScore() 
    		+ " Percentile: " + individualStudent.getPercentile() 
    		+ " Grade: " + individualStudent.getLetterGrade());
    		*/
    		
    		
    		reCalcGrades += "Student ID: " + individualStudent.getID() 
    		+ "    Student Score: " + individualStudent.getScore() 
    		+ "    Percentage: " + individualStudent.getScore()/getMaxPosScore() 
    		+ "    Percentile: " + individualStudent.getPercentile() 
    		+ "    Grade: " + individualStudent.getLetterGrade() + "\n";
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

	
		
}  //End of java file
	
