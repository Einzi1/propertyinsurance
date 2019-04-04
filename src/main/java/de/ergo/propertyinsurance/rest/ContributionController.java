package de.ergo.propertyinsurance.rest;

import de.ergo.propertyinsurance.business.CalculateContributionService;
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

    public ContributionController(CalculateContributionService calculateContributionService) {
        this.calculateContributionService = calculateContributionService;
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
}