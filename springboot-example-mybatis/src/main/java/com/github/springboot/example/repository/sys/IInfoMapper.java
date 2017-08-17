package com.github.springboot.example.repository.sys;

import com.github.springboot.example.entities.Info;
import org.springframework.stereotype.Repository;

@Repository
public interface IInfoMapper {
    public int insertInfo(Info info);
}
