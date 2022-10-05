package kr.co.fiven.sdadivingapi.service;


import kr.co.fiven.sdadivingapi.mapper.DivingMapper;
import kr.co.fiven.sdadivingapi.vo.PlayerList;
import kr.co.fiven.sdadivingapi.vo.Response;
import kr.co.fiven.sdadivingapi.vo.TeamPlayerList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class DivingService {

    @Autowired
    private DivingMapper DivingMapper;


    public Response<List> getPlayerList(Long gameLevelIdx) {
        Response<List> res = new Response<>();
        List<PlayerList> playerList = null;

        try {
            log.info("[getPlayerList] gameLevelIdx : {}", gameLevelIdx);
            playerList = DivingMapper.getPlayerList(gameLevelIdx);

            for (PlayerList p : playerList) {
                log.info("[getPlayerList] player list : {}", p);
            }
            res.setRstCode(200);

            if(playerList.size() == 0) {
                res.setRstMessage("조회 결과 없음");
            } else if(playerList.size() > 0) {
                res.setResult(playerList);
            }
        } catch (Exception e) {
            log.error("message : {}", e.getMessage() + "\n e : {}", e);
            res.setRstMessage("오류 발생 : " + e.getMessage());
        }
        return res;
    }

    public Response<List> getTeamPlayerList(Long gameMemberIdx) {
        Response<List> res = new Response<>();
        List<TeamPlayerList> teamPlayerList = null;

        try {
            teamPlayerList = DivingMapper.getTeamPlayerList(gameMemberIdx);

            for (TeamPlayerList p : teamPlayerList) {
                log.info("[getTeamPlayerList] player team list : {}", p);
            }
            res.setRstCode(200);

            if(teamPlayerList.size() == 0) {
                res.setRstMessage("조회 결과 없음");
            } else if(teamPlayerList.size() > 0) {
               res.setResult(teamPlayerList);
            }
        } catch (Exception e) {
            log.error("message : {}", e.getMessage() + "\n e : {}", e);
            res.setRstMessage("오류 발생 : " + e.getMessage());
        }
        return res;
    }

    @Transactional
    public Response<List> setPlayerList(Map<String, Integer> params) {
        Response<List> res = new Response<>();
        int result = 0;

        try {
            //기존에 선택 된 선수가 있는지 확인
            Long originIdx = DivingMapper.getPartnerIdx(params);
            log.info("[setPlayerList] originIdx : {}", originIdx);

            //선택된 선수가 있다면 제거하고 새로운 선수를 등록
            if(originIdx != null || originIdx > 0) {
                DivingMapper.setPlayerSelected(originIdx);
            }
            result = DivingMapper.setPlayerList(params);

            res.setRstCode(200);

            if(result > 0) {
                res.setRstMessage("출전 선수가 변경되었습니다");
            } else {
                res.setRstMessage("선수 변경에 실패했습니다");
            }
        } catch (Exception e) {
            log.error("message : {}", e.getMessage() + "\n e : {}", e);
            res.setRstMessage("오류 발생 : " + e.getMessage());
        }
        return res;
    }


//    public Response<> x() {
//        Response<List> res = new Response<>();
//
//        try {
//
//        } catch (Exception e) {
//            log.error("message : {}", e.getMessage() + "\n e : {}", e);
//            res.setRstMessage("오류 발생 : " + e.getMessage());
//        }
//
//        return res;
//    }
}