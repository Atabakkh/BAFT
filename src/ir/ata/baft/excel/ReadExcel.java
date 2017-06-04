package ir.ata.baft.excel;

import ir.ata.baft.FileType;
import ir.baft.databasehelper.DatabaseConnection;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.catalina.util.Conversions;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ReadExcel {

	static DatabaseConnection dbConn;
	static Connection conn;
	public ReadExcel(){
		dbConn = new DatabaseConnection();
		conn = dbConn.mySqlConnection();
	}
	public void read(File UPLOADED_FILE, FileType TYPE) throws IOException {

		// Location of the source file
		String sourceFilePath = UPLOADED_FILE.getPath();

		FileInputStream fileInputStream = null;

		// Array List to store the excel sheet data
		List excelSheetData = new ArrayList();

		try {

			// FileInputStream to read the excel file
			fileInputStream = new FileInputStream(sourceFilePath);

			// Create an excel workbook
			HSSFWorkbook excelWorkBook = new HSSFWorkbook(fileInputStream);

			// Retrieve the first sheet of the workbook.
			HSSFSheet excelSheet = excelWorkBook.getSheetAt(0);

			// Iterate through the sheet rows and cells.
			// Store the retrieved data in an arrayList
			Iterator rows = excelSheet.rowIterator();
			while (rows.hasNext()) {
				HSSFRow row = (HSSFRow) rows.next();
				Iterator cells = row.cellIterator();

				List cellData = new ArrayList();
				while (cells.hasNext()) {
					HSSFCell cell = (HSSFCell) cells.next();
					cellData.add(cell);
				}

				excelSheetData.add(cellData);
			}

			// Print retrieved data to the console
			if(TYPE == FileType.mapping)
			{
			for (int rowNum = 0; rowNum < excelSheetData.size(); rowNum++) {

				List list = (List) excelSheetData.get(rowNum);
				importDataMapping(list);

				// for (int cellNum = 0; cellNum < list.size(); cellNum++) {
				//
				// HSSFCell cell = (HSSFCell) list.get(cellNum);
				//
				// if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
				// System.out.print(cell.getRichStringCellValue()
				// .getString() + " ");
				// } else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
				// {
				// System.out.print(cell.getNumericCellValue() + " ");
				// } else if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN)
				// {
				// System.out.println(cell.getBooleanCellValue() + " ");
				// }
				// }
//				System.out.println("");
			}
			}
			else if(TYPE == FileType.weights)
			{
				for (int rowNum = 0; rowNum < excelSheetData.size(); rowNum++) {
	
					List list = (List) excelSheetData.get(rowNum);
					importDataWeights(list);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileInputStream != null) {
				fileInputStream.close();
			}
		}

	}

	public void importDataMapping(List list) {

		HSSFCell cell1, cell2, cell3;
		try {
			cell1 = (HSSFCell) list.get(0);cell2 = (HSSFCell) list.get(1);cell3 = (HSSFCell) list.get(2);
			String preferred_name = (cell1.getCellType() == HSSFCell.CELL_TYPE_STRING) ? cell1.getRichStringCellValue().getString() : 
				((cell1.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) ? Double.toString(cell1.getNumericCellValue()) : "");
			String name = (cell2.getCellType() == HSSFCell.CELL_TYPE_STRING) ? cell2.getRichStringCellValue().getString() : 
				((cell2.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) ? Double.toString(cell2.getNumericCellValue()) : "");
			String source = (cell3.getCellType() == HSSFCell.CELL_TYPE_STRING) ? cell3.getRichStringCellValue().getString() : 
				((cell3.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) ? Double.toString(cell3.getNumericCellValue()) : "");
					
			conn.createStatement().executeUpdate("insert into mapping (preferred_name, name, source)values ('"
							+ preferred_name
							+ "','"
							+ name
							+ "','"
							+ source + "')");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void importDataWeights(List list) {

		HSSFCell cell1, cell2, cell3;
		try {
			cell1 = (HSSFCell) list.get(0);cell2 = (HSSFCell) list.get(1);cell3 = (HSSFCell) list.get(2);
			String Gene_A = (cell1.getCellType() == HSSFCell.CELL_TYPE_STRING) ? cell1.getRichStringCellValue().getString() : 
				((cell1.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) ? Double.toString(cell1.getNumericCellValue()) : "");
			String Gene_B = (cell2.getCellType() == HSSFCell.CELL_TYPE_STRING) ? cell2.getRichStringCellValue().getString() : 
				((cell2.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) ? Double.toString(cell2.getNumericCellValue()) : "");
			String Weight = (cell3.getCellType() == HSSFCell.CELL_TYPE_STRING) ? cell3.getRichStringCellValue().getString() : 
				((cell3.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) ? Double.toString(cell3.getNumericCellValue()) : "");
					
			conn.createStatement().executeUpdate("insert into weights (gene_a, gene_b, weight)values ('"
							+ Gene_A
							+ "','"
							+ Gene_B
							+ "','"
							+ Weight + "')");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void importData() {

		DatabaseConnection dbConn = new DatabaseConnection();
		Connection conn = dbConn.mySqlConnection();
		try {
			Statement stmt = conn.createStatement();
			stmt.executeQuery("insert into mapping (`preferred_name`,`name`,`source`)values ('1','1','1')");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
