package hello;

/**
 * Created by zlq on 6/3/15.
 */
public class CommunityIndexSource {
    private int id; // 小区ID
    private int cityid; // 城市ID
    private String areacode; // 区域板块编码
    private String name; // 名称
    private String address; // 地址
    private String iconImg; // 默认图片地址，运营维护
    private int saleNum; // 出售房源数
    private int rentNum; // 出租房源数，值等于0
    private int imgNum; // 图片数量
    private int threadNum; // 含义未知，值等于0
    private int hitsNum; // 含义未知，值等于0
    private String letter; // match_name字段的每个汉字拼音的首字母缩写，拼音字母全大写
    private int forumId; // 含义未知，不写值
    private String houseType; // 含义未知，不写值
    private int nhNum; // 含义未知，不写值
    private String areaString; // 区域名称
    private String subAreaString; // 板块名称
    private String mapx; // 含义未知
    private String mapy; // 含义未知
    private int integrity; // 小区完整度
    private int goodpicNum; // 小区图片数量，运营维护
    private int goodmodelNum; // 房型图片数量，运营维护
    private int showcommexpert; // 是否显示小区专家，添加人ID不等于0，添加人ID对应的人就是该小区专家
    private String matchName; // 小区名称去除特殊字符后的形式
    private String aliasName; // 小区别名
    private int isInternal; // 是否是内部小区，添加人ID不等于0的小区为内部小区
    private int metroId; // 含义未知，不写值
    private int metroStationId; // 含义未知，不写值
    private int metroDistance; // 含义未知，不写值
    private int metroLineDistance; // 含义未知，不写值
    private int metroStationDistance; // 含义未知，不写值
    private int metroDistanceMin; // 含义未知，不写值
    private int masterStore; // 含义未知，不写值
    private String otherName; // 小区别名去除特殊字符，用逗号分割出的字符串数组
    private String schoolId; // 附近学校ID，多个id组成的数组
    private String schoolName; // 附近学校名称，值等于""
    private String schoolTags; // 附近学校标签，值等于""
    private double commScore; // 小区分数，值等于0
    private double glat; // 小区谷歌坐标纬度
    private double glng; // 小区谷歌坐标经度
    private int opstate; // 小区是否已锁定
    private int senddate; // 竣工日期
    private double greenpert; // 绿化率
    private String usetype; // 物业类型，数字字符串数组
    private int housetotal; // 总户数
    private long buildarea; // 建筑面积
    private String commbuilder; // 开发商
    private String metroLines; // 小区附近地铁线路，数组
    private double blat; // 小区百度坐标纬度
    private double blng; // 小区百度坐标经度
    private String latlng; // 小区百度坐标纬度和经度，逗号分隔
    private String pinyin; // match_name字段对应的汉字拼音全拼，拼音字母全大写
    private String defname; // 小区默认名称
    private String defpinyin; // 小区默认名称对应的汉字拼音全拼，拼音字母全大写
    private int midPrice; // 小区月均价
    private float midChange; // 小区月均价涨跌幅度
}
