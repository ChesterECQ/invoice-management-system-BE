package com.springKotlin.invoicemanagementsystem.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "Invoice")
data class Invoice(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id : Long,
    val invoiceNo : Long,
    val stockCode : String,
    val description : String,
    val quantity : Int,
    val invoiceDate : String,
    val unitPrice : Double,
    val customerId : String,
    val country : String
)
