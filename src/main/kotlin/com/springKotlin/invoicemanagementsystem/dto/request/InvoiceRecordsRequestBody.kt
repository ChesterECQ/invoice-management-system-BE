package com.springKotlin.invoicemanagementsystem.dto.request

import org.springframework.web.bind.annotation.RequestBody
data class InvoiceRecordsRequestBody (
    val searchVal : String?
)