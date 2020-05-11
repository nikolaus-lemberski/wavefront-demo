package com.vmware.wavefront.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@RestController
public class DemoController {

    @GetMapping
    public String sayHello() {
        return "Hello from Wavefront Demo";
    }

    @GetMapping("/slow")
    public String slow() throws InterruptedException {
        Thread.sleep(100l);
        return "This took some time";
    }

    @GetMapping("/random")
    public String randomSuccess() {
        Random random = new Random();
        boolean success = random.nextBoolean();
        if (!success)
            throw new RuntimeException("Something terrible happened");
        return "Lucky you, it works!";
    }

    @ExceptionHandler(RuntimeException.class)
    public void handleRuntimeException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

}
