package com.springKotlin.invoicemanagementsystem.service

import com.springKotlin.invoicemanagementsystem.repository.InvoiceRepository
import com.springKotlin.invoicemanagementsystem.utils.CsvFileReader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.IOException

@Service
class FileUploadServiceImpl : FileUploadService {
    @Autowired
    private lateinit var invoiceRepository : InvoiceRepository
    override fun uploadFile(file: MultipartFile) {
        try{
            val invoices = CsvFileReader()

            val invoiceList = invoices.csvToInvoiceModel(file.inputStream)

            invoiceRepository.saveAll(invoiceList)
        } catch (e : IOException) {
            throw RuntimeException("fail to store csv data: " + e.message)
        }
    }
}