package kr.co.fiven.sdadivingapi.mapper;

import kr.co.fiven.sdadivingapi.vo.PlayerList;
import kr.co.fiven.sdadivingapi.vo.TeamPlayerList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DivingMapper {
    public List<PlayerList> getPlayerList(Long gameLevelIdx);
    List<TeamPlayerList> getTeamPlayerList(Long gameMemberIdx);

    int getPartnerIdxCount(Map<String, Integer> params);
    Long getPartnerIdx(Map<String, Integer> params);
    int setPlayerList(Map<String, Integer> params);
    void setPlayerSelected(Long originIdx);
}
