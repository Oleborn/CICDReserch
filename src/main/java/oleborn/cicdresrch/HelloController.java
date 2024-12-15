package oleborn.cicdresrch;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Привет, а я работаю!";
    }

    @GetMapping("/test/")
    public String test() {
        return "Просто проверка обновления!";
    }
}
