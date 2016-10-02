package pl.com.bottega.cinema.infrastructure;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.com.bottega.cinema.api.EmailFacade;
import pl.com.bottega.cinema.domain.PDFGenerator;
import pl.com.bottega.cinema.domain.Reservation;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by bernard.boguszewski on 01.10.2016.
 */
@AllArgsConstructor
@NoArgsConstructor
@Service
public class EmailFacadeImpl implements EmailFacade {

    private MailSender mailSender;
    private SimpleMailMessage templateMessage;
    private JavaMailSenderImpl javaMailSender;
    private PDFGenerator pdfGenerator;

    @Override
    public void sendTickets(Reservation reservation) {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(msg, true);
            helper.setTo(reservation.getCustomer().getEmail());
            msg.setText("Hi, there is ticket bought in our cinema!");
            ByteArrayResource byteArrayResource = new ByteArrayResource(pdfGenerator.getReservationInPDF(reservation));
            helper.addAttachment("Ticket" + reservation.getId().toString() + ".pdf", byteArrayResource, "application/pdf");
            javaMailSender.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
