package com.example.Sport.Dnevnik.Entity;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "training")
public class Training {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Temporal(TemporalType.TIME)
    private Date duration;

    @Temporal(TemporalType.DATE)
    private Date date;

    public Training(User user, Date duration, Date date, String name_training, String description, double distance) {
        this.user = user;
        this.duration = duration;
        this.date = date;
        this.name_training = name_training;
        this.description = description;
        this.distance = distance;
    }

    public Date getDuration() {
        return duration;
    }


    public void setDuration(Date duration) {
        this.duration = duration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Training() {
    }

    public Training(User user, String name_training, String description, double distance) {
        this.user = user;
        this.name_training = name_training;
        this.description = description;
        this.distance = distance;
    }

    private String name_training;
    private String description;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName_training() {
        return name_training;
    }

    public void setName_training(String name_training) {
        this.name_training = name_training;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Column(columnDefinition = "double default 0.0")
    private double distance ;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
