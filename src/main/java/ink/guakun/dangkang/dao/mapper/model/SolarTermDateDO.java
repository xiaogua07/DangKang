package ink.guakun.dangkang.dao.mapper.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class SolarTermDateDO extends BaseDO {
    /**
     * 节气名称
     */
    private String solarTermName;

    /**
     * 节气时间
     */
    private LocalDate solarTermDate;
}
