package com.reservationapp.payload;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;

public class UserRegistraionDto {
    private long id;
    private String email;
    private String name;
    private String password;


    private byte[] profilePicture;
}
