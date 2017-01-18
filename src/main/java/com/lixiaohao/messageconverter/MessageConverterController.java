package com.lixiaohao.messageconverter;

import com.lixiaohao.messageconverter.model.JsonReturnMessage;
import com.lixiaohao.messageconverter.model.XmlReturnMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lixiaohao on 2017/1/17
 *
 * @Description
 * @Create 2017-01-17 14:52
 * @Company
 */
@Controller
@RequestMapping("/messageConverter")
public class MessageConverterController {

    @RequestMapping("xml")
    @ResponseBody
    public   XmlReturnMessage xmlMessage(){
        XmlReturnMessage message = new XmlReturnMessage();
        message.setName("liudehua");
        message.setAge(12);
        message.setAddr("shagnhai");
        return message;
    }

    @RequestMapping("json")
    @ResponseBody
    public JsonReturnMessage jsonMessage(){
        JsonReturnMessage json = new JsonReturnMessage();
        json.setAddr("attr");
        json.setAge(15);
        json.setName("name");
        return json;
    }

}
