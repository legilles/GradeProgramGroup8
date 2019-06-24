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
						int returnFile = gradeFileFinder.showOpenDialog(screenFrame);
						gradeFileFinder.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); //user can look for file using directory
							
					}	
				});
		
		
				
				
				
				
				
				
				
				
				
			
	
			}
		});
	}

}
