package com.sample


import com.sample.service.PersonService
import ir.moke.microfox.api.http.Chain
import ir.moke.microfox.api.http.Request
import ir.moke.microfox.api.http.Response
import orchestra.Environment

class HelloWorldResources {

    static def sayHello(Request request, Response response) {
        println "Environment Variable : " + Environment.name
        PersonService.savePerson()
        response.body("Hello World Module Working")
    }

    static def checkFilter(Request request, Response response, Chain chain) {
        println "Filter Called"
        chain.doFilter(request, response)
    }
}
