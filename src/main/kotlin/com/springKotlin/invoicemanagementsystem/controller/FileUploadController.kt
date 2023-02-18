package com.springKotlin.invoicemanagementsystem.controller

import com.springKotlin.invoicemanagementsystem.dto.response.FileUploadResponseDto

import com.springKotlin.invoicemanagementsystem.service.FileUploadService
import com.springKotlin.invoicemanagementsystem.utils.CsvFileReader

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile

@RestController
@CrossOrigin
@RequestMapping("/api/csv")
class FileUploadController {

    @Autowired
    private lateinit var fileUploadService: FileUploadService

    @Transactional
    @PostMapping("/upload")
    @ResponseBody
    fun uploadFile(@RequestParam("file") file: MultipartFile): ResponseEntity<FileUploadResponseDto> {
        var message: String
        var statusCode = HttpStatus.BAD_REQUEST
        val csvFileReader = CsvFileReader()

        if (csvFileReader.hasCSVFormat(file)) {
            try {
                fileUploadService.uploadFile(file)

                message = "File uploaded successfully!"
                statusCode = HttpStatus.OK
                return ResponseEntity.status(HttpStatus.OK).body(FileUploadResponseDto(message, statusCode.toString()))

            } catch (e: IllegalArgumentException) {
                message = "Failed Validation, File upload failed!"
                statusCode = HttpStatus.BAD_REQUEST
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(FileUploadResponseDto(message, statusCode.toString()))

            } catch (e: Exception) {

                message = "File upload failed!"
                statusCode = HttpStatus.BAD_REQUEST
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(FileUploadResponseDto(message, statusCode.toString()))
            }
        }

        message = "File type does not match csv file format, please upload a csv file!"

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(FileUploadResponseDto(message, statusCode.toString()))
    }
}
