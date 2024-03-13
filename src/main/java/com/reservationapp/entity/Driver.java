package com.reservationapp.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "driver_name")
    private String driverName;

    @Column(name = "licence_number", unique = true)
    private String licenceNumber;

    @Column(name = "adhar_number", unique = true)
    private String adharNumber;

    private String address;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "alternate_contact_number")
    private String alternateContactNumber;

    @Column(name = "email_id")
    private String emailId;




}
