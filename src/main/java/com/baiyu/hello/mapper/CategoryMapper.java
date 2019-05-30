package com.baiyu.hello.mapper;

import com.baiyu.hello.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Select("SELECT * FROM cate")
    List<Category> list();
    @Select("SELECT * FROM cate WHERE id = #{id}")
    Category get(@Param("id") int id);
}
