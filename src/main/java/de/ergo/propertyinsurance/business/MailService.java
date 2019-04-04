package de.ergo.propertyinsurance.business;

import de.ergo.propertyinsurance.model.InsuranceEnquiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private final JavaMailSender emailSender;

    public MailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    private void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    void sendFachbereichMessage(InsuranceEnquiry insuranceEnquiry) {
        sendSimpleMessage("beitragsrechnerERGO@gmail.com", "Test Betreff", "Das ist eine Testnachricht");
    }

    void sendKundenMessage(InsuranceEnquiry insuranceEnquiry) {
        StringBuilder builder = new StringBuilder();
        builder.append("Sehr geehrte/r ")
                .append(insuranceEnquiry.getSalutation())
                .append(" ")
                .append(insuranceEnquiry.getLastName())
                .append(",")
                .append("\n\n")
                .append("wir haben Ihren Antrag bezüglich einer Versicherung für Ihr ")
                .append(insuranceEnquiry.getProperty())
                .append(" mit dem Kaufpreis ")
                .append(insuranceEnquiry.getPrice())
                .append("€ ")
                .append("über die Vertragsdauer ")
                .append(insuranceEnquiry.getContractDuration())
                .append(" Jahre erhalten.\n\n")
                .append("Ein Sachbearbeiter prüft Ihren Antrag und wird sich zeitnah bei Ihnen melden!\n\n")
                .append("Freundliche Grüße\n")
                .append("Ihre ERGO");


        sendSimpleMessage(insuranceEnquiry.getEmail(), "Auftragsbestätigung für Ihre Geräteversicherung", builder.toString());
    }
}