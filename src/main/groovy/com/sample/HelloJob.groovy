package com.sample

import ir.moke.microfox.api.job.Task

class HelloJob implements Task {
    @Override
    void run() {
        println "Job V0.1 Executed"
    }
}
