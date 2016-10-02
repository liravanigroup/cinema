package pl.com.bottega.cinema.domain;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import pl.com.bottega.cinema.api.PdfGenerator;


import java.io.ByteArrayOutputStream;

/**
 * Created by Admin on 01.10.2016.
 */

@Service
public class ImMemoryPDFGenerator implements PdfGenerator{

    public byte[] getReservationInPDF(Reservation reservation) {
        Document document = new Document(PageSize.A8, 25, 25, 25, 25);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, out);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        document.open();
        setMetadata(document, reservation);
        setContent(document, reservation);
        document.close();
        return out.toByteArray();
    }

    private void setContent(Document document, Reservation reservation) {
        Paragraph paragraph = new Paragraph();
        paragraph.add(new Chunk(reservation.getShow().getMovie().getTitle()));

        paragraph.add(new Chunk(reservation.getSeats().toString()));

        paragraph.add(new Chunk(reservation.getShow().getDate().toString()));
        paragraph.add(new Chunk(reservation.getShow().getTime().toString()));

        paragraph.add(new Chunk(reservation.getShow().getMovie().getLength().toString()));
        try {
            document.add(paragraph);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private void setMetadata(Document document, Reservation reservation) {
        document.addTitle("Tickets for");
        document.addSubject("Tickets paiment");
        document.addKeywords("movie, email");
        document.addAuthor("Cinema Lublin");
        document.addCreator("John Doe");
    }

}
