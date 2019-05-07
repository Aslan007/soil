package com.lx.soil.demos.spring_boot_test.controller;

import com.lx.soil.demos.spring_boot_test.Repository.UserRepository;
import com.lx.soil.demos.spring_boot_test.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author : Aslan
 * @version : v1.0
 * @time : 2018-02-02 16:33
 * @desc : 因为thmeleaf ,不能使用@RestController,所以新建一个controller
 */

@Controller
public class ThmeleafTestController {

    @Autowired
    private UserRepository repository;



    @GetMapping(value = "/toList")
    public  String getList(Model model, HttpServletRequest request){
        List<User> userList = repository.findAll();

        System.out.println("to List!");
        model.addAttribute("name","李白");

        request.setAttribute("rName","李清照");
        request.setAttribute("users",userList);
        request.setAttribute("date",new Date());


        return "demo/demo_1";
    }


}
