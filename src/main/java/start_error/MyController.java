package start_error;

import java.util.concurrent.ExecutorService;

import javax.inject.Inject;
import javax.inject.Named;

import io.micronaut.context.annotation.Context;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;

@Controller
@Context
public class MyController {
    private final ExecutorService service;

    @Inject
    public MyController(@Named(TaskExecutors.SCHEDULED) ExecutorService service) {
        this.service = service;
    }

    @Get("/ping")
    public String ping() {
        return service.toString();
    }
}
