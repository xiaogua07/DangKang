package ink.guakun.dangkang.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qweather")
public class QWeatherController {

//    /**
//     * qweather hosts
//     */
//    private final static String qWeatherHost = "https://devapi.qweather.com";
//
//    /**
//     * 杭州拱墅区经纬度
//     */
//    private final static String GONGSHU_DISTRICT_LOCATION = "120.15,30.31";
//
//    /**
//     * QWeather key
//     */
//    @Value("${qweather.privatekey}")
//    private String qWeatherKey;
//
//    private final OkHttpClient httpClient;
//
//    /**
//     * Docs: https://dev.qweather.com/docs/api/weather/weather-daily-forecast/
//     * @param httpClient
//     */
//    @Autowired
//    public QWeatherController(OkHttpClient httpClient) {
//        this.httpClient = httpClient;
//    }
//
//    /**
//     * link: https://devapi.qweather.com/v7/weather/3d?location=${120.15,30.31}&key=${env['qweather_privatekey']
//     * @return
//     */
//    @GetMapping("/weather/3d")
//    @ResponseBody
//    public QWeatherDTO fetchShortTermForecast() throws IOException {
//        final String queryPath = "/v7/weather/3d";
//        final String query = "?location=" + GONGSHU_DISTRICT_LOCATION + "&key=" + qWeatherKey;
//        final String qWeatherQueryUrl = qWeatherHost + queryPath + query;
//
//        Request req = new Request.Builder()
//                .url(qWeatherQueryUrl)
//                .build();
//        try (Response res = httpClient.newCall(req).execute()) {
//            System.out.println(res);
//            return  JSON.parseObject(res.body().string(), QWeatherDTO.class);
//        }
//    }

}
