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
@CrossOrigin(origins = "http://swimming.sportsdiary.co.kr/")
public class DivingController {

    @Autowired
    private DivingService DivingService;


    /**
     * 연결 테스트
     * @param idx
     * @return
     */
    @GetMapping("/test")
    public Response<String> test(@RequestParam int idx) {
        Response<String> res = new Response<>();

        res.setRstCode(200);
        res.setRstMessage("성공");
        res.setResult("테스트입니다!");
        return res;
    }

    /**
     * 종목에 참가하는 팀과 선수들 리스트
     * @param gameLevelIdx
     * @return
     */
    @GetMapping("/player/list")
    public Response<List> getPlayerList(@RequestParam Long gameLevelIdx) {
        Response<List> res = new Response<>();
        res = DivingService.getPlayerList(gameLevelIdx);

        return res;
    }

    /**
     * 종목에 참가하는 팀의 선수 리스트
     * @param gameMemberIdx
     * @return
     */
    @GetMapping("/player/team/list")
    public Response<List> getTeamPlayerList(@RequestParam Long gameMemberIdx) {
        Response<List> res = new Response<>();
        res = DivingService.getTeamPlayerList(gameMemberIdx);

        return res;
    }

    /**
     * 참가하는 선수의 순번 변경
     * @param params
     * {
     *      sort : int : 몇번째 선수인지
     *      gameMemberIdx : 바꾸는 학교 idx
     *      partnerIDX : 변경 선수의 idx
     * }
     * @return
     */
    @PostMapping("/player/switch")
    public Response<List> setPlayerList(@RequestBody Map<String, Integer> params) {
        Response<List> res = new Response<>();
        res = DivingService.setPlayerList(params);

        return res;
    }

}

