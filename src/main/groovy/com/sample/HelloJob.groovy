package com.sample

import ir.moke.orchestra.api.Task

class HelloJob implements Task {
    @Override
    void run() {
        println "Job V0.1 Executed"
    }
}
