package kr.co.fiven.sdadivingapi.service;


import kr.co.fiven.sdadivingapi.mapper.DivingMapper;
import kr.co.fiven.sdadivingapi.vo.Player;
import kr.co.fiven.sdadivingapi.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DivingService {

    @Autowired
    private DivingMapper DivingMapper;


    public Response<Player> getPlayerList() {
        Response<Player> res = new Response<>();

        Player player =  DivingMapper.getPlayerList();

        return res;

    }
}