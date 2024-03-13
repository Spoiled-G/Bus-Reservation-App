package com.reservationapp.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.reservationapp.entity.Passenger;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
@Service
public class PdfGenerator {
    public  byte[] generateTicket(Passenger passenger, String fromLocation, String toLocation, String fromDate, String toDate) throws DocumentException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, outputStream);
        document.open();

        // Add content to the PDF
        document.add(new Paragraph("Passenger Details:"));
        document.add(new Paragraph("First Name: " + passenger.getFirstName()));
        document.add(new Paragraph("Last Name: " + passenger.getLastName()));
        document.add(new Paragraph("Email: " + passenger.getEmail()));
        document.add(new Paragraph("Mobile: " + passenger.getMobile()));
        document.add(new Paragraph("Bus ID: " + passenger.getBusId()));
        document.add(new Paragraph("Route ID: " + passenger.getRouteId()));
        document.add(new Paragraph("From: " + fromLocation));
        document.add(new Paragraph("To: " + toLocation));
        document.add(new Paragraph("From Date: " + fromDate));
        document.add(new Paragraph("To Date: " + toDate));


        // Add more details as needed

        document.close();
        return outputStream.toByteArray();
    }
}
