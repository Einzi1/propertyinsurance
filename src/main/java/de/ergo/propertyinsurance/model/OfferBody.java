package de.ergo.propertyinsurance.model;

public class OfferBody {
    private double price;
    private String email;

    public OfferBody() {
    }

    public OfferBody(double price, String email) {
        this.price = price;
        this.email = email;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
