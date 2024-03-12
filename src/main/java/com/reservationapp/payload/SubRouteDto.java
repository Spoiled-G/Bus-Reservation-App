package com.reservationapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubRouteDto{
    private String fromLocation;
    private String toLocation;
    private String fromDate;
    private String toDate;
    private String fromTime;
    private String toTime;
    private String totalDuration;
}

