import java.awt.Color;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SeeStatistics extends gradeAnalyticsGUI {
	
	public void seeStatistics()
	{

	System.out.println("See Satistics Button Clicked");
	
	JFrame statisticsFrame = new JFrame("See Statistics");
	statisticsFrame.setSize(400, 200);
	statisticsFrame.setDefaultCloseOperation(statisticsFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
	statisticsFrame.setVisible(true); 
	statisticsFrame.setLocationRelativeTo(null);
	
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
	
	} //End of seeStatistics()
	
	
	
	
} //End of SeeStatistics.java
