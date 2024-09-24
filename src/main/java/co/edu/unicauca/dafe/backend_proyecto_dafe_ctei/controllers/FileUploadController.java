package co.edu.unicauca.dafe.backend_proyecto_dafe_ctei.controllers;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import co.edu.unicauca.dafe.backend_proyecto_dafe_ctei.entities.Proyecto;
import co.edu.unicauca.dafe.backend_proyecto_dafe_ctei.services.IProyectoService;

import java.io.*;
import java.util.*;

@RestController
@RequestMapping("/api/files")
@CrossOrigin(origins={"http://localhost:4400","http://localhost:4200"})
public class FileUploadController {

    @Autowired
    private IProyectoService proyectoService;
    private Proyecto proyecto = new Proyecto();

    @SuppressWarnings("null")
    @PostMapping("/upload")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        Map<String, Object> respuesta = new HashMap<>();
        String content;
        try {
            if (file.getOriginalFilename().endsWith(".xlsx")) {
                content = handleExcelFile(file.getInputStream());
            } else if (file.getOriginalFilename().endsWith(".pdf")) {
                content = handlePdfFile(file.getInputStream());
            } else {
                respuesta.put("mensaje", "Formato de archivo no soportado");
                return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
            }

            //respuesta.put("proyecto", content);

            proyecto = this.proyectoService.parseContentToProyecto(content);
       
            this.proyectoService.save(proyecto);

            return new ResponseEntity<String>(content, HttpStatus.OK);

        } catch (DataAccessException e) {
            respuesta.put("mensaje", "Error al procesar archivo");
            respuesta.put("Error", e.getMessage() + " " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
           
        }
    }

    private String handleExcelFile(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (Workbook workbook = new XSSFWorkbook(inputStream)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            while (rows.hasNext()) {
                Row row = rows.next();
                row.forEach(cell -> sb.append(cell.toString()).append("\t"));
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private String handlePdfFile(InputStream inputStream) throws IOException {
        try (PDDocument document = PDDocument.load(inputStream)) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document);
        }
    }
}
