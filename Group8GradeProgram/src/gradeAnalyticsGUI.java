import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Label;
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
		var scoreBreakDown = new JMenu("Grade Breakdown");
		var gradeDistribution = new JMenu("Grade Distribution");
		var gradePercentiles = new JMenu("Grade Percentiles");
		
		//Sub menu items added to (seeStatisticsMenu)
		seeStatisticsMenu.add(scoreBreakDown);
		seeStatisticsMenu.add(gradeDistribution);
		seeStatisticsMenu.add(gradePercentiles);
		
		//Sub menu items added to (createReportMenu)
		createReportMenu.add(nameReportTab);
		
		
		//Sub-sub menu items created for (makeAChange)
		var addGrade = new JMenu("Add Grade");
		var deleteGrade = new JMenu("Delete Grade");
		var replaceGrade = new JMenu("Replace Grade");
		
		
		var makeAChange = new JMenu("Make a Grade Change");
		var distributionChange = new JMenu("Change Grade Distribution");
		
		editTab.add(makeAChange);
		editTab.add(distributionChange);
		
		//Added sub sub menu items for (MakeAChange)
		makeAChange.add(addGrade);
		makeAChange.add(deleteGrade);
		makeAChange.add(replaceGrade);
		
		//Created/Added sub sub menu items for (distributionChange)
		var redefineLetterGrade = new JMenu("Redefine Letter Grade");
		var setNewPointScale = new JMenu("Set New Point Scale");
		distributionChange.add(redefineLetterGrade);
		distributionChange.add(setNewPointScale);
		
		setJMenuBar(menuBar); //adds menu bar to screen
		
		setLayout(new FlowLayout(FlowLayout.CENTER,20,100));
		add(new Label("Welcome to the Grade Analysis Program")); //Welcome message on screen
		
	}
	

	
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(() -> {
			var ex = new gradeAnalyticsGUI();
			ex.setVisible(true);
		});
	}
		
} //End of gradeAnalyticsGUI.java

