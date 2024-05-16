package ink.guakun.dangkang.facade;

import lombok.Data;

import java.util.List;

/**
 * 获取日天气预报接口返回值
 */
@Data
public class QWeatherDTO {
    /**
     * 状态码
     * 200	请求成功
     * 204	请求成功，但你查询的地区暂时没有你需要的数据。
     * 400	请求错误，可能包含错误的请求参数或缺少必选的请求参数。
     * 401	认证失败，可能使用了错误的KEY、数字签名错误、KEY的类型错误（如使用SDK的KEY去访问Web API）。
     * 402	超过访问次数或余额不足以支持继续访问服务，你可以充值、升级访问量或等待访问量重置。
     * 403	无访问权限，可能是绑定的PackageName、BundleID、域名IP地址不一致，或者是需要额外付费的数据。
     * 404	查询的数据或地区不存在。
     * 429	超过限定的QPM（每分钟访问次数），请参考QPM说明
     * 500	无响应或超时，接口服务异常请联系我们
     * @reffer: https://dev.qweather.com/docs/resource/status-code/
     */
    public String code;

    /**
     * 当前API的最近更新时间
     */
    public String updateTime;

    /**
     * 当前数据的响应式页面，便于嵌入网站或应用
     */
    public String fxLink;


    /**
     * 某天的预报
     */
    public List<DayWeather> daily;

    /**
     * 原始数据
     */
    public Refer refer;
}

@Data
class DayWeather {
    /**
     * 预报日期
     */
    public String fxDate;

    /**
     * 日出时间，在高纬度地区可能为空
     */
    public String sunrise;

    /**
     * 日落时间，在高纬度地区可能为空
     */
    public String sunset;

    /**
     * 当天月升时间，可能为空
     */
    public String moonrise;

    /**
     * 当天月落时间，可能为空
     */
    public String moonset;

    /**
     * 月相名称
     */
    public String moonPhase;

    /**
     *  月相图标代码，另请参考天气图标项目
     */
    public String moonPhaseIcon;

    /**
     * 预报当天最高温度
     */
    public String tempMax;

    /**
     *  预报当天最低温度
     */
    public String tempMin;

    /**
     * 预报白天天气状况的图标代码，另请参考天气图标项目
     * 图标: https://dev.qweather.com/docs/resource/icons/
     * 项目: https://icons.qweather.com/
     */
    public String iconDay;

    /**
     * 预报白天天气状况文字描述，包括阴晴雨雪等天气状态的描述
     */
    public String textDay;

    /**
     *  预报夜间天气状况的图标代码，另请参考天气图标项目
     */
    public String iconNight;

    /**
     * 预报晚间天气状况文字描述，包括阴晴雨雪等天气状态的描述
     */
    public String textNight;

    /**
     * 预报白天风向360角度
     */
    public String wind360Day;

    /**
     * 预报白天风向
     */
    public String windDirDay;

    /**
     * 预报白天风力等级
     */
    public String windScaleDay;

    /**
     * 预报白天风速，公里/小时
     */
    public String windSpeedDay;

    /**
     * 预报夜间风向360角度
     */
    public String wind360Night;

    /**
     * 预报夜间当天风向
     */
    public String windDirNight;

    /**
     * 预报夜间风力等级
     */
    public String windScaleNight;

    /**
     * 预报夜间风速，公里/小时
     */
    public String windSpeedNight;

    /**
     * 相对湿度，百分比数值
     */
    public String humidity;

    /**
     *  预报当天总降水量，默认单位：毫米
     */
    public String precip;

    /**
     * 大气压强，默认单位：百帕
     */
    public String pressure;

    /**
     * 大气压强，默认单位：百帕
     */
    public String vis;

    /**
     * 云量，百分比数值。可能为空
     */
    public String cloud;

    /**
     * 紫外线强度指数
     */
    public String uvIndex;
}

/**
 * 原始数据
 */
@Data
class Refer{
    /**
     * 原始数据来源，或数据源说明，可能为空
     */
    public List<String> sources;

    /**
     * 数据许可或版权声明，可能为空
     */
    public List<String> license;
}
