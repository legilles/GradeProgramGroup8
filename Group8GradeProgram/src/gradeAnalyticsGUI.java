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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class gradeAnalyticsGUI 
{
	
	ArrayList<String> studentIDList = new ArrayList<String>(); 			//array list to hold Student ID's 
	ArrayList<Double> studentScoreList = new ArrayList<Double>(); 			//array list to hold Student Scores
	ArrayList<Character> studentLetterList = new ArrayList<Character>();		 //array list to hold letter equivalent of scores
	ArrayList<Double> computedScoreList = new ArrayList<Double>();				 	//array list to hold computed scores
	
	
	protected  int returnFile;
	protected JFrame screenFrame;
	protected JFrame makeChangesFrame;
	protected String textResults;
	
	//Main Body of code
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable() { 
			public void run() {
		
		JFrame screenFrame = new JFrame("Grade Analytics Program"); //creates opening window frame
		screenFrame.setSize(900,100); //sets frame size
		screenFrame.setDefaultCloseOperation(screenFrame.EXIT_ON_CLOSE); //program will quit if user clicks "x"
		screenFrame.setVisible(true);  
		screenFrame.setResizable(false); //user can't resize window
	
		//Creates Labels
		JLabel programTitle = new JLabel("Grade Analytics Program");
		//JLabel resultsLabel = new JLabel("Student Grades");
		
		//Creates buttons
		JButton inputFileButton = new JButton("Import File");
		JButton seeStatisticsButton = new JButton("See Statistics");
		JButton changeGradeDistriButton = new JButton("Change Grade Distribution");
		JButton makeChangesButton = new JButton("Make A Grade Change");
		JButton createReportButton = new JButton("Create Grade Report");
		JButton quitButton = new JButton("Close Program");
		
		//Sets colors of buttons
		inputFileButton.setBackground(Color.yellow);
		seeStatisticsButton.setBackground(Color.green);
		changeGradeDistriButton.setBackground(Color.red);
		makeChangesButton.setBackground(Color.cyan);
		createReportButton.setBackground(Color.orange);
		quitButton.setBackground(Color.magenta);
	
		
		//Panel to Hold Buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		
		//Panel to hold all user components
		JPanel userPanel = new JPanel();
		userPanel.setLayout(new BorderLayout());
		userPanel.add(programTitle, BorderLayout.NORTH);
	
		//Panel to show results
		//JPanel showResultsPanel = new JPanel();
		//showResultsPanel.setBackground(Color.white);
		//userPanel.add(showResultsPanel,BorderLayout.CENTER);
				
		//Results label added to panel
		//showResultsPanel.add(resultsLabel,BorderLayout.CENTER);
				
		//Adds buttons to button panel and spacing
		//buttonPanel.add(Box.createVerticalStrut(30));
		buttonPanel.add(inputFileButton);
		buttonPanel.add(Box.createHorizontalStrut(10));
		//buttonPanel.add(Box.createVerticalStrut(30)); //adds spacing
		buttonPanel.add(makeChangesButton);
		buttonPanel.add(Box.createHorizontalStrut(10));
		//buttonPanel.add(Box.createVerticalStrut(30));
		buttonPanel.add(changeGradeDistriButton);
		buttonPanel.add(Box.createHorizontalStrut(10));
		//buttonPanel.add(Box.createVerticalStrut(30));
		buttonPanel.add(seeStatisticsButton);
		buttonPanel.add(Box.createHorizontalStrut(10));
		//buttonPanel.add(Box.createVerticalStrut(30));
		buttonPanel.add(createReportButton);
		buttonPanel.add(Box.createHorizontalStrut(10));
		//buttonPanel.add(Box.createVerticalStrut(30));
		buttonPanel.add(quitButton);
		
		//Add button panel to user panel
		userPanel.add(buttonPanel,BorderLayout.WEST);
			
//JButton Action Listeners (organized upside down from menu)
		
//Close Program JButton Action Listener
		quitButton.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Close Program Button Clicked"); //to see if listener worked
				screenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				int confirmation = JOptionPane.showConfirmDialog(screenFrame, "Are you sure you want to quit?", "Close Program",JOptionPane.YES_NO_OPTION); //warning message prompts yes/no to close program
	
				if (confirmation == JOptionPane.YES_OPTION) //user clicks yes
				{
					System.out.println("Program Closed"); //prints to console that program closed
					System.exit(0); //closes program
				}	
			}	
			});
		
		//Adds components to screen frame
		screenFrame.add(userPanel);	
		
		
		//Create Report JButton Action Listener
		createReportButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new CreateReport().createReport(); //calls on CreateReport call methods
			}	
		});
		
		//See Statistics JButton Action Listener
				seeStatisticsButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("See Satistics Button Clicked");
						
						JFrame statisticsFrame = new JFrame("See Statistics");
						statisticsFrame.setSize(400, 200);
						statisticsFrame.setDefaultCloseOperation(statisticsFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
						statisticsFrame.setVisible(true); 
						
						JPanel statisticsPanel = new JPanel();
						statisticsPanel.setBackground(Color.green);
						
						
						//Labels for high,low,average,median score
						JLabel highScoreLabel = new JLabel("Hightest Score: ");
						JLabel lowScoreLabel = new JLabel("Lowest Score: ");
						JLabel avgScoreLabel = new JLabel("Average Score: ");
						JLabel medScoreLabel = new JLabel("Median Score: ");
						
						//Label for number of letter grades
						JLabel gradeDistributionLabel = new JLabel("Grade Distribution:");
						JLabel numberOfLettersLabel = new JLabel("Number of  A's[] B's[] C's[] D's[] F's[] E's[]");
						
						
						//Labels for grade percentiles
						JLabel gradePercLabel = new JLabel("Grade Percentiles:");
						
						//Adding Labels to panel
						statisticsPanel.add(highScoreLabel);
						//statisticsPanel.add(Box.createVerticalStrut(10));
						statisticsPanel.add(lowScoreLabel);
						//statisticsPanel.add(Box.createVerticalStrut(10));
						statisticsPanel.add(avgScoreLabel);
						//statisticsPanel.add(Box.createVerticalStrut(10));
						statisticsPanel.add(medScoreLabel);
						statisticsPanel.add(Box.createVerticalStrut(10));
						statisticsPanel.add(gradeDistributionLabel);
						statisticsPanel.add(numberOfLettersLabel);
						statisticsPanel.add(Box.createVerticalStrut(20));
						statisticsPanel.add(gradePercLabel);
						
						
						
						statisticsPanel.setLayout(new BoxLayout(statisticsPanel, BoxLayout.Y_AXIS));
						statisticsFrame.add(statisticsPanel);	
					}	
				});
		
		//Change Grade Distribution JButton Action Listener
				changeGradeDistriButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("Change Grade Distribution Button Clicked");
						
						
						//Creating frame
						JFrame gradeDisFrame = new JFrame("Change Grade Distribution");
						gradeDisFrame.setSize(450,90);
						gradeDisFrame.setDefaultCloseOperation(gradeDisFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
						gradeDisFrame.setVisible(true); 
						
						//Creating Panel
						JPanel gradeDisPanel = new JPanel();
						gradeDisPanel.setBackground(Color.red);
						
						//Creating buttons
						JButton changeGradeRangeButton = new JButton("Change Letter Grade Ranges");
						JButton changeTotalPointsButton = new JButton("Change Total Points Possible");
						
						gradeDisPanel.setLayout(new BoxLayout(gradeDisPanel, BoxLayout.X_AXIS));
						
						//Adding buttons to panel
						gradeDisPanel.add(changeGradeRangeButton);
						gradeDisPanel.add(Box.createHorizontalStrut(5));
						gradeDisPanel.add(changeTotalPointsButton);
						
						gradeDisFrame.add(gradeDisPanel);
						
						//Change Total Points Possible JButton Action Listener
						changeTotalPointsButton.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								//Creating frame
								JFrame changePointFrame = new JFrame("Change Total Points");
								changePointFrame.setSize(200,90);
								changePointFrame.setDefaultCloseOperation(changePointFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
								changePointFrame.setVisible(true); 
								
								//Creating Panel
								JPanel changePointPanel = new JPanel();
								changePointPanel.setBackground(Color.red);
								
								//Creating label and text field
								JLabel setTotalLabel = new JLabel("Out of how many points?");
								JTextField newTotalField = new JTextField(10);
							
								//Adding to panel
								changePointPanel.add(newTotalField);
								
								
								changePointFrame.add(setTotalLabel, BorderLayout.NORTH);
								changePointFrame.add(changePointPanel);
							}	
						}); //CHANGE TOTAL POINTS POSSIBLE ACTION LISTENER
						
						
						
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
				}); //CHANGE GRADE DISTRIBUTION ACTION LISTENER
				
							
		//Make a Grade Change JButton Action Listener
				makeChangesButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("Make Grade Change Button Clicked");
						
						//Drop Down Menu for Make a Grade Change
						//JComboBox<String> changeList = new JComboBox<String>();
						//changeList.addItem("Make a Grade Change");
						//changeList.addItem("Add Grade");
						//changeList.addItem("Replace Grade");
						//changeList.addItem("Delete Grade");
						//makeChangesButton.add(changeList);
						
						
						JFrame makeChangesFrame = new JFrame("Make a Grade Change");
						makeChangesFrame.setSize(350, 100);
						makeChangesFrame.setDefaultCloseOperation(makeChangesFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
						makeChangesFrame.setVisible(true); 
						makeChangesFrame.setResizable(false); //user can't resize window
						 
					//Created add,replace,delete buttons
						JButton addGrade = new JButton("Add Grade");
						JButton replaceGrade = new JButton("Replace Grade");
						JButton deleteGrade = new JButton("Delete Grade");
						
						
					//Added buttons to panel
						JPanel makeChangesPanel = new JPanel();
						makeChangesPanel.setBackground(Color.cyan);
						makeChangesPanel.add(addGrade);
						makeChangesPanel.add(Box.createHorizontalStrut(10));
						makeChangesPanel.add(replaceGrade);
						makeChangesPanel.add(Box.createHorizontalStrut(10));
						makeChangesPanel.add(deleteGrade);
						
						makeChangesPanel.setLayout(new BoxLayout(makeChangesPanel, BoxLayout.X_AXIS));
						makeChangesFrame.add(makeChangesPanel);
						
						
						
		//JButton Action Listener for Add a Grade
						addGrade.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								new GradeChange().addGrade(); //calls on GradeChange class method
							}	
						}); //ADD A GRADE BUTTON LISTENER
						
						
				//JButton Action Listener for Replace a Grade
						replaceGrade.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
						
								new GradeChange().replaceGrade(); //calls on GradeChange class method
							}	
						}); //REPLACE A GRADE BUTTON LISTENER
						
						
						
	//JButton Action Listener for Delete a Grade
						deleteGrade.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								new GradeChange().deleteGrade(); //calls on GradeChange class method
						
							}	
						}); //DELETE A GRADE BUTTON LISTENER
							
					}	
					//printGrades(); //re- print grades after making changes
					
				}); //CHANGE A GRADE BUTTON LISTENER
		
			
	//Import File JButton Action Listener
				inputFileButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("Import File Button Clicked");
						
						new ImportGrades().getTotalPointsPossible(); //calls on ImportGrades() class methods 
					}	
				});
		
		
			}
		});
	}

} //End of gradeAnalyticsGUI
