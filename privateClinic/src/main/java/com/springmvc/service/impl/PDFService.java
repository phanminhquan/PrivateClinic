package com.springmvc.service.impl;


import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.springmvc.dto.BenhNhanDTO;
import com.springmvc.dto.PhieuKhamDTO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public class PDFService {
    public void export(HttpServletResponse response, BenhNhanDTO benhnhan, PhieuKhamDTO phieuKhamDTO, List<Object[]> list) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());


        document.open();

        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        Paragraph paragraph = new Paragraph("PHIẾU THUỐC", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);

        Paragraph paragraph2 = new Paragraph("Họ tên: " + benhnhan.getHoTen(), fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);
        Paragraph paragraph5 = new Paragraph("Ngày Sinh: " + benhnhan.getNgaySinh(), fontParagraph);
        paragraph5.setAlignment(Paragraph.ALIGN_RIGHT);
        Paragraph paragraph3 = new Paragraph("Số điện thoại: " + benhnhan.getDienThoai(), fontParagraph);
        paragraph3.setAlignment(Paragraph.ALIGN_LEFT);
        Paragraph paragraph4 = new Paragraph("Chuẩn đoán: " + phieuKhamDTO.getChuanDoan(), fontParagraph);
        paragraph4.setAlignment(Paragraph.ALIGN_LEFT);


        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[]{3.0f, 2.0f, 2.0f});
        table.setSpacingBefore(10);

        PdfPCell cell = new PdfPCell();
        cell.setPadding(5);

        cell.setPhrase(new Phrase("Tên thuốc", fontParagraph));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Số lượng", fontParagraph));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Cách dùng", fontParagraph));
        table.addCell(cell);


//         write table row data
        for (Object[] obj : list) {
            table.addCell(obj[0].toString() + "-" + obj[1].toString());
            table.addCell(obj[2].toString());
            table.addCell(obj[3].toString());
        }


        document.add(paragraph5);
        document.add(paragraph);
        document.add(paragraph3);
        document.add(paragraph4);
        document.add(paragraph2);
        document.add(table);
        document.close();
    }
}
