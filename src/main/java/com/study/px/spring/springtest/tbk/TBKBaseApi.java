package com.study.px.spring.springtest.tbk;

import com.alibaba.druid.util.StringUtils;
import com.taobao.api.*;
import com.taobao.api.request.*;
import com.taobao.api.response.*;

/**
 * @description:
 * @author: 苏定
 * @create: 2018-10-08 10:04
 **/
public class TBKBaseApi {

    private final static String sandBoxPrefix = "http://gw.api.tbsandbox.com/router/rest";

    private final static String prefix = "http://gw.api.taobao.com/router/rest";

    private final static String appKey = "24963849";

    private final static String secret = "69e4e1546f3dfd0bd15dd814bd6510f6";

    private static TaobaoClient getSandBoxClient() {
        return new DefaultTaobaoClient(sandBoxPrefix, appKey, secret);
    }

    private static TaobaoClient getClient() {
        return new DefaultTaobaoClient(prefix, appKey, secret);
    }

    private static TaobaoResponse apiExecute(BaseTaobaoRequest request) {
        TaobaoClient client = getClient();
        TaobaoResponse rsp = null;
        try {
            if (StringUtils.isEmpty(request.getBatchApiSession())) {
                rsp = client.execute(request);
            } else {
                rsp = client.execute(request, request.getBatchApiSession());
            }
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return rsp;
    }

    /**
     * 淘宝客商品查询
     *
     * @param req
     * @return
     */
    public static TbkItemGetResponse itemGet(TbkItemGetRequest req) {
        if (StringUtils.isEmpty(req.getFields())) {
            req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick");
        }
        return (TbkItemGetResponse) apiExecute(req);
    }

    /**
     * 淘宝客商品关联推荐查询
     *
     * @param req
     * @return
     */
    public static TbkItemRecommendGetResponse itemRecommendGet(TbkItemRecommendGetRequest req) {
        if (StringUtils.isEmpty(req.getFields())) {
            req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url");
        }
        return (TbkItemRecommendGetResponse) apiExecute(req);
    }

    /**
     * 淘宝客商品详情（简版）
     *
     * @param req
     * @return
     */
    public static TbkItemInfoGetResponse itemInfoGet(TbkItemInfoGetRequest req) {
        return (TbkItemInfoGetResponse) apiExecute(req);
    }

    /**
     * 淘宝客店铺查询
     *
     * @param req
     * @return
     */
    public static TbkShopGetResponse shopGet(TbkShopGetRequest req) {
        if (StringUtils.isEmpty(req.getFields())) {
            req.setFields("user_id,shop_title,shop_type,seller_nick,pict_url,shop_url");
        }
        return (TbkShopGetResponse) apiExecute(req);
    }

    /**
     * 淘宝客店铺关联推荐查询
     *
     * @param req
     * @return
     */
    public static TbkShopRecommendGetResponse shopRecommendGet(TbkShopRecommendGetRequest req) {
        if (StringUtils.isEmpty(req.getFields())) {
            req.setFields("user_id,shop_title,shop_type,seller_nick,pict_url,shop_url");
        }
        return (TbkShopRecommendGetResponse) apiExecute(req);
    }

    public static TbkUatmEventItemGetResponse uatmEventItemGet(TbkUatmEventItemGetRequest req) {
        if (StringUtils.isEmpty(req.getFields())) {
            req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick,shop_title,zk_final_price_wap,event_start_time,event_end_time,tk_rate,type,status");
        }
        return (TbkUatmEventItemGetResponse) apiExecute(req);
    }

    /**
     * 通用物料搜索API (超级搜索)
     *
     * @param req
     * @return
     */
    public static TbkScMaterialOptionalResponse scMaterialOptional(TbkScMaterialOptionalRequest req) {
        return (TbkScMaterialOptionalResponse) apiExecute(req);
    }

    /**
     * 生成优惠卷
     *
     * @param req
     * @return
     */
    public static TbkTpwdCreateResponse tpwdCreate(TbkTpwdCreateRequest req) {
        return (TbkTpwdCreateResponse) apiExecute(req);
    }

    /**
     * 订单列表
     *
     * @param req
     * @return
     */
//    public static TbkTpwdCreateResponse orderGet(TbkOrderGetRequest req) {
//        return (TbkTpwdCreateResponse) apiExecute(req);
//    }

    /**
     *  获取淘宝联盟选品库列表
     * @param req
     * @return
     */
    public static TbkUatmFavoritesGetResponse uatmFavoritesGet(TbkUatmFavoritesGetRequest req) {
        if (req.getFields() == null) {
            req.setFields("favorites_title,favorites_id,type");
        }
        if (req.getType() == null){
            req.setType(-1L);
        }
        return (TbkUatmFavoritesGetResponse) apiExecute(req);
    }

    /**
     * 获取淘宝联盟选品库的宝贝信息
     * @param req
     * @return
     */
    public static TbkUatmFavoritesItemGetResponse uatmFavoritesItemGet(TbkUatmFavoritesItemGetRequest req) {
        if (req.getFields() == null) {
            req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick,shop_title,zk_final_price_wap,event_start_time,event_end_time,tk_rate,status,type");
        }
        return (TbkUatmFavoritesItemGetResponse) apiExecute(req);
    }


}
