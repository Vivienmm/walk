package com.buxingzhe.pedestrian.bean.user;

/**
 * 用户登陆后的数据Bean
 * Created by zhaishaoping on 26/03/2017.
 */

public class  UserLoginResultInfo {
    private String id;//userID
    private String createTime;//创建时间
    private String avatarUrl;//头像链接
    private String nickName;//昵称
    private String gender;//性别
    private String height;//身高cm
    private String weight;//体重kg
    private String age;//年龄
    private String score;//积分
    private String walkMoney;//步票
    private String unionId;//qq唯一标识
    private String openid;
    private String token;//访问凭证
    private String mobile;// 手机登陆接口 返回的手机号
    private String registerType;// //注册类型 0 QQ 1 微信

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getWalkMoney() {
        return walkMoney;
    }

    public void setWalkMoney(String walkMoney) {
        this.walkMoney = walkMoney;
    }

    public String getRegisterType() {
        return registerType;
    }

    public void setRegisterType(String registerType) {
        this.registerType = registerType;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserLoginResultInfo{" +
                "id='" + id + '\'' +
                ", createTime='" + createTime + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", nickName='" + nickName + '\'' +
                ", gender='" + gender + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", age='" + age + '\'' +
                ", score='" + score + '\'' +
                ", walkMoney='" + walkMoney + '\'' +
                ", unionId='" + unionId + '\'' +
                ", openid='" + openid + '\'' +
                ", token='" + token + '\'' +
                ", mobile='" + mobile + '\'' +
                ", registerType='" + registerType + '\'' +
                '}';
    }
}
