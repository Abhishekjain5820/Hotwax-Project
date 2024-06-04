package com.hotwax.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotwax.order.entities.OrderHeaderEntity;

@Repository
public interface OrderHeaderRepository extends JpaRepository<OrderHeaderEntity, String> {

}
