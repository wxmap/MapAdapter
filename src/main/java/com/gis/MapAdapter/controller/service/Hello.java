package com.gis.MapAdapter.controller.service;

import com.gis.MapAdapter.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
@Api(tags = "用户相关接口")
@RestController("service")
@RequestMapping("service1")
public class Hello {
    @ApiOperation(value = "用户详细信息", notes = "通过id获得用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType = "query", defaultValue = "0")})
    @GetMapping("say1")
    public Object say(){
        User user=new User();
        user.setAge(12);
        user.setCreateTime(new Date());
        user.setPwd("123");
        return user;
    }

}
