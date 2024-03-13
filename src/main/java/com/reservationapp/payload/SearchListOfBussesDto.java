package com.reservationapp.payload;

import javax.persistence.Column;
import lombok.Data;

@Data
public class SearchListOfBussesDto {

    private Long busId;

    private String busNumber;

    private String busType;

    private double price;

    private int availableSeats;

    private Long routeId;

    private String fromLocation;

    private String toLocation;

    private String toDate;

    private String fromDate;

    private String fromTime;

    private String toTime;

    private String totalDuration;

}
