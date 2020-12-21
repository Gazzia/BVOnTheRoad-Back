package com.breizhvideo.ontheroad.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="village")
@Data
public class Village {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String postCode;
}
