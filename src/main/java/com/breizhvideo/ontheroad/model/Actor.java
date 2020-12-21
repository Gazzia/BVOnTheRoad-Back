package com.breizhvideo.ontheroad.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="actor")
@Data
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String firstName;

    public String lastName;

    @ManyToMany(mappedBy = "actors")
    @JsonIgnore
    private List<Film> films;
}
