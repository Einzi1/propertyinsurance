package de.ergo.propertyinsurance.business;

import de.ergo.propertyinsurance.model.Contribution;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static java.util.List.of;

@Service
public class CalculateContributionService {

    public List<Contribution> calculateContributionSmartphone(double price) {
        double[] vsuFactors = new double[]{0.9, 0.7, 0.5};
        double[] jbnMultipliers = new double[]{0.11621, 0.107556, 0.101228};
        double[] jbnAdditions = new double[]{37.344, 33.414, 29.483};

        return calculateContributions(price, vsuFactors, jbnMultipliers, jbnAdditions, 3);
    }

    public List<Contribution> calculateContributionLaptop(double price) {
        double[] vsuFactors = new double[]{0.9, 0.7, 0.5, 0.3, 0.3};
        double[] jbnMultipliers = new double[]{0.088866, 0.082249, 0.07741, 0.077906, 0.077906};
        double[] jbnAdditions = new double[]{28.557, 25.552, 22.546, 19.539, 19.539};

        return calculateContributions(price, vsuFactors, jbnMultipliers, jbnAdditions, 5);
    }

    private List<Contribution> calculateContributions(double price, double[] vsuFactors, double[] jbnMultipliers, double[] jbnAdditions, int years) {
        List<Contribution> contributions = new ArrayList<>();

        for (int i = 0; i < years; i++) {
            BigDecimal versicherungssumme = BigDecimal.valueOf(price * vsuFactors[i]).setScale(2, RoundingMode.HALF_UP);
            BigDecimal jahresbeitragNetto = calculateJahresBeitragNetto(versicherungssumme, jbnMultipliers[i], jbnAdditions[i]);
            BigDecimal jahresbeitragBrutto = calculateJahresbeitragBrutto(jahresbeitragNetto);
            contributions.add(new Contribution(versicherungssumme, jahresbeitragBrutto, calculateMonatsbeitrag(jahresbeitragBrutto)));
        }

        return contributions;
    }


    public List<Contribution> calculateContributionBike(double price) {
        BigDecimal versicherungssumme = BigDecimal.valueOf(price * 0.9).setScale(2, RoundingMode.HALF_UP);
        BigDecimal jahresbeitragNetto = versicherungssumme.multiply(BigDecimal.valueOf(0.11055)).setScale(2, RoundingMode.HALF_UP);
        BigDecimal jahresbeitragBrutto = calculateJahresbeitragBrutto(jahresbeitragNetto);

        return of(new Contribution(versicherungssumme, jahresbeitragBrutto, calculateMonatsbeitrag(jahresbeitragBrutto)));
    }

    private BigDecimal calculateJahresbeitragBrutto(BigDecimal jahresbeitragNetto) {
        return jahresbeitragNetto.multiply(BigDecimal.valueOf(1.19)).setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateMonatsbeitrag(BigDecimal jahresBeitragBrutto) {
        return jahresBeitragBrutto.divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateJahresBeitragNetto(BigDecimal versicherungssumme, double multiplier, double addition) {
        return versicherungssumme.multiply(BigDecimal.valueOf(multiplier)).add(BigDecimal.valueOf(addition)).setScale(2, RoundingMode.HALF_UP);
    }
}