package com.springKotlin.invoicemanagementsystem.controller

import com.springKotlin.invoicemanagementsystem.model.Invoice
import org.apache.commons.csv.CSVFormat
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.InputStream

@RestController
@RequestMapping("/api/csv")
class FileUploadController {
}