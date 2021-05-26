package FitnessApp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class Controller {

    @RequestMapping("/")
    String home() {
        System.out.println("Testtest");
        return "Hello, World!";
    }

}