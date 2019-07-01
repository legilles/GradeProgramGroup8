import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;



public class ImportGrades extends gradeAnalyticsGUI {
	
	BufferedReader reader = null;
	int lineIndex = 0;
	String lineValue;
	String textResults = "";
	
public void importGrades()
{
	
	//if (returnFile == JFileChooser.APPROVE_OPTION)
	//{

	try  {
		reader = new BufferedReader(new FileReader("C:\\Users\\Laura\\Documents\\gradeAnalyticsTester.txt"));
	
		while ((lineValue = reader.readLine()) != null)
		{
			//System.out.println(lineValue); //print results to console
			lineIndex++;
			if (lineIndex % 2 != 0) // odd line number is Student ID
			{
				studentIDList.add(lineValue); //store in Student ID Array List
			}
			if (lineIndex % 2 == 0) //even line number is Student Score
			{
				studentScoreList.add(lineValue); //store in Score Array List
				double lineScore = Double.parseDouble(lineValue);
				defaultLetterGrade(lineScore); //call defaultLetterGrade() method to get Letter Grade equivalent
			}
		}
		reader.close();
		
		System.out.println("File Uploaded"); //check console if file uploaded
		JOptionPane.showMessageDialog(screenFrame, "File Uploaded.", "File Status",JOptionPane.INFORMATION_MESSAGE); //tells user text file was uploaded
		
		printGrades();
		
	} catch (FileNotFoundException notFound)
	{
		System.out.println("File Not Found"); //check console if file not found
		JOptionPane.showMessageDialog(screenFrame, "File Not Found.", "File Status",JOptionPane.ERROR_MESSAGE); //warns user if file not found
	
	} catch (IOException ioe)
	{
		System.out.println("File Not Readable"); //check console if file didn't load
		JOptionPane.showMessageDialog(screenFrame, "File Not Readable.", "File Status",JOptionPane.ERROR_MESSAGE); //warns user if file not uploaded
	
	}
	return;
	//}
	
	
	
}


//Method to Print out all Array Lists with Student ID's/Scores/Letter Grades
public void printGrades()
	{
	
//Prints studentIDList/studentScoreList/studentLetterList in a friendly format in console
			for (int listIndex = 0; listIndex < studentIDList.size(); listIndex++)
		{
			textResults += "Student ID: " + studentIDList.get(listIndex) + " Grade Score: " + studentScoreList.get(listIndex) + " Letter Grade: " + studentLetterList.get(listIndex) + "\n" + "\n";
			
	
		}

			JTextArea area = new JTextArea();
			area.setText(textResults);
			area.setEditable(false);
			
			//Creates new window to display grade results
			JFrame resultsFrame = new JFrame("Student Grades");
			resultsFrame.setSize(300,500);
			resultsFrame.setDefaultCloseOperation(resultsFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
			resultsFrame.setVisible(true);
			resultsFrame.add(area, BorderLayout.NORTH);

}



	
//Method to assign student score with corresponding letter grade value (includes rounding values)
	public void defaultLetterGrade(double lineValue)
	{
		//Default A Letter Range
		if (lineValue <= 100.0 || lineValue >= 89.5 )
		{
			studentLetterList.add('A');
		}
		//Default B Letter Range
		if (lineValue <= 89.4 || lineValue >= 79.5 )
		{
			studentLetterList.add('B');
		}
		//Default C Letter Range
		if (lineValue <= 79.4 || lineValue >= 69.5 )
		{
			studentLetterList.add('C');
		}
		//Default D Letter Range
		if (lineValue <= 69.4 || lineValue >= 59.5 )
		{
			studentLetterList.add('D');
		}
		//Default F Letter Range
		if (lineValue <= 49.4 || lineValue >= 39.5 )
		{
			studentLetterList.add('F');
		}
		//Default E Letter Range
		if (lineValue <= 39.4 )
		{
			studentLetterList.add('E');
		}
		return;
	}



}//End of ImportGrades.java
