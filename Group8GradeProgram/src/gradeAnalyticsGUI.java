import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class gradeAnalyticsGUI 
{
	
	//ArrayList<String> studentIDList = new ArrayList<String>(); 			//array list to hold Student ID's 
	//ArrayList<Double> studentScoreList = new ArrayList<Double>(); 			//array list to hold Student Scores
	//ArrayList<Character> studentLetterList = new ArrayList<Character>();		 //array list to hold letter equivalent of scores
	//ArrayList<Double> computedScoreList = new ArrayList<Double>();				 	//array list to hold computed scores
	
	
	
	protected  int returnFile;
	protected JFrame screenFrame;
	protected JFrame makeChangesFrame;
	protected static String textResults;
	protected JPanel userPanel;
	protected JFrame statisticsFrame;
	
	double totalPointsPossible;	 //variable in ImportGrades to get total points
	double computedScore; 			// studentScore divided by totalPointsPossible value
	
	Student studentObj;
	String id;
	
	static ArrayList<Student> studentList; //array list from import file must be static to reference
	ArrayList<Student> updatedStudentList; //dynamic array list, copy of studentList
	
	protected static double total;
	
	//Method to return student list
		public ArrayList<Student> getStudentList()
		{
			return studentList;
		}
		
	//Method to get and return total possible score
		public double getTotal()
		{
			return total;
		}
		
		public void setTotal(double newTotal)
		{
			total = newTotal;
		}
	
		
		
		
		
		
		
		
		
		
	//Main Body of code
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable() { 
			public void run() {
		
		JFrame screenFrame = new JFrame("Grade Analytics Program"); //creates opening window frame
		screenFrame.setSize(900,450); //sets frame size
		screenFrame.setDefaultCloseOperation(screenFrame.EXIT_ON_CLOSE); //program will quit if user clicks "x"
		screenFrame.setVisible(true);  
		screenFrame.setLocationRelativeTo(null); //displays window in center of screen
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
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		
		//Panel to hold all user components
		JPanel userPanel = new JPanel();
		userPanel.setLayout(new BorderLayout());
		userPanel.add(programTitle, BorderLayout.NORTH);
	
		//Panel to show results
		JPanel showResultsPanel = new JPanel();
		showResultsPanel.setBackground(Color.white);
		userPanel.add(showResultsPanel,BorderLayout.CENTER);
					
		//Results label added to panel
		//showResultsPanel.add(resultsLabel,BorderLayout.CENTER);
				
		//Adds buttons to button panel and spacing
		buttonPanel.add(Box.createVerticalStrut(30));
		buttonPanel.add(inputFileButton);
		//buttonPanel.add(Box.createHorizontalStrut(10));
		buttonPanel.add(Box.createVerticalStrut(30)); //adds spacing
		buttonPanel.add(makeChangesButton);
		//buttonPanel.add(Box.createHorizontalStrut(10));
		buttonPanel.add(Box.createVerticalStrut(30));
		buttonPanel.add(changeGradeDistriButton);
		//buttonPanel.add(Box.createHorizontalStrut(10));
		buttonPanel.add(Box.createVerticalStrut(30));
		buttonPanel.add(seeStatisticsButton);
		//buttonPanel.add(Box.createHorizontalStrut(10));
		buttonPanel.add(Box.createVerticalStrut(30));
		buttonPanel.add(createReportButton);
		//buttonPanel.add(Box.createHorizontalStrut(10));
		buttonPanel.add(Box.createVerticalStrut(30));
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
						new SeeStatistics().seeStatistics(); //calls SeeStatistics class methods
					}	
				});
		
//Change Grade Distribution JButton Action Listener
				changeGradeDistriButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						new ChangeGradeDistribution().changeGradeDistribution(); //calls ChangeGradeDistribution class methods
					}	
				}); //CHANGE GRADE DISTRIBUTION ACTION LISTENER
				
							
//Make a Grade Change JButton Action Listener
				makeChangesButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("Make Grade Change Button Clicked");
							
						JFrame makeChangesFrame = new JFrame("Make a Grade Change");
						makeChangesFrame.setSize(350, 100);
						makeChangesFrame.setDefaultCloseOperation(makeChangesFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
						makeChangesFrame.setVisible(true); 
						makeChangesFrame.setResizable(false); //user can't resize window
						makeChangesFrame.setLocationRelativeTo(null);
						 
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
								new GradeChange().addGrade(studentList); //calls on GradeChange class method
							}	
						}); //ADD A GRADE BUTTON LISTENER
						
						
		//JButton Action Listener for Replace a Grade
						replaceGrade.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								new GradeChange().replaceGrade(studentList); //calls on GradeChange class method
							}	
						}); //REPLACE A GRADE BUTTON LISTENER
						
						
						
	//JButton Action Listener for Delete a Grade
						deleteGrade.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								new GradeChange().deleteGrade(studentList); //calls on GradeChange class method
						
							}	
						}); //DELETE A GRADE BUTTON LISTENER
							
					}	
					
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

} //End of gradeAnalyticsGUI.java
