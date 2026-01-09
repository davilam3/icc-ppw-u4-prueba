package ec.edu.ups.icc.proyecto01.vehiculo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.apache.coyote.BadRequestException;

import ec.edu.ups.icc.proyecto01.vehiculo.dtos.PartialUpdateStockDto;
import ec.edu.ups.icc.proyecto01.vehiculo.dtos.VehicleResponseDto;
import ec.edu.ups.icc.proyecto01.vehiculo.entity.VehicleEntity;

public class Vehicle {

    public Long id;
    public String brand;
    public String model;
    public double price;
    public Integer stock;
    public String delete;


    /**
     * Constructor básico para nuevos productos
     */

    public Vehicle(String brand, String model, double price, int stock) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.stock = stock;
    }


    public Vehicle(Double price, Integer stock) {

        if (price == null || price.compareTo(Double.valueOf(0.0)) < 0)
            throw new BadRequestException("Precio inválido");
        if (stock == null || stock < 0)
            throw new BadRequestException("Stock inválido");
        this.price = price;
        this.stock = stock;
    }

    /**
     * Crea un Vehicle desde una entidad persistente
     * 
     * @param entity Entidad recuperada de la BD
     * @return instancia de Vehicle para lógica de negocio
     */

    public static Vehicle fromEntity(VehicleEntity entity) {
        Vehicle vehicle = new Vehicle(
            entity.getBrand(),
            entity.getModel(),
            entity.getPrice(),
            entity.getStock()
        );
        vehicle.setId(entity.getId().intValue());
        return vehicle;
    }

    /**
     * Convierte este Vehicle a una entidad persistente
     * 
     * @return VehicleEntity lista para guardar en BD
     */

    public VehicleEntity toEntity() {
        VehicleEntity entity = new VehicleEntity();
        entity.setId(this.getId().longValue());
        entity.setBrand(this.getBrand());
        entity.setModel(this.getModel());
        entity.setPrice(this.getPrice());
        entity.setStock(this.getStock());
        return entity;
    }

      public VehicleResponseDto toResponseDto() {
        VehicleResponseDto dto = new VehicleResponseDto();
        dto.id = (long) this.id;
        dto.brand = this.brand;
        dto.model = this.model;
        dto.price = this.price;
        dto.stock = this.stock;
        return dto;
    }
    public Vehicle partialUpdate(PartialUpdateStockDto dto) {

        if (dto.id != null) {
            this.id = dto.id;
        }

        if (dto.stock != null) {
            this.stock = dto.stock;
        }

        return this;
    }




    // getters y setters
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}