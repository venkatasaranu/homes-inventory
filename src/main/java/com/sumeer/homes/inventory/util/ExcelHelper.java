package com.sumeer.homes.inventory.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.sumeer.homes.inventory.model.HomeInventory;
import org.apache.commons.compress.archivers.dump.DumpArchiveEntry;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;


public class ExcelHelper {
  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
  public static boolean hasExcelFormat(MultipartFile file) {

    if (!TYPE.equals(file.getContentType())) {
      return false;
    }

    return true;
  }

  public static List<HomeInventory> processExcel(InputStream excelStream) {
    int i = 1;

    try {
      List<HomeInventory> inventoryList = new ArrayList<>();

      // Creates a workbook object from the uploaded excelfile
      XSSFWorkbook workbook = new XSSFWorkbook(excelStream);
      // Creates a worksheet object representing the first sheet
      XSSFSheet worksheet = workbook.getSheetAt(0);

      List<String> cellNames= buildCellNames(worksheet);
      // Reads the data in excel file until last row is encountered
      while (i < worksheet.getLastRowNum()) {
        // Creates an object for the UserInfo Model

        HomeInventory inventory = new HomeInventory();
        // Creates an object representing a single row in excel
        i++;
        XSSFRow row = worksheet.getRow(i);


        // Sets the Read data to the model class
        inventory.setInventoryId(i);
        inventory.setSaleManager(row.getCell(0) !=null ?row.getCell(0).getStringCellValue():"");
        inventory.setCommunity(row.getCell(1) !=null ?row.getCell(1).getStringCellValue():"");
        inventory.setCity(row.getCell(2) !=null ?row.getCell(2).getStringCellValue():"");
        inventory.setCounty(row.getCell(3) !=null ?row.getCell(3).getStringCellValue():"");
        inventory.setSchoolISD(row.getCell(4) !=null ?row.getCell(4).getStringCellValue():"");
        inventory.setAddress(row.getCell(5) !=null ?row.getCell(5).getStringCellValue():"");
        inventory.setStories(row.getCell(6) !=null ?getNumericDoubleValue(row.getCell(6)):0);
        inventory.setRooms(row.getCell(7) !=null ?(int)getNumericDoubleValue(row.getCell(7)).doubleValue():0);
        inventory.setBaths(row.getCell(8) !=null ?getNumericDoubleValue(row.getCell(8)):0.00);
        inventory.setGarageSize(row.getCell(9) !=null ?(int)row.getCell(9).getNumericCellValue():0);
        inventory.setDirection(row.getCell(10) !=null ?row.getCell(10).getStringCellValue():"");
        inventory.setHouseSize(row.getCell(11) !=null ?(int)row.getCell(11).getNumericCellValue():0);
        if(row.getCell(12) !=null) {
          inventory.setLotSize(row.getCell(12).getCellType() == CellType.STRING?row.getCell(16).getStringCellValue().trim() : String.valueOf(row.getCell(12).getNumericCellValue()));
        }
        inventory.setListPrice(row.getCell(13) !=null ?getNumericDoubleValue(row.getCell(13)):0.00);
        if(row.getCell(14) !=null) {
          inventory.setMlsListingId(row.getCell(14).getCellType() == CellType.STRING ?row.getCell(14).getStringCellValue():String.valueOf(row.getCell(14).getNumericCellValue()));
        }
        inventory.setStatus(row.getCell(15) !=null ?row.getCell(15).getStringCellValue().trim():"");
        inventory.setAvailable(row.getCell(16) !=null ?getStringValue(row.getCell(16)):"");
        inventory.setHoaFee(row.getCell(17) !=null ?getNumericDoubleValue(row.getCell(17)):0.00);
        inventoryList.add(inventory);
      }


      workbook.close();
      return inventoryList;
    } catch (Exception e) {
      System.out.println("Row "+i+ "has issue");
      e.printStackTrace();
    }
    return new ArrayList<>();
  }

  private static String getStringValue(XSSFCell cell) {
    if(cell.getCellType() == CellType.STRING){
      return cell.getStringCellValue();
    }else if( cell.getDateCellValue() !=null){
      DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

      // Get the date today using cell.getDateCellValue()
      Date today = cell.getDateCellValue();
      // Using DateFormat format method we can create a string
      // representation of a date with the defined format.
      String reportDate = df.format(today);
      return reportDate;
    }
    return "";
  }

  private static Double getNumericDoubleValue(XSSFCell cell) {
    if(cell.getCellType() == CellType.STRING){
      try {
        return Double.parseDouble(cell.getStringCellValue());
      }catch (Exception e){
        return 0.0;
      }
    }else {
      try {
        return cell.getNumericCellValue();
      }catch (Exception e) {
        return 0.0;
      }
    }
  }

  private static List<String> buildCellNames(XSSFSheet worksheet) {
    Row headerRow = worksheet.getRow(1);
    List<String> columnNames = new ArrayList<>();
    Iterator<Cell> cellIterator=headerRow.cellIterator();
    while(cellIterator.hasNext()){
      Cell cell = (Cell) cellIterator.next();
      String columnName = cell.getStringCellValue();
      if(StringUtils.isNotEmpty(columnName)){
        columnNames.add(columnName.trim());
      }
    }
  return columnNames;
  }


}