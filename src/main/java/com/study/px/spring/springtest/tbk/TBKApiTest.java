package com.study.px.spring.springtest.tbk;

import com.taobao.api.request.*;
import com.taobao.api.response.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: 苏定
 * @create: 2018-10-08 11:02
 **/
public class TBKApiTest {

    public static void main(String[] args) {
        uatmFavoritesGet();
    }

    /**
     * 淘宝客商品查询
     */
    public static void itemGetTest() {
        TbkItemGetRequest req = new TbkItemGetRequest();
        req.setQ("女装");
        TbkItemGetResponse response = TBKBaseApi.itemGet(req);
        if (!response.isSuccess()) {
            System.out.println("请求失败," + response.getMsg());
            return;
        }
        if (response.getTotalResults() != null)
            System.out.println("total=" + response.getTotalResults());
        response.getResults().forEach(item -> System.out.println(item.getTitle() + "," + item.getNumIid()));
    }

    public static void itemRecommendGet() {
        TbkItemRecommendGetRequest req = new TbkItemRecommendGetRequest();
        req.setNumIid(576464985535L);
        TbkItemRecommendGetResponse response = TBKBaseApi.itemRecommendGet(req);
        System.out.println(response.getResults());
    }

    public static void itemInfoGet() {
        TbkItemInfoGetRequest req = new TbkItemInfoGetRequest();
        req.setNumIids("576464985535,574243047558");
        TbkItemInfoGetResponse response = TBKBaseApi.itemInfoGet(req);
        System.out.println(response.getBody());
    }

    public static void shopGet() {
        TbkShopGetRequest req = new TbkShopGetRequest();
        req.setQ("女装");
        TbkShopGetResponse response = TBKBaseApi.shopGet(req);
        System.out.println(response.getBody());
    }

    public static void shopRecommendGet() {
        TbkShopRecommendGetRequest req = new TbkShopRecommendGetRequest();
        req.setUserId(845929914L);
        TbkShopRecommendGetResponse response = TBKBaseApi.shopRecommendGet(req);
        System.out.println(response.getBody());
    }

    public static void uatmEventItemGet() {
        TbkUatmEventItemGetRequest req = new TbkUatmEventItemGetRequest();
        req.setPlatform(1L);
        req.setPageSize(20L);
        req.setAdzoneId(34567L);
        req.setUnid("3456");
        req.setEventId(123456L);
        req.setPageNo(1L);
        TbkUatmEventItemGetResponse response = TBKBaseApi.uatmEventItemGet(req);
        System.out.println(response.getBody());
    }

    public static void scMaterialOptional() {
        TbkScMaterialOptionalRequest req = new TbkScMaterialOptionalRequest();
        req.setQ("女装");
        req.setAdzoneId(8854150364L);
        req.setSiteId(46800578L);
        req.setHasCoupon(true);
//        req.setcon

        //        "6201506c0bbde2ZZ4a3b72cffb9b387035f7aa7c11c39c64019684950"
//6101407b46da7a21875f909d07144993c5048c0332c084a4019684950
        req.setBatchApiSession("6101407b46da7a21875f909d07144993c5048c0332c084a4019684950");
        TbkScMaterialOptionalResponse response = TBKBaseApi.scMaterialOptional(req);
        List<TbkScMaterialOptionalResponse.MapData> resultList = response.getResultList();
        Set<String> s = new HashSet<>();
        resultList.forEach(item->{
            s.add(item.getCouponShareUrl());
        });

        System.out.println(resultList.toString());

        System.out.println(response.getBody());
        System.out.println(s.size());
    }

    public static void tpwdCreate() {
        TbkTpwdCreateRequest req = new TbkTpwdCreateRequest();
        req.setUserId("845929914");
        req.setText("长度大于5个字符");
        req.setUrl("https://uland.taobao.com/coupon/edetail?e=RPUADeQFX%2FANfLV8niU3RwXoB%2BDaBK5LQS0Flu%2FfbSog%2BeE%2BjpQFGNpsAmOX0u61tVNRlA%2Fi6pDX%2BRDg1qur4vT2f3vty1KkTFrPXfXP8LJpK7ezpgddoKdYHKckIsQF8uqoDa04DU9%2B7VRqfIsJEXpCJJY2OI0xdo%2FCSPVOJtYhsugmXM%2BcPVJ1xZIMp9VH8ibbZxVXWR6mfheg6aTAuSOY0pZAr%2Fq9GWqNBzv719M%3D&&app_pvid=0bba882b15389986464417478e&ptl=floorId:2836;app_pvid:0bba882b15389986464417478e;tpp_pvid:100_11.182.89.163_169566_7841538998646508270&union_lens=lensId:0b013690_0d87_1665377b786_e0fd/");
        req.setLogo("https://uland.taobao.com/");
        req.setExt("{\"userId\": 12121}");
        TbkTpwdCreateResponse response = TBKBaseApi.tpwdCreate(req);
        System.out.println(response.getBody());
    }

//    public static void orderGet() {
//        TbkTpwdCreateRequest req = new TbkTpwdCreateRequest();
//        req.setUserId("845929914");
//        req.setText("长度大于5个字符");
//        req.setUrl("https://uland.taobao.com/coupon/edetail?e=RPUADeQFX%2FANfLV8niU3RwXoB%2BDaBK5LQS0Flu%2FfbSog%2BeE%2BjpQFGNpsAmOX0u61tVNRlA%2Fi6pDX%2BRDg1qur4vT2f3vty1KkTFrPXfXP8LJpK7ezpgddoKdYHKckIsQF8uqoDa04DU9%2B7VRqfIsJEXpCJJY2OI0xdo%2FCSPVOJtYhsugmXM%2BcPVJ1xZIMp9VH8ibbZxVXWR6mfheg6aTAuSOY0pZAr%2Fq9GWqNBzv719M%3D&&app_pvid=0bba882b15389986464417478e&ptl=floorId:2836;app_pvid:0bba882b15389986464417478e;tpp_pvid:100_11.182.89.163_169566_7841538998646508270&union_lens=lensId:0b013690_0d87_1665377b786_e0fd/");
//        req.setLogo("https://uland.taobao.com/");
//        req.setExt("{\"userId\": 12121}");
//        TbkTpwdCreateResponse response = TBKBaseApi.tpwdCreate(req);
//        System.out.println(response.getBody());
//    }

    public static void uatmFavoritesGet() {
        TbkUatmFavoritesGetRequest req = new TbkUatmFavoritesGetRequest();
        req.setPageNo(1L);
        req.setPageSize(20L);
//        req.setType(1L);
        TbkUatmFavoritesGetResponse response = TBKBaseApi.uatmFavoritesGet(req);
        System.out.println(response.getBody());
    }
}
