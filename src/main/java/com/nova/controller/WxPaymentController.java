package com.nova.controller;

import com.alibaba.fastjson.JSON;
import com.nova.model.User;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by Administrator on 2017/1/10 0010.
 */

@RestController
@RequestMapping("/wxpayment")
public class WxPaymentController {
    private static Logger logger = Logger.getLogger(WxPaymentController.class);

    /**
     * 商户平台提交参数串和与商户key哈希后的MD5值
     * @param name
     */
    @RequestMapping("/sign/{name}")
    public void sign(@PathVariable("name") String name) {
        LocalDate date =  LocalDate.now();
        logger.info(name);
        logger.info(date);

    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView doView(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("name", name);
        return mv;
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public void jsonParamTest(@RequestBody List<User> users) {
        if(users != null){
            logger.info(users);
        }
        logger.info(JSON.toJSONString(users));
    }
}
