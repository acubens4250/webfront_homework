package kr.ac.mokwon.team_d.front.board.service.impl;

import kr.ac.mokwon.team_d.front.board.dao.impl.FrontBoardDAOImpl;
import kr.ac.mokwon.team_d.front.board.service.FrontBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FrontBoardServiceImpl implements FrontBoardService {

    @Autowired
    private FrontBoardDAOImpl frontBoardDAOImpl;


    @Override
    public Map<String, Object> selectBoardListService(HashMap<String, Object> dataMap) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        try {
            List<Map<String, Object>> boardList = frontBoardDAOImpl.selectBoardList(dataMap);
            System.err.println(boardList);

            resultMap.put("data_list", boardList);
            resultMap.put("code", HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            resultMap.put("code", HttpStatus.INTERNAL_SERVER_ERROR);
            resultMap.put("msg", "내부 서버 오류입니다.");
        }

        return resultMap;
    }

    @Override
    public Map<String, Object> selectOneBoardService(HashMap<String, Object> dataMap) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        try {
            Map<String, Object> board = frontBoardDAOImpl.selectOneBoard(dataMap);
            System.err.println(board);

            resultMap.put("data", board);
            resultMap.put("code", HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            resultMap.put("code", HttpStatus.INTERNAL_SERVER_ERROR);
            resultMap.put("msg", "내부 서버 오류입니다.");
        }

        return resultMap;
    }

    @Override
    public Map<String, Object> insertBoardService(HashMap<String, Object> dataMap) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        try {
            int result = frontBoardDAOImpl.insertBoard(dataMap);

            if(result == 1) {
                resultMap.put("result", true);
            } else {
                resultMap.put("result", false);
            }
        } catch(Exception e) {
            e.printStackTrace();
            resultMap.put("result", false);
        }

        return resultMap;
    }

    @Override
    public Map<String, Object> updateBoardService(HashMap<String, Object> dataMap) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        try {
            int result = frontBoardDAOImpl.updateBoard(dataMap);

            if(result == 1) {
                resultMap.put("result", true);
            } else {
                resultMap.put("result", false);
            }
        } catch(Exception e) {
            e.printStackTrace();
            resultMap.put("result", false);
        }

        return resultMap;
    }

    @Override
    public Map<String, Object> deleteBoardService(HashMap<String, Object> dataMap) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        try {
            int result = frontBoardDAOImpl.deleteBoard(dataMap);

            if(result == 1) {
                resultMap.put("result", true);
            } else {
                resultMap.put("result", false);
            }
        } catch(Exception e) {
            e.printStackTrace();
            resultMap.put("result", false);
        }

        return resultMap;
    }


}
