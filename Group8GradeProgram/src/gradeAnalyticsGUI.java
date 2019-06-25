import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class gradeAnalyticsGUI 
{
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
		
		JFrame screenFrame = new JFrame("Grade Analytics Program");
		screenFrame.setSize(900,500); //sets frame size
		screenFrame.setDefaultCloseOperation(screenFrame.EXIT_ON_CLOSE); //program will quit if user clicks "x"
		screenFrame.setVisible(true); 
	
		//Creates Labels
		JLabel programTitle = new JLabel("Grade Analytics Program");
		JLabel resultsGoHere = new JLabel("(Results Go Here)");

		
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
		
		//Temporary indicator of GUI layout ("Results go here label")
		showResultsPanel.add(resultsGoHere,BorderLayout.CENTER);
		
		//Adds buttons to button panel
		buttonPanel.add(Box.createVerticalStrut(30));
		buttonPanel.add(inputFileButton);
		buttonPanel.add(Box.createVerticalStrut(30)); //adds spacing
		buttonPanel.add(makeChangesButton);
		buttonPanel.add(Box.createVerticalStrut(30));
		buttonPanel.add(changeGradeDistriButton);
		buttonPanel.add(Box.createVerticalStrut(30));
		buttonPanel.add(seeStatisticsButton);
		buttonPanel.add(Box.createVerticalStrut(30));
		buttonPanel.add(createReportButton);
		buttonPanel.add(Box.createVerticalStrut(30));
		buttonPanel.add(quitButton);
		
		userPanel.add(buttonPanel,BorderLayout.WEST);
		
		
		
		
		
		//JButton Action Listeners (organized upside down from menu)
		
		//Close Program JButton Action Listener
		quitButton.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Close Program Button Clicked"); //to see if listener worked

				JOptionPane.showMessageDialog(screenFrame, "Are you sure you want to quit?", "Close Program",JOptionPane.WARNING_MESSAGE);
			}	
			});
		
		//Adds components to screen frame
		screenFrame.add(userPanel);	
		
		
		//Create Report JButton Action Listener
		createReportButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Create Grade Report Button Clicked");
				
				JFrame createReportFrame = new JFrame("Create Grade Report");
				createReportFrame.setSize(400,100); //sets frame size
				createReportFrame.setDefaultCloseOperation(createReportFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
				createReportFrame.setVisible(true); 
				
				JPanel createReportPanel = new JPanel();
				createReportPanel.setBackground(Color.orange);
				
				JTextField reportNameTextField = new JTextField(20);
				
				JLabel nameReportPrompt = new JLabel("Please Enter a Name for the Grade Report.");
				
				createReportPanel.add(nameReportPrompt,BorderLayout.NORTH);
				createReportPanel.add(reportNameTextField,BorderLayout.SOUTH);
				
				createReportPanel.add(reportNameTextField); //adds report name text field to report panel
				createReportFrame.add(createReportPanel); //adds panel to report window
			}	
		});
		
		//See Statistics JButton Action Listener
				seeStatisticsButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("See Satistics Button Clicked");
					}	
				});
		
		//Change Grade Distribution JButton Action Listener
				changeGradeDistriButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("Change Grade Distribution Button Clicked");
						
						JFrame gradeChangerFrame = new JFrame("Change Letter Grade Range");
						gradeChangerFrame.setSize(400, 200);
						gradeChangerFrame.setDefaultCloseOperation(gradeChangerFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
						gradeChangerFrame.setVisible(true); 
						
						JPanel gradeChangerPanel = new JPanel();
						gradeChangerPanel.setBackground(Color.red);
						
						//Grade Letter Labels
						JLabel letterChangeTitle = new JLabel("Change Grade Letter Ranges");
						JLabel letterALabel = new JLabel("A:");
						JLabel letterBLabel = new JLabel("B:");
						JLabel letterCLabel = new JLabel("C:");
						JLabel letterDLabel = new JLabel("D:");
						JLabel letterFLabel = new JLabel("F:");
						JLabel letterELabel = new JLabel("E:");
						
						//Adding letter labels to gradeChangerPanel
						gradeChangerPanel.setLayout(new BoxLayout(gradeChangerPanel, BoxLayout.Y_AXIS));
						gradeChangerPanel.add(letterChangeTitle);
						gradeChangerPanel.add(letterALabel);
						gradeChangerPanel.add(letterBLabel);
						gradeChangerPanel.add(letterCLabel);
						gradeChangerPanel.add(letterDLabel);
						gradeChangerPanel.add(letterFLabel);
						gradeChangerPanel.add(letterELabel);
						
						
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
						
						
						gradeChangerFrame.add(gradeChangerPanel, BorderLayout.WEST);
						gradeChangerFrame.add(letterTextFields, BorderLayout.EAST);
					}	
				});
		
		//Make a Grade Change JButton Action Listener
				makeChangesButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("Make Grade Change Button Clicked");
						
					}	
				});
		
		
		//Import File JButton Action Listener
				inputFileButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("Import File Button Clicked");
						
						JFileChooser gradeFileFinder = new JFileChooser();
						int returnFile = gradeFileFinder.showOpenDialog(screenFrame); //dialog opens on screen frame
						gradeFileFinder.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); //user can look for file using directory
							
					}	
				});
		
		
				
				
				
				
				
				
				
				
				
			
	
			}
		});
	}

}
