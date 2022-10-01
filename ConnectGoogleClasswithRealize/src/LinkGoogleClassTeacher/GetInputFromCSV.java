package LinkGoogleClassTeacher;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

public class GetInputFromCSV {
	
	public  String[] GetInput()
	{
		  private String Fpath ="D:\\CkycApps.csv";   
		    String line;
		    File file = new File(Fpath);

		    BufferedReader bufRdr;
		    bufRdr = new BufferedReader(new FileReader(file));

		    while((line = bufRdr.readLine()) != null){
		        System.out.println(line);       
		        String[] cell= line.split(",");
		  return cell;
		}
	}

}
