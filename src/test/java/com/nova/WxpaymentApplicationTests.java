package com.nova;

import com.alibaba.fastjson.JSON;
import com.nova.model.WechatConfig;
import com.nova.model.WechatUnifiedOrder;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WxpaymentApplicationTests {

	private static Logger logger = Logger.getLogger(WxpaymentApplicationTests.class);

	@Test
	public void contextLoads() {
	}

	/**
	 * 测试下单
	 */
	@Test
	public void testunifiedOrder(){
		WechatUnifiedOrder request = new WechatUnifiedOrder();
		request.setBody("测试商品");
		request.setDetail("微信支付测试");
		request.setGoods_tag("测试");
		request.setOut_trade_no(System.currentTimeMillis()+"");
		request.setFee_type("CNY");
		request.setTotal_fee(100);
		request.setSpbill_create_ip("127.0.0.1");
		request.setTime_start(System.currentTimeMillis()+"");
		request.setLimit_pay("cera");
		WechatUnifiedOrder.Response response = WechatConfig.getInstance().unifiedOrder(request);

		logger.info(JSON.toJSONString(response));
		logger.info(request.getAppid());
		logger.info(response.getResult_code());
		logger.info(response.getErr_code());
	}

}
