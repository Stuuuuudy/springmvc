package first.sample.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import first.common.dao.AbstractDAO;

@Repository("sampleDAO")
public class SampleDAO extends AbstractDAO {

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {
        return (List<Map<String, Object>>) selectList("sample.selectBoardList", map);
    }

    public void insertBoard(Map<String, Object> map) throws Exception {
        insert("sample.insertBoard", map);
    }

    public void updateHitCount(Map<String, Object> map) throws Exception {
        update("sample.updateHitCount", map);
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception {
        return (Map<String, Object>) selectOne("sample.selectBoardDetail", map);
    }

    public void updateBoard(Map<String, Object> map) throws Exception {
        update("sample.updateBoard", map);
    }

    public void deleteBoard(Map<String, Object> map) throws Exception {
        delete("sample.deleteBoard", map);
    }
}
