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
	
	String newPointsPossible; 
	double doublenewPointsPossible;
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
						
						//calculateNewStudentGrades(); //calls method to re-calculate scores
						//printNewGrades(); //prints out new grade results
						
							}	
						}); 
					}	
				}); 
				
			}	
		}); //CHANGE TOTAL POINTS POSSIBLE ACTION LISTENER
		
	
	
	

//Change Grade Letter Ranges JButton Action Listener
		changeGradeRangeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
		JFrame gradeRangeFrame = new JFrame("Change Grade Distribution");
		gradeRangeFrame.setSize(200,300);
		gradeRangeFrame.setDefaultCloseOperation(gradeDisFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
		gradeRangeFrame.setVisible(true); 
		gradeRangeFrame.setLocationRelativeTo(null);
		gradeRangeFrame.setResizable(false);
		
		//Creating Panel
		JPanel gradeRangePanel = new JPanel();
		gradeRangePanel.setBackground(Color.red);
		
		//Grade Letter Labels
		//JLabel letterChangeTitle = new JLabel("Change Grade Letter Ranges");
		JLabel letterALabel = new JLabel("A");
		JLabel letterBLabel = new JLabel("B");
		JLabel letterCLabel = new JLabel("C");
		JLabel letterDLabel = new JLabel("D");
		JLabel letterFLabel = new JLabel("F");
	
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
		JTextField AHighTextField = new JTextField(4);
		JTextField BLowTextField = new JTextField(4);
		JTextField BHighTextField = new JTextField(4);
		JTextField CLowTextField = new JTextField(4);
		JTextField CHighTextField = new JTextField(4);
		JTextField DLowTextField = new JTextField(4);
		JTextField DHighTextField = new JTextField(4);
		JTextField FLowTextField = new JTextField(4);
		JTextField FHighTextField = new JTextField(4);
		
	
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
		highTextPanel.add(AHighTextField);
		highTextPanel.add(BHighTextField);
		highTextPanel.add(CHighTextField);
		highTextPanel.add(DHighTextField);
		highTextPanel.add(FHighTextField);
		
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
				AHighTextField.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						aHigh = AHighTextField.getText();
						System.out.println("High A: " + aHigh);
					}
				});
		
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
				BHighTextField.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						bHigh = BHighTextField.getText();
						System.out.println("B High: " +  bHigh);
					}
				});
		

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
				CHighTextField.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						cHigh = CHighTextField.getText();
						System.out.println("C High: " +  cHigh);
					}
				});
				
				
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
				DHighTextField.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						dHigh = DHighTextField.getText();
						System.out.println("D High: " +  dHigh);
					}
				});
				
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
		FHighTextField.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				fHigh = FHighTextField.getText();
				System.out.println("F High: " + fHigh);
				
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
		
		
		
		}	
	}); //CHANGE GRADE LETTER RANGES ACTION LISTENER
}
	
	
	
	
	
} //End of ChangeGradeDistribution.java
