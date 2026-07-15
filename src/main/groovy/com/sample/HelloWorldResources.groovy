package com.sample

import com.sample.entity.Person
import ir.moke.microfox.api.http.Chain
import ir.moke.microfox.api.http.Request
import ir.moke.microfox.api.http.Response
import ir.moke.orchestra.api.Orchestra
import jakarta.persistence.EntityManager
import orchestra.Environment

import java.util.function.Consumer

class HelloWorldResources {

    static def sayHello(Request request, Response response) {
        println "Environment Variable : " + Environment.name
        Person p = new Person()
        p.name = "ali"
        p.family = "mohammadi"
        Orchestra.jpa(Environment.DS_POSTGRESQL, { em -> em.persist(p) } as Consumer<EntityManager>)
        response.body("Hello World Module Working")
    }

    static def checkFilter(Request request, Response response, Chain chain) {
        println "Filter Called"
        chain.doFilter(request,response)
    }
}
