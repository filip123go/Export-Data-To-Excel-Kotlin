package com.stavros.readwriteexcel.readWriteToExcel

import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileInputStream
import java.io.IOException

class ReadFromExcelFile {

    var excelContents = ""

    @Throws(IOException::class)
    fun readFromExcel(): String {
        val excelFile = FileInputStream(File("customer.xlsx"))
        val workbook = XSSFWorkbook(excelFile)

        val sheet = workbook.getSheet("Customers")
        val rows = sheet.iterator()
        while (rows.hasNext()) {
            val currentRow = rows.next()
            val cellsInRow = currentRow.iterator()
            while (cellsInRow.hasNext()) {
                val currentCell = cellsInRow.next()
                if (currentCell.cellTypeEnum === CellType.STRING) {
                    excelContents = excelContents + currentCell.stringCellValue + " | "
                } else if (currentCell.cellTypeEnum === CellType.NUMERIC) {
                    excelContents = excelContents + currentCell.numericCellValue.toString() + "(numeric)" + System.lineSeparator()
                }
            }
        }

        workbook.close()
        excelFile.close()

        val sb = StringBuilder(excelContents);
        sb.insert(28, System.lineSeparator());
        return sb.toString();
    }
}
