package com.reservationapp.service;

import com.reservationapp.entity.Bus;
import com.reservationapp.entity.Route;
import com.reservationapp.entity.SubRoute;
import com.reservationapp.payload.BusDto;
import com.reservationapp.payload.RouteDto;
import com.reservationapp.payload.SubRouteDto;
import com.reservationapp.repository.BusRepository;

import com.reservationapp.repository.RouteRepository;
import com.reservationapp.repository.SubRouteRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private SubRouteRepository subRouteRepository;


    //@Transactional
    public BusDto addBus(BusDto busDto) {
        // Map BusDto to Bus entity manually
        Bus bus = new Bus();
        bus.setBusNumber(busDto.getBusNumber());
        bus.setBusType(busDto.getBusType());
        bus.setPrice(busDto.getPrice());
        bus.setTotalSeats(busDto.getTotalSeats());
        bus.setAvailableSeats(busDto.getAvailableSeats());
        // Other fields...

        // Save Bus entity
        Bus savedBus = busRepository.save(bus);



//        // Map RouteDto to Route entity manually
//        RouteDto routeDto = busDto.getRoute();
//        Route route = new Route();
//        route.setFromLocation(routeDto.getFromLocation());
//        route.setToLocation(routeDto.getToLocation());
//        route.setFromDate(routeDto.getFromDate());
//        route.setToDate(routeDto.getToDate());
//        route.setTotalDuration(routeDto.getTotalDuration());
//        route.setFromTime(routeDto.getFromTime());
//        route.setToTime(routeDto.getToTime());
//        // Other fields...
//
//        route.setBus(savedBus);
//
//        // Save Route entity
//        Route savedRoute = routeRepository.save(route);
//
//        // Map and save SubRoutes manually
//        List<SubRouteDto> subRoutesDto = routeDto.getSubRoutes();
//        List<SubRoute> subRoutes = subRoutesDto.stream()
//                .map(dto -> {
//                    SubRoute subRoute = new SubRoute();
//                    subRoute.setFromLocation(dto.getFromLocation());
//                    subRoute.setToLocation(dto.getToLocation());
//                    subRoute.setFromDate(dto.getFromDate());
//                    subRoute.setToDate(dto.getToDate());
//                    subRoute.setTotalDuration(dto.getTotalDuration());
//                    subRoute.setFromTime(dto.getFromTime());
//                    subRoute.setToTime(dto.getToTime());
//                    subRoute.setRoute(savedRoute);
//
//                    return subRoute;
//                })
//                .collect(Collectors.toList());
//
//        // Save SubRoutes
//        subRouteRepository.saveAll(subRoutes);

        // Map Bus entity back to BusDto manually
        BusDto savedBusDto = new BusDto();
        savedBusDto.setBusNumber(savedBus.getBusNumber());
        savedBusDto.setBusType(savedBus.getBusType());
        savedBusDto.setPrice(savedBus.getPrice());
        savedBusDto.setTotalSeats(savedBus.getTotalSeats());
        savedBusDto.setAvailableSeats(savedBus.getAvailableSeats());


        return savedBusDto;
    }


}