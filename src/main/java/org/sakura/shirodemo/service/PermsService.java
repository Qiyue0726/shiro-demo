package org.sakura.shirodemo.service;

import org.sakura.shirodemo.entiry.UserEntity;
import org.sakura.shirodemo.mapper.PermsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @Author ：yujianhao
 * @Date ：2020/5/12
 * @Time : 17:21
 * @Description：
 */
@Service
public class PermsService {

    @Autowired
    PermsMapper permsMapper;

    public Set<String> getPerms(UserEntity userEntity){
        int id = userEntity.getId();
        List<Integer> midList = permsMapper.getMid(id);

        List<String> permsList = new LinkedList<>();
        for (Integer i : midList) {
            permsList.add(permsMapper.getPerms(i));
        }
        Set<String> permsSet = new HashSet<>();
        for (String s : permsList) {
            permsSet.add(s);
        }
        return permsSet;
    }
}
