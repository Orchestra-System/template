package com.sample

import com.sample.service.PersonService
import ir.moke.orchestra.api.Task

class HelloJob implements Task {
    @Override
    void run() {
        println "Job V0.1 Executed"
        PersonService.savePerson()
    }
}
