package portaltek.cleancode.api.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CleanCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CleanCodeApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
    @PostMapping("/post")
    public String post() {
        return "Hello World. POST";
    }
    @GetMapping("/free")
    public String free() {
        return "Hello World. FREE";
    }


}

