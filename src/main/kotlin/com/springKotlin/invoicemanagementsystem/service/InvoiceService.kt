package com.springKotlin.invoicemanagementsystem.service

import com.springKotlin.invoicemanagementsystem.dto.request.InvoiceRecordsRequestBody
import com.springKotlin.invoicemanagementsystem.dto.response.InvoiceResponseDto
import org.springframework.stereotype.Service

@Service
interface InvoiceService {
    fun getInvoiceRecords(requestBody: InvoiceRecordsRequestBody) : List<InvoiceResponseDto>
}