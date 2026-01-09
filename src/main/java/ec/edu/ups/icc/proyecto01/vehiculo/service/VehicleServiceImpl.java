package ec.edu.ups.icc.proyecto01.vehiculo.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ec.edu.ups.icc.proyecto01.vehiculo.dtos.CreateVehiculoDTO;
import ec.edu.ups.icc.proyecto01.vehiculo.dtos.VehicleResponseDto;
import ec.edu.ups.icc.proyecto01.vehiculo.entity.VehicleEntity;
import ec.edu.ups.icc.proyecto01.vehiculo.mappers.VehicleMappers;
import ec.edu.ups.icc.proyecto01.vehiculo.repository.VehicleRepository;

    public class VehicleServiceImpl implements VehicleService {

        private final VehicleRepository vehicleRepository;

        public VehicleServiceImpl(VehicleRepository vehicleRepository) {
            this.vehicleRepository = vehicleRepository;
        }

        @Override
        public List<VehicleResponseDto> findAll() {
            return vehicleRepository.findAll()
                    .stream()
                    .map(this::toResponseDto)
                    .collect(Collectors.toList());
        }

        @Override
        public VehicleResponseDto findOne(Long id) {
            return vehicleRepository.findById(id)
                    .map(this::toResponseDto)
                    .orElseThrow(() -> new RuntimeException("Vehículo con id: " + id + " no encontrado"));
        }

        @Override
        public VehicleResponseDto create(VehicleResponseDto dto) {
            VehicleEntity entity = new VehicleEntity();
            entity.setBrand(dto.brand);
            entity.setModel(dto.model);
            entity.setPrice(dto.price);
            entity.setStock(dto.stock);
            VehicleEntity saved = vehicleRepository.save(entity);
            return toResponseDto(saved);
        }

        @Override
        public VehicleResponseDto partialUpdateStockDto(Long id, PartialUpdateStockDto dto) {
            VehicleEntity entity = vehicleRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));
            entity.setStock(dto.stock);
            VehicleEntity saved = vehicleRepository.save(entity);
            return toResponseDto(saved);
        }

        @Override
        public void delete(String model) {
            vehicleRepository.findByModel(model).ifPresent(entity -> {
                entity.setDeleted(true);
                vehicleRepository.save(entity);
            });
        }

        @Override
        public VehicleResponseDto update(Long id, VehicleResponseDto dto) {
            VehicleEntity entity = vehicleRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));
            entity.setBrand(dto.brand);
            entity.setModel(dto.model);
            entity.setPrice(dto.price);
            entity.setStock(dto.stock);
            VehicleEntity saved = vehicleRepository.save(entity);
            return toResponseDto(saved);
        }

        private VehicleResponseDto toResponseDto(VehicleEntity e) {
            VehicleResponseDto dto = new VehicleResponseDto();
            dto.id = e.getId();
            dto.brand = e.getBrand();
            dto.model = e.getModel();
            dto.price = e.getPrice();
            dto.stock = e.getStock();
            return dto;
        }

    }
