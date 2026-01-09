package ec.edu.ups.icc.proyecto01.vehiculo.mappers;

import ec.edu.ups.icc.proyecto01.vehiculo.dtos.CreateVehiculoDTO;
import ec.edu.ups.icc.proyecto01.vehiculo.dtos.VehicleResponseDto;
import ec.edu.ups.icc.proyecto01.vehiculo.model.Vehicle;

public class VehicleMappers {
    
    /**
     * Convierte un DTO de creación a un modelo Product
     */
    public static Vehicle fromCreateDto(CreateVehiculoDTO dto) {
        Vehicle vehicle = new Vehicle(dto.brand, dto.model, dto.price, dto.stock);
        return vehicle;
    }

    /**
     * Convierte un Vehicle a un DTO de respuesta
     * @param vehicle Modelo de dominio
     * @return DTO con los datos públicos del producto
     */
    public static VehicleResponseDto toResponse(Vehicle vehicle) {
        VehicleResponseDto dto = new VehicleResponseDto();
        dto.id = (long) vehicle.getId();
        dto.brand = vehicle.getBrand();
        dto.model = vehicle.getModel();
        dto.price = vehicle.getPrice();
        dto.stock = vehicle.getStock();
        return dto;
    }
}
