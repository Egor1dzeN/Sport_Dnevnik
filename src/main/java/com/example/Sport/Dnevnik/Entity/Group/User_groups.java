package com.example.Sport.Dnevnik.Entity.Group;


import com.example.Sport.Dnevnik.Entity.User;

import javax.persistence.*;

@Entity
@Table(name = "user_group")
public class User_groups {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    private Group group;

    private int status;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
