package com.crud.SpringJavaServer.repository;

import com.crud.SpringJavaServer.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PlaceRepository extends JpaRepository<Place, Long>{

}