package com.lx.soil.demos.spring_boot_test.controller;

import com.lx.soil.demos.spring_boot_test.dto.Host;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Aslan
 * @version : v1.0
 * @time : 2018-01-22 19:56
 * @desc : 输入描述
 */
@RestController
public class TestController {

    @Value("${ws_test.ip}")
    private String ip;
    @Value("${content}")
    private String content;

    @Autowired
    private Host host;

    /*@RequestMapping(value = "/hello",method = RequestMethod.GET)*/
    @GetMapping("/hello")
    public String say(){
        System.out.println("ip = "+ip);
        System.out.println("content = "+content);
        return "ip = "+host.getIp();
    }

    @RequestMapping(value ={"/getValue/{id}", "/value"}, method=RequestMethod.GET)
    public String GetValue(@PathVariable("id") Integer id ){
        //@PathVariable("id") 这种对应的url写法是/getValue/3
        //@RequestParam(value = "id",required =false, defaultValue ="0")  这种对应的写法是/getValue?id=23
        return "nihao"+id;
    }
}
