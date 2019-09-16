package com.stavros.readwriteexcel

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReadWriteExcelApplication

val writeToExcelFile: WriteToExcelFile = WriteToExcelFile()
fun main(args: Array<String>) {
    writeToExcelFile.writeToExcel()
    //todo read files from excel
    //todo export json to Excel
    runApplication<ReadWriteExcelApplication>(*args)
}
