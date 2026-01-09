
package ec.edu.ups.icc.proyecto01.vehiculo.entity;

import ec.edu.ups.icc.proyecto01.core.entities.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicles")
public class VehicleEntity extends BaseModel {

    @Column(nullable = false, length = 150)
    private String brand;

    @Column(nullable = false, length = 150)
    private String model;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer stock;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

}