package com.reservationapp.repository;

import com.reservationapp.entity.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegistrationRepository extends JpaRepository<UserRegistration,Long> {
}
