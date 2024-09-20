package ci.digitalacademy.adamonapp.controller;

import ci.digitalacademy.adamonapp.services.SchoolService;
import ci.digitalacademy.adamonapp.services.TeacherService;
import ci.digitalacademy.adamonapp.services.UserService;
import ci.digitalacademy.adamonapp.services.dto.SchoolDTO;
import ci.digitalacademy.adamonapp.services.dto.TeacherDTO;
import ci.digitalacademy.adamonapp.services.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.itextpdf.layout.element.Paragraph;

import com.itextpdf.layout.Document;
import java.io.ByteArrayOutputStream;
import org.springframework.http.HttpHeaders;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.itextpdf.kernel.pdf.PdfWriter;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/reports")
public class ReportController {

    private final SchoolService schoolService;
    private final TeacherService teacherService;
    private final UserService userService;

    @GetMapping
    public String ShowReportPage(Model model) {

        List<TeacherDTO> teacherDTOS = teacherService.findAll();
        model.addAttribute("teacher",teacherDTOS);
        return "reports/default";
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadRapport(String option, String format) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        if ("pdf".equalsIgnoreCase(format)) {
            generatePdf(option, outputStream);
        } else if ("xlsx".equalsIgnoreCase(format)) {
            generateExcel(option, outputStream);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=rapport." + format);
        headers.setContentType("pdf".equalsIgnoreCase(format) ? MediaType.APPLICATION_PDF : MediaType.APPLICATION_OCTET_STREAM);

        return ResponseEntity.ok().headers(headers).body(outputStream.toByteArray());
    }

    private void generatePdf(String option, ByteArrayOutputStream outputStream) throws Exception {
        PdfWriter writer = new PdfWriter(outputStream);
        com.itextpdf.kernel.pdf.PdfDocument pdfDoc = new com.itextpdf.kernel.pdf.PdfDocument(writer);
        Document document = new Document(pdfDoc);

        if ("teachers".equalsIgnoreCase(option)) {
            List<TeacherDTO> teacherDTOS = teacherService.findAll();
            document.add(new Paragraph("Listes des élèves"));
            for (TeacherDTO teacher : teacherDTOS) {
                document.add(new Paragraph(teacher.getFirstName() + " - " + teacher.getLastName()));
            }
        } else if ("teachers".equalsIgnoreCase(option)) {
            List<TeacherDTO> teacherDTOS = teacherService.findAll();
            document.add(new Paragraph("Listes des professeurs"));
            for (TeacherDTO teacher : teacherDTOS) {
                document.add(new Paragraph(teacher.getFirstName() + " - " + teacher.getLastName()));
            }
        } else if ("users".equalsIgnoreCase(option)) {
            List<UserDTO> userDTOS = userService.findAll();
            document.add(new Paragraph("Listes des utilisateurs"));
            for (UserDTO user : userDTOS) {
                document.add(new Paragraph(user.getPseudo() + " - " + user.getCreationDate()));
            }
        }

        document.close();
    }


    private void generateExcel(String option, ByteArrayOutputStream outputStream) throws Exception {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(option);

        Row headerRow = sheet.createRow(0);
        if ("teachers".equalsIgnoreCase(option)) {
            List<TeacherDTO> teacherDTOS = teacherService.findAll();
            headerRow.createCell(0).setCellValue("Name");
            headerRow.createCell(1).setCellValue("Email");

            int rowIdx = 1;
            for (TeacherDTO teacher : teacherDTOS) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(teacher.getFirstName());
                row.createCell(1).setCellValue(teacher.getLastName());
            }
        } else if ("teachers".equalsIgnoreCase(option)) {
            List<TeacherDTO> teacherDTOS = teacherService.findAll();
            headerRow.createCell(0).setCellValue("Name");
            headerRow.createCell(1).setCellValue("Email");

            int rowIdx = 1;
            for (TeacherDTO teacher : teacherDTOS) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(teacher.getFirstName());
                row.createCell(1).setCellValue(teacher.getLastName());
            }
        } else if ("users".equalsIgnoreCase(option)) {
            List<UserDTO> userDTOS = userService.findAll();
            headerRow.createCell(0).setCellValue("Username");
            headerRow.createCell(1).setCellValue("Email");

            int rowIdx = 1;
            for (UserDTO user : userDTOS) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(user.getPseudo());
                row.createCell(1).setCellValue(Date.from(Instant.now()));
            }
        }

        workbook.write(outputStream);
        workbook.close();
    }
}
