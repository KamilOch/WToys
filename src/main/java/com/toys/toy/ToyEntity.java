package com.toys.toy;

import lombok.AccessLevel;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "toys")
@SequenceGenerator(name = "TOY_SEQ",sequenceName = "toy_id_seq", allocationSize = 1)
public class ToyEntity {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TOY_SEQ")
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String toyName;


}
