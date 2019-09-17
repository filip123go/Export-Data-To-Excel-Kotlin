package com.stavros.readwriteexcel.readWriteToExcel

import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileInputStream
import java.io.IOException

class ReadFromExcelFile {

    @Throws(IOException::class)
    fun readFromExcel() {
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
                    print(currentCell.stringCellValue + " | ")
                } else if (currentCell.cellTypeEnum === CellType.NUMERIC) {
                    print(currentCell.numericCellValue.toString() + "(numeric)")
                }
            }

            println()
        }

        workbook.close()
        excelFile.close()
    }
}