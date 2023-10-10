package com.example.Sport.Dnevnik.Entity.Group;


import com.example.Sport.Dnevnik.Entity.User;

import javax.persistence.*;

@Entity
@Table(name = "user_group")
public class User_groups {

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    private Group group;

    public User_groups(User user, Group group, int status) {
        this.user = user;
        this.group = group;
        this.status = status;
    }

    private int status;

    public User_groups() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
