package org.launchcode.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HelloSpringController {

    // Controller with Query parameter(Responds to get requests at path /hello?name=LaunchCode)
    @RequestMapping(value="hello", method = {RequestMethod.GET, RequestMethod.POST})
    //@ResponseBody
    public String helloWithQueryParam(@RequestParam String name, Model model) {//add model
        //return "Hello, " + name + "!";
        String theGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", theGreeting);
        return "helloQuery";
    }
    //Controller with path parameter(Responds to get requests at /hello/LaunchCode)
    @GetMapping("hello/{name}")
    //@ResponseBody
    public String helloWithPathParam(@PathVariable String name, Model model) {
        //return "Hello, " + name + "!";
        //String theGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", "Hello, " + name + "!");
        return "helloQuery";
    }
    //controller with forms(responds to /hello/form)
    @GetMapping("form")
    public String helloForm() {
       return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("HTML");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hello-list";
    }
    @GetMapping("hello-tare")
    public String helloTare(Model model){
        List<String> cars = new ArrayList<>();
        cars.add("Toyota");
        cars.add("Honda");
        cars.add("Lexus");
        cars.add("Mitsubishi");
        cars.add("Tesla");
        model.addAttribute("welcome", cars);
        return "tare";

    }

}
