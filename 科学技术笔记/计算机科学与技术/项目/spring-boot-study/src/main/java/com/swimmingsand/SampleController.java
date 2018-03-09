package com.swimmingsand;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zlq on 2/19/16.
 */
@Controller
public class SampleController {
    @RequestMapping("/hello")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
}
