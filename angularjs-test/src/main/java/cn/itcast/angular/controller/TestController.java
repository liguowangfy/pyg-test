package cn.itcast.angular.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

/**
 * 测试控制器
 * @author lee.siu.wah
 * @version 1.0
 * <p>File Created at 2018-07-11<p>
 */
@RestController
public class TestController {

    /** 处理get请求与post请求 */
    @RequestMapping("/find")
    public Map<String,String> find(){
        return null;
    }

    /**  处理post请求 */
    @PostMapping("/user")
    public Map<String,String> user(){

        return null;
    }
}