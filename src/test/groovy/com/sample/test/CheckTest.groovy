package com.sample.test

import com.sample.service.PersonService
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class CheckTest {

    @BeforeAll
    static void doBeforeAll() {
        println "Start test"
    }

    @AfterAll
    static void doAfterAll() {
        println "All test evaluated"
    }

    @AfterEach
    void doAfterEach() {
        println "Unit test completed"
    }

    @Test
    void checkString() {
        Assertions.assertEquals("name", "name");
    }

    @Test
    void checkException() {
        throw new RuntimeException("Oh nooo !")
    }

    @Test
    void checkPersonService() {
        def person = PersonService.savePerson("Ali")
        Assertions.assertEquals(person.getName(), "Ali")
    }

    @Test
    @Disabled
    void checkDisabled() {
        // this test is disabled
    }

}