import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
		JButton seeGradePercentilesButton = new JButton("Change Grade Distribution");
		JButton makeChangesButton = new JButton("Make A Grade Change");
		JButton createReportButton = new JButton("Create Grade Report");
		JButton quitButton = new JButton("Close Program");
		
		//Sets colors of buttons
		inputFileButton.setBackground(Color.yellow);
		seeStatisticsButton.setBackground(Color.green);
		seeGradePercentilesButton.setBackground(Color.red);
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
		
		//Temporary indicator of gui layout ("Results go here label")
		showResultsPanel.add(resultsGoHere,BorderLayout.CENTER);
		
		//Adds buttons to button panel
		buttonPanel.add(Box.createVerticalStrut(30));
		buttonPanel.add(inputFileButton);
		buttonPanel.add(Box.createVerticalStrut(30)); //adds spacing
		buttonPanel.add(makeChangesButton);
		buttonPanel.add(Box.createVerticalStrut(30));
		buttonPanel.add(seeGradePercentilesButton);
		buttonPanel.add(Box.createVerticalStrut(30));
		buttonPanel.add(seeStatisticsButton);
		buttonPanel.add(Box.createVerticalStrut(30));
		buttonPanel.add(createReportButton);
		buttonPanel.add(Box.createVerticalStrut(30));
		buttonPanel.add(quitButton);
		
		userPanel.add(buttonPanel,BorderLayout.WEST);
		
		//Adds components to screen frame
		screenFrame.add(userPanel);
			}
		});
	}

}
