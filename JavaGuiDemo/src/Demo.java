import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.BufferedReader;
import java.io.File; 


 
 
 






public class Demo {
	public String filePathname;
	public FileInputStream inputFile;

	private JFrame frame;
	private final JButton btnLoadButton = new JButton("Load");
    public DefaultTableModel tableModel=new DefaultTableModel();
	public final JTextField filePath=new JTextField(100);
	private JButton btnRun;
	public JTable table;
	public JLabel lblFileErrorMessage;
	public ArrayList<ThreadGroup> threadGroupList=new ArrayList<ThreadGroup>();
	public ArrayList<String> threadGroupNameList=new ArrayList<String>();
	
	String fileFolder;
	String fileName;
	int temp=0;
	Node nNode;
	boolean filepathAvailable=false;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo window = new Demo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Demo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1194, 762);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/***********************************	LOAD BUTTON	*********************************/
		btnLoadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GetFilePath();
				
				if(filepathAvailable == true)
				{
					AddElementsToTable();
				}
			}
		});
		btnLoadButton.setBackground(SystemColor.menu);
		btnLoadButton.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnLoadButton.setBounds(1065, 71, 80, 30);
		frame.getContentPane().add(btnLoadButton);	
		/***********************************	FILE PATH 	*********************************/
		filePath.setFont(new Font("Calibri", Font.PLAIN, 16));
		filePath.setBounds(187, 74, 738, 30);
		frame.getContentPane().add(filePath);
		filePath.setColumns(10);
		
		/***********************************	FILE PATH LABEL	*********************************/
		JLabel lblFilePath = DefaultComponentFactory.getInstance().createLabel("File Path");
		lblFilePath.setHorizontalAlignment(SwingConstants.CENTER);
		lblFilePath.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblFilePath.setBounds(35, 74, 114, 30);
		frame.getContentPane().add(lblFilePath);
		/***********************************Run	BUTTON	*********************************/
		btnRun = new JButton("Run ");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RunScript();
			}
		});
		btnRun.setBackground(SystemColor.menu);
		btnRun.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnRun.setBounds(1075, 678, 80, 30);
		frame.getContentPane().add(btnRun);
		
		
		/***********************************	TABLE	*********************************/
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"ThreadGroupName", "VUsers", "RU Time(Sec)", "Duration(Sec)", "RD Time(Sec)"},
			},
			new String[] {
				"ThreadGroupName", "VUsers", "RU Time", "Duration", "RD Time"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(191);
		table.getColumnModel().getColumn(2).setPreferredWidth(66);
		table.setFont(new Font("Calibri", Font.PLAIN, 14));
		table.setBounds(187, 249, 755, 265);
		frame.getContentPane().add(table);
		/***********************************	ERROR MESSAGE FOR FILE PATH 	*********************************/
		lblFileErrorMessage = new JLabel("");
		lblFileErrorMessage.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblFileErrorMessage.setBounds(187, 120, 250, 30);
		frame.getContentPane().add(lblFileErrorMessage);
		/***********************************	CLEAR BUTTON	*********************************/
		JButton btnClearButton = new JButton("Clear");
		btnClearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ClearTable();
				
			}
		});
		btnClearButton.setBackground(SystemColor.menu);
		btnClearButton.setBounds(970, 676, 80, 30);
		frame.getContentPane().add(btnClearButton);
	}
	/***********************************	GET THREADGROUPNAME	*********************************/
	public void GetFilePath()
	{
		
		 
		filePathname= filePath.getText();
		
		
			try
			{
				/*************************Get the ExactFile	**************************/
				inputFile = new FileInputStream(filePathname);
				/*************************Get the ParentFilePathName	**************************/
				fileFolder = Path.of(filePathname).getParent().toString();
				/*************************Get the FileName	Using Regular Expression**************************/
				fileName=Path.of(filePathname).getFileName().toString();
				
				Pattern pattern = Pattern.compile("(.*?).jmx");
				Matcher matcher = pattern.matcher(fileName);
				if (matcher.find())
				{
				/*************************Get the First Group of the Regular Expression**************************/
					fileName=matcher.group(1);
				}
			
			
			
			
				filepathAvailable=true;
				lblFileErrorMessage.setText("");
			
			}
			catch(Exception e)
			{
				filepathAvailable=false;
				lblFileErrorMessage.setText("File not found");
				System.out.println(e.getMessage());
				
			}
			
				try
				{
					/*************************	PARSE THE DOCUMENT IN TO XML	**************************/
					DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
					Document doc = dBuilder.parse(inputFile);
					doc.getDocumentElement().normalize();
					/*************************	GET THE NUMBER OF THREADGROUPS IN LIST	**************************/
					NodeList nList = doc.getElementsByTagName("ThreadGroup");
					
					for(int i=0;i<=nList.getLength();i++)
					{
						nNode = nList.item(i);
						
							Element eElement = (Element) nNode;
							/*************************	ADD THE THREAD GROUP NAME TO THE ARRAYLIST	**************************/
							threadGroupNameList.add(eElement.getAttribute("testname"));
						
		    	
					}
				}
				catch(Exception e)
				{
					
					e.getStackTrace();
				}
			
			
		}
		
		
		
		
	/***********************************	GET THREADGROUPNAME	*********************************/
	public void AddElementsToTable()
	{
		
		DefaultTableModel modelThreadGroupName=(DefaultTableModel) table.getModel();
		Object rowData[]=new Object[5];
		
		
			for(int i=0;i<threadGroupNameList.size();i++)
			{
				rowData[0]=threadGroupNameList.get(i);
				/*************************	ADD THE THREADGROUP NAME TO THE ROW	**************************/
				modelThreadGroupName.addRow(rowData);
			
			}
		
		
		
		
	}
	/***********************************	EXECUTE THE SCRIPT BASED ON INPUTS	*********************************/
	public void RunScript()
	{
		//DefaultTableModel currentModel = (DefaultTableModel) table.getModel();
		
		temp = (temp == 0) ? 1: ++temp;
		System.out.println(temp);
		/***************************************	 Pattern for Execute Multiple Line Command	*****************************/
		String[] command = new String[3];
        command[0] = "cmd";
        command[1] = "/c";
        command[2] = "D: && cd D:/Jmeter/apache-jmeter-5.1.1/bin && jmeter -n -t "+filePath.getText()+" -l "+fileFolder+"/"+fileName+"NonGui_"+temp+".csv";
		try
		{
			
			String outputLine;
			 
			/******************************	FUNCTION TO EXECUTE A SHELL COMMAND	********************************/
			Process process = Runtime.getRuntime().exec(command);
			final BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			final BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			
			/******************************	PRINTING THE EXACT OUTPUT FROM THE COMMAND PROMPT IN THE CONSOLE	********************************/
			System.out.println("*******************	OUTPUT	**********************");
			 while ((outputLine = reader.readLine()) != null) {
	                System.out.println(outputLine);
	            } 
			 /******************************	PRINTING THE ERROR FROM THE CONSOLE	********************************/
			System.out.println("*******************	ERROR	**********************");
			 while ((outputLine = stdError.readLine()) != null) {
	                System.out.println(outputLine);
			 }
			 
			 
			 /****************************************	NEED TO WORK ON THIS LOGIC	*******************************/
			 /*for(int i=1;i<currentModel.getRowCount();i++)
			 {
	        	command[2] = "D: && cd Jmeter/apache-jmeter-5.1.1/bin && jmeter -n -t "+filePath.getText()+" -l "+fileFolder+"/"+currentModel.getValueAt(i, 0).toString()+"NonGui_"+temp+".csv -JUsers"+i+"="+currentModel.getValueAt(i,1);
	        	Process process = Runtime.getRuntime().exec(command);
				final BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				final BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
				
				/******************************	PRINTING THE EXACT OUTPUT FROM THE COMMAND PROMPT IN THE CONSOLE	********************************/
				/*System.out.println("*******************	OUTPUT	**********************");
				 while ((outputLine = reader.readLine()) != null) {
		                System.out.println(outputLine);
		            }
				 /******************************	PRINTING THE ERROR FROM THE CONSOLE	********************************/
				/*System.out.println("*******************	ERROR	**********************");
				while ((outputLine = stdError.readLine()) != null) {
			           System.out.println(outputLine);
					 }
			 }*/	
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		 
		
	}
	/***********************************	Clear the table	*********************************/
	/*public void ClearTable()
	{
		DefaultTableModel modelClearTable = (DefaultTableModel) table.getModel();
		
		if(modelClearTable.getRowCount()>0)
		{
			modelClearTable.removeRow(1);
			modelClearTable.fireTableCellUpdated(0,0);
			
		}
	}*/
	
	}

