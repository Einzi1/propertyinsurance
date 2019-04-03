package de.ergo.propertyinsurance.rest;

import de.ergo.propertyinsurance.business.CalculateContributionService;
import de.ergo.propertyinsurance.model.PriceBody;
import de.ergo.propertyinsurance.model.Contribution;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ContributionController {

    private final CalculateContributionService calculateContributionService;

    public ContributionController(CalculateContributionService calculateContributionService) {
        this.calculateContributionService = calculateContributionService;
    }

    @PostMapping(path = "/bike/contribution", produces = "application/json", consumes = "application/json")
    public Contribution getContributionBike(@RequestBody PriceBody priceBody) {
        return calculateContributionService.calculateContributionBike(priceBody.getPrice());
    }


    @PostMapping(path = "/smartphone/contribution", produces = "application/json", consumes = "application/json")
    public List<Contribution> getContributionSmartphone(@RequestBody PriceBody priceBody) {
        return calculateContributionService.calculateContributionSmartphone(priceBody.getPrice());
    }

    @PostMapping(path = "/laptop/contribution", produces = "application/json", consumes = "application/json")
    public List<Contribution> getContributionaptop(@RequestBody PriceBody priceBody) {
        return calculateContributionService.calculateContributionLaptop(priceBody.getPrice());
    }
}