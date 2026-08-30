package orchestra

import com.sample.HelloJob
import com.sample.HelloWorldResources
import ir.moke.orchestra.api.IModule
import ir.moke.orchestra.api.Orchestra
import ir.moke.orchestra.api.annotation.Job
import ir.moke.orchestra.api.annotation.Jpa
import ir.moke.orchestra.api.annotation.JpaItem
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Jpa(
        value = Environment.DS_POSTGRESQL, entityPackages = "com.sample.entity",
        secondary = [
                @JpaItem(value = Environment.DS_POSTGRESQL, entityPackages = "com.sample.entity")
        ]
)
@Job(HelloJob)
class Module implements IModule {
    private static final Logger logger = LoggerFactory.getLogger(Module)

    @Override
    void start() {
        logger.info("Module HelloWorld Started")
        Orchestra.httpFilter("/api/*", "Check Filter", HelloWorldResources::checkFilter)
    }

    @Override
    void stop() {
        logger.info("Call module destroy method")
    }
}
