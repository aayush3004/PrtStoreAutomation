package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
	//first provider method provide all details of the user
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException
	{
		
		String path=System.getProperty("user.dir")+ "//testData//Userdata.xlsx";  //We use this method to find path in current project location 
		XLUtility xl=new XLUtility(path);
		
		int rownum=xl.getRowCount("Sheet"); // using both method we are getting total number of rows and column
		int colcount=xl.getCellCount("Sheet1",1); 
		 
		String apidata[][]=new String[rownum][colcount];  // here we user two dimensional array for excel sheet rows and column
		
		
		//once the loop is completed data store in above array which is apidata 
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				apidata[i-1][j]=xl.getCellDAta("Sheet1", i, j);
			}

		}
		return apidata;
	}
	
	//second provider method provide all the user name of the users
	
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException
	{
		
		String path=System.getProperty("user.dir")+ "//testData//UserData.xlsx";  //We use this method to find path in current project location 
		XLUtility xl=new XLUtility(path);
		
		int rownum=xl.getRowCount("Sheet1"); // using this method we are getting row count
		
		 
		String apidata[]=new String[rownum];  // here we user array for number of rows
		
		
		//once the loop is completed data store in above array which is apidata 
		for(int i=1;i<=rownum;i++)
		{
				apidata[i-1]=xl.getCellDAta("Sheet1", i, 1); //all user name comes into the array 
		}
		return apidata;
	}

}
