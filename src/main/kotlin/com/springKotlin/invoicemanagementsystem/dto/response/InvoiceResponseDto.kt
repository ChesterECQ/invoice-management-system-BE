package com.springKotlin.invoicemanagementsystem.dto.response

import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@Getter
@Setter
data class InvoiceResponseDto (
    var id : Int,
    var invoiceNo : String,
    var stockCode : String,
    var description : String,
    var quantity : Int,
    var invoiceDate : String,
    var unitPrice : Double,
    var customerId : String,
    var country : String
) {
    constructor() : this(0, "11111", "stockCode", "description",
        0, "date", 0.0, "customerId", "singapore")
}