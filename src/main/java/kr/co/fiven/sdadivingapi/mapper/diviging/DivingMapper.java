package kr.co.fiven.sdadivingapi.mapper.diviging;

import kr.co.fiven.sdadivingapi.vo.Player;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DivingMapper {

    public Player getPlayerList();

}
