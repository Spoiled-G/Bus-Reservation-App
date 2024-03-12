package com.reservationapp.controller;

import com.reservationapp.entity.Route;
import com.reservationapp.payload.BusDto;
import com.reservationapp.repository.BusRepository;
import com.reservationapp.repository.RouteRepository;
import com.reservationapp.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bus")  //http://localhost:8080/api/v1/bus
public class BusController {
    @Autowired
    private BusService busService;

    @Autowired
    private RouteRepository routeRepository;

    @PostMapping("/add")   //http://localhost:8080/api/v1/bus/add
    public ResponseEntity<BusDto> addBus(@RequestBody BusDto busDto) throws ParseException {

        BusDto dto = busService.addBus(busDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

//    @GetMapping
//    public List<Route> searchBuses(
//            @RequestParam("fromLocation") String fromLocation,
//            @RequestParam("toLocation") String toLocation,
//            @RequestParam("fromDate") String fromDate) {
//        //routeRepository.findFromLocationAndToLocationAndFromDate
//        return null;
//    }


}


