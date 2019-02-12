package com.study.px.spring.springtest.wy;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @description:
 * @author: 苏定
 * @create: 2018-11-01 10:10
 **/
public class WyTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String url= "http://api.vephp.com/pid?vekey=V00000443Y19684950&para=%s";
        String tkl ="https://s.click.taobao.com/tH93kKw";
        String encode = URLEncoder.encode(tkl, "UTF-8");
        String format = String.format(url, encode);
        System.out.println(format);
        String s = httpGet(format);
        System.out.println(s);
    }
    public static String httpGet(String str) {
        String result = null;
        try {
            URL url = new URL(str);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Accept-Charset", "UTF-8");
            urlConnection.setRequestProperty("contentType", "UTF-8");
            urlConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=UTF-8");

            InputStream inputStream = urlConnection.getInputStream();

            urlConnection.connect();
            if (urlConnection.getResponseCode() == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                String line;
                StringBuffer sbf = new StringBuffer();
                while ((line = bufferedReader.readLine()) != null) {
                    sbf.append(line);
//                    sbf.append("\r\n");
                }
                result = sbf.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
