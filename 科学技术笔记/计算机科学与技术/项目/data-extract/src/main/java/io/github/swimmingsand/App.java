package io.github.swimmingsand;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import us.codecraft.webmagic.Spider;

public class App
{
    public static void test() throws Exception{
        System.out.println( "Hello World!" );
        Document doc = Jsoup.connect("http://www.stats.gov.cn/was5/web/search?searchscope=&channelid=288041&andsen=+%E5%8F%91%E7%94%B5%E9%87%8F&total=&orsen=&exclude=&presearchword=&templet=&prepage=20&orderby=-DOCRELTIME&andsen2=%E5%8F%91%E7%94%B5%E9%87%8F&secondsearch=ON").get();
        Elements newsHeadlines = doc.select("body > div.home > div > div.center > div.center_list > ul");
        //body > div.home > div > div.center > div.center_list > ul > li:nth-child(1) > span:nth-child(1) > font.cont_tit02
        Elements item = newsHeadlines.select("li:nth-child(1) > span:nth-child(1) > font.cont_tit02");
        String date = item.get(0).text();
    }
    public static void main( String[] args )
    throws Exception{
        String startUrl = "http://www.stats.gov.cn/was5/web/search?searchscope=&channelid=288041&andsen=+%E5%8F%91%E7%94%B5%E9%87%8F&total=&orsen=&exclude=&presearchword=&templet=&prepage=20&orderby=-DOCRELTIME&andsen2=%E5%8F%91%E7%94%B5%E9%87%8F&secondsearch=ON";

        Spider.create(new StatsPageProcessor()).addUrl(startUrl).addPipeline(new DataFilePipleline()).thread(5).run();
    }
}
