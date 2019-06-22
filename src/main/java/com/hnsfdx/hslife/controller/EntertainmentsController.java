package com.hnsfdx.hslife.controller;

import com.hnsfdx.hslife.exception.DataInsertException;
import com.hnsfdx.hslife.pojo.Answer;
import com.hnsfdx.hslife.pojo.Entertainment;
import com.hnsfdx.hslife.service.AnswerService;
import com.hnsfdx.hslife.service.EntertainmentService;
import com.hnsfdx.hslife.util.PageUtil;
import com.hnsfdx.hslife.util.ResponseTypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/Entertainments")
public class EntertainmentsController {
    private EntertainmentService entertainmentService;
    private AnswerService answerService;

    @Autowired
    public EntertainmentsController(EntertainmentService entertainmentService, AnswerService answerService) {
        this.entertainmentService = entertainmentService;
        this.answerService = answerService;
    }

    @PostMapping("/addEntertainment")
    public Map<String, Object> addEntertainment(@RequestBody Entertainment entertainment) {
        Integer result = entertainmentService.insertEntertainment(entertainment);
        if (result == 0) {
            throw new DataInsertException();
        } else {
            Map<String, Object> res = ResponseTypeUtil.createSucResponse();
            res.put("data", entertainment.getId());
            return res;
        }
    }

    @GetMapping("/findEntertainmentById")
    public Map<String, Object> findEntertainmentById(@RequestParam("id") Integer id) {
        List<Entertainment> obtained = entertainmentService.getSingleEntertainmentById(id);
        Map<String, Object> forRet = ResponseTypeUtil.createSucResponse();
        if (obtained.size() != 0) {
            forRet.put("data", obtained.get(0));
            return forRet;
        }
        return forRet;
    }

    @GetMapping("/getEntertainments")
    public Map<String, Object> findEntertainments(@RequestParam("page") Integer page) {
        if (page <= 0) {
            return ResponseTypeUtil.createFailResponse();
        }
        List<Entertainment> obtained = entertainmentService.getEntertainments((page - 1) * PageUtil.PAGESIZE, PageUtil.PAGESIZE);
        Map<String, Object> forRet = ResponseTypeUtil.createSucResponse();
        forRet.put("data", obtained);
        return forRet;
    }

    @GetMapping("/getEntertainmentMaxPage")
    public Map<String, Object> getMaxPage() {
        Integer count = entertainmentService.countEntertainmentsNumber();
        Logger.getLogger("EntertainmentsContoller").info(String.format("entertainments Size=%d", count));
        Map<String, Object> forRet = ResponseTypeUtil.createSucResponse();
        forRet.put("data", (int) Math.ceil(count * 1.0 / PageUtil.PAGESIZE));
        return forRet;
    }

    @PostMapping("/addAnswer")
    public Map<String, Object> addAnswer(@RequestBody Answer answer) {
        Integer result = answerService.addSingleAnswer(answer);
        if (result == 0) {
            throw new DataInsertException();
        } else {
            return ResponseTypeUtil.createSucResponseWithData(answer.getId());
        }
    }

    @GetMapping("/getAnswer")
    public Map<String, Object> getAnswer(@RequestParam("enterId") Integer enterId, @RequestParam("page") Integer page) {
        return ResponseTypeUtil.createSucResponseWithData(
                answerService.getAllAnswerByEntertainmentId(enterId, (page - 1) * PageUtil.PAGESIZE, PageUtil.PAGESIZE)
        );
    }


}