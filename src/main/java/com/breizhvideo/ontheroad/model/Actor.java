package com.breizhvideo.ontheroad.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="actor")
public class Actor {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    public Date firstName;

    @Column(name="last_name")
    public Date lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFirstName() {
        return firstName;
    }

    public void setFirstName(Date firstName) {
        this.firstName = firstName;
    }

    public Date getLastName() {
        return lastName;
    }

    public void setLastName(Date lastName) {
        this.lastName = lastName;
    }
}
