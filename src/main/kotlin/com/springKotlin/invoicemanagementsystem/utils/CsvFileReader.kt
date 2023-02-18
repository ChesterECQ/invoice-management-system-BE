package com.springKotlin.invoicemanagementsystem.utils

import com.springKotlin.invoicemanagementsystem.model.Invoice
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.springframework.web.multipart.MultipartFile
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class CsvFileReader {
    private val type: String = "text/csv"

    // Check if file has a csv format
    fun hasCSVFormat(file: MultipartFile): Boolean {
        if (type != file.contentType) {
            return false
        }
        return true
    }

    fun csvToInvoiceModel(`is`: InputStream): List<Invoice> {
        val fileReader = BufferedReader(InputStreamReader(`is`, "UTF-8"))
        val csvParser = CSVParser(
            fileReader, CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .withIgnoreHeaderCase()
                .withTrim()
        )
        val csvRecords = csvParser.records

        val invoiceList = arrayListOf<Invoice>()

        // to loop through records and initialise invoice objects
        for (csvRecord in csvRecords) {
            val invoiceDetails = Invoice()

            invoiceDetails.invoiceNo = csvRecord["invoiceNo"]
            invoiceDetails.stockCode = csvRecord["stockCode"]
            invoiceDetails.description = csvRecord["description"]
            invoiceDetails.quantity = csvRecord["quantity"].toInt()
            invoiceDetails.invoiceDate = csvRecord["invoiceDate"]
            invoiceDetails.unitPrice = csvRecord["unitPrice"].toDouble()
            invoiceDetails.customerId = csvRecord["customerId"]
            invoiceDetails.country = csvRecord["country"]

            // to go through validation checks
            // Check if invoiceNo is a valid long
            invoiceList.add(invoiceDetails)
        }

        // Closing the stream
        `is`.close()
        csvParser.close()

        return invoiceList
    }
}