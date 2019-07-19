package com.example1.demo1.pushmessage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * Date: 2019/5/23
 * Time: 16:28
 *
 * @author xm
 */
@Controller
public class MyController {

    @RequestMapping(value="/pushVideoListToWeb",method=RequestMethod.POST,consumes = "application/json")
    public @ResponseBody
    Map<String,Object> pushVideoListToWeb(@RequestBody Map<String,Object> param) {
        Map<String,Object> result =new HashMap<String,Object>();

        try {
            WebSocketServer.sendInfo("有新客户呼入");
            result.put("operationResult", true);
        }catch (IOException e) {
            result.put("operationResult", true);
        }
        return result;
    }

    @RequestMapping(value = "/test.do")
    public String test(HttpServletRequest req, HttpServletResponse res){
        try {
            req.setCharacterEncoding("utf8");
            res.setCharacterEncoding("utf8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("进来了！！！！！！！！！！！！！！");
        return "test";
    }
}
