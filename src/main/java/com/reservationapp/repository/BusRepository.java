package com.reservationapp.repository;

import com.reservationapp.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Long> {
}
