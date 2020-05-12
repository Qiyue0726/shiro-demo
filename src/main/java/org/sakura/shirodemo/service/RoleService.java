package org.sakura.shirodemo.service;

import org.sakura.shirodemo.entiry.UserEntity;
import org.sakura.shirodemo.mapper.RoleMapper;
import org.sakura.shirodemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author ：yujianhao
 * @Date ：2020/5/12
 * @Time : 14:38
 * @Description：角色服务类
 */
@Service
public class RoleService {


    @Autowired
    RoleMapper roleMapper;

    public String select(UserEntity userEntity){
        int uid = userEntity.getId();
        return roleMapper.selectRole(uid);
    }
}
