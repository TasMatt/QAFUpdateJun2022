package com.application.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteAndReadFromExcel extends WebDriverTestCase {

    @QAFTestStep(description = "Update Test Cases in Excel")
    public void writeToExcel() throws IOException {

        Row forFromExcel;
        Cell testCaseFromExcel;
        String strTestResult;

        FileInputStream inputFile = new FileInputStream("C:\\Users\\MT\\Desktop\\TestCase.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int intTotalRow = sheet.getLastRowNum();

        for (int i = 1; i < intTotalRow+1; i++) {

            forFromExcel = sheet.getRow(i);
            testCaseFromExcel = forFromExcel.getCell(1);
            strTestResult = "Pass";

            testCaseFromExcel.setCellValue(strTestResult);

        }

        inputFile.close();

        FileOutputStream outFile = new FileOutputStream("C:\\Users\\MT\\Desktop\\TestCase.xlsx");
        workbook.write(outFile);
        outFile.close();

    }

    @QAFTestStep(description = "Read Test Cases in Excel")
    public void readFromExcel() throws IOException {

        Row forFromExcel;
        Cell testCaseFromExcel;
        String strTestResult;

        FileInputStream inputFile = new FileInputStream("C:\\Users\\MT\\Desktop\\TestCase.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
        XSSFSheet sheet = workbook.getSheetAt(0);
        forFromExcel = sheet.getRow(1);
        testCaseFromExcel = forFromExcel.getCell(1);

        strTestResult = String.valueOf(testCaseFromExcel);

        System.out.println(strTestResult);

    }

}
