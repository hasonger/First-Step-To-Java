import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class IOExample
{
	public static void main(String[] args)
	{
		String filePath = "demo.txt";
		DataInputStream dis;
		try
		{
			dis = new DataInputStream(new BufferedInputStream( new FileInputStream(filePath)));
			String fileContent = new String();
			String formatContent = new String();
			while((fileContent = dis.readLine()) != null)
			{
				formatContent += fileContent + "\n";

			}
			System.out.println(formatContent);
			dis.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}