package org.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.mybatis.pojo.Grade;

import java.util.List;

/**
 * @author zyc
 * @date 2022/10/21
 */
public interface GradeMapper {

    List<Grade> selectList();

    List<Grade> selectLike(@Param("likeInfo") String like);

}
