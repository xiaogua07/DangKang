package ink.guakun.dangkang.dao.mapper.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class BaseDO {
    /**
     * 主键
     */
    private int id;

    /**
     * 创建时间
     */
    private LocalDate gmtCreate;

    /**
     * 修改时间
     */
    private LocalDate gmtModified;

    /**
     * 删除标识
     */
    private int isDeleted;
}
