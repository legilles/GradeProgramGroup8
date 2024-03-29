import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class SeeStatistics extends gradeAnalyticsGUI {
	
	//Initializing grade letter counters
	int A_counter = 0;
	int B_counter = 0;
	int C_counter = 0;
	int D_counter = 0;
	int F_counter = 0;
	
	String percentileResults = "";
	
	
	
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
	statisticsFrame.setDefaultCloseOperation(statisticsFrame.DISPOSE_ON_CLOSE); //program will close "create report" window if user clicks "x"
	statisticsFrame.setVisible(true); 
	statisticsFrame.setBounds(850,300,400,300);
	statisticsFrame.setResizable(false);
	
	

	
	JPanel statisticsPanel = new JPanel();
	statisticsPanel.setBackground(Color.green);
	
	JPanel p = new JPanel();
	
	
	
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
	JLabel whatPercLabel = new JLabel("What Percentile?:");
	
	
	//Text field for percentile value
	JTextField givenPercentilesField = new JTextField(5);
	

	
	//Percentile "Enter" button 
	JButton percEnterButton = new JButton("Enter");
	JButton percCloseButton = new JButton("Close");
	
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
	statisticsPanel.add(whatPercLabel);
	
	
	//Adding layout to statisticsPanel
	statisticsPanel.add(givenPercentilesField);
	
	
	
	statisticsPanel.setLayout(new BoxLayout(statisticsPanel, BoxLayout.Y_AXIS));
	p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
	p.setBackground(Color.green);
	

	//p.add(statisticsPanel, BorderLayout.WEST);
	p.add(percEnterButton);
	statisticsPanel.add(Box.createVerticalStrut(25));
	p.add(percCloseButton);
	
	
	
	//Add to frame
	statisticsFrame.add(statisticsPanel);
	statisticsFrame.add(p, BorderLayout.SOUTH);
	
	
	
	
	percEnterButton.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{ 
					double userPercentile = Double.parseDouble(givenPercentilesField.getText());
					System.out.println("Percentile: " + userPercentile);
					
					CalcStatistics(studentList, userPercentile);
					
					
					JTextArea percenArea = new JTextArea();
					percenArea.setText("Percentile Results For: "+ userPercentile + "\n"+ percentileResults);
					percenArea.setBackground(Color.green);
					percenArea.setEditable(false);
					
					
					JButton percClose = new JButton("Close");
					
					JFrame temp = new JFrame();
					//temp.setSize(500, 500);
					temp.add(percenArea, BorderLayout.CENTER);
					temp.setDefaultCloseOperation(screenFrame.DISPOSE_ON_CLOSE); //program will quit if user clicks "x"
					temp.setVisible(true);  
					temp.setBounds(850,350,450,400); //displays window in center of screen
					temp.add(percClose, BorderLayout.SOUTH);
					
					
				
					
					percClose.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent e)
						{ 
							temp.dispose();
						}
					});
				
					
				}
			});
	
	percCloseButton.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e)
		{ 
			statisticsFrame.dispose();
		}
	});
	
	
	} //End of seeStatistics()
	
	
	public void CalcStatistics (ArrayList<Student> studentList , double userPercentile)
	{
		Collections.sort(studentList);
		//for (Student individualStudent: studentList)
    	//{
    		//System.out.println("Student ID: " + individualStudent.getID() + ", Student Score: " + individualStudent.getScore());
    	//}
		//Student MaxStudent = findMaxScore (studentList);
		//Student MinStudent = findMinScore (studentList);
		//double aveScore = findAveScore (studentList);
		//System.out.println("AveScore: " + aveScore);
		//System.out.println("2nd Student's score: " + studentList.get(studentList.size()/2-1).getScore());
		//double medianScore = findMedian(studentList);
		//System.out.println(medianScore);
		
		//letterGradeDistribution(studentList);
				//double score = 80.7;
				//System.out.println("Percentile("+score+"): " + percentileScore(studentList, score));
				
				
				for (Student individualStudent: studentList)
		    	{
					double percentileForEach = percentileScore(studentList, individualStudent.getScore()); 
					//System.out.println("Percentile " + percentileForEach);
					//System.out.println(percentileForEach);
		    		individualStudent.setPercentile(percentileForEach);
		    		//System.out.println(individualStudent.getPercentile());
		    		//System.out.println("Student Size: " + studentList.size());
		    	}	
				percentileList(studentList, userPercentile);
				Collections.sort(studentList, new SortbyID()); 
	}
	
	double findMaxScore (ArrayList<Student> studentList)
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
		setMaxPosScore(MaxStudent.getScore());
		return MaxStudent.getScore();
	}
	
	double findMinScore (ArrayList<Student> studentList)
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
		setMinPosScore(MinStudent.getScore());
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
	
	protected double percentileScore (ArrayList<Student> studentList, double Score) 
	{
        int lowerCount = 0;
        int sameCount = 0;
        int n = studentList.size();
        
		if (studentList.size() != 0) 
        {
        

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
            //System.out.println("Provided value do not exists in dataset: " + Score);
        }
        }
        return (lowerCount + 0.5 * sameCount) / n * 100;
       
	}
	
	private void percentileList(ArrayList<Student> studentList, double userPercentile) //user value
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
				System.out.println("Student ID: " + individualStudent.getID() + " Student Score: " + individualStudent.getScore() + " Percentile: " + individualStudent.getPercentile());
				percentileResults += "Student ID: " + individualStudent.getID() + " Student Score: " + individualStudent.getScore() + " Percentile: " + individualStudent.getPercentile() + "\n";
			}
			if (studentList.size() == 0)
			{
				System.out.println("The studentList is empty.");
			}
    	}
		//return percentileResults;
	}

} //End of SeeStatistics.java
