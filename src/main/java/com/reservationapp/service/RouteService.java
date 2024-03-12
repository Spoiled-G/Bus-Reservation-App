package com.reservationapp.service;

import com.reservationapp.entity.Route;
import com.reservationapp.exception.ResourceNotFoundException;
import com.reservationapp.repository.BusRepository;
import com.reservationapp.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RouteService {
    @Autowired
    private BusRepository busRepository;


    @Autowired
    private RouteRepository routeRepository;


    public Route createRoute(long busId, Route route) {
        busRepository.findById(busId).orElseThrow(
                () -> new ResourceNotFoundException("Bus not added")
        );
        Route r = routeRepository.findByBusId(route.getBusId());

        if (r != null) {
            throw new ResourceNotFoundException("Route was already added");
        }
        if (r == null) {
            routeRepository.save(route);
            return route;
        }
return null;
    }

}
