package first.sample.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import first.common.common.CommandMap;

@Controller
public class SampleController {
    Logger log = Logger.getLogger(this.getClass());

    @Resource(name = "sampleService")
    private SampleService sampleService;

    @RequestMapping(value = "/sample/openBoardList.do")
    public ModelAndView openSampleList(Map<String, Object> commandMap) throws Exception {
        ModelAndView mv = new ModelAndView("BoardList");
        log.debug("인터셉터 테스트");

        List<Map<String, Object>> list = sampleService.selectBoardList(commandMap);
        mv.addObject("list", list);

        return mv;
    }

    @RequestMapping(value="/sample/openBoardWrite.do")
    public ModelAndView openBoardWrite(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("/boardWrite");

        return mv;
    }

    @RequestMapping(value="/sample/insertBoard.do")
    public ModelAndView insertBoard(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("redirect:/sample/openBoardList.do");

        sampleService.insertBoard(commandMap.getMap());

        return mv;
    }

    @RequestMapping(value="/sample/openBoardDetail.do")
    public ModelAndView openBoardDetail(CommandMap commandMap) throws Exception {
        ModelAndView mv = new ModelAndView("boardDetail");

        Map<String, Object> map = sampleService.selectBoardDetail(commandMap.getMap());
        mv.addObject("map", map);

        return mv;
    }

    @RequestMapping(value = "/sample/testMapArgumentResolver.do")
    public ModelAndView testMapArgumentResolver(CommandMap commandMap) throws Exception {
        ModelAndView mv = new ModelAndView("");

        if (commandMap.isEmpty() == false) {
            Iterator<Entry<String, Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String, Object> entry = null;
            while (iterator.hasNext()) {
                entry = iterator.next();
                log.debug("key : " + entry.getKey() + ", value : " + entry.getValue());
            }
        }
        return mv;
    }
}
