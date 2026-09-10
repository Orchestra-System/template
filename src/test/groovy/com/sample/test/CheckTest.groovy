package com.sample.test


import org.junit.jupiter.api.*

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
    @Disabled
    void checkDisabled() {
        // this test is disabled
    }

}