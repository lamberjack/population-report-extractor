package com.model;

/**
 * Represent a municipality data.
 */
public class Municipality extends DataWithCodeAbstract {

    private String name;

    private String city;

    private String region;

    public Municipality(){ }

    public Municipality(String code, String name, String city, String region) {
        super(code);
        this.name = name;
        this.city = city;
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
