package com.buxingzhe.pedestrian.http;

/**
 * Created by zhaishaoping on 27/03/2017.
 */

public class NetRequestParams {

    //*************************** Server ****************************
    public static final String WALK_SERVER_HOST = "http://115.28.109.174:8282/"; // http://222.128.13.159:8585/walkman //http://115.28.109.174:8282/walkman/
//    public static final String WALK_SERVER_HOST = "http://pacers.yjxtech.com/api/";


    //*************************** User ****************************
    /** 手机号登陆 */
    public static final String WALK_USER_LOGIN_PHONE = "walkman/wmUser/mobileLogin";
    /** 用户登陆 */
    public static final String WALK_USER_LOGIN = "walkman/wmUser/login";
    /** 修改用户信息 */
    public static final String WALK_USER_MODIFY_USER_INFO = "walkman/wmUser/modifyUserInformationAndAvatar";
    /** 增加用户步票 */
    public static final String WALK_USER_ADD_WALK_NUM = "walkman/wmUser/addWalkMoneyAmount";
    /** 获取用户信息 */
    public static final String WALK_USER_GET_INFO = "walkman/wmUser/getUserInformation";
    /** 用户注册 */
    public static final String WALK_USER_REGISTER = "walkman/wmUser/registe";

    //*************************** Walk ****************************
    /** 上传步行或者骑行记录 */
    public static final String WALK_UPLOAD_WALK = "walkman/wmWalkRecord/addWalkRecord";
    /** 获取步行或者骑行记录*/
    public static final String WALK_GET_WALK_RECORD = "walkman/wmWalkRecord/getWalkRecord";


    //*************************** Weather ****************************
    /** 获取今天天气信息 */
    public static final String WALK_GET_CURRENT_WEATHER = "walkman/wmWeather/getCurWeather";
    /** 获取历史天气信息 */
    public static final String WALK_GET_HISTORY_WEATHER = "walkman/wmWeather/getHistoryWeather";





}
