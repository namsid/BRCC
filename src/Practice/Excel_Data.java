package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Data {

	public static void main(String[] args) throws InvalidFormatException, IOException 
	{	//define xl path
		String XlPath = "./data/input.xlsx";
		
		//open the excel file
		FileInputStream fis = new FileInputStream(XlPath);
				Workbook wb = WorkbookFactory.create(fis);
		
		//go to required sheet 
		Sheet s = wb.getSheet("Sheet1");
		//go to required row
		Row r = s.getRow(0);
		// go to required cell
		Cell c = r.getCell(1);
		//get the value present in the cell and print the value
		String cValue = c.toString();
		System.out.println(cValue);

	}

}
