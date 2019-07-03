import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class CreateReport extends gradeAnalyticsGUI {
	
	 String reportFileName = ""; //user entered string for file name
	 protected JFrame createReportFrame;
	
	public void createReport()
	{
	
	System.out.println("Create Grade Report Button Clicked"); //prints to console
	
	//Creates frame for create report
	JFrame createReportFrame = new JFrame("Create Grade Report");
	createReportFrame.setSize(400,100); //sets frame size
	createReportFrame.setDefaultCloseOperation(createReportFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
	createReportFrame.setVisible(true); 
	
	//Creates panel
	JPanel createReportPanel = new JPanel();
	createReportPanel.setBackground(Color.orange);
	
	//Creates text field
	JTextField reportNameTextField = new JTextField(20);
	
	//Creates label
	JLabel nameReportPrompt = new JLabel("Please Enter a Name for the Grade Report.");
	JLabel nameLabel = new JLabel("Grade Report Name:");
	
	//Creates "Enter" button
	JButton createReportEnter = new JButton("Enter");
	
	//Add text field and button to panel
	createReportPanel.add(nameLabel);
	createReportPanel.add(reportNameTextField);
	createReportPanel.add(createReportEnter);
			
	
	createReportPanel.setLayout(new BoxLayout(createReportPanel, BoxLayout.X_AXIS));
			
			
	//Add prompt and panel to frame
	createReportFrame.add(nameReportPrompt,BorderLayout.NORTH);
	createReportFrame.add(createReportPanel,BorderLayout.SOUTH);
			
//Action listener for reportNameTextField
	reportNameTextField.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e)
		 {
		reportFileName = reportNameTextField.getText();
		System.out.println("Create Report File Name: " + reportFileName); //prints input by user in reportNameTextField text field
		 }
	});
	
//Action listener for createReportEnter button
	createReportEnter.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e)
		 {
			 writeToTextFile(reportFileName); //calls on method to create text file
			 //createReportFrame.dispose(); //closes createReportFrame after enter clicked
		 }
	});
	}
	
//Method to Write Grades to a Text File
	public void writeToTextFile(String reportFileName)
	{
		try {
	FileWriter writer = new FileWriter(reportFileName); //creates a text file called the name the user entered
	
	//for (int listIndex = 0; listIndex < studentIDList.size(); listIndex++)
	//{
		//textResults += "Student ID: " + studentIDList.get(listIndex) + " Grade Score: " + studentScoreList.get(listIndex) + " Letter Grade: " + studentLetterList.get(listIndex) + "\n" + "\n";
	//}
	
	//writer.write(textResults); //data in array lists written to text file
	writer.close(); //closes text file
	
	JOptionPane.showMessageDialog(createReportFrame, "Grade Report Created.", "Create Grade Report Status",JOptionPane.INFORMATION_MESSAGE); //notifies user that text file was created
	
		} catch (IOException e)
		{
			System.out.println("Text File Not Created"); //prints to console that text file was not created
			JOptionPane.showMessageDialog(createReportFrame, "Grade Report Not Created.", "Create Grade Report Status",JOptionPane.ERROR_MESSAGE); //notifies user that text file wasn't created
		}
		
		System.out.println("Text File Created: " + reportFileName + ".txt"); //prints to console that text file was created
	}
	


} //End of CreateReport.java
