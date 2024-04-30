package ink.guakun.dangkang.controller;

import ink.guakun.dangkang.dao.mapper.SolarTermDateMapper;
import ink.guakun.dangkang.dao.mapper.model.SolarTermDateDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/solar-term")
public class SolarQueryController {

    private final SolarTermDateMapper solarTermDateMapper;

    @Autowired
    public SolarQueryController(SolarTermDateMapper solarTermDateMapper) {
        this.solarTermDateMapper = solarTermDateMapper;
    }

    @GetMapping("")
    public List<SolarTermDateDO> solarQuery() {
        return solarTermDateMapper.selectAllSolarTermDate();
    }
}
