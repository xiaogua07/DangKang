package ink.guakun.dangkang.facade;

import ink.guakun.dangkang.dao.mapper.model.SolarTermDO;
import ink.guakun.dangkang.dao.mapper.model.SolarTermDateDO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Data
@Accessors(chain = true)
public class NextSolarTermDTO {
    /**
     * 举例下一个节气还剩几天
     */
    private long dayCount;

    /**
     * 下一个节气
     */
    private SolarTermDTO nextSolarTerm;

    public static NextSolarTermDTO convert2DTO(SolarTermDateDO solarTermDateDO, SolarTermDO solarTermDO) {
        NextSolarTermDTO res = new NextSolarTermDTO();
        LocalDate currentDate = LocalDate.now(); // 当前日期

        long daysBetween = ChronoUnit.DAYS.between(currentDate, solarTermDateDO.getSolarTermDate());
        res.setDayCount(daysBetween);
        res.setNextSolarTerm(SolarTermDTO.convert2DTO(solarTermDO));
        return res;
    }
}

@Data
@Accessors(chain = true)
class SolarTermDTO {

    /**
     * 主键
     */
    private int id;

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

    public static SolarTermDTO convert2DTO(SolarTermDO solarTerm) {
        SolarTermDTO target = new SolarTermDTO();

        target.setId(solarTerm.getId())
                .setName(solarTerm.getName())
                .setNameEn(solarTerm.getNameEn())
                .setMeaning(solarTerm.getMeaning())
                .setMeteorologicalChanges(solarTerm.getMeteorologicalChanges())
                .setRelatedVerses(solarTerm.getRelatedVerses())
                .setCustom(solarTerm.getCustom())
                .setRecommendedFoods(solarTerm.getRecommendedFoods())
                .setAddition(solarTerm.getAddition());

        return target;
    }

}
