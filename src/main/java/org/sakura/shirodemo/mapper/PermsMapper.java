package org.sakura.shirodemo.mapper;

import java.util.List;
import java.util.Set;

/**
 * @Author ：yujianhao
 * @Date ：2020/5/12
 * @Time : 17:17
 * @Description：
 */
public interface PermsMapper {

    String getPerms(Integer mid);

    List<Integer> getMid(Integer uid);
}
