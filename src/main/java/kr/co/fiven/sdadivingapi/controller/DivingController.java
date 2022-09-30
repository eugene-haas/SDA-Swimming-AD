package kr.co.fiven.sdadivingapi.controller;

import kr.co.fiven.sdadivingapi.service.DivingService;
import kr.co.fiven.sdadivingapi.vo.PlayerSettingList;
import kr.co.fiven.sdadivingapi.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DivingController {

    @Autowired
    private DivingService DivingService;


    @GetMapping("/test")
    public Response<String> test(@RequestParam int idx) {
        Response<String> res = new Response<>();
        
        res.setRstCode(200);
        res.setRstMessage("성공");
        res.setResult("테스트입니다!");
        return res;
    }

    @GetMapping("/player/list")
    public Response<PlayerSettingList> getPlayerList(@RequestParam int gameLevelIdx) {
        Response<PlayerSettingList> res = new Response<>();

        res = DivingService.getPlayerList(gameLevelIdx);

        return res;
    }


}

