package com.example.Sport.Dnevnik.Entity;

import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "training")
public class Training {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    private String name_training;
    private String description;
    @Column(columnDefinition = "double default 0.0")
    private double distance ;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
