package mvc_everything.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class WebController {
    @RequestMapping
    public String Everything(ModelMap model, @RequestParam(value = "message", required = false) String message) {
        model.addAttribute("message", message);
        return "/index";
    }
}
