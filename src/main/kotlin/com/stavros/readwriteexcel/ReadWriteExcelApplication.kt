package com.stavros.readwriteexcel

import com.stavros.readwriteexcel.readWriteToExcel.ReadFromExcelFile
import com.stavros.readwriteexcel.readWriteToExcel.WriteToExcelFile
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReadWriteExcelApplication

val writeToExcelFile: WriteToExcelFile = WriteToExcelFile()
val readFromExcelFile: ReadFromExcelFile = ReadFromExcelFile()
fun main(args: Array<String>) {
    //todo export json to Excel
    runApplication<ReadWriteExcelApplication>(*args)
}
