package de.ergo.propertyinsurance.business;

import de.ergo.propertyinsurance.model.Contribution;
import de.ergo.propertyinsurance.model.InsuranceEnquiry;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

    public void sendFachbereichMessage(InsuranceEnquiry insuranceEnquiry) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate currentDate = LocalDate.now();

        StringBuilder builder = new StringBuilder();
        builder.append("Hallo zusammen,\n\n")
                .append("am ")
                .append(dtf.format(currentDate))
                .append(" haben wir einen Antrag für eine Geräteversicherung erhalten. Diese muss geprüft werden und nachfolgend soll der " +
                        "Kunde informiert werden und ihm die Unterlagen zugeschickt werden.\n\n")
                .append("Kundendaten:\n\n")
                .append("Name: ")
                .append(insuranceEnquiry.getLastName())
                .append("\n")
                .append("Vorname: ")
                .append(insuranceEnquiry.getFirstName())
                .append("\n")
                .append("Geburtsdatum: ")
                .append(dtf.format(insuranceEnquiry.getBirthDate()))
                .append("\n")
                .append("Adresse: ")
                .append(insuranceEnquiry.getAddress())
                .append("\n")
                .append("PLZ: ")
                .append(insuranceEnquiry.getPostalCode())
                .append("\n")
                .append("Ort: ")
                .append(insuranceEnquiry.getCity())
                .append("\n")
                .append("E-Mail: ")
                .append(insuranceEnquiry.getEmail())
                .append("\n")
                .append("Telefon: ")
                .append(insuranceEnquiry.getPhoneNumber())
                .append("\n\nGegenstandsdaten:\n\n")
                .append("Gegenstand: ")
                .append(insuranceEnquiry.getProperty())
                .append("\n")
                .append("Kaufpreis: ")
                .append(insuranceEnquiry.getPrice())
                .append("\n")
                .append("gewünschte Laufzeit: ")
                .append(insuranceEnquiry.getContractDuration())
                .append(" Jahre");

        sendSimpleMessage("beitragsrechnerERGO@gmail.com", "Antrag für Geräteversicherung", builder.toString());
    }

    public void sendKundenMessage(InsuranceEnquiry insuranceEnquiry) {
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

    public void sendKundenMessageAlexa(String property, double price, String email, List<Contribution> contributions) {
        StringBuilder builder = new StringBuilder();
        builder.append("Sehr geehrte/r Alexa-NutzerInnen,")
                .append("\n\n")
                .append("wir haben Ihre Anfrage bezüglich einer Versicherung für Ihr ")
                .append(property)
                .append(" mit dem Kaufpreis ")
                .append(price)
                .append("€ ")
                .append(" erhalten.\n\n")
                .append("Dies sind Ihre Vertragsdetails: \n\n");

        for (int i = 0; i < contributions.size(); i++) {
            builder.append("Vertragsjahr ")
                    .append(i+1)
                    .append(":\n")
                    .append("Versicherungssumme: ")
                    .append(contributions.get(i).getVersicherungssumme())
                    .append("€")
                    .append("\n")
                    .append("Jahresbeitrag: ")
                    .append(contributions.get(i).getJahresBeitragbrutto())
                    .append("€")
                    .append("\n")
                    .append("Monatsbeitrag: ")
                    .append(contributions.get(i).getMonatsbetrag())
                    .append("€")
                    .append("\n\n");
        }

        builder.append("Freundliche Grüße\n")
                .append("Ihre ERGO");

        sendSimpleMessage(email, "Angebot für Ihre Geräteversicherung", builder.toString());
    }
}