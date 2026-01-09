package ec.edu.ups.icc.proyecto01.vehiculo.service;

import java.util.List;

import ec.edu.ups.icc.proyecto01.vehiculo.dtos.PartialUpdateStockDto;
import ec.edu.ups.icc.proyecto01.vehiculo.dtos.VehicleResponseDto;

public interface VehicleService {

    List<VehicleResponseDto> findAll();
    VehicleResponseDto findOne(Long id);
    VehicleResponseDto create(VehicleResponseDto dto);
    VehicleResponseDto partialUpdateStockDto(Long id, PartialUpdateStockDto dto);
    void delete(String model);
    VehicleResponseDto update(Long id, VehicleResponseDto dto);

}
