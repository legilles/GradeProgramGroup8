import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
	
	String newMaxPointsPossible; 
	String newMinPointsPossible;
	double doubleMaxPointsPossible;
	double doubleMinPointsPossible;
	double newRoundedComputedScore;
	double newComputedScore;
	
	//Variables for new grade ranges
	String aLow;
	String aHigh;
	String bLow;
	String bHigh;
	String cLow;
	String cHigh;
	String dLow;
	String dHigh;
	String fLow;
	String fHigh;
	
	
	ArrayList<Double> newComputedScoreList = new ArrayList<Double>();	//array list to store new grades with changed point scale
	
	public void changeGradeDistribution()
	{
		System.out.println("Change Grade Distribution Button Clicked");
		
		
		//Creating frame
		JFrame gradeDisFrame = new JFrame("Change Grade Distribution");
		gradeDisFrame.setSize(700,90);
		gradeDisFrame.setDefaultCloseOperation(gradeDisFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
		gradeDisFrame.setVisible(true); 
		gradeDisFrame.setResizable(false);
		gradeDisFrame.setBounds(750,350,700,90);
		
		//Creating Panel
		JPanel gradeDisPanel = new JPanel();
		gradeDisPanel.setBackground(Color.red);
		
		//Creating buttons
		JButton changeGradeRangeButton = new JButton("Change Letter Grade Ranges");
		JButton changeMaxPointsButton = new JButton("Change Maximum Points Possible");
		JButton changeMinPointsButton = new JButton("Change Minimum Points Possible");
		
		gradeDisPanel.setLayout(new BoxLayout(gradeDisPanel, BoxLayout.X_AXIS));
		
		//Adding buttons to panel and spacing
		gradeDisPanel.add(Box.createHorizontalStrut(10));
		gradeDisPanel.add(changeGradeRangeButton);
		gradeDisPanel.add(Box.createHorizontalStrut(10));
		gradeDisPanel.add(changeMaxPointsButton);
		gradeDisPanel.add(Box.createHorizontalStrut(10));
		gradeDisPanel.add(changeMinPointsButton);
		
		gradeDisFrame.add(gradeDisPanel);
		
//Change Min Points Possible JButton Action Listener
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
		
		//Adding high letter ranges to panel
		//highTextPanel.add(AHighTextField);
		//highTextPanel.add(BHighTextField);
		//highTextPanel.add(CHighTextField);
		//highTextPanel.add(DHighTextField);
		//highTextPanel.add(FHighTextField);
		
		//Add components to panel
		gradeRangeFrame.add(gradeRangePanel, BorderLayout.WEST);
		gradeRangePanel.add(Box.createRigidArea(new Dimension(100,0)));
		gradeRangeFrame.add(lowTextPanel, BorderLayout.CENTER);
		gradeRangeFrame.add(highTextPanel, BorderLayout.EAST);
		gradeRangeFrame.add(rangeEnterButton, BorderLayout.SOUTH);
		
		
		//Action Listener for ALowTextField
				ALowTextField.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						aLow = ALowTextField.getText();
						System.out.println("Low A: " + aLow);
					}
				});
		
		//Action Listener for AHighTextField
				/*
				AHighTextField.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						aHigh = AHighTextField.getText();
						System.out.println("High A: " + aHigh);
					}
				});
				/*/
		
		//Action Listener for BLowTextField
				BLowTextField.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						bLow = BLowTextField.getText();
						System.out.println("B Low: " + bLow);
					}
				});
		
		//Action Listener for BHighTextField
				/*
				BHighTextField.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						bHigh = BHighTextField.getText();
						System.out.println("B High: " +  bHigh);
					}
				});
				/*/
		

		//Action Listener for CLowTextField
				CLowTextField.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						cLow = CLowTextField.getText();
						System.out.println("C Low: " + cLow);
					}
				});
		
		//Action Listener for BHighTextField
				/*
				CHighTextField.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						cHigh = CHighTextField.getText();
						System.out.println("C High: " +  cHigh);
					}
				});
				/*/
				
				
//Action Listener for DLowTextField
				DLowTextField.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						dLow = DLowTextField.getText();
						System.out.println("D Low: " + dLow);
					}
				});
		
//Action Listener for DHighTextField
				/*
				DHighTextField.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						dHigh = DHighTextField.getText();
						System.out.println("D High: " +  dHigh);
					}
				});
				/*/
				
//Action Listener for FLowTextField
				FLowTextField.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						fLow = FLowTextField.getText();
						System.out.println("F Low: " + fLow);
					}
				});			
				
		
//Action Listener for FHighTextField
				/*
		FHighTextField.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				fHigh = FHighTextField.getText();
				System.out.println("F High: " + fHigh);
				/*/
				
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
	
	
	
	
	
}  //End of ChangeGradeDistribution.java
