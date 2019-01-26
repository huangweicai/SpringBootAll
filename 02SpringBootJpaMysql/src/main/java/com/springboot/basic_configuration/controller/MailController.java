package com.springboot.basic_configuration.controller;

import com.springboot.basic_configuration.dao.HolidayRepository;
import com.springboot.basic_configuration.entity.HolidayEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//组合注解(RequestMapping的变形)
//@GetMapping = @RequestMapping(method = RequestMethod.GET)
//@PostMapping = @RequestMapping(method = RequestMethod.POST)
//@PutMapping = @RequestMapping(method = RequestMethod.PUT)
//@DeleteMapping = @RequestMapping(method = RequestMethod.DELETE)

@RestController
@RequestMapping("/02")
public class MailController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HolidayRepository holidayRepository;

    @RequestMapping("/test")
    @ResponseBody
    public List<HolidayEntity> testTempo(@RequestParam(value = "startTime", required = true) String startTime) {
        return holidayRepository.findAll();
    }

    //get请求，获取url路径上的参数
    //localhost：8080/test/11/hans
    //id:81 name:hello
    @RequestMapping(value = "/test/{id}/{name}", method = RequestMethod.GET)
    public String sayHello(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        return "id:" + id + " name:" + name;
    }

    //get请求，获取url请求参数的值 @RequestParam
    //localhost:8080/test?id=99
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String sayHello(@RequestParam Integer id) {
        return "id:" + id;
    }

    //get请求，获取url请求参数的值，增加参数映射，默认值 @RequestParam
    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    //required=false 表示url中可以无id参数，此时就使用默认参数
    public String sayHello2(@RequestParam(value = "id", required = false, defaultValue = "1") Integer id) {
        return "id:" + id;
    }

    ////////////////////////////////////////

    //post请求
    //表单参数
    @RequestMapping(value= "/getMessage", method = RequestMethod.POST)
    public String getMessage(int code, String message)  {
        return "success";
    }

    //post请求
    //json raw参数
    @PostMapping(value= "/getMessageBody")
    public String getMessagePost(@RequestBody HolidayEntity bean)  {
        return "success";
    }

    //匹配参数
    //password如果匹配对，@RequestParam不写都ok
    public void login(@RequestParam("account") String name, @RequestParam String password) {
        System.out.println(name + ":" + password);
    }

    //@RequestHeader注解用来将请求头的内容绑定到方法参数上。
    @PostMapping(value = "login")
    public void login2(@RequestHeader("access_token") String accessToken,@RequestParam String name) {
        System.out.println("accessToken:" + accessToken);
    }
}
