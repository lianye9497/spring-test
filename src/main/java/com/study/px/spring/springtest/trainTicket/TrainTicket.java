package com.study.px.spring.springtest.trainTicket;

import com.alibaba.dubbo.cache.support.lru.LruCache;
import com.alibaba.dubbo.common.URL;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.study.px.spring.springtest.util.OkHttpUtil;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.CollectionUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-01-31 10:29
 **/
public class TrainTicket {
    private static volatile List<StationNameVO> stationNames = new ArrayList<>();
    private static volatile Map<String, StationNameVO> stationNameVOMap = new HashMap<>();
    private static String URL_STR = "https://kyfw.12306.cn/otn/leftTicket/queryZ?leftTicketDTO.train_date=%s&leftTicketDTO.from_station=%s&leftTicketDTO.to_station=HHQ";
    private static String END = "&purpose_codes=ADULT";

    public static void main(String[] args) {
        ss();
    }

    public static List<TrainTicketVO> query(TrainTicketQueryVO vo) {
        String format = String.format(URL_STR, vo.getStartTime(), vo.getFrom(), vo.getTo());
        format = format + END;
        String json = OkHttpUtil.requestOfGet(format, null, null);
        if (StringUtils.isEmpty(json)) {
            return new ArrayList<>();
        }
        JSONObject jsonObject = JSON.parseObject(json);
        JSONObject data = jsonObject.getJSONObject("data");
        if (data == null) {
            return new ArrayList<>();
        }
        String flag = data.getString("flag");
        if (!"1".equals(flag)) {
            return new ArrayList<>();
        }
        JSONArray result = data.getJSONArray("result");
        if (result == null || result.isEmpty()) {
            return new ArrayList<>();
        }
        List<TrainTicketVO> list = new ArrayList<>(result.size());
        for (int i = 0; i < result.size(); i++) {
            //|预订|780000K83402|K834|GIW|SNH|HHQ|HGH|03:37|21:34|17:57|N|n7gUUTFuUcXJewXJgmBWaqJeme%2FBp8fBsIjJ84vKPnhWOZDUiVY7%2FmFtEAI%3D|
            // 20190209|3|W2|03|19|0|0||||无|||无||无|无|||||10401030|1413|0|0|null
            String o = (String) result.get(i);
            System.out.println(o);
            if (StringUtils.isEmpty(o)) {
                continue;
            }
            String[] split = o.split("\\|");
            if (split.length <= 1) {
                continue;
            }
            TrainTicketVO trainTicketVO = new TrainTicketVO();
            String trainNo = split[3];
            trainTicketVO.setTrainNo(trainNo);
            String startTime = split[8];
            trainTicketVO.setStartTime(startTime);
            String endTime = split[9];
            trainTicketVO.setEndTime(endTime);
            String consumeTime = split[10];
            trainTicketVO.setConsumeTime(consumeTime);
            String highGradeSoftBerth = split[25];//高级软卧
            trainTicketVO.setHighGradeSoftBerth(highGradeSoftBerth);
            String firstSoftSleeper = split[23]; //一等软卧
            trainTicketVO.setFirstSoftSleeper(firstSoftSleeper);
            String twoHardSleeper = split[26];//二等硬卧
            trainTicketVO.setTwoHardSleeper(twoHardSleeper);
            String softSeat = split[25];//软座
            trainTicketVO.setSoftSeat(softSeat);
            String hardSeat = split[28];//硬座
            trainTicketVO.setHardSeat(hardSeat);
            String noSeat = split[29];//无座
            trainTicketVO.setNoSeat(noSeat);
            String businessSeats = null; //商务座 32
            String firstSeat = null; //一等座 31
            String twoSeat = null;//二等座 30 17
            if ("OM9".equals(split[35])) {
                businessSeats = split[32]; //商务座 32
                firstSeat = split[31]; //一等座 31
                twoSeat = split[30];//二等座 30 17
            } else if ("OMP".equals(split[35])) {
                businessSeats = split[25]; //商务座
                firstSeat = split[30]; //一等座
                twoSeat = split[31];//二等座 30
            }
            trainTicketVO.setBusinessSeats(businessSeats);
            trainTicketVO.setFirstSeat(firstSeat);
            trainTicketVO.setTwoSeat(twoSeat);
            trainTicketVO.setStartStation(mapStation(split[6]));
            trainTicketVO.setEndStation(mapStation(split[7]));
            trainTicketVO.setOriginatingStation(mapStation(split[4]));
            trainTicketVO.setFinalStation(mapStation(split[5]));
            list.add(trainTicketVO);
        }
        return list;
    }
//|预订|56000G483501|G4835|HGH|KQW|HGH|KAQ|06:16|12:50|06:34|Y|0fBAtrVXxsbrDscdTu3uBNHm3uroBcvzosv1Z1EyXrthP3CS|20190210|3|HZ|01|14|1|0|||||||||||无|有|有||O0M090|OM9|0|0|null
//|预订|5l000G132160|G1321|AOH|KQW|HGH|KAQ|06:59|13:45|06:46|Y|UUbnXPxZPR27s5yte65zXPDT7v1JdedyZUUmba4640XODxpX|20190210|3|HZ|02|19|1|0|||||||||||17|6|3||O0M090|OM9|1|0|null

    private static String mapStation(String abbreviation) {
        StationNameVO stationNameVO = stationNameVOMap.get(abbreviation);
        if (stationNameVO == null) {
            return null;
        }
        return stationNameVO.getName();
    }

    public static List<StationNameVO> getStationNames() {
        if (!CollectionUtils.isEmpty(stationNames)) {
            return stationNames;
        }
        synchronized (StationNameVO.class) {
            if (!CollectionUtils.isEmpty(stationNames)) {
                return stationNames;
            }
            loadStationNames();
        }
        return stationNames;
    }

    private static void loadStationNames() {
        Resource data = new ClassPathResource("station_names.json");
        try {
            JSONObject json = JSON.parseObject(FileCopyUtils.copyToString(new FileReader(data.getFile())));
            String stations = json.getString("stations");
            String[] split = stations.split("\\|");
            for (int i = 0; i < split.length; ) {
                StationNameVO stationNameVO = new StationNameVO();
                if (i != 0) {
                    String[] split1 = split[i].split("@");
                    if (split1.length == 2) {
                        stationNameVO.setNo(split1[1]);
                    }
                } else {
                    stationNameVO.setNo(split[i]);
                }
                if (i + 4 > split.length) {
                    System.out.println(1);
                    break;
                }
                stationNameVO.setAbbreviation(split[i + 2]);
                stationNameVO.setName(split[i + 1]);
                stationNameVO.setPinyin(split[i + 3]);
                stationNames.add(stationNameVO);
                i += 5;
            }
            stationNameVOMap = stationNames.stream().collect(Collectors.toMap(StationNameVO::getAbbreviation, p -> p));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void ss(){
        Map<String, String> parameters = new HashMap<>();
        parameters.put("cache.size", "10");
        URL url = new URL("http", "localhos", 8028, parameters);
        LruCache lruCache = new LruCache(url);
        for (int i = 0; i < 10; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("id", ""+i);
            String s = map.toString();
            lruCache.put(s, "1");
        }
        Map<String, String> map1 = new HashMap<>();
        map1.put("id", ""+0);
        String s1 = map1.toString();
        lruCache.put(s1, "1");
        for (int i = 6; i < 11; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("id", ""+i);
            String s = map.toString();
            lruCache.put(s, "1");
        }
        System.out.println(lruCache);
    }

}
