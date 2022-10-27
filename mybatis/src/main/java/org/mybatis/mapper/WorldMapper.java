package org.mybatis.mapper;

import org.apache.ibatis.annotations.Select;
import org.mybatis.pojo.World;

import java.util.List;

/**
 * @author zyc
 * @date 2022/10/21
 */
public interface WorldMapper {

    @Select("select * from world;")
    List<World> selectList();
}
