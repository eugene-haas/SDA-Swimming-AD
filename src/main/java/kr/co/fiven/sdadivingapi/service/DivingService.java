package kr.co.fiven.sdadivingapi.service;


import kr.co.fiven.sdadivingapi.mapper.diviging.DivingMapper;
import kr.co.fiven.sdadivingapi.vo.PlayerSettingList;
import kr.co.fiven.sdadivingapi.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DivingService {

    @Autowired
    private DivingMapper DivingMapper;


    public Response<PlayerSettingList> getPlayerList(int gameLevelIdx) {
        Response<PlayerSettingList> res = new Response<>();

        PlayerSettingList player =  DivingMapper.getPlayerList(gameLevelIdx);

        return res;

    }
}