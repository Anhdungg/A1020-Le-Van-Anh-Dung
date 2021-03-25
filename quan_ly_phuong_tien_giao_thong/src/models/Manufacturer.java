package models;

public class Manufacturer {
    private String idProduct;
    private String manufacturerName;
    private String countryName;

    public Manufacturer(String idProduct, String manufacturerName, String countryName) {
        this.idProduct = idProduct;
        this.manufacturerName = manufacturerName;
        this.countryName = countryName;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
