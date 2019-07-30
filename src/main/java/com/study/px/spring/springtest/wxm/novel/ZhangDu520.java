package com.study.px.spring.springtest.wxm.novel;

import com.alibaba.druid.util.StringUtils;
import com.study.px.spring.springtest.util.OkHttpUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 掌读520
 * @author: 苏定
 * @create: 2019-07-24 15:44
 **/

@Slf4j
public class ZhangDu520 {

    static OkHttpClient client = OkHttpUtil.getClient(5000);

    public static void main(String[] args) {
//        login();
//        search();
        articleHome();
    }


    //登陆
    public static void login() {
        String url = "https://novel.zhangdu520.com/default/login";
        Map<String, String> headers = getHeaders("/default/login", "https://novel.zhangdu520.com/default/login");
        Map<String, String> params = new HashMap<>();
        params.put("username", "yfss88");
        params.put("password", "xiaoshuo6688");
        params.put("act", "login");
//        client.cookieJar().loadForRequest();
        String s = OkHttpUtil.requestOfFormPost(url, params, null);
        System.out.println(s);
    }

    //搜索

    public static void search() {
        String key = "最强奶爸在都市";
        String url = "https://novel.zhangdu520.com/article/list?key=%s";
        Map<String, String> headers = getHeaders(null, null);
        String format = String.format(url, key);
        String s =  OkHttpUtil.requestOfGet(format, headers, null);
        if (StringUtils.isEmpty(s)){
            return;
        }
        Document document = Jsoup.parse(s);
        Elements table = document.getElementsByClass("article_list");
        if (CollectionUtils.isEmpty(table)){
            return;
        }
        Elements tbody = table.get(0).getElementsByTag("tbody");
        if (CollectionUtils.isEmpty(tbody)){
            return;
        }
        Elements trs = tbody.get(0).getElementsByTag("tr");
        if (CollectionUtils.isEmpty(trs)){
            return;
        }
        for (Element tr : trs) {
            Elements tds = tr.getElementsByTag("td");
            if (CollectionUtils.isEmpty(tds)){
                continue;
            }
            String imgSrc = tds.get(0).getElementsByTag("img").attr("src");//图片
            String name = tds.get(1).childNodes().get(0).toString();//书名
            String status = tds.get(2).text();//状态
            String channel = tds.get(3).text();//频道
            String category = tds.get(4).text();//分类
            String heat = tds.get(5).text();//热度
            Elements as = tds.get(8).getElementsByTag("a");
            if (CollectionUtils.isEmpty(as)){
                continue;
            }
            String href = as.get(0).attr("href");//链接地址
            log.info("\n图片={},\n 书名={},\n 状态={},\n 频道={},\n 分类={},\n 热度={},\n 链接地址={}",
                    imgSrc, name, status, channel, category, heat, href);
        }
        //https://novel.zhangdu520.com/article/list?key=%E6%9C%80%E5%BC%BA%E5%A5%B6%E7%88%B8%E5%9C%A8%E9%83%BD%E5%B8%82
//        https://novel.zhangdu520.com/article/list?key=%E6%9C%80%E5%BC%BA%E5%A5%B6%E7%88%B8%E5%9C%A8%E9%83%BD%E5%B8%82
    }

    private static Map<String, String> getHeaders(String path, String referer) {
        Map<String, String> headers = new HashMap<>();
//        headers.put(":authority", "novel.zhangdu520.com");
//        headers.put(":method", "GET");
//        headers.put(":path", path);
//        headers.put(":scheme", "https");
//        headers.put("accept","POST");
        headers.put("cookie", "PHPSESSID=ec8d66b2f607e06b97f59697edbf98e9; SERVERID=420e7a2ba307810e3d82f25917a58586|1564034016|1564033957");
//        headers.put("origin", "https://novel.zhangdu520.com");
//        headers.put("referer", referer);
        return headers;
    }

    //文章首页
    public static void articleHome() {
        //https://novel.zhangdu520.com/article/view?articleid=8481
        String url="https://novel.zhangdu520.com/article/view?articleid=8481";
        Map<String, String> headers = getHeaders(null, null);
        String s = OkHttpUtil.requestOfGet(url, headers, null);
        if (StringUtils.isEmpty(s)){
            return;
        }
        Document document = Jsoup.parse(s);
        Elements table = document.getElementsByTag("table");
        if (CollectionUtils.isEmpty(table)){
            return;
        }
        Elements tbody = table.get(0).getElementsByTag("tbody");
        if (CollectionUtils.isEmpty(tbody)){
            return;
        }
        Elements trs = tbody.get(0).getElementsByTag("tr");
        if (CollectionUtils.isEmpty(trs)){
            return;
        }
        for (Element tr : trs) {
            Elements tds = tr.getElementsByTag("td");
            if (CollectionUtils.isEmpty(tds)){
                continue;
            }
            String no = tds.get(0).text();//序号
            Elements lis = tds.get(1).getElementsByTag("li");
            if (CollectionUtils.isEmpty(lis)){
                continue;
            }
            String textAttr = lis.get(0).getElementsByTag("a").get(0).attr("href");
            String imageAttr = lis.get(1).getElementsByTag("a").get(0).attr("href");
            String bgimageAttr = lis.get(2).getElementsByTag("a").get(0).attr("href");
            log.info("序号={}, bgimageAttr={}", no, bgimageAttr);
        }
    }

    public void articleContent(){
        String url = "https://novel.zhangdu520.com/wxeditor/view?mtype=bgimage&aid=5274379";
        Map<String, String> headers = getHeaders(null, null);
        String s = OkHttpUtil.requestOfGet(url, headers, null);

    }


}