package com.springKotlin.invoicemanagementsystem.service

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
interface FileUploadService {
    fun uploadFile (file : MultipartFile)
}