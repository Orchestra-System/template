package com.sample.entity


import jakarta.persistence.*

@Entity
@Table(name = "person")
class Person {
    @Id
    @SequenceGenerator(name = "person_seq", sequenceName = "default_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    Long id
    String name
    String family
}
