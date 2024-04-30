package ink.guakun.dangkang.dao.mapper;

import ink.guakun.dangkang.dao.mapper.model.SolarTermDateDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SolarTermDateMapper {
    @Select("select * from `solar-term-date`")
    List<SolarTermDateDO> selectAllSolarTermDate();
}
