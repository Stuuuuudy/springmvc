package first.sample.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import first.sample.dao.SampleDAO;

@Service("sampleService")
public class SampleServiceImpl implements SampleService {
    Logger log = Logger.getLogger(this.getClass());

    @Resource(name = "sampleDAO")
    private SampleDAO sampleDAO;

    @Override
    public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {
        // TODO Auto-generated method stub
        return sampleDAO.selectBoardList(map);
    }

    @Override
    public void insertBoard(Map<String, Object> map) throws Exception {
        sampleDAO.insertBoard(map);
    }

    @Override
    public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception {
        sampleDAO.updateHitCount(map);
        Map<String, Object> resultMap = sampleDAO.selectBoardDetail(map);

        return resultMap;
    }

    @Override
    public void updateBoard(Map<String, Object> map) throws Exception {
        sampleDAO.updateBoard(map);
    }

    @Override
    public void deleteBoard(Map<String, Object> map) throws Exception {
        sampleDAO.deleteBoard(map);
    }
}
