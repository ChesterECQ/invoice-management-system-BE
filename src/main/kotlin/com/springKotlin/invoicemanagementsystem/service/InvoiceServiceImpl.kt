package com.springKotlin.invoicemanagementsystem.service

import com.springKotlin.invoicemanagementsystem.dto.request.InvoiceRecordsRequestBody
import com.springKotlin.invoicemanagementsystem.dto.response.InvoiceResponseDto
import com.springKotlin.invoicemanagementsystem.repository.InvoiceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class InvoiceServiceImpl : InvoiceService {
    @Autowired
    private lateinit var invoiceRepository: InvoiceRepository
    override fun getInvoiceRecords(requestBody : InvoiceRecordsRequestBody): List<InvoiceResponseDto> {
        val invoiceRecords = mutableListOf<InvoiceResponseDto>()
        println(requestBody.searchVal)
        // Search value is empty
        if (requestBody.searchVal.isNullOrEmpty()) {
            val invoice = invoiceRepository.findAll()

            println("Im in this function")

            for (invoiceDetails in invoice) {
                val invoiceResponse = InvoiceResponseDto()

                println("this is the stockCode " + invoiceDetails.stockCode)

                invoiceResponse.id = invoiceDetails.id
                invoiceResponse.invoiceNo = invoiceDetails.invoiceNo
                invoiceResponse.stockCode = invoiceDetails.stockCode
                invoiceResponse.description = invoiceDetails.description
                invoiceResponse.quantity = invoiceDetails.quantity.toInt()
                invoiceResponse.invoiceDate = invoiceDetails.invoiceDate
                invoiceResponse.unitPrice = invoiceDetails.unitPrice.toDouble()
                invoiceResponse.customerId = invoiceDetails.customerId
                invoiceResponse.country = invoiceDetails.country

                invoiceRecords.add(invoiceResponse)
            }
            return(invoiceRecords)
        } else {
            val invoice = invoiceRepository.findBySearchVal(requestBody.searchVal.toString())
            println(invoice)
            println("with the search function")
            for (invoiceDetails in invoice) {
                val invoiceResponse = InvoiceResponseDto()

                println("this is the stockCode " + invoiceDetails.stockCode)

                invoiceResponse.id = invoiceDetails.id
                invoiceResponse.invoiceNo = invoiceDetails.invoiceNo
                invoiceResponse.stockCode = invoiceDetails.stockCode
                invoiceResponse.description = invoiceDetails.description
                invoiceResponse.quantity = invoiceDetails.quantity.toInt()
                invoiceResponse.invoiceDate = invoiceDetails.invoiceDate
                invoiceResponse.unitPrice = invoiceDetails.unitPrice.toDouble()
                invoiceResponse.customerId = invoiceDetails.customerId
                invoiceResponse.country = invoiceDetails.country

                invoiceRecords.add(invoiceResponse)
            }
        }

        return invoiceRecords
    }
}