package com.stavros.readwriteexcel

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReadWriteExcelApplication

val writeToExcelFile: WriteToExcelFile = WriteToExcelFile()
fun main(args: Array<String>) {
    writeToExcelFile.writeToExcel()
    runApplication<ReadWriteExcelApplication>(*args)
}
