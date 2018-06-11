package ch.bfh.bti7081.blue.PMS.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePDF {

    public static File pfdGenerator(Long id, String name, String date, String medizin) throws DocumentException {

        File file = new File(id + ".pdf");
        file.delete();
        Document document = new Document(PageSize.A4);
        try {
			PdfWriter.getInstance(document, new FileOutputStream(file));
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        document.open();
        document.addAuthor("Grid");

        // Title
        String title = "Rezept";
        Font titleFont = new Font(Font.FontFamily.COURIER, 40, Font.BOLD, BaseColor.BLACK);
        Chunk titleObj = new Chunk(title, titleFont);
       
        // Table
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setSpacingAfter(10f);
        table.setSpacingBefore(15f);
        try {
			table.setWidths(new float[] { 2f, 2f, 2f});
		} catch (DocumentException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        Font fontHeader = new Font(Font.FontFamily.COURIER, 15, Font.BOLD, BaseColor.DARK_GRAY);
        PdfPCell headerCell = new PdfPCell(new Phrase("Vor- und Nachname", fontHeader));
        headerCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        headerCell.setPaddingBottom(5f);
        table.addCell(headerCell);
        headerCell = new PdfPCell(new Phrase("Datum und Zeit der Bestellung", fontHeader));
        headerCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        headerCell.setPaddingBottom(5f);
        table.addCell(headerCell);
        headerCell = new PdfPCell(new Phrase("Medikament", fontHeader));
        headerCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        headerCell.setPaddingBottom(5f);
        table.addCell(headerCell);
        table.addCell(name);
        table.addCell(date);
        table.addCell(medizin);
      

        // Document
        document.open();
        document.open();
        document.add(new Paragraph(""));
        document.add(Chunk.NEWLINE);
        document.add(titleObj);
        document.add(Chunk.NEWLINE);
        document.add(table);
        document.add(new Paragraph(""));
        document.add(Chunk.NEWLINE);
        document.add(new Paragraph("Dr. med. Alain Keller\nFacharzt FMH für Allgemeine Innere Medizin\nMünzgraben 6\nCH-3011 Bern\nTel. 031 311 53 53\nkeller.alain@hin.ch "));
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        document.add(new Paragraph("Unterschrift"));
        document.close();
        document.close();

        return file;
    }
    
}
