package com.example.bbb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/add")
    public void test(){
        testService.add();
    }

    @RequestMapping("/query")
    public void findByOrderId(){

        System.out.println(testService.findByOrderId(1L));

    }

}
