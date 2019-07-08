import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class SeeStatistics extends gradeAnalyticsGUI {
	
	//Initializing grade letter counters
	int A_counter = 0;
	int B_counter = 0;
	int C_counter = 0;
	int D_counter = 0;
	int F_counter = 0;
	
	String percentileResults;
	
	//Methods to get letter grade counter values
	public int getA()
	{
		return A_counter;
	}
	public int getB()
	{
		return B_counter;
	}
	public int getC()
	{
		return C_counter;
	}
	public int getD()
	{
		return D_counter;
	}
	public int getF()
	{
		return F_counter;
	}
	
	public void seeStatistics()
	{

	System.out.println("See Satistics Button Clicked");
	
	JFrame statisticsFrame = new JFrame("See Statistics");
	statisticsFrame.setSize(400, 300);
	statisticsFrame.setDefaultCloseOperation(statisticsFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
	statisticsFrame.setVisible(true); 
	statisticsFrame.setLocationRelativeTo(null);
	
	JPanel statisticsPanel = new JPanel();
	statisticsPanel.setBackground(Color.green);
	
	
	//Labels for high,low,average,median score
	JLabel highScoreLabel = new JLabel("Hightest Score: " + findMaxScore(studentList));
	JLabel lowScoreLabel = new JLabel("Lowest Score: " + findMinScore(studentList));
	JLabel avgScoreLabel = new JLabel("Average Score: " + findAveScore(studentList));
	JLabel medScoreLabel = new JLabel("Median Score: " + findMedian(studentList));
	
	//Label for number of letter grades
	JLabel gradeDistributionLabel = new JLabel("Grade Distribution");
	letterGradeDistribution (studentList);
	JLabel counterA = new JLabel("A's: " + getA());
	JLabel counterB = new JLabel("B's: " + getB());
	JLabel counterC = new JLabel("C's: " + getC());
	JLabel counterD = new JLabel("D's: " + getD());
	JLabel counterF = new JLabel("E's: " + getF());

	
	
	
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
	//statisticsPanel.add(Box.createVerticalStrut(5));
	statisticsPanel.add(counterA);
	statisticsPanel.add(counterB);
	statisticsPanel.add(counterC);
	statisticsPanel.add(counterD);
	statisticsPanel.add(counterF);
	statisticsPanel.add(Box.createVerticalStrut(10));
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
		//Student MaxStudent = findMaxScore (studentList);
		//Student MinStudent = findMinScore (studentList);
		double aveScore = findAveScore (studentList);
		System.out.println("AveScore: " + aveScore);
		System.out.println("2nd Student's score: " + studentList.get(studentList.size()/2-1).getScore());
		double medianScore = findMedian(studentList);
		System.out.println(medianScore);
		
		//letterGradeDistribution(studentList);
		//percentileScore(studentList, 79.1);
				//double score = 80.7;
				//System.out.println("Percentile("+score+"): " + percentileScore(studentList, score));
				
				
				for (Student individualStudent: studentList)
		    	{
					double percentileForEach = percentileScore(studentList, individualStudent.getScore());
					//System.out.println(percentileForEach);
		    		individualStudent.setPercentile( percentileForEach );
		    		//System.out.println(individualStudent.getPercentile());
		    		//System.out.println("Student Size: " + studentList.size());
		    	}
				
				double userPercentile = 70;
				percentileList(studentList, userPercentile);
		        
	}
	
	private double findMaxScore (ArrayList<Student> studentList)
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
		//System.out.println(maxScore);
		System.out.println("Highest Score: ID: " + MaxStudent.getID() + " Score: " + MaxStudent.getScore());
		return MaxStudent.getScore();
	}
	
	private double findMinScore (ArrayList<Student> studentList)
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
		//System.out.println(minScore);
		System.out.println("Lowest Score : ID: " + MinStudent.getID() + " Score: " + MinStudent.getScore());
		return MinStudent.getScore();
	}
	
	private double findAveScore (ArrayList<Student> studentList) 
	{
		double sum = 0;
		int studentCounter = 0;
		for (Student individualStudent: studentList)
    	{
			studentCounter++;
    		sum += individualStudent.getScore();
    	}
		if (studentCounter == 0)
		{
			System.out.println("The list is empty; no student.");
			statisticsFrame.dispose();
		}
		System.out.println("Average Score: " + sum/studentCounter);
		return sum/studentCounter;
	}
	
	private double findMedian (ArrayList<Student> studentList)
	{
		Collections.sort(studentList);
		if (studentList.size()%2 == 0)
		{
			//System.out.println(pStudentList.get(pStudentList.size()/2-1).getRawScore());
			//System.out.println(pStudentList.get(pStudentList.size()/2).getRawScore());
			return (studentList.get(studentList.size()/2-1).getScore() + studentList.get(studentList.size()/2).getScore() ) / 2.0;
			//System.out.println("Median: " + studentList.get(studentList.size()/2-1).getScore() + studentList.get(studentList.size()/2).getScore()) / 2.0);
			
		}
		else
			return studentList.get(studentList.size()/2).getScore();
	}
	
	
	
	
	
	
	
	public void letterGradeDistribution (ArrayList<Student> studentList)
	{
	
		
		for (Student individualStudent: studentList)
    	{
    		if (individualStudent.getLetterGrade() == 'A')
    			A_counter++;
    		if (individualStudent.getLetterGrade() == 'B')
    			B_counter++;
    		if (individualStudent.getLetterGrade() == 'C')
    			C_counter++;
    		if (individualStudent.getLetterGrade() == 'D')
    			D_counter++;
    		if (individualStudent.getLetterGrade() == 'F')
    			F_counter++;
    	}
		System.out.println("Grade Distribution");
		System.out.println("A's: " + A_counter);
		System.out.println("B's: " + B_counter);
		System.out.println("C's: " + C_counter);
		System.out.println("D's: " + D_counter);
		System.out.println("F's: " + F_counter);
		
	
	}
	
	
	
	
	private double percentileScore (ArrayList<Student> studentList, double Score)
	{	
		if (studentList.size() == 0) 
        {
            throw new IllegalArgumentException("studentList is empty");
        }
 
        int lowerCount = 0;
        int sameCount = 0;
        int n = studentList.size();
        for (int i = 0; i < n; i++) 
        {
            if (studentList.get(i).getScore() < Score) 
            {
                lowerCount++;
            } 
            else if (studentList.get(i).getScore() == Score) 
            {
                sameCount++;
            } 
            else 
            {
                break;
            }
        }        
         
        if (sameCount == 0) 
        {
            throw new IllegalArgumentException("Provided value do not exists in dataset: " + Score);
        }
 
        return (lowerCount + 0.5 * sameCount) / n * 100;
	}
	
	private void percentileList (ArrayList<Student> studentList, double userPercentile)
	{
		//ArrayList<Student> percentileList = new ArrayList<>();
		//if (pStudentList.getPercentile() < userPercentile)
		Collections.sort(studentList);
		System.out.println("Student IDs and Scores for " + userPercentile + " Percentile");
		//System.out.println("===================================================================");
		for (Student individualStudent: studentList)
    	{
			if (individualStudent.getPercentile() <= userPercentile)
			{
				System.out.println("Student ID: " + individualStudent.getID() + ", Student Score: " + individualStudent.getScore() + ", Percentile: " + individualStudent.getPercentile());
				percentileResults = "Student ID: " + individualStudent.getID() + ", Student Score: " + individualStudent.getScore() + ", Percentile: " + individualStudent.getPercentile();
			}
			if (studentList.size() == 0)
			{
				System.out.println("The studentList is empty.");
			}
    	}
	}
	


	
} //End of SeeStatistics.java
