package com.test.example;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Car.class, name = "car"),
        @JsonSubTypes.Type(value = Truck.class, name = "truck")
})
public abstract class Vehicle {
    private String make;
    private String model;
    public Vehicle() {
    }
    protected Vehicle(String make, String model) {
        this.make = make;
        this.model = model;
    }
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String print() {
    	return "I am a vehicle";
    }
}
