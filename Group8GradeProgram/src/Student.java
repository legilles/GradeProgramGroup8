import java.util.ArrayList;

public class Student implements Comparable<Student> {

	private String ID;
	private double Score;
	private Character LetterGrade;
	private double totalPoints;
		
// ID get and set methods
	public Student (String newID)
	{
		setID(newID); //set new ID
	}
	
	public String getID()
	{
		return ID;
	}
	
	public void setID(String newID)
	{
		ID = newID;
	}
	
// Score/Rounded score get and set helper methods
	public double getScore()
	{
		return Score;
	}
	
	public void setScore(double newScore)
	{
		Score = newScore;
	}
	
	public double getRoundedScore()
	{
		return Math.round(Score);
	}
	

// Letter Grade set and get help helper methods 
	public Character getLetterGrade()
	{
		return LetterGrade;
	}
	
	public void setLetterGrade(Character newLetterGrade)
	{
		LetterGrade = newLetterGrade;
	}
	
//Grade percentile
	private double percentile;
	
	public double getPercentile()
	{
		return percentile;
	}
	
		
	public void setPercentile (double newPercentile)
	{
		percentile = newPercentile;
	}
	
	
	

//Set Default Letter Grades
	public Character defaultLetterGrade(double scoreEarned)
	{
	//Default A Letter Range
			if (scoreEarned <= 100.0 && scoreEarned >= 90.0 )
			{
				return 'A';
			}
			//Default B Letter Range
			if (scoreEarned < 90.0 && scoreEarned >= 80.0 )
			{
				return 'B';
			}
			//Default C Letter Range
			if (scoreEarned < 80.0 && scoreEarned >= 70.0 )
			{
				return 'C';
			}
			//Default D Letter Range
			if (scoreEarned < 70.0 && scoreEarned >= 60.0 )
			{
				return 'D';
			}
			//Default F Letter Range
			if (scoreEarned < 60.0 )
			{
				return 'F';
			}
			else
			{
				System.out.println("Not Letter Assigned."); //prints to console if letter assigned to student
				return '-';
			}
	
		}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	} //End of Student.java
