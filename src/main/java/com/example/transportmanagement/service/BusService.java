package com.example.transportmanagement.service;

import com.example.transportmanagement.model.Bus;
import com.example.transportmanagement.repository.BusRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BusService {
    private final BusRepository busRepository;

    @Autowired
    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    public List<Bus> getAllBuses() {
        List<Bus> bus= busRepository.findAll();
        log.info("Получен список автобусов: {}", bus);
        return bus;
    }


    public Bus getBusById(Long id) {
        return busRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bus with ID " + id + " not found"));
    }

    public Bus saveBus(Bus bus) {
        if (busRepository.existsByNumber(bus.getNumber())) {
            throw new RuntimeException("Bus with number " + bus.getNumber() + " already exists");
        }
        return busRepository.save(bus);
    }

    public void deleteBus(Long id) {
        if (!busRepository.existsById(id)) {
            throw new RuntimeException("Bus with ID " + id + " not found");
        }
        busRepository.deleteById(id);
    }
}
