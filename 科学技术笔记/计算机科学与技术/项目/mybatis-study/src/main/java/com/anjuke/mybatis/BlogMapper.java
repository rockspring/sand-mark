package com.anjuke.mybatis;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BlogMapper {
    @Select("SELECT * FROM blog WHERE id = #{id}")
    Blog selectBlog(int id);

    @Update("update blog set id=id+#{id}")
    int updateBlog(int id);

    @Insert("insert into blog values()")
    int insertBlog();
}
