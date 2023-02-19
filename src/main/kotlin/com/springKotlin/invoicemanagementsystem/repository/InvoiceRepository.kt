package com.springKotlin.invoicemanagementsystem.repository

import com.springKotlin.invoicemanagementsystem.model.Invoice
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface InvoiceRepository : JpaRepository<Invoice, Long>{

    // Get all records from invoice table based on search value
    @Query("SELECT i FROM Invoice i "+
            "WHERE CONCAT(i.country, i.customerId, i.description, i.invoiceDate," +
            " i.invoiceNo, i.quantity, i.stockCode, i.unitPrice) LIKE %:searchVal%")
    fun findBySearchVal(searchVal: String) : List<Invoice>

}