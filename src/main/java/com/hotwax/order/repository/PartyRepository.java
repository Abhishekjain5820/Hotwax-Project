package com.hotwax.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotwax.order.entities.PartyEntity;


@Repository
public interface PartyRepository extends JpaRepository<PartyEntity, String> {

}
