package com.springKotlin.invoicemanagementsystem.model

import lombok.NoArgsConstructor
import javax.persistence.Column
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
    @Column (name = "id", unique = true)
    var id : Int,

    @Column (name = "invoiceNo")
    var invoiceNo : String,

    @Column (name = "stockCode")
    var stockCode : String,

    @Column (name = "description")
    var description : String,

    @Column (name = "quantity")
    var quantity : Int,

    @Column (name = "invoiceDate")
    var invoiceDate : String,

    @Column (name = "unitPrice")
    var unitPrice : Double,

    @Column (name = "customerId")
    var customerId : String,

    @Column (name = "country")
    var country : String
) {
    constructor() : this(0, "11111", "stockCode", "description",
        0, "date", 0.0, "customerId", "singapore")
}
