package tij.generics;

import java.util.Date;

/**
 * Created by zhaocaiwen on 2017/3/17.
 */
public class Automobile {
    private String brand;
    private Date manuDate;

    public Automobile(String brand) {
        this.brand = brand;
    }

    public Automobile() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getManuDate() {
        return manuDate;
    }

    public void setManuDate(Date manuDate) {
        this.manuDate = manuDate;
    }
}
