package orchestra


import com.sample.HelloJob
import com.sample.HelloWorldResources
import ir.moke.microfox.api.http.HttpMethod
import ir.moke.orchestra.api.IModule
import ir.moke.orchestra.api.JobRegistry
import ir.moke.orchestra.api.JpaRegistry
import ir.moke.orchestra.api.Orchestra
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@JpaRegistry(Environment.DS_POSTGRESQL)
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
