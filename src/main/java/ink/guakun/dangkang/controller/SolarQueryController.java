package ink.guakun.dangkang.controller;

import ink.guakun.dangkang.dao.mapper.SolarTermDateMapper;
import ink.guakun.dangkang.dao.mapper.SolarTermMapper;
import ink.guakun.dangkang.dao.mapper.model.SolarTermDO;
import ink.guakun.dangkang.dao.mapper.model.SolarTermDateDO;
import ink.guakun.dangkang.facade.NextSolarTermDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/solar-term")
public class SolarQueryController {

    private final SolarTermDateMapper solarTermDateMapper;

    private final SolarTermMapper solarTermMapper;

    @Autowired
    public SolarQueryController(SolarTermDateMapper solarTermDateMapper
            ,SolarTermMapper solarTermMapper) {
        this.solarTermDateMapper = solarTermDateMapper;
        this.solarTermMapper = solarTermMapper;
    }

    @GetMapping("/next")
    @ResponseBody
    public NextSolarTermDTO solarQuery() {
        SolarTermDateDO solarTermDateDO =
                Optional.ofNullable(solarTermDateMapper.selectNext())
                        .orElseThrow(() -> new RuntimeException("挂了。"));
        SolarTermDO solarTermDO = Optional.ofNullable(solarTermMapper.selectByName(solarTermDateDO.getSolarTermName()))
                .orElseThrow(() -> new RuntimeException("挂了。"));

        NextSolarTermDTO res = NextSolarTermDTO.convert2DTO(solarTermDateDO, solarTermDO);

        return res;
    }

}
