package hello;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

/**
 * Created by zlq on 6/3/15.
 */
@SolrDocument(solrCoreName = "collection1")
public class CommunityIndexSourceDoc {
    private @Id @Indexed int id; // 小区ID
    private @Indexed int cityid; // 城市ID
    private @Indexed String areacode; // 区域板块编码
    private @Indexed String name; // 名称
    private @Indexed String address; // 地址
    private @Indexed String iconImg; // 默认图片地址，运营维护
    private @Indexed int saleNum; // 出售房源数
    private @Indexed int rentNum; // 出租房源数，值等于0
    private @Indexed int imgNum; // 图片数量
    private @Indexed int threadNum; // 含义未知，值等于0
    private @Indexed int hitsNum; // 含义未知，值等于0
    private @Indexed String letter; // match_name字段的每个汉字拼音的首字母缩写，拼音字母全大写
    private @Indexed int forumId; // 含义未知，不写值
    private @Indexed String houseType; // 含义未知，不写值
    private @Indexed int nhNum; // 含义未知，不写值
    private @Indexed String areaString; // 区域名称
    private @Indexed String subAreaString; // 板块名称
    private @Indexed String mapx; // 含义未知
    private @Indexed String mapy; // 含义未知
    private @Indexed int integrity; // 小区完整度
    private @Indexed int goodpicNum; // 小区图片数量，运营维护
    private @Indexed int goodmodelNum; // 房型图片数量，运营维护
    private @Indexed int showcommexpert; // 是否显示小区专家，添加人ID不等于0，添加人ID对应的人就是该小区专家
    private @Indexed String matchName; // 小区名称去除特殊字符后的形式
    private @Indexed String aliasName; // 小区别名
    private @Indexed int isInternal; // 是否是内部小区，添加人ID不等于0的小区为内部小区
    private @Indexed int[] metroId; // 含义未知，不写值
    private @Indexed int[] metroStationId; // 含义未知，不写值
    private @Indexed int[] metroDistance; // 含义未知，不写值
    private @Indexed int[] metroLineDistance; // 含义未知，不写值
    private @Indexed int[] metroStationDistance; // 含义未知，不写值
    private @Indexed int metroDistanceMin; // 含义未知，不写值
    private @Indexed int masterStore; // 含义未知，不写值
    private @Indexed String[] otherName; // 小区别名去除特殊字符，用逗号分割出的字符串数组
    private @Indexed String[] schoolId; // 附近学校ID，多个id组成的数组
    private @Indexed String[] schoolName; // 附近学校名称，值等于""
    private @Indexed String[] schoolTags; // 附近学校标签，值等于""
    private @Indexed double commScore; // 小区分数，值等于0
    private @Indexed double glat; // 小区谷歌坐标纬度
    private @Indexed double glng; // 小区谷歌坐标经度
    private @Indexed int opstate; // 小区是否已锁定
    private @Indexed int senddate; // 竣工日期
    private @Indexed double greenpert; // 绿化率
    private @Indexed String[] usetype; // 物业类型，数字字符串数组
    private @Indexed int housetotal; // 总户数
    private @Indexed long buildarea; // 建筑面积
    private @Indexed String commbuilder; // 开发商
    private @Indexed String[] metroLines; // 小区附近地铁线路，数组
    private @Indexed double blat; // 小区百度坐标纬度
    private @Indexed double blng; // 小区百度坐标经度
    private @Indexed String latlng; // 小区百度坐标纬度和经度，逗号分隔
    private @Indexed String pinyin; // match_name字段对应的汉字拼音全拼，拼音字母全大写
    private @Indexed String defname; // 小区默认名称
    private @Indexed String defpinyin; // 小区默认名称对应的汉字拼音全拼，拼音字母全大写
    private @Indexed int midPrice; // 小区月均价
    private @Indexed float midChange; // 小区月均价涨跌幅度

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIconImg() {
        return iconImg;
    }

    public void setIconImg(String iconImg) {
        this.iconImg = iconImg;
    }

