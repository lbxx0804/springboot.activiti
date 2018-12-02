package com.kboss.activitidemo.controller;

import com.kboss.activitidemo.RestResponseModel;
import com.kboss.activitidemo.dao.LeavebillMapper;
import com.kboss.activitidemo.entity.Leavebill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/leavelBill")
public class LeavelBillController {

    @Autowired
    private LeavebillMapper leavebillMapper;

    @RequestMapping("queryLeaveBillList")
    public List<Leavebill> queryLeaveBillList() {
        List<Leavebill> leavebillList = leavebillMapper.selectAll();
        return leavebillList;
    }

    @RequestMapping("addLeaveBill")
    public RestResponseModel<Object> addLeaveBill(Leavebill leavebill) {
        leavebillMapper.insert(leavebill);
        RestResponseModel<Object> restResponseModel = new RestResponseModel<Object>();
        restResponseModel.setData(leavebill);
        return restResponseModel;
    }
}
