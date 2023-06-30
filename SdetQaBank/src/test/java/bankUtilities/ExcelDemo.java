package bankUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExcelDemo xl= new ExcelDemo();
		xl.getData();
	}
		String [][] getData() throws IOException
		{
			String path =System.getProperty("user.dir")+"\\TestData\\xlfile.xlsx";
			FileInputStream fis = new FileInputStream (path);
			XSSFWorkbook wb= new XSSFWorkbook(fis);
			XSSFSheet sh= wb.getSheet("LoginData");
	        int row = sh.getPhysicalNumberOfRows();
			int col = sh.getRow(0).getPhysicalNumberOfCells();
			String logindata[][]=new String[row-1][col];	
			for (int i=1; i<row; i++)
			{
				for(int j=0; j<col; j++)
				{
					logindata[i-1][j]= sh.getRow(i).getCell(j).getStringCellValue();
                    System.out.print(logindata[i-1][j]);
                    System.out.print(" ");
				}
				System.out.println();
			}
			return logindata;
		}

	

}
