import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class UserEnteredTotalPoints extends gradeAnalyticsGUI {
	
	
	//creates object of GUI
	gradeAnalyticsGUI GUIObj = new gradeAnalyticsGUI();
	
	
	//Method to prompt user and retrieve the totalPointsPossible value to apply to student scores
		public double getTotalPointsPossible()
		{
			//creates window
			JFrame pointsPossibleFrame = new JFrame("Total Points Possible"); //creates new window
			pointsPossibleFrame.setSize(300, 100); //sets size of frame
			pointsPossibleFrame.setDefaultCloseOperation(makeChangesFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
			pointsPossibleFrame.setVisible(true);
			pointsPossibleFrame.setResizable(false); //user can't re-size frame
			pointsPossibleFrame.setBounds(800,350,300,100); //opens window to center of screen
			
			//creates label, text field, button
			JLabel promptPointsLabel = new JLabel("Out of how many points?");
			JTextField pointsPossibleField = new JTextField(20);
			JButton pointsPossibleEnterButton = new JButton("Enter");
			
			//creates panel
			JPanel pointsPossiblePanel = new JPanel();
			pointsPossiblePanel.setBackground(Color.yellow);
			
			//panel layout
			pointsPossiblePanel.setLayout(new BoxLayout(pointsPossiblePanel, BoxLayout.X_AXIS));
			
			//adds components to panel
			pointsPossiblePanel.add(promptPointsLabel);
			pointsPossiblePanel.add(pointsPossibleField);
			pointsPossiblePanel.add(pointsPossibleEnterButton);
			
			//adds panel to frame
			pointsPossibleFrame.add(pointsPossiblePanel);
				
			//Action Listener for pointsPossibleEnterButton
					pointsPossibleEnterButton.addActionListener(new ActionListener() { //user can't move on until value is entered for points possible
						 public void actionPerformed(ActionEvent e)
						 {

							 totalPointsPossible = Double.parseDouble(pointsPossibleField.getText()); //sets totalPointsPossible equal to contents entered in text field
								
								//sets total points possible
								GUIObj.setTotal(totalPointsPossible);
								
								System.out.println("Total Points Possible: " + GUIObj.getTotal()); //prints to console total points possible value entered
								
							 
							 pointsPossibleFrame.dispose(); //closes point prompt window after "Enter" is clicked
							 
							 //importGrades(); //calls on importGrades() method after enter is clicked
						 }
					});			
			
			return totalPointsPossible;
		} //End of getTotalPointsPossible
}
