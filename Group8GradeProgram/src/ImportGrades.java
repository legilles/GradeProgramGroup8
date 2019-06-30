import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



public class ImportGrades extends gradeAnalyticsGUI {
	

	
public static void importGrades()
{
	if (returnFile == JFileChooser.APPROVE_OPTION)
	{
	
			JOptionPane.showMessageDialog(screenFrame, "File Uploaded.", "File Status",JOptionPane.INFORMATION_MESSAGE);		
	}
	else
	{
		JOptionPane.showMessageDialog(screenFrame, "File Not Choosen.", "File Error",JOptionPane.ERROR_MESSAGE);
	}
		
}
	
	

}//End of ImportGrades.java
