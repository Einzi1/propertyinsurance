package de.ergo.propertyinsurance.rest;

import de.ergo.propertyinsurance.business.CalculateContributionService;
import de.ergo.propertyinsurance.model.BikeBody;
import de.ergo.propertyinsurance.model.ContributionBike;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class ContributionController {

    private final CalculateContributionService calculateContributionService;

    public ContributionController(CalculateContributionService calculateContributionService) {
        this.calculateContributionService = calculateContributionService;
    }

    @PostMapping(path = "/bike/contribution", produces = "application/json", consumes = "application/json")
    public ContributionBike getContributionBike(@RequestBody BikeBody bikeBody) {
        return calculateContributionService.calculateContributionBike(bikeBody.getPrice());
    }
}