package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }
    // Spring MVC
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name="name",required = false) String name, Model model){
        //required = false 일 경우 name 값이 없어도 오류가 나지 않음
        model.addAttribute("name", name);
        return "hello-template";
    }

    //API
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam(name="name",required = false) String name){
        //ResponseBody 사용시 뷰리졸버를 사용하지 않음
        return " hello " + name;
    }
    //문자가 아니고 객체일 경우 JSON 방식으로 나온다.
    //객체일 경우 jsonconverter 동작 string일경우 stringconverter 동작
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam(name="name",required = false) String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    public static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
