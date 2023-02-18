package com.springKotlin.invoicemanagementsystem.repository

import com.springKotlin.invoicemanagementsystem.model.Invoice
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InvoiceRepository : JpaRepository<Invoice, Long>{

    // Get all records from invoice table based on search value
}