package ink.guakun.dangkang.dao.mapper;

import ink.guakun.dangkang.dao.mapper.model.SolarTermDateDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SolarTermDateMapper {
    @Select("select * from `solar-term-date`")
    List<SolarTermDateDO> selectAllSolarTermDate();

    @Select("select * from `solar-term-date` std where std.solar_term_date >= curdate() order by std.solar_term_date asc limit 1;")
    SolarTermDateDO selectNext();
}
