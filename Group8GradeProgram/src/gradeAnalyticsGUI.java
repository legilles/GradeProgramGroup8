import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

//import newGUi.NewGradeGUI;


public class gradeAnalyticsGUI extends JFrame {
	
	public gradeAnalyticsGUI()
	{
		menuUI();
	}
	
	private void menuUI()
	{
	createMenuBar();
	setTitle("Grade Analysis Program");
	setSize(900,600);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void createMenuBar()
	{
		var menuBar = new JMenuBar(); //creates menu bar
		
		//Creates main menu labels
		var fileMenu = new JMenu("File");
		var seeStatisticsMenu = new JMenu("See Statistics");
		var createReportMenu = new JMenu("Create Report");
		
		//Creates sub menu labels
		var uploadFileTab = new JMenu("Upload File");
		var editTab = new JMenu("Edit");
		var quitProgramTab = new JMenu("Quit");
		var nameReportTab = new JMenu("Name Report");
		
		
		//Main menu items added
		menuBar.add(fileMenu);
		menuBar.add(seeStatisticsMenu);
		menuBar.add(createReportMenu);
		
		//Sub menu items added to (fileMenu)
		fileMenu.add(uploadFileTab);
		fileMenu.add(editTab);
		fileMenu.add(quitProgramTab);
		
		
		//seeStatisticsMenu sub tabs created
		var minMaxScore = new JMenu("Min/Max Scores");
		var averageScore = new JMenu("Average Score");
		var medianScore = new JMenu("Median Score");
		var gradeDistribution = new JMenu("Grade Distribution");
		var gradePercentiles = new JMenu("Grade Percentiles");
		
		//Sub menu items added to (seeStatisticsMenu)
		seeStatisticsMenu.add(minMaxScore);
		seeStatisticsMenu.add(averageScore);
		seeStatisticsMenu.add(medianScore);
		seeStatisticsMenu.add(gradeDistribution);
		seeStatisticsMenu.add(gradePercentiles);
		
		//Sub menu items added to (createReportMenu)
		createReportMenu.add(nameReportTab);
		
		
		//Sub-sub menu items created for (makeAChange)
		var addGrade = new JMenu("Add Grade");
		var deleteGrade = new JMenu("Delete Grade");
		var replaceGrade = new JMenu("Replace Grade");
		
		
		var makeAChange = new JMenu("Make a Grade Change");
		
		editTab.add(makeAChange);
		
		//Added sub sub menu items for (MakeAChange)
		makeAChange.add(addGrade);
		makeAChange.add(deleteGrade);
		makeAChange.add(replaceGrade);
		
		
		
		setJMenuBar(menuBar); //adds menu bar to screen
	}
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(() -> {
			var ex = new gradeAnalyticsGUI();
			ex.setVisible(true);
		});
	}
	
	
	
	
} //End of gradeAnalyticsGUI.java

