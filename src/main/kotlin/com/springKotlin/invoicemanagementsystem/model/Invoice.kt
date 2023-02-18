package com.springKotlin.invoicemanagementsystem.model

import lombok.NoArgsConstructor
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "Invoice")
@NoArgsConstructor
data class Invoice(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
