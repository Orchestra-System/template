package com.sample.service

import com.sample.entity.Person
import ir.moke.orchestra.api.persistance.OptionalRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class PersonService {
    private static final Logger logger = LoggerFactory.getLogger(PersonService)
    private static final OptionalRepository<Person> repo = OptionalRepository.of(Person)

    static def savePerson() {
        Person p = new Person()
        p.name = "Mahdi"
        p.family = "Sheikh Hosseini"
        repo.save(p)
        logger.info("Save Person")
    }
}
