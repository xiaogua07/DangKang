package ink.guakun.dangkang.dao.mapper.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class SolarTermDO extends BaseDO {
    /**
     * 节气名称
     */
    private String name;

    /**
     * 节气英文名
     */
    private String nameEn;

    /**
     * 气象变化
     */
    private String meteorologicalChanges;

    /**
     * 关联诗句
     */
    private String relatedVerses;

    /**
     * 节气渊源
     */
    private String meaning;

    /**
     * 风俗
     */
    private String custom;

    /**
     * 推荐食物
     */
    private String recommendedFoods;

    /**
     * 注意事项
     */
    private String addition;
}
