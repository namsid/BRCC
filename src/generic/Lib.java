package generic;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Lib 
{
	public static String getProperty(String Path, String Key)
	{
		String Value = "";
		
		try
		{
			Properties p = new Properties();
			p.load(new FileInputStream(Path));
			Value = p.getProperty(Key);
		}
		
		catch(Exception e)
		{
			
		}
		return Value;
	}
	
	public static String getCellValue(String XlPath,String sheet , int r , int c )
	{
				String cValue = "";
				
				try {
					//Go to workbook and open the file from the xl path -- get sheet , get row , get cell , convert to string
					cValue  = WorkbookFactory.create(new FileInputStream(XlPath)).getSheet(sheet).getRow(r).getCell(c).toString();
			 
				}
				
				catch (Exception e)
				{
					cValue = " ";
				}	
				return cValue;
    }
	
	public static int getRowCount(String Xlpath , String sheet ) 
	{
		int rcount =0;
		try
		{
		 rcount =WorkbookFactory.create(new FileInputStream(Xlpath)).getSheet(sheet).getLastRowNum();
		
		
		}
		catch(Exception e)
		{
			
		}
		return rcount;
		
		
	}

	public static int getcollumncount(String Xlpath , String sheet ,int r)
	{
		int cCount = 0;
		try
		{
			cCount = WorkbookFactory.create(new FileInputStream(Xlpath)).getSheet(sheet).getRow(r).getLastCellNum();
		}
		catch(Exception e)
		{
			
		}
		return cCount;
		
	}
	
}