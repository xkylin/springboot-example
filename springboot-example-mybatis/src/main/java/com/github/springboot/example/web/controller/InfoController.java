package com.github.springboot.example.web.controller;

import com.github.springboot.example.entities.Info;
import com.github.springboot.example.service.IInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoController {

    @Autowired
    private IInfoService infoService;

    @RequestMapping(value = "/add")
    public int addInfo() {
        Info info = new Info("测试");
        try {
            this.infoService.addInfo(info);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
