package de.ergo.propertyinsurance.model;

public class ContributionBike {
    private double versicherungssumme;
    private double jahresBeitragbrutto;
    private double monatsbetrag;

    public ContributionBike(double versicherungssumme, double jahresBeitragbrutto, double monatsbetrag) {
        this.versicherungssumme = versicherungssumme;
        this.jahresBeitragbrutto = jahresBeitragbrutto;
        this.monatsbetrag = monatsbetrag;
    }

    public double getVersicherungssumme() {
        return versicherungssumme;
    }

    public void setVersicherungssumme(double versicherungssumme) {
        this.versicherungssumme = versicherungssumme;
    }

    public double getJahresBeitragbrutto() {
        return jahresBeitragbrutto;
    }


    public void setJahresBeitragbrutto(double jahresBeitragbrutto) {
        this.jahresBeitragbrutto = jahresBeitragbrutto;
    }

    public double getMonatsbetrag() {
        return monatsbetrag;
    }

    public void setMonatsbetrag(double monatsbetrag) {
        this.monatsbetrag = monatsbetrag;
    }

}
