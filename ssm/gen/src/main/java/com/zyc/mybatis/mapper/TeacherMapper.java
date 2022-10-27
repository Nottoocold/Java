package com.zyc.mybatis.mapper;

import com.zyc.mybatis.pojo.Teacher;
import com.zyc.mybatis.pojo.TeacherExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbggenerated Mon Aug 15 18:15:24 CST 2022
     */
    int countByExample(TeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbggenerated Mon Aug 15 18:15:24 CST 2022
     */
    int deleteByExample(TeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbggenerated Mon Aug 15 18:15:24 CST 2022
     */
    int deleteByPrimaryKey(Integer tid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbggenerated Mon Aug 15 18:15:24 CST 2022
     */
    int insert(Teacher record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbggenerated Mon Aug 15 18:15:24 CST 2022
     */
    int insertSelective(Teacher record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbggenerated Mon Aug 15 18:15:24 CST 2022
     */
    List<Teacher> selectByExample(TeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbggenerated Mon Aug 15 18:15:24 CST 2022
     */
    Teacher selectByPrimaryKey(Integer tid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbggenerated Mon Aug 15 18:15:24 CST 2022
     */
    int updateByExampleSelective(@Param("record") Teacher record, @Param("example") TeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbggenerated Mon Aug 15 18:15:24 CST 2022
     */
    int updateByExample(@Param("record") Teacher record, @Param("example") TeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbggenerated Mon Aug 15 18:15:24 CST 2022
     */
    int updateByPrimaryKeySelective(Teacher record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbggenerated Mon Aug 15 18:15:24 CST 2022
     */
    int updateByPrimaryKey(Teacher record);
}