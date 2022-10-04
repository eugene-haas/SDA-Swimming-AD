package kr.co.fiven.sdadivingapi.controller;

import kr.co.fiven.sdadivingapi.service.DivingService;
import kr.co.fiven.sdadivingapi.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
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
    public Response<List> getPlayerList(@RequestParam Long gameLevelIdx) {
        Response<List> res = new Response<>();
        res = DivingService.getPlayerList(gameLevelIdx);

        return res;
    }

    @GetMapping("/player/team/list")
    public Response<List> getTeamPlayerList(@RequestParam Long gameMemberIdx) {
        Response<List> res = new Response<>();
        res = DivingService.getTeamPlayerList(gameMemberIdx);

        return res;
    }

    @PostMapping("/player/switch")
    public Response<List> setPlayerList(@RequestBody Map<String, Integer> params) {
        Response<List> res = new Response<>();
        res = DivingService.setPlayerList(params);

        return res;
    }





}

