package com.zyc.mapper;

import com.zyc.pojo.Book_t;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookMapper {

    @Insert("insert into tbl_book (type,name,description) values(#{type},#{name},#{description})")
    int save(Book_t book);

    @Update("update tbl_book set type = #{type}, name = #{name}, description = #{description} where id = #{id}")
    int update(Book_t book);

    @Delete("delete from tbl_book where id = #{id}")
    int delete(Integer id);

    @Select("select * from tbl_book where id = #{id}")
    Book_t getById(Integer id);

    @Select("select * from tbl_book")
    List<Book_t> getAll();

}
