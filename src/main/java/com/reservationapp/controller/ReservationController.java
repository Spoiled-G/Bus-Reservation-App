package com.reservationapp.controller;

import com.itextpdf.text.DocumentException;
import com.reservationapp.entity.Bus;
import com.reservationapp.entity.Passenger;
import com.reservationapp.entity.Route;
import com.reservationapp.entity.SubRoute;
import com.reservationapp.payload.ReservationDto;
import com.reservationapp.repository.BusRepository;
import com.reservationapp.repository.PassengerRepository;
import com.reservationapp.repository.RouteRepository;
import com.reservationapp.repository.SubRouteRepository;
import com.reservationapp.util.EmailService;
import com.reservationapp.util.ExcelGeneratorService;
import com.reservationapp.util.PdfGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/reservation")
public class ReservationController {

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private SubRouteRepository subRouteRepository;

    @Autowired
    private PdfGenerator pdfGenerator;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ExcelGeneratorService excelGeneratorService;


    @PostMapping  //https://localhost:8080/api/v1/reservation?busId=2&routeId=2
    public ResponseEntity<String> bookTicket(
            @RequestParam long busId,
            @RequestParam long routeId,
            @RequestBody Passenger passenger

    ){

        boolean busIsPresent=false;
        boolean routeIsPresent = false;
        boolean subRouteIsPresent=false;
        Optional<Bus> byId = busRepository.findById(busId);

          if (byId.isPresent()){
              busIsPresent=true;
              Bus bus = byId.get();
          }


        Optional<Route> byRouteId = routeRepository.findById(routeId);
          if (byRouteId.isPresent()){
              routeIsPresent=true;
              Bus bus = byId.get();
          }

        Optional<SubRoute> bySubRouteId = subRouteRepository.findById(routeId);
        if (bySubRouteId.isPresent()){
            subRouteIsPresent=true;
            Bus bus = byId.get();
        }
        if (busIsPresent&&routeIsPresent || busIsPresent&&subRouteIsPresent){
            //add passenger
            Passenger p = new Passenger();
            p.setFirstName(passenger.getFirstName());
            p.setLastName(passenger.getLastName());
            p.setEmail(passenger.getEmail());
            p.setMobile(passenger.getMobile());
            p.setRouteId(routeId);
            p.setBusId(busId);
            Passenger savedPassenger = passengerRepository.save(p);
            try {
                byte[] pdfBytes = pdfGenerator.generateTicket(savedPassenger, byRouteId.get().getFromLocation(), byRouteId.get().getToLocation(), byRouteId.get().getFromDate(), byRouteId.get().getFromDate());
                emailService.sendEmailWithAttachment(passenger.getEmail(),"Booking Confirmation","Your Reservation id: "+savedPassenger.getPassengerId(),pdfBytes,"ticket.pdf");
            } catch (DocumentException e) {
                throw new RuntimeException(e);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        }

        return new ResponseEntity<>("Done..!!!", HttpStatus.CREATED);

    }

    @GetMapping("/generate-excel")
    public ResponseEntity<byte[]> generateExcel() throws IOException {
        List<Passenger> passengers = fetchPassengersFromDatabase();
        byte[] excelBytes = excelGeneratorService.generateExcel(passengers);

        // Set response headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "passengers.xlsx");

        // Return the Excel file as a byte array
        return new ResponseEntity<>(excelBytes,headers,HttpStatus.OK);
    }

    private List<Passenger> fetchPassengersFromDatabase() {
        return passengerRepository.findAll();
    }
}


