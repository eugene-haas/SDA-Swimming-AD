package kr.co.fiven.sdadivingapi.mapper.diviging;

import kr.co.fiven.sdadivingapi.vo.PlayerSettingList;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DivingMapper {

    public PlayerSettingList getPlayerList(int gameLevelIdx);

}
