package org.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.mybatis.pojo.My;
import org.mybatis.vo.PageItem;

import java.util.List;

/**
 * @author zyc
 * @date 2022/10/21
 */
public interface TestMapper {

    int insert(@Param("my") My my);

    List<My> select(@Param("offset") int offset, @Param("limit") int limit);

    List<My> selectByPage(@Param("pageItem") PageItem pageItem);
}
