package com.github.springboot.example.service.impl;

import com.github.springboot.example.entities.Info;
import com.github.springboot.example.entities.User;
import com.github.springboot.example.repository.boot.IUserMapper;
import com.github.springboot.example.repository.sys.IInfoMapper;
import com.github.springboot.example.service.IInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class InfoService implements IInfoService {

    @Autowired
    private IInfoMapper infoMapper;

    @Autowired
    private IUserMapper userMapper;

    @Override
    //Spring事务会默认回滚RuntimeException、Error，Exception需要手动通过rollbackOn属性指定回滚的异常类型
    @Transactional(rollbackOn = {Exception.class})
    public void addInfo(Info info) throws Exception {
        User user = new User();
        user.setName("事务");
        user.setAge(33);
        this.userMapper.insert(user);
        this.infoMapper.insertInfo(info);
        throw new Exception("发生异常");
//        return 0;
    }
}
