package com.sample

import com.sample.entity.Person
import com.sample.service.PersonService
import ir.moke.microfox.api.http.Chain
import ir.moke.microfox.api.http.Request
import ir.moke.microfox.api.http.Response
import ir.moke.microfox.api.http.annotation.Path
import ir.moke.microfox.api.http.annotation.PathParam
import ir.moke.microfox.api.http.annotation.QueryParam
import ir.moke.orchestra.api.ModuleLogger
import ir.moke.orchestra.api.annotation.Rest

@Rest
@Path("/api")
class HelloWorldResources {
    private static final ModuleLogger logger = ModuleLogger.getLogger(HelloWorldResources)

    @Path("/hello/{name}")
    static Person sayHello(@PathParam("name") String name) {
        logger.info("Save new person {}", name)
        def person = PersonService.savePerson(name)
        return person
    }

    @Path("/bye")
    static def sayBye(@QueryParam("id") Long id) {
        logger.info("Remove person {}", id)
        PersonService.removePerson(id)
    }

    static def checkFilter(Request request, Response response, Chain chain) {
        logger.info("HelloWorldResources Filter Called")
        chain.doFilter(request, response)
    }
}
