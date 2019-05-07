package com.lx.soil.demos.spring_boot_test.controller;

import com.lx.soil.demos.spring_boot_test.Repository.UserRepository;
import com.lx.soil.demos.spring_boot_test.dto.Host;
import com.lx.soil.demos.spring_boot_test.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @Autowired
    private UserRepository userRepository;


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

    /**
     * 查询列表
     * @return
     */
    @GetMapping(value = "/users",  produces = { "application/json;charset=UTF-8" })
    public List<User> userList(){
       return  userRepository.findAll();
    }

    /**
     * 创建一个用户
     */
    @ResponseBody
    @PostMapping(value = "/users")
    public User createUser(@RequestParam(value="name") String name,
                            @RequestParam(value="pwd") String pwd,
                           @RequestParam(value="age") Integer age){
        User user = new User();
        user.setAge(age);
        user.setName(name);
        user.setPwd(pwd);
        System.out.println(user.toString());
      return   userRepository.save(user);
    }
    /**
     * 查询一个用户
     */
    @GetMapping(value = "/users/{id}")
    public User findUserByid(@PathVariable(value="id") Integer id){
        return userRepository.findOne(id);
    }
    /**
     * 修改一个用户
     * 使用postman测试时，需要将body里改成x-www-form-urlencode
     */
    @PutMapping(value = "/users/{id}")
    public User updateUser(@PathVariable(value="id") Integer id,
                           @RequestParam(value="name") String name,
                           @RequestParam(value="pwd") String pwd,
                           @RequestParam(value="age") Integer age
                           ){
        User user = new User();
        user.setId(id);
        user.setAge(age);
        user.setName(name);
        user.setPwd(pwd);
        return   userRepository.save(user);
    }
    /**
     * 删除一个用户
     */
    @DeleteMapping(value = "/users/{id}")
    public void deleteUser(@PathVariable(value="id") Integer id){
        userRepository.delete(id);
    }

    @GetMapping(value = "/getUser/{id}")
    public User getByMybaties(@PathVariable(value = "id") Integer id){
        //return userMapper.selectByPrimaryKey(id);
        return null;
    }


}
