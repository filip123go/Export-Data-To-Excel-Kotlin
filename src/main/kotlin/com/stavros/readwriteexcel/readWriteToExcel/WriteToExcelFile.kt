package com.stavros.readwriteexcel.readWriteToExcel
import com.stavros.readwriteexcel.model.CustomerModel
import java.io.IOException
import org.apache.poi.ss.usermodel.IndexedColors
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.FileOutputStream

class WriteToExcelFile {
    private val excelColumns = arrayOf("Id", "Name" , "Address" , "Age")
    private val customers = listOf(
            CustomerModel("1", "John Shena", "Lilip 13", 30),
            CustomerModel("2", "Adele Jackson", "yutir 15", 27),
            CustomerModel("3", "Katherin Carter", "Latsiou 14", 26),
            CustomerModel("4", "Jack York", "Nevadas 22", 33),
            CustomerModel("5", "Jason Bourne", "Californias 345", 36))

    @Throws(IOException::class)
    fun writeToExcel(customerArray:Array<CustomerModel>) {
        val excelWorkBook = XSSFWorkbook()
        val createHelper = excelWorkBook.creationHelper

        val sheet = excelWorkBook.createSheet("Customers")

        val headerFont = excelWorkBook.createFont()
        headerFont.color = IndexedColors.BLUE.getIndex()
        headerFont.bold

        val  headerCellStyle = excelWorkBook.createCellStyle()
        headerCellStyle.setFont(headerFont)

        val headerRow= sheet.createRow(0) //initialize 1st row

        //create 1st row
        for (col in excelColumns.indices){
            val cell = headerRow.createCell(col)
            cell.setCellValue(excelColumns[col])
            cell.cellStyle = headerCellStyle
        }

        //cell style for age
        val ageCellStyle= excelWorkBook.createCellStyle()
        ageCellStyle.dataFormat = createHelper.createDataFormat().getFormat("#")

        var rowIndex = 1
        for (customer in customerArray){
            val row = sheet.createRow(rowIndex++)
            row.createCell(0).setCellValue(customer.id)
            row.createCell(1).setCellValue(customer.name)
            row.createCell(2).setCellValue(customer.address)
            val ageCell = row.createCell(3)
            customer.age?.toDouble()?.let { ageCell.setCellValue(it) }
            ageCell.cellStyle = ageCellStyle
        }

        val generatedExcelFile = FileOutputStream("customer.xlsx")
        excelWorkBook.write(generatedExcelFile)
        excelWorkBook.close()
    }
}