    public int getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }

    public int getRentNum() {
        return rentNum;
    }

    public void setRentNum(int rentNum) {
        this.rentNum = rentNum;
    }

    public int getImgNum() {
        return imgNum;
    }

    public void setImgNum(int imgNum) {
        this.imgNum = imgNum;
    }

    public int getThreadNum() {
        return threadNum;
    }

    public void setThreadNum(int threadNum) {
        this.threadNum = threadNum;
    }

    public int getHitsNum() {
        return hitsNum;
    }

    public void setHitsNum(int hitsNum) {
        this.hitsNum = hitsNum;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public int getNhNum() {
        return nhNum;
    }

    public void setNhNum(int nhNum) {
        this.nhNum = nhNum;
    }

    public String getAreaString() {
        return areaString;
    }

    public void setAreaString(String areaString) {
        this.areaString = areaString;
    }

    public String getSubAreaString() {
        return subAreaString;
    }

    public void setSubAreaString(String subAreaString) {
        this.subAreaString = subAreaString;
    }

    public String getMapx() {
        return mapx;
    }

    public void setMapx(String mapx) {
        this.mapx = mapx;
    }

    public String getMapy() {
        return mapy;
    }

    public void setMapy(String mapy) {
        this.mapy = mapy;
    }

    public int getIntegrity() {
        return integrity;
    }

    public void setIntegrity(int integrity) {
        this.integrity = integrity;
    }

    public int getGoodpicNum() {
        return goodpicNum;
    }

    public void setGoodpicNum(int goodpicNum) {
        this.goodpicNum = goodpicNum;
    }

    public int getGoodmodelNum() {
        return goodmodelNum;
    }

    public void setGoodmodelNum(int goodmodelNum) {
        this.goodmodelNum = goodmodelNum;
    }

    public int getShowcommexpert() {
        return showcommexpert;
    }

    public void setShowcommexpert(int showcommexpert) {
        this.showcommexpert = showcommexpert;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public int getIsInternal() {
        return isInternal;
    }

    public void setIsInternal(int isInternal) {
        this.isInternal = isInternal;
    }

    public int[] getMetroId() {
        return metroId;
    }

    public void setMetroId(int[] metroId) {
        this.metroId = metroId;
    }

    public int[] getMetroStationId() {
        return metroStationId;
    }

    public void setMetroStationId(int[] metroStationId) {
        this.metroStationId = metroStationId;
    }

    public int[] getMetroDistance() {
        return metroDistance;
    }

    public void setMetroDistance(int[] metroDistance) {
        this.metroDistance = metroDistance;
    }

    public int[] getMetroLineDistance() {
        return metroLineDistance;
    }

    public void setMetroLineDistance(int[] metroLineDistance) {
        this.metroLineDistance = metroLineDistance;
    }

    public int[] getMetroStationDistance() {
        return metroStationDistance;
    }

    public void setMetroStationDistance(int[] metroStationDistance) {
        this.metroStationDistance = metroStationDistance;
    }

    public int getMetroDistanceMin() {
        return metroDistanceMin;
    }

    public void setMetroDistanceMin(int metroDistanceMin) {
        this.metroDistanceMin = metroDistanceMin;
    }

    public int getMasterStore() {
        return masterStore;
    }

    public void setMasterStore(int masterStore) {
        this.masterStore = masterStore;
    }

    public String[] getOtherName() {
        return otherName;
    }

    public void setOtherName(String[] otherName) {
        this.otherName = otherName;
    }

    public String[] getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String[] schoolId) {
        this.schoolId = schoolId;
    }

    public String[] getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String[] schoolName) {
        this.schoolName = schoolName;
    }

    public String[] getSchoolTags() {
        return schoolTags;
    }

    public void setSchoolTags(String[] schoolTags) {
        this.schoolTags = schoolTags;
    }

    public double getCommScore() {
        return commScore;
    }

    public void setCommScore(double commScore) {
        this.commScore = commScore;
    }

    public double getGlat() {
        return glat;
    }

    public void setGlat(double glat) {
        this.glat = glat;
    }

    public double getGlng() {
        return glng;
    }

    public void setGlng(double glng) {
        this.glng = glng;
    }

    public int getOpstate() {
        return opstate;
    }

    public void setOpstate(int opstate) {
        this.opstate = opstate;
    }

    public int getSenddate() {
        return senddate;
    }

    public void setSenddate(int senddate) {
        this.senddate = senddate;
    }

    public double getGreenpert() {
        return greenpert;
    }

    public void setGreenpert(double greenpert) {
        this.greenpert = greenpert;
    }

    public String[] getUsetype() {
        return usetype;
    }

    public void setUsetype(String[] usetype) {
        this.usetype = usetype;
    }

    public int getHousetotal() {
        return housetotal;
    }

    public void setHousetotal(int housetotal) {
        this.housetotal = housetotal;
    }

    public long getBuildarea() {
        return buildarea;
    }

    public void setBuildarea(long buildarea) {
        this.buildarea = buildarea;
    }

    public String getCommbuilder() {
        return commbuilder;
    }

    public void setCommbuilder(String commbuilder) {
        this.commbuilder = commbuilder;
    }

    public String[] getMetroLines() {
        return metroLines;
    }

    public void setMetroLines(String[] metroLines) {
        this.metroLines = metroLines;
    }

    public double getBlat() {
        return blat;
    }

    public void setBlat(double blat) {
        this.blat = blat;
    }

    public double getBlng() {
        return blng;
    }

    public void setBlng(double blng) {
        this.blng = blng;
    }

    public String getLatlng() {
        return latlng;
    }

    public void setLatlng(String latlng) {
        this.latlng = latlng;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getDefname() {
        return defname;
    }

    public void setDefname(String defname) {
        this.defname = defname;
    }

    public String getDefpinyin() {
        return defpinyin;
    }

    public void setDefpinyin(String defpinyin) {
        this.defpinyin = defpinyin;
    }

    public int getMidPrice() {
        return midPrice;
    }

    public void setMidPrice(int midPrice) {
        this.midPrice = midPrice;
    }

    public float getMidChange() {
        return midChange;
    }

    public void setMidChange(float midChange) {
        this.midChange = midChange;
    }
}
