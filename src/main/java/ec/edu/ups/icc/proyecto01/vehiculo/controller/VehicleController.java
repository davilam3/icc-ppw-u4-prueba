package ec.edu.ups.icc.proyecto01.vehiculo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.ups.icc.proyecto01.vehiculo.dtos.PartialUpdateStockDto;
import ec.edu.ups.icc.proyecto01.vehiculo.dtos.VehicleResponseDto;
import ec.edu.ups.icc.proyecto01.vehiculo.service.VehicleService;


@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController (VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    //---- ENDPOINT 1 DE OBTENER TODOS LOS VEHICULOS ----//

    @GetMapping
    public List<VehicleResponseDto> findAll() {
        return vehicleService.findAll();
    }

    @GetMapping("/{id}")
    public VehicleResponseDto findOne(@PathVariable("id") Long id) {
        return vehicleService.findOne(id);
    }

    @PostMapping
    public ResponseEntity<VehicleResponseDto> create(
            @RequestBody VehicleResponseDto dto) {
        VehicleResponseDto created = vehicleService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    //---- ENDPOINT 3 DE OBTENER TODOS LOS VEHICULOS ----//


    @PutMapping("/delete/{model}")
    public VehicleResponseDto update(@PathVariable("id") Long id, @RequestBody VehicleResponseDto dto) {
        return vehicleService.update(id, dto);
    }


    //---- ENDPOINT 4 DE OBTENER TODOS LOS VEHICULOS ----//

    @PatchMapping("/stock")
    public VehicleResponseDto partialUpdate(@PathVariable("id") Long id, @RequestBody PartialUpdateStockDto dto) {
        return vehicleService.partialUpdateStockDto(id, dto);
    }


}
