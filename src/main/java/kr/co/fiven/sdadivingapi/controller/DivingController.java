package kr.co.fiven.sdadivingapi.controller;

import kr.co.fiven.sdadivingapi.service.DivingService;
import kr.co.fiven.sdadivingapi.vo.Player;
import kr.co.fiven.sdadivingapi.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DivingController {

    @Autowired
    private DivingService DivingService;


    @GetMapping("/player/list")
    public Response<Player> getPlayerList() {
        Response<Player> res = new Response<>();

        res = DivingService.getPlayerList();

        return res;
    }


}

