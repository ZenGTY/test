package org.hospital.controller;

import org.hospital.entity.Bill;
import org.hospital.service.BillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by pismery on 2017-10-24.
 */
@Controller
@RequestMapping("bill")
public class BillController {

    private static Logger log = LoggerFactory.getLogger(BillController.class);

    @Autowired
    private BillService billService;

    @ResponseBody
    @RequestMapping(value = "/get",produces = "text/json;charset=utf-8")
    public String get(WebRequest req){
        Bill bill= billService.getBillById(1L);
        log.info("bill :",bill);
        System.out.println("bill id:" + bill.getBillId()+" clientId:"+bill.getClient().getClientId());
        return "Bill get";
    }
}
