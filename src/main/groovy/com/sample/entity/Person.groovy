package com.sample.entity


import jakarta.persistence.*

@Entity
@Table(name = "person")
class Person {
    @Id
    @SequenceGenerator(name = "default_seq", sequenceName = "person_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_seq")
    Long id
    String name
    String family
}
