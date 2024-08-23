package org.factzoopia.sonarEvents.models;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    private Timestamp date;  

    @Column(name = "available")
    private Boolean available;

    @Column(name = "past")
    private Boolean past;

    @Column(name = "max_participants")
    private Integer maxParticipants;

    @Column(name = "registered_participants")
    private Integer registeredParticipants;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    public Event() {
        
    }

    public Event(Long id, String title, Timestamp date, Boolean available, Boolean past, Integer maxParticipants,
            Integer registeredParticipants, String description, String image) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.available = available;
        this.past = past;
        this.maxParticipants = maxParticipants;
        this.registeredParticipants = registeredParticipants;
        this.description = description;
        this.image = image;
    }

    public boolean hasEventPassed() {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        return this.date.before(currentTimestamp);
    }

    public boolean isEventAvailable() {
        return !this.past && this.available && this.registeredParticipants < this.maxParticipants;
    }

    public void registerParticipant() {
        if (isEventAvailable()) {
            this.registeredParticipants++;
            if (this.registeredParticipants >= this.maxParticipants) {
                this.available = false;
            }
        } else {
            throw new IllegalStateException("The event is not available for more participants.");
        }
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Boolean getPast() {
        return past;
    }

    public void setPast(Boolean past) {
        this.past = past;
    }

    public Integer getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(Integer maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public Integer getRegisteredParticipants() {
        return registeredParticipants;
    }

    public void setRegisteredParticipants(Integer registeredParticipants) {
        this.registeredParticipants = registeredParticipants;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}