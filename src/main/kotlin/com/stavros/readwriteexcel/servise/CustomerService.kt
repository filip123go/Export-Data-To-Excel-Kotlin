package com.stavros.readwriteexcel.servise

import com.stavros.readwriteexcel.model.CustomerModel
import com.stavros.readwriteexcel.readWriteToExcel.ReadFromExcelFile
import com.stavros.readwriteexcel.readWriteToExcel.WriteToExcelFile
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class CustomerService {

    val writeToExcelFile = WriteToExcelFile()
    val readFromExcelFile = ReadFromExcelFile()
    @PostMapping()
    fun writeJsonToExcel(@Valid @RequestBody customer: Array<CustomerModel>) {
        writeToExcelFile.writeToExcel(customer)
    }

    @GetMapping
    fun readExcelFile(): String {
        return readFromExcelFile.readFromExcel()
    }

}