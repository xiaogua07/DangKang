package ink.guakun.dangkang.dao.mapper;

import ink.guakun.dangkang.dao.mapper.model.SolarTermDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SolarTermMapper {

    @Select("select * from `solar-term` where name = #{name}")
    SolarTermDO selectByName(@Param("name") String name);
}
