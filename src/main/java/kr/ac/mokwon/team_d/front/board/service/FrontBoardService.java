package kr.ac.mokwon.team_d.front.board.service;

import java.util.HashMap;
import java.util.Map;

public interface FrontBoardService {

    Map<String, Object> selectBoardListService(HashMap<String, Object> dataMap);
    Map<String, Object> selectOneBoardService(HashMap<String, Object> dataMap);
    Map<String, Object> insertBoardService(HashMap<String, Object> dataMap);
    Map<String, Object> updateBoardService(HashMap<String, Object> dataMap);
    Map<String, Object> deleteBoardService(HashMap<String, Object> dataMap);
}
