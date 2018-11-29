package com.kboss.activitidemo.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.StyledEditorKit;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/procdef")
public class ProcdefController {

    @Autowired
    private RepositoryService repositoryService;

    @RequestMapping("/queryProcDefList")
    public String queryProcDefList(){
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();

        for(ProcessDefinition definition : list){
            System.out.println("定义："+definition.getId());
        }
        return "ok";
    }

    /**
     * 查看流程图
     * @param defId
     * @param response
     * @throws Exception
     */
    @RequestMapping("/viewProcessImg")
    public void viewProcessImg(String defId, HttpServletResponse response)throws Exception{
        InputStream processDiagram = repositoryService.getProcessDiagram(defId);

        ServletOutputStream outputStream = response.getOutputStream();
        try {
            byte[]temptytes = new byte[1024];
            int byteread = 0;
            while ((byteread = processDiagram.read(temptytes))!= -1){
                outputStream.write(temptytes,0,byteread);
            }
        }catch (Exception ex){
            throw ex;
        }finally {
            try{
                processDiagram.close();
            }catch (Exception ex){

            }
            try {
                outputStream.close();
            }catch (Exception ex){

            }
        }
    }
}
