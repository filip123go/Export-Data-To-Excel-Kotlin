package com.stavros.readwriteexcel.servise

import com.stavros.readwriteexcel.model.CustomerModel
import com.stavros.readwriteexcel.readWriteToExcel.WriteToExcelFile
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class GetJsonService {

    val writeToExcelFile:WriteToExcelFile = WriteToExcelFile()
    @PostMapping()
    fun getJsonRequest(@Valid @RequestBody customer:Array<CustomerModel>){
        writeToExcelFile.writeToExcel(customer)
    }
}