package com.kboss.activitidemo.service;

import com.kboss.activitidemo.vo.ActModelVo;
import com.kboss.activitidemo.vo.PageInfoOutVo;
import org.activiti.engine.repository.Model;

import java.util.List;

public interface ModelerService {
    /**
     * 创建空model
     * @param name
     * @param key
     * @param description
     * @return
     */
    String crateModel(String name,String key,String description);


    /**
     * 获取模型列表
     * @return
     */
    PageInfoOutVo<ActModelVo> queryModelList(ActModelVo actModelVo);

    /**
     * 部署
     * @param modelId
     */
    void deploy(String modelId) throws Exception;
}
