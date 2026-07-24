package orchestra

import com.sample.HelloJob
import com.sample.HelloWorldResources
import ir.moke.microfox.api.http.HttpMethod
import ir.moke.orchestra.api.*
import ir.moke.orchestra.api.annotation.JobRegistry
import ir.moke.orchestra.api.annotation.JpaItem
import ir.moke.orchestra.api.annotation.JpaRegistry
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@JpaRegistry(@JpaItem(value = Environment.DS_POSTGRESQL, entityPackages = "com.sample.entity"))
@JobRegistry(HelloJob)
class Module implements IModule {
    private static final Logger logger = LoggerFactory.getLogger(Module)

    @Override
    void start() {
        logger.info("Module HelloWorld Started")
        Orchestra.httpRoute("/api/hello", HttpMethod.GET, HelloWorldResources::sayHello)
        Orchestra.httpRoute("/api/bye", HttpMethod.POST, HelloWorldResources::sayHello)
        Orchestra.httpFilter("/api/*", "Check Filter", HelloWorldResources::checkFilter)
    }

    @Override
    void stop() {
        logger.info("Call module destroy method")
    }
}
