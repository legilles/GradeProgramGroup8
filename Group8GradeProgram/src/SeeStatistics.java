import java.awt.Color;
import java.util.ArrayList;
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
	JLabel highScoreLabel = new JLabel("Hightest Score: " + findMaxScore(studentList));
	JLabel lowScoreLabel = new JLabel("Lowest Score: " + findMinScore(studentList));
	JLabel avgScoreLabel = new JLabel("Average Score: " + findAveScore(studentList));
	JLabel medScoreLabel = new JLabel("Median Score: ");
	
	//Label for number of letter grades
	JLabel gradeDistributionLabel = new JLabel("Grade Distribution:");
	JLabel numberOfLettersLabel = new JLabel("Number of  A's[] B's[] C's[] D's[] F's[]");
	
	
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
	
	
	public void CalcStatistics (ArrayList<Student> studentList)
	{
		for (Student individualStudent: studentList)
    	{
    		System.out.println("Student ID: " + individualStudent.getID() + ", Student Score: " + individualStudent.getScore());
    	}
		Student MaxStudent = findMaxScore (studentList);
		Student MinStudent = findMinScore (studentList);
		double aveScore = findAveScore (studentList);
		System.out.println("AveScore: " + aveScore);
		System.out.println("2nd Student's score: " + studentList.get(studentList.size()/2-1).getScore());
		//double medianScore = findMedian (studentList);
		//System.out.println(medianScore);
	}
	
	private Student findMaxScore (ArrayList<Student> studentList)
	{
		double maxScore = 0;
		Student MaxStudent = null;
		for (Student individualStudent: studentList)
    	{
    		if (individualStudent.getScore() > maxScore)
    		{
    			maxScore = individualStudent.getScore();
    			MaxStudent = individualStudent;
    		}
    	}
		System.out.println(maxScore);
		System.out.println("ID: " + MaxStudent.getID() + ", Score: " + MaxStudent.getScore());
		return MaxStudent;
	}
	
	private Student findMinScore (ArrayList<Student> studentList)
	{
		double minScore = Double.POSITIVE_INFINITY;
		Student MinStudent = null;
		for (Student individualStudent: studentList)
    	{
    		if (individualStudent.getScore() < minScore)
    		{
    			minScore = individualStudent.getScore();
    			MinStudent = individualStudent;
    		}
    	}
		System.out.println(minScore);
		System.out.println("ID: " + MinStudent.getID() + ", Score: " + MinStudent.getScore());
		return MinStudent;
	}
	
	private double findAveScore (ArrayList<Student> pStudentList) 
	{
		double sum = 0;
		int studentCounter = 0;
		for (Student individualStudent: pStudentList)
    	{
			studentCounter++;
    		sum += individualStudent.getScore();
    	}
		if (studentCounter == 0)
		{
			System.out.println("The list is empty; no student.");
			statisticsFrame.dispose();
		}
		return sum/studentCounter;
	}
	
	//private double findMedian (ArrayList<StudentJae> pStudentList)
	//{
		//Collections.sort(pStudentList);
		//if (pStudentList.size()%2 == 0)
		//{
			//System.out.println(pStudentList.get(pStudentList.size()/2-1).getRawScore());
			//System.out.println(pStudentList.get(pStudentList.size()/2).getRawScore());
			//return ( pStudentList.get(pStudentList.size()/2-1).getRawScore() + pStudentList.get(pStudentList.size()/2).getRawScore() ) / 2.0;
			
	//	}
		//else
			//return pStudentList.get(pStudentList.size()/2).getRawScore();
	//}
	
	
} //End of SeeStatistics.java
