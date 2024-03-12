package com.reservationapp.controller;

import com.reservationapp.entity.Route;
import com.reservationapp.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/route")
public class RouteController {

    @Autowired
    private RouteService routeService;


    @PostMapping("/{busId}")
    public ResponseEntity<Route> addRoute(@PathVariable long busId, @RequestBody Route route){
        Route route1 = routeService.createRoute(busId , route);
        return  new ResponseEntity<>(route1, HttpStatus.CREATED);
    }
}
