package com.project.spring.springboot.web;

import com.project.spring.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RestController : @ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 해준다.
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloResponseDto(@RequestParam("name") String name,
                                             @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
