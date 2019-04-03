package de.ergo.propertyinsurance.model;

import java.math.BigDecimal;

public class Contribution {
    private BigDecimal versicherungssumme;
    private BigDecimal jahresBeitragbrutto;
    private BigDecimal monatsbetrag;

    public Contribution(BigDecimal versicherungssumme, BigDecimal jahresBeitragbrutto, BigDecimal monatsbetrag) {
        this.versicherungssumme = versicherungssumme;
        this.jahresBeitragbrutto = jahresBeitragbrutto;
        this.monatsbetrag = monatsbetrag;
    }

    public BigDecimal getVersicherungssumme() {
        return versicherungssumme;
    }

    public void setVersicherungssumme(BigDecimal versicherungssumme) {
        this.versicherungssumme = versicherungssumme;
    }

    public BigDecimal getJahresBeitragbrutto() {
        return jahresBeitragbrutto;
    }

    public void setJahresBeitragbrutto(BigDecimal jahresBeitragbrutto) {
        this.jahresBeitragbrutto = jahresBeitragbrutto;
    }

    public BigDecimal getMonatsbetrag() {
        return monatsbetrag;
    }

    public void setMonatsbetrag(BigDecimal monatsbetrag) {
        this.monatsbetrag = monatsbetrag;
    }
}