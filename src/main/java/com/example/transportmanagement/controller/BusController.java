package com.example.transportmanagement.controller;

import com.example.transportmanagement.model.Bus;
import com.example.transportmanagement.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus")
public class BusController {
    private final BusService busService;

    @Autowired
    public BusController(BusService busService) {
        this.busService = busService;
    }

    @GetMapping
    public List<Bus> getAllBuses() {
        return busService.getAllBuses();
    }

    @GetMapping("/{id}")
    public Bus getBusById(@PathVariable Long id) {
        return busService.getBusById(id);
    }

    @PostMapping
    public Bus addBus(@RequestBody Bus bus) {
        if (bus.getNumber() == null || bus.getCapacity() <= 0) {
            throw new RuntimeException("Invalid bus data");
        }
        return busService.saveBus(bus);
    }

    @DeleteMapping("/{id}")
    public String deleteBus(@PathVariable Long id) {
        busService.deleteBus(id);
        return "Bus with ID " + id + " deleted";
    }
}
