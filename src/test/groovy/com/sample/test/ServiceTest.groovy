package com.sample.test

import com.sample.HelloJob
import com.sample.HelloWorldResources
import com.sample.service.PersonService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ServiceTest {

    @Test
    void checkPersonService() {
        def person = PersonService.savePerson("Ali")
        Assertions.assertEquals(person.getName(), "Ali")
    }

    @Test
    void checkJob() {
        def job = new HelloJob();
        Assertions.assertThrowsExactly(RuntimeException, job::run)
    }

    @Test
    void checkApi() {
        def hello = HelloWorldResources.sayHello("mohammad")
        Assertions.assertNull(hello.id)
    }
}