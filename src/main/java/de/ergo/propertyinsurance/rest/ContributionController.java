package de.ergo.propertyinsurance.rest;

import de.ergo.propertyinsurance.business.CalculateContributionService;
import de.ergo.propertyinsurance.business.MailService;
import de.ergo.propertyinsurance.model.OfferBody;
import de.ergo.propertyinsurance.model.PriceBody;
import de.ergo.propertyinsurance.model.Contribution;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class ContributionController {

    private final CalculateContributionService calculateContributionService;
    private final MailService mailService;

    public ContributionController(CalculateContributionService calculateContributionService, MailService mailService) {
        this.calculateContributionService = calculateContributionService;
        this.mailService = mailService;
    }

    @PostMapping(path = "/bike/contribution", produces = "application/json", consumes = "application/json")
    public ResponseEntity<List<Contribution>> getContributionBike(@RequestBody PriceBody priceBody) {
        return ResponseEntity.ok(calculateContributionService.calculateContributionBike(priceBody.getPrice()));
    }

    @PostMapping(path = "/smartphone/contribution", produces = "application/json", consumes = "application/json")
    public ResponseEntity<List<Contribution>> getContributionSmartphone(@RequestBody PriceBody priceBody) {
        return ResponseEntity.ok(calculateContributionService.calculateContributionSmartphone(priceBody.getPrice()));
    }

    @PostMapping(path = "/laptop/contribution", produces = "application/json", consumes = "application/json")
    public ResponseEntity<List<Contribution>> getContributionLaptop(@RequestBody PriceBody priceBody) {
        return ResponseEntity.ok(calculateContributionService.calculateContributionLaptop(priceBody.getPrice()));
    }

    @PostMapping(path = "/bike/offer", consumes = "application/json")
    public ResponseEntity<String> postBikeOffer(@RequestBody OfferBody offerBody) {
        List<Contribution> contributions = calculateContributionService.calculateContributionBike(offerBody.getPrice());
        mailService.sendKundenMessageAlexa("Fahrrad", offerBody.getPrice(), offerBody.getEmail(), contributions);
        return ResponseEntity.ok("Angebot versandt an " + offerBody.getEmail());
    }

    @PostMapping(path = "/smartphone/offer", consumes = "application/json")
    public ResponseEntity<String> postSmartphoneOffer(@RequestBody OfferBody offerBody) {
        List<Contribution> contributions = calculateContributionService.calculateContributionSmartphone(offerBody.getPrice());
        mailService.sendKundenMessageAlexa("Smartphone", offerBody.getPrice(), offerBody.getEmail(), contributions);
        return ResponseEntity.ok("Angebot versandt an " + offerBody.getEmail());
    }

    @PostMapping(path = "/laptop/offer", consumes = "application/json")
    public ResponseEntity<String> postLaptopOffer(@RequestBody OfferBody offerBody) {
        List<Contribution> contributions = calculateContributionService.calculateContributionLaptop(offerBody.getPrice());
        mailService.sendKundenMessageAlexa("Laptop", offerBody.getPrice(), offerBody.getEmail(), contributions);
        return ResponseEntity.ok("Angebot versandt an " + offerBody.getEmail());
    }
}