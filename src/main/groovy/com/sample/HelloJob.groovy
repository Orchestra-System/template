package com.sample

import com.sample.service.PersonService
import ir.moke.orchestra.api.Task
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class HelloJob implements Task {
    private static final Logger logger = LoggerFactory.getLogger(HelloJob)

    @Override
    void run() {
        logger.info("Job V0.2 Executed")
        PersonService.savePerson()
    }
}
