package com.springKotlin.invoicemanagementsystem.controller

import com.springKotlin.invoicemanagementsystem.dto.request.InvoiceRecordsRequestBody
import com.springKotlin.invoicemanagementsystem.dto.response.InvoiceResponseDto
import com.springKotlin.invoicemanagementsystem.service.InvoiceService
import lombok.extern.log4j.Log4j2
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
@RequestMapping("/api/invoice")
@Log4j2
class InvoiceController {
    @Autowired
    private lateinit var invoiceService: InvoiceService

    @PostMapping("/getInvoiceRecords")
    @ResponseBody
    fun getInvoiceRecords(@RequestBody requestBody : InvoiceRecordsRequestBody) : ResponseEntity <List<InvoiceResponseDto>> {
        val response = invoiceService.getInvoiceRecords(requestBody)

        return ResponseEntity<List<InvoiceResponseDto>>(response, HttpStatus.OK)
    }
}