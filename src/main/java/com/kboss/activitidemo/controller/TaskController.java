package com.kboss.activitidemo.controller;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @RequestMapping("/start")
    public String start(String defKey) {
        runtimeService.startProcessInstanceByKey(defKey);
        return "ok";
    }

    @RequestMapping("/findTask")
    @ResponseBody
    public String findTask(String userName) {
        List<Task> taskList = taskService.createTaskQuery().taskAssignee(userName).listPage(0, 10);
        for (Task task : taskList) {
            System.out.println(task.getId());
            System.out.println(task.getAssignee());
            System.out.println(task.getName());
            System.out.println("#####################");
        }
        return "ok";
    }

    @RequestMapping("/completeTask")
    public String completeTask(String taskId) {
        //Map<String, Object> map = new HashMap<String, Object>();
        //map.put("days", 8);
        //taskService.complete(taskId, map);
        taskService.complete(taskId);
        return "ok";
    }

}
