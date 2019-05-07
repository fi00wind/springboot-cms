package cn.coolwind.manager.web.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrController implements ErrorController {
    @Override
    @RequestMapping("/error")
    public String getErrorPath() {
        return "index.html";
    }
}
