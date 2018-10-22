package com.study.px.spring.springtest.vo;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: suding
 * @create: 2018-06-26 12:05
 **/
@Data
public class PageSonVO extends PageVO {

    private String name;

    public static void main(String[] args) {
//        test("http://xiaoy.fed.ywwl.com/index/?user_id=76&source=share&channel_promotion_id=123456");
//        test("https://m.39ysj.com/index/?user_id=12345&source=share");
//        test("https://m.39ysj.com/index/?channel_promotion_id=12345&from=singlemessage");
test("redirectUrl=http://xiaoy.fed.ywwl.com/index/?source=share&channelPromotionId=2&code=001MrDJU0Z9sgX1RThJU0sKBJU0MrDJg&appid=wx5feea8d296f7f218");
    }

    public static void test(String s){
        try {
            if (StringUtils.isEmpty(s)){
                return;
            }
            String replace = s.replace("redirectUrl=", "");
            if (StringUtils.isEmpty(replace)){
                return;
            }

            URL url = new URL(replace);
            String query = url.getQuery();
            if (StringUtils.isEmpty(query)){
                return;
            }
            String[] split = query.split("&");
            JSONObject jsonObject = new JSONObject();
            if (split != null && split.length> 0){
                for (String s1 : split) {
                    String[] split1 = s1.split("=");
                    if (split1 != null && split1.length == 2){
                        jsonObject.put(split1[0], split1[1]);
                    }
                }
            }
            if (!"share".equals(jsonObject.getString("source"))){
                return;
            }
            if (!StringUtils.isEmpty(jsonObject.getString("userId"))
                    && !StringUtils.isEmpty(jsonObject.getString("channelPromotionId"))){
                System.out.println("同时存在渠道和用户" + jsonObject.toJSONString());

            }else if (!StringUtils.isEmpty(jsonObject.getString("userId"))){
                System.out.println("用户分享="+ jsonObject.toJSONString());

            }else if (!StringUtils.isEmpty(jsonObject.getString("channelPromotionId"))){
                System.out.println("渠道分享"+ jsonObject.toJSONString());

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
