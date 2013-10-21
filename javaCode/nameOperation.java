import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class nameOperation
{
	Hashtable<String, Integer> firstName = new Hashtable<String, Integer>();
	Hashtable<String, Integer> lastName = new Hashtable<String, Integer>();
	Hashtable<String, Integer> uniqueName = new Hashtable<String, Integer>();
	String filePath = null;

	nameOperation(String filePath)
	{
		this.filePath = filePath;
	}

	//Validation for name : Alphabetic
	public static boolean isValidCode(String code) 
	{
    	return code.matches("^[a-zA-Z]*$");
	}

	//Generate three hashtables, and output 50 unique names into UniqueNameOutput_50.txt file
	public void generateHashtable()
	{
		DataInputStream dis;
		int count = 50;
		try
		{
			FileWriter fw = new FileWriter("UniqueNameOutput_50.txt"); 

			dis = new DataInputStream(new BufferedInputStream( new FileInputStream(this.filePath)));
			String line = new String();
			while((line = dis.readLine()) != null)
			{
				//name start without space, remove lines not for names
				if(line.substring(0,1).equals(" ") == false)
				{
					String nameStr =  line.split("--")[0];
					String[] nameArray = nameStr.split(",");
					String firstNameStr = nameArray[0].trim();//get first name
					String lastNameStr = nameArray[1].trim(); //get last name
					if(isValidCode(firstNameStr) && isValidCode(lastNameStr))
					{
						//System.out.println(firstNameStr +"--"+lastNameStr);
						if(!firstName.containsKey(firstNameStr) && !lastName.containsKey(lastNameStr))
						{
							uniqueName.put(firstNameStr+", "+lastNameStr,1);
							if(count > 0)
							{
								fw.write(firstNameStr+", "+lastNameStr+"\r\n"); 
								count--;
							}
							else
							{
								fw.close();
							} 			 
						}

						if(firstName.containsKey(firstNameStr))
						{
							firstName.put(firstNameStr, firstName.get(firstNameStr)+1);
						}
						else
						{
							firstName.put(firstNameStr, 1);
						}

						if(lastName.containsKey(lastNameStr))
						{
							lastName.put(lastNameStr, lastName.get(lastNameStr)+1);
						}
						else
						{
							lastName.put(lastNameStr, 1);
						}
					}
					
				}
				
			}
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

	//Sort the whole hashtable based on value, [I think it is not efficient, but we can control the output count here]
	public static void sortValue(Hashtable<String, Integer> t, int count)
	{
       	//Transfer as List and sort it
       	ArrayList<Map.Entry<String, Integer>> l = new ArrayList(t.entrySet());
       	//sort the hashtable, find this part code here: http://stackoverflow.com/questions/5176771/sort-hashtable-by-values
       	Collections.sort(l, new Comparator<Map.Entry<String, Integer>>()
       	{
         	public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) 
         	{
            	return o2.getValue().compareTo(o1.getValue());
        	}
    	});
       	for(Map.Entry<String, Integer> d:l) 
       	{
            System.out.println("\t"+d.getKey()+" : "+d.getValue());
            count--;
            if(count == 0)
            {
            	break;
            }
        }
        //System.out.println(l);
    }

	public int getUniqueNameCount()
	{
		return uniqueName.size();
	}

	public int getUniqueFirstNameCount()
	{
		return firstName.size();
	}
	public int getUniqueLastNameCount()
	{
		
		return lastName.size();
	}
	public void getTopCountFirstName(int count)
	{
		sortValue(firstName, count);
	}

	public void getTopCountLastName(int count)
	{
		sortValue(lastName, count);
	}

	public static void main(String[] args)
	{
		nameOperation no = new nameOperation("data-file.txt");
		no.generateHashtable();
		System.out.println("Unique   Name    Count : "+no.getUniqueNameCount());
		//System.out.println("Unique FirstName Count : "+no.getUniqueFirstNameCount());
		//System.out.println("Unique LastName  Count : "+no.getUniqueLastNameCount());
		System.out.println("The ten most common first names:");
		no.getTopCountFirstName(10);
		System.out.println();
		System.out.println("The ten most common last names:");
		no.getTopCountLastName(10);
		
	}
}