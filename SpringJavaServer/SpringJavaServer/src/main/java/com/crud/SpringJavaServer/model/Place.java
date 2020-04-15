package com.crud.SpringJavaServer.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "place_to_visit_db")
public class Place {

    private long id;
    private String placeName;
    private String description;
    private String coordinates;

    public Place() {

    }

    public Place(String placeName, String description, String coordinates) {
        this.placeName = placeName;
        this.description = description;
        this.coordinates = coordinates;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "place_name", nullable = false)
    public String getPlaceName() {
        return placeName;
    }
    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "email_address", nullable = false)
    public String getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Place [id=" + id + ", placeName=" + placeName + ", description=" + description + ", coordinates=" + coordinates
                + "]";
    }

}
