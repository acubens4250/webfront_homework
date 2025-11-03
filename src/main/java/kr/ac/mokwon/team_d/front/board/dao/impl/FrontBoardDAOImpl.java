package kr.ac.mokwon.team_d.front.board.dao.impl;


import kr.ac.mokwon.team_d.front.board.dao.FrontBoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Repository
public class FrontBoardDAOImpl implements FrontBoardDAO{

    @Autowired
    private FrontBoardDAO frontBoardDAO;

    @Override
    public List<Map<String, Object>> selectBoardList(Map<String, Object> m) {
        return frontBoardDAO.selectBoardList(m);
    }

    @Override
    public Map<String, Object> selectOneBoard(Map<String, Object> m) {
        return frontBoardDAO.selectOneBoard(m);
    }

    @Override
    public int insertBoard(Map<String, Object> m) {
        return frontBoardDAO.insertBoard(m);
    }

    @Override
    public int updateBoard(Map<String, Object> m) {
        return frontBoardDAO.updateBoard(m);
    }

    @Override
    public int deleteBoard(Map<String, Object> m) {
        return frontBoardDAO.deleteBoard(m);
    }


//    @Autowired
//    private SqlSessionTemplate sqlSession;
//
//    @Override
//    public List<Map<String,Object>> selectBoardList(Map<String,Object> m) {
//        return sqlSession.getMapper(FrontBoardDAO.class).selectBoardList(m);
//    }

}
