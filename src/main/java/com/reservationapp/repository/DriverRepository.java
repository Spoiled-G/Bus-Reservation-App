package com.reservationapp.repository;

import com.reservationapp.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver,Long> {
}
