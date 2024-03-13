package com.reservationapp.controller;

import com.reservationapp.entity.Bus;
import com.reservationapp.entity.Route;
import com.reservationapp.entity.SubRoute;
import com.reservationapp.payload.BusDto;
import com.reservationapp.payload.SearchListOfBussesDto;
import com.reservationapp.repository.BusRepository;
import com.reservationapp.repository.RouteRepository;
import com.reservationapp.repository.SubRouteRepository;
import com.reservationapp.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bus")  //http://localhost:8080/api/v1/bus
public class BusController {
    @Autowired
    private BusService busService;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private SubRouteRepository subRouteRepository;

    @Autowired
    private BusRepository busRepository;

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


    //http://localhost:8080/api/v1/bus?fromLocation=&toLocation=&fromDate=
    @GetMapping
    public List<?> getAllBuses(@RequestParam String fromLocation,
                                                   @RequestParam String toLocation,
                                                   @RequestParam String fromDate) {
        List<Route> routes = routeRepository.findByFromLocationAndToLocationAndFromDate(fromLocation, toLocation, fromDate);
        List<SubRoute> subRoutes = subRouteRepository.findByFromLocationAndToLocationAndFromDate(fromLocation, toLocation, fromDate);
        List<SearchListOfBussesDto> buses = new ArrayList<>();


        if (routes != null) {
            for (Route route : routes) {
                Bus bus = busRepository.findById(route.getBusId()).get();
                SearchListOfBussesDto searchListOfBussesDto = mapToSearchListOfBusesDto(bus, route);
                buses.add(searchListOfBussesDto);
            }
            return buses;
        }

        if (subRoutes != null) {
            for (SubRoute route : subRoutes) {
                Bus bus = busRepository.findById(route.getBusId()).get();
                SearchListOfBussesDto searchListOfBussesDto = mapToSearchListOfBusesDto(bus, route);
                buses.add(searchListOfBussesDto);
            }
            return buses;
        }



        return null;



    }

    SearchListOfBussesDto mapToSearchListOfBusesDto (Bus bus, Route route){
        SearchListOfBussesDto searchListOfBussesDto = new SearchListOfBussesDto();
        searchListOfBussesDto.setBusId(bus.getBusId());
        searchListOfBussesDto.setBusNumber(bus.getBusNumber());
        searchListOfBussesDto.setPrice(bus.getPrice());
        searchListOfBussesDto.setBusType(bus.getBusType());
        searchListOfBussesDto.setAvailableSeats(bus.getAvailableSeats());
        searchListOfBussesDto.setFromLocation(route.getFromLocation());
        searchListOfBussesDto.setToLocation(route.getToLocation());
        searchListOfBussesDto.setFromDate(route.getFromDate());
        searchListOfBussesDto.setToDate(route.getToDate());
        searchListOfBussesDto.setFromTime(route.getToTime());
        searchListOfBussesDto.setRouteId(route.getRouteId());
        searchListOfBussesDto.setToTime(route.getToTime());
        searchListOfBussesDto.setTotalDuration(route.getTotalDuration());

        return searchListOfBussesDto;
    }

    SearchListOfBussesDto mapToSearchListOfBusesDto (Bus bus, SubRoute route){
        SearchListOfBussesDto searchListOfBussesDto = new SearchListOfBussesDto();
        searchListOfBussesDto.setBusId(bus.getBusId());
        searchListOfBussesDto.setBusNumber(bus.getBusNumber());
        searchListOfBussesDto.setPrice(bus.getPrice());
        searchListOfBussesDto.setBusType(bus.getBusType());
        searchListOfBussesDto.setAvailableSeats(bus.getAvailableSeats());
        searchListOfBussesDto.setFromLocation(route.getFromLocation());
        searchListOfBussesDto.setToLocation(route.getToLocation());
        searchListOfBussesDto.setFromDate(route.getFromDate());
        searchListOfBussesDto.setToDate(route.getToDate());
        searchListOfBussesDto.setFromTime(route.getToTime());
        searchListOfBussesDto.setRouteId(route.getRouteId());
        searchListOfBussesDto.setToTime(route.getToTime());
        searchListOfBussesDto.setTotalDuration(route.getTotalDuration());

        return searchListOfBussesDto;

    }
}


