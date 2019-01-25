package com.springboot.basic_configuration.controller;

import com.springboot.basic_configuration.dao.HolidayRepository;
import com.springboot.basic_configuration.entity.HolidayEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //获取url路径上的参数
    //localhost：8080/hello/100/hello
    //id:81 name:hello
    @RequestMapping(value = "/hello/{id}/{name}", method = RequestMethod.GET)
    public String sayHello(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        return "id:" + id + " name:" + name;
    }

    //获取url请求参数的值
    //localhost:8080/hello?id=1000
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(@RequestParam Integer id) {
        return "id:" + id;
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    //required=false 表示url中可以无id参数，此时就使用默认参数
    public String sayHello2(@RequestParam(value = "id", required = false, defaultValue = "1") Integer id) {
        return "id:" + id;
    }



}
