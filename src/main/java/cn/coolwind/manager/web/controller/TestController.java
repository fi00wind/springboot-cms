package cn.coolwind.manager.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("test")
    public Object test() {
        return "test";
    }

    @GetMapping("coolwind")
    public Object coolwind() {
        return "this is coolwind page";
    }

    @GetMapping("aaa")
    public Object aaa() {
        return "this is aaa page";
    }
}
