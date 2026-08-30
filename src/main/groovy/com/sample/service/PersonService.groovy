package com.sample.service

import com.sample.entity.Person
import ir.moke.orchestra.api.ModuleLogger
import ir.moke.orchestra.api.persistance.OptionalRepository

class PersonService {
    private static final ModuleLogger logger = ModuleLogger.getLogger(PersonService)
    private static final OptionalRepository<Person> repo = OptionalRepository.of(Person)

    static Person savePerson(String name) {
        Person p = new Person()
        p.name = name
        repo.save(p)
        logger.info("Save Person {}", name)

        return p
    }

    static def removePerson(long id) {
        def person = repo.find(id)
        if (person != null) repo.remove(person)
        logger.info("Remove Person {}", id)
    }
}
