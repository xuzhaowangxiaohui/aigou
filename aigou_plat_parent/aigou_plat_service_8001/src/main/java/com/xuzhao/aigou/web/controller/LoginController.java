package com.xuzhao.aigou.web.controller;

import com.xuzhao.aigou.Employee;
import com.xuzhao.aigou.util.AjaxResult;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @PostMapping("/login")
    public AjaxResult login(@RequestBody Employee employee){
        if("admin".equals(employee.getUsername())&&"admin".equals(employee.getPassword())){
            return AjaxResult.me().setObject("6666");
        }else {
            return AjaxResult.me().setSuccess(false).setMsg("操作错误").setObject("9999");
        }
    }
}
