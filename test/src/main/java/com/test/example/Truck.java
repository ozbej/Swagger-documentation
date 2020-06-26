package com.test.example;

public class Truck extends Vehicle {
    private double payloadCapacity;
    private Trailer trailer;

    public Truck() {
    }

    public Truck(String make, String model, double payloadCapacity, Trailer trailer) {
        super(make, model);
        this.payloadCapacity = payloadCapacity;
        this.trailer = trailer;
    }

    public double getPayloadCapacity() {
        return payloadCapacity;
    }
    public void setPayloadCapacity(double payloadCapacity) {
        this.payloadCapacity = payloadCapacity;
    }

    public Trailer getTrailer() {
        return trailer;
    }

    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }
}
