package com.hnsfdx.hslife.controller;

import com.hnsfdx.hslife.exception.ArgsIntroduceException;
import com.hnsfdx.hslife.exception.AuthException;
import com.hnsfdx.hslife.exception.DataInsertException;
import com.hnsfdx.hslife.exception.StorageException;
import com.hnsfdx.hslife.pojo.Answer;
import com.hnsfdx.hslife.pojo.Entertainment;
import com.hnsfdx.hslife.service.AnswerService;
import com.hnsfdx.hslife.service.EntertainmentService;
import com.hnsfdx.hslife.util.FileUtils;
import com.hnsfdx.hslife.util.PageUtils;
import com.hnsfdx.hslife.util.ResponseTypeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Api(value = "娱乐-抢答模块控制器")
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

    @ApiOperation(value = "添加一个抢答的问题", httpMethod = "POST", produces = "application/json")
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "")
            }
    )
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
            throw new ArgsIntroduceException();
        }
        List<Entertainment> obtained = entertainmentService.getEntertainments((page - 1) * PageUtils.PAGESIZE, PageUtils.PAGESIZE);
        Map<String, Object> forRet = ResponseTypeUtil.createSucResponse();
        forRet.put("data", obtained);
        return forRet;
    }

    //娱乐的最大页数
    @GetMapping("/getEntertainmentMaxPage")
    public Map<String, Object> getMaxPage() {
        Integer count = entertainmentService.countEntertainmentsNumber();
        Logger.getLogger("EntertainmentsContoller").info(String.format("entertainments Size=%d", count));
        Map<String, Object> forRet = ResponseTypeUtil.createSucResponse();
        forRet.put("data", (int) Math.ceil(count * 1.0 / PageUtils.PAGESIZE));
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
                answerService.getAllAnswerByEntertainmentId(enterId, (page - 1) * PageUtils.PAGESIZE, PageUtils.PAGESIZE)
        );
    }

    //回答的最大页数
    @GetMapping("/getAnswerMaxPage")
    public Map<String, Object> getAnswerMaxPage(@RequestParam("enterId") Integer enterId) {
        Integer count = answerService.getAllAnswersCount(enterId);
        Map<String, Object> forRet = ResponseTypeUtil.createSucResponse();
        forRet.put("data", (int) Math.ceil(count * 1.0 / PageUtils.PAGESIZE));
        return forRet;
    }

    // 给出发布娱乐的人的openId和娱乐的Id以及上传的文件，将其保存在服务端，返回相对路径
    @PostMapping("/uploadimg")
    public Map<String, Object> uploadOneImage(@RequestParam("author") String author,
                                              @RequestParam("datetime") String datetime,
                                              @RequestParam("file") MultipartFile file) {
        String uploadPath = author + "/" + "entertainment" + datetime + "/";
        Map<String, Object> forRet = ResponseTypeUtil.createSucResponse();
        try {
            forRet.put("data", FileUtils.uploadToServer(uploadPath, file));
        } catch (Exception e) {
            throw new StorageException();
        }
        return forRet;
    }

    // 给出发布娱乐的人的openId和娱乐的Id，删除对应相对路径下的所有文件
    @PostMapping("/deleteimg")
    public Map<String, Object> deleteOneImage(@RequestParam("author") String author,
                                              @RequestParam("datetime") String datetime) {
        String deletePath = author + "/" + "entertainment" + datetime + "/";
        Map<String, Object> forRet = ResponseTypeUtil.createSucResponse();
        try {
            FileUtils.deleteInServer(deletePath);
        } catch (Exception e) {
            throw new AuthException();
        }
        return forRet;
    }

    @GetMapping("/doUserAnswer")
    public Map<String, Object> doUserAnswer(@RequestParam("qid") Integer qid, @RequestParam("uid") String uid) {
        Integer result = answerService.doUserAnswer(qid, uid);
        if (result == 1) {
            return ResponseTypeUtil.createSucResponseWithData("true");
        } else {
            return ResponseTypeUtil.createSucResponseWithData("false");
        }
    }
}