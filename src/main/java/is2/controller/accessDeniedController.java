package is2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class accessDeniedController {

	@RequestMapping(value = "accessDenied")
	public String accessDenied() {
        return "accessDenied";
    }
}
