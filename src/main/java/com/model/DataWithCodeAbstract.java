package com.model;

public abstract class DataWithCodeAbstract {

    String code;

    public DataWithCodeAbstract(){ }

    public DataWithCodeAbstract(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
