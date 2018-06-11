package ch.bfh.bti7081.blue.PMS.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePDF {

    public static File pfdGenerator(String name) {

        File file = new File(name + ".pdf");
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
        String title = "TEest";
        Font titleFont = new Font(Font.FontFamily.COURIER, 22, Font.BOLD, BaseColor.WHITE);
        Chunk titleObj = new Chunk(title, titleFont);
        titleObj.setBackground(new BaseColor(33, 33, 233), 1f, 1f, 1f, 3f);

        // List
        List list = new List(true, 30);
        list.add(new ListItem("Erstens"));
        list.add(new ListItem("Zweitens"));
        list.add(new ListItem("Drittens"));

        // Table
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.setSpacingAfter(10f);
        table.setSpacingBefore(15f);
        try {
			table.setWidths(new float[] { 2f, 2f });
		} catch (DocumentException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        Font fontHeader = new Font(Font.FontFamily.COURIER, 15, Font.BOLD, BaseColor.DARK_GRAY);
        PdfPCell headerCell = new PdfPCell(new Phrase("Überschrift 1", fontHeader));
        headerCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        headerCell.setPaddingBottom(5f);
        table.addCell(headerCell);
        headerCell = new PdfPCell(new Phrase("Überschrift 2", fontHeader));
        headerCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        headerCell.setPaddingBottom(5f);
        table.addCell(headerCell);
        table.addCell("Data 1");
        table.addCell("Data 2");
        table.addCell("Data 3");
        table.addCell("Data 4");

        // Document
        document.open();
        try {
			document.add(new Paragraph(""));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			document.add(Chunk.NEWLINE);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			document.add(titleObj);
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
			document.add(Chunk.NEWLINE);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			document.add(new Paragraph("Beispiel einer Liste"));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			document.add(list);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        document.newPage();
        try {
			document.add(table);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        document.close();

        System.out.println("done");
        
        return file;
    }
    
}
