package com.study.px.spring.springtest.controller;


import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.px.study.moremodule.client.CacheService;
import com.study.px.spring.springtest.BaseResult;
import com.study.px.spring.springtest.IgnoreToken;
import com.study.px.spring.springtest.MyException;
import com.study.px.spring.springtest.orm.model.Channel;
import com.study.px.spring.springtest.service.TestService;
import com.study.px.spring.springtest.vo.PageVO;
import com.study.px.spring.springtest.vo.Son;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@RestController
@RequestMapping("test")
public class TestController {

    @Resource
    private TestService testService;

    @Resource
    private CacheService cacheService;

    @IgnoreToken
    @GetMapping("cache")
    public void cache() {
        for (int n = 0; n < 1000; n++) {
            cacheService.findCache(String.valueOf(n));
        }
        String result1 = cacheService.findCache(String.valueOf(0));
        System.out.println(result1);
        String result2 = cacheService.findCache(String.valueOf(1001));
        System.out.println(result2);
    }

    @IgnoreToken
    @GetMapping("cache1/{id}")
    public void cache1(@PathVariable Integer id) {
        String result2 = cacheService.findCache(String.valueOf(id));
        System.out.println(result2);
    }

    public static void main(String[] args) {


//        List<String> list = new ArrayList<String>();
//        list.add("1");
//        list.add("2");
//        for (String item : list) {
//            if ("2".equals(item)) {
//                list.remove(item);
//            }
//        }
//        System.out.println(list.toString());
    }

    @IgnoreToken
    @GetMapping("test1")
    public String test1(HttpServletResponse response) {
        List<Channel> channels = testService.test1(1000);
        System.out.println("test1");
//        String s = "123";
        try {
            response.sendRedirect("https://www.baidu.com/");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        return "redirect:" +"https://www.baidu.com/";
        return "";
    }

    @IgnoreToken
    @GetMapping("test4")
    public void test4() {
        testService.test4();
        System.out.println("test4");
        String s = "123";
    }

    @IgnoreToken
    @GetMapping("test2")
    public String test2() throws Exception {
        List<Channel> channels = testService.test1(5000);
        System.out.println("test2");
        PageInfo<Channel> channelPageInfo = new PageInfo<>(channels);
        String s1 = JSONObject.toJSONString(channelPageInfo);
        throw new MyException("101", "Sam 错误");
        //  return s1;
    }

    @IgnoreToken
    @PostMapping("test3")
    public String test3(@RequestBody @Validated PageVO pageVO, BindingResult bindingResult) {
        String result = null;

        if (bindingResult.getErrorCount() == 0) {
            result = "通过验证！";
        }

        List<ObjectError> allErrors = bindingResult.getAllErrors();
        for (ObjectError error : allErrors) {
            String defaultMessage = error.getDefaultMessage();
            System.out.println(defaultMessage);
        }
        return "333";
    }

    @GetMapping("callbackTest")
    public String callbackTest() {
        testService.callbackTest();
        return "callbackTest";
    }

    @IgnoreToken
    @RequestMapping("/uploads")
    public @ResponseBody
    String upload(MultipartHttpServletRequest request,
                  HttpServletResponse response) throws Exception {
        String result = "";
        // 获取上传的所有文件名
        Iterator<String> itr = request.getFileNames();
        MultipartFile mpf = null;
        String UPLOADFILEPATH = "E:\\Axure";
        while (itr.hasNext()) {
            // 取出文件
            mpf = request.getFile(itr.next());
            try {
                File file = new File(UPLOADFILEPATH);
                if (!file.exists()) {
                    file.mkdirs();
                }
                // 输出(保存)文件
                try (FileOutputStream fos = new FileOutputStream(new File(UPLOADFILEPATH + mpf.getOriginalFilename()))) {
                    //获取文件的输入流并写入文件
                    InputStream fis = mpf.getInputStream();
                    byte[] buffer = new byte[1024];
                    int len = 0;
                    while ((len = fis.read(buffer)) != -1) {
                        fos.write(buffer, 0, len);
                        fos.flush();
                    }
                    //关闭流
                    fis.close();
                }
                mpf = null;
                result = "{\"success\":true}";
            } catch (IOException e) {
                result = "{\"success\":false}";
                e.printStackTrace();
            }

        }
        itr = null;
        return result;
    }

    @IgnoreToken
    @RequestMapping("fileUpload")
    public String  fileUpload(MultipartFile file) throws IOException {


        //用来检测程序运行时间
        long  startTime=System.currentTimeMillis();
        System.out.println("fileName："+file.getOriginalFilename());

        try {
            //获取输出流
            OutputStream os=new FileOutputStream("E:/"+new Date().getTime()+file.getOriginalFilename());
            //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
            InputStream is=file.getInputStream();
            int temp;
            //一个一个字节的读取并写入
            while((temp=is.read())!=(-1))
            {
                os.write(temp);
            }
            os.flush();
            os.close();
            is.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long  endTime=System.currentTimeMillis();
        System.out.println("方法一的运行时间："+String.valueOf(endTime-startTime)+"ms");
        return "/success";
    }

    @IgnoreToken
    @RequestMapping(value = "/uploadFile")
    public BaseResult uploadImg( @RequestParam("file") MultipartFile files, String uploadPath, Integer fileType) throws Exception {

        BaseResult result = new BaseResult<>();
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {

             return result;
        } catch (Exception ex) {
         }
         return result;
    }
}
