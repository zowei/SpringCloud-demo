package cn.itcast.user.mapper;

import cn.itcast.user.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface UserMapper {
    
    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Long id);
}