package com.fangxiaofeng.passbook.controller;

import com.alibaba.fastjson.JSON;
import com.fangxiaofeng.passbook.service.IMerchantsServ;
import com.fangxiaofeng.passbook.vo.CreateMerchantsRequest;
import com.fangxiaofeng.passbook.vo.PassTemplate;
import com.fangxiaofeng.passbook.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商户服务 Controller
 */
@Slf4j
@RestController
@RequestMapping("/merchants")
public class MerchantsCtl {

    /* 商户服务接口*/
    private final IMerchantsServ merchantsServ;

    @Autowired
    public MerchantsCtl(IMerchantsServ merchantsServ) {
        this.merchantsServ = merchantsServ;
    }

    @ResponseBody
    @PostMapping("/create")
    public Response createMerchants(@RequestBody CreateMerchantsRequest request) {
        log.info("CreateMerchants: {}", JSON.toJSON(request));
        return merchantsServ.createMerchants(request);

    }

    @ResponseBody
    @GetMapping("/{id}")
    public Response buildMerchantsInfo(@PathVariable Integer id) {
        log.info("BuildMerchantsInfo: {}", id);
        return merchantsServ.buildMerchantsInfoById(id);
    }

    @ResponseBody
    @PostMapping("/drop")
    public Response dropPassTemplate(@RequestBody PassTemplate passTemplate) {
        log.info("DropPassTemplate; {}", passTemplate);
        return merchantsServ.dropPassTemplate(passTemplate);
    }
}
