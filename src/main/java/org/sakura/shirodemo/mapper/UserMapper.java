package org.sakura.shirodemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.sakura.shirodemo.entiry.UserEntity;

import java.util.List;

public interface UserMapper {

    List<UserEntity> selectList();

    String selectPasswordByName(String name);

    UserEntity selectUserByName(String name);
}
