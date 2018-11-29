package com.kboss.activitidemo.controller;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @RequestMapping("/start")
    public String start(String defKey){
        runtimeService.startProcessInstanceByKey(defKey);
        return "ok";
    }

    @RequestMapping("/findTask")
    @ResponseBody
    public String findTask(String userName) {
        List<Task> taskList = taskService.createTaskQuery().taskAssignee(userName).listPage(0,10);
        for (Task task : taskList) {
            System.out.println(task.getId());
        }
        return "ok";
    }

    @RequestMapping("/completeTask")
    public String completeTask(String taskId) {
        taskService.complete(taskId);
        return "ok";
    }

}
