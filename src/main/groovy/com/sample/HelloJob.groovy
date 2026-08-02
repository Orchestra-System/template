package com.sample

import com.sample.service.PersonService
import ir.moke.orchestra.api.ModuleLogger
import ir.moke.orchestra.api.Task

class HelloJob implements Task {
    private static final ModuleLogger logger = ModuleLogger.getLogger(HelloJob)

    @Override
    void run() {
        logger.info("Job V0.2 Executed")
        PersonService.savePerson()
    }
}
