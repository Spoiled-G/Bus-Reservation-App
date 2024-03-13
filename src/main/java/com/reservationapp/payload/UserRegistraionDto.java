package com.reservationapp.payload;

import javax.persistence.Column;
import javax.persistence.Lob;

public class UserRegistraionDto {
    private long id;
    private String email;
    private String name;
    private String password;


    private byte[] profilePicture;
}
