package com.automation.ezycomp.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class ExcelOperations {

    FileInputStream fis;
    XSSFWorkbook workbook;
    //HashMap<String, LinkedHashMap<Integer, List<String>>> outerMap = new LinkedHashMap<>();
    LinkedHashMap<Integer, List<String>> innerMap = new LinkedHashMap();

    public ExcelOperations(String path) throws Exception {
        File file =    new File(path);
        fis = new FileInputStream(file);
        //Workbook ws = new XSSFWorkbook(fis);
        workbook = new XSSFWorkbook(fis);
        //Sheet sh = ws.getSheet("Acts");
        //XSSFSheet Sheet = workbook.getSheet("Acts");
        //int rowCount = sh.getLastRowNum()-sh.getFirstRowNum();
        //int rowCount = Sheet.getLastRowNum()-Sheet.getFirstRowNum();
    }

    //	get column count
    public int getColcount(String userSheetname){
        XSSFSheet Sheet = workbook.getSheet(userSheetname);
        return Sheet.getRow(0).getLastCellNum();
    }

    //	get Row count
    public int getRowcount(String userSheetname){
        XSSFSheet Sheet = workbook.getSheet(userSheetname);
        int rowcount = Sheet.getLastRowNum();
        return rowcount;

    }

    public Iterator<Object[]> getData(String sheetName, int rowcount, int colcount) throws Exception{
        List<Object[]> ls = new ArrayList<Object[]>();
//		iterate thru each row
        for(int iRow=1;iRow<=rowcount;iRow++){
            Object[] obj = new Object[1];
//			create a map
            Map<String, String> hm = new HashMap<String, String>();
//			column iteration
            for(int iCol=0;iCol<colcount;iCol++){

                String key=readCellValue(sheetName, 0, iCol);
                String val=readCellValue(sheetName, iRow, iCol);
                hm.put(key, val);
            }	//			column iteration
            obj[0]=hm;
            ls.add(obj);
            //}
        }
        return ls.iterator();
    }

    public String readCellValue(String userSheetname,int row,int col){
        XSSFSheet Sheet = workbook.getSheet(userSheetname);
        String celltext = null;
        XSSFCell cell = Sheet.getRow(row).getCell(col);
//		if the cell has string value

        switch(cell.getCellType())
        {
            case Cell.CELL_TYPE_STRING:
                celltext=cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                celltext= String.valueOf(cell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_BLANK:
                celltext= "";
                break;
        }

        return celltext;


    }

    //	Save and Close the file after operations
    public void saveAndClose(String path) throws Exception {
        FileOutputStream fos = new FileOutputStream(path);
        workbook.write(fos);
        fos.close();
        fis.close();
    }
}