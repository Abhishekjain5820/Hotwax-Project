package com.hotwax.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotwax.order.entities.PersonEntity;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, String> {

}
