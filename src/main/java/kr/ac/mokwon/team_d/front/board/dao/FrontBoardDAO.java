package kr.ac.mokwon.team_d.front.board.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FrontBoardDAO {
    List<Map<String, Object>> selectBoardList(Map<String, Object> m);
    Map<String, Object> selectOneBoard(Map<String, Object> m);
    int insertBoard(Map<String, Object> m);
    int updateBoard(Map<String, Object> m);
    int deleteBoard(Map<String, Object> m);

}
