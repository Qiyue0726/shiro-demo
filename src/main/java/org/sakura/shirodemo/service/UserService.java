package org.sakura.shirodemo.service;

import com.mysql.cj.util.StringUtils;
import org.sakura.shirodemo.entiry.UserEntity;
import org.sakura.shirodemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void selectList(){
        List<UserEntity> userEntities = userMapper.selectList();
        for (UserEntity userEntity : userEntities) {
            System.out.println(userEntity.toString());
        }
    }

    public boolean login(String name, String password) {
        String pwd = userMapper.selectPasswordByName(name);
        if (!StringUtils.isNullOrEmpty(pwd)){
            if (pwd.equals(password)){
                return true;
            }
        }
        return false;
    }

    public UserEntity getUser(String name){
        UserEntity userEntity = userMapper.selectUserByName(name);
        return userEntity;
    }
}
