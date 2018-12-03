package com.kboss.activitidemo.controller;


import com.kboss.activitidemo.service.ModelerService;
import com.kboss.activitidemo.vo.ActModelVo;
import com.kboss.activitidemo.vo.PageInfoOutVo;
import com.kboss.activitidemo.vo.PagedModelInVo;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/model")
public class ModelerController {
    private static final Logger logger = LoggerFactory.getLogger(ModelerController.class);

    @Autowired
    private ModelerService modelerService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;


    /**
     * 创建流程模型
     * @param name
     * @param key
     * @param description
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createModel(@RequestParam("name") String name, @RequestParam("key") String key,
                              @RequestParam("description") String description,
                              HttpServletRequest request, HttpServletResponse response) {
        logger.info("创建空modeler：name:{},key:{},description:{}", name, key, description);
        try {
            //创建空模型
            String modelId = modelerService.crateModel(name, key, description);
            if(StringUtils.isBlank(modelId)) {
                throw new RuntimeException("创建modeler失败modelId:" + modelId);
            }

            return "redirect:modeler.html?modelId=" + modelId;
        }catch (Exception e) {
            logger.error("创建模型失败",e );
            throw new RuntimeException(e);
        }
    }

    /**
     * 模型列表
     * @param
     * @return
     */
    @RequestMapping("/list")
    public PageInfoOutVo<ActModelVo> modelList(ActModelVo actModelVo) {
        PageInfoOutVo<ActModelVo> result = modelerService.queryModelList(actModelVo);
        return result;
    }

    @RequestMapping("/deploy")
    @ResponseBody
    public String deploy(String modelId) throws Exception{
        modelerService.deploy(modelId);
        return "ok";
    }


}
