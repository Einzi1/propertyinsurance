package de.ergo.propertyinsurance.business;

import de.ergo.propertyinsurance.model.ContributionBike;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;

@Service
public class CalculateContributionService {

    public String calculateContributionStandard(double price, int duration) {
        return "calculationFinished";
    }

    public ContributionBike calculateContributionBike(double price) {
        double versicherungssumme = price * 0.9;
        double jahresbeitragNetto = versicherungssumme * 0.11055;
        double jahresbeitragBrutto = jahresbeitragNetto * 1.19;
        double monatsbeitrag = jahresbeitragBrutto / 12;

        return new ContributionBike(versicherungssumme, jahresbeitragBrutto, monatsbeitrag);
    }
}