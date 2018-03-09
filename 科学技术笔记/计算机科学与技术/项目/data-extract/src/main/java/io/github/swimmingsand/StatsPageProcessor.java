package io.github.swimmingsand;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zlq on 11/30/15.
 *
 * 用电量
 * http://www.nea.gov.cn/2015v/policy/qt.htm
 */
public class StatsPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(10000);

    public void process(Page page) {
        List<String> requests = page.getHtml().links().regex("(http://www.stats.gov.cn/was5/web/search?.*)").all();
        page.addTargetRequests(requests);
        Selectable section = page.getHtml().$("body > div.home > div > div.center > div.center_list > ul");
        //page.putField("section", section.toString());
        Selectable lists = section.$("li");
        List<Selectable> nodes = lists.nodes();
        String titleNum;
        String titleText;
        String dateText;
        String contentText;
        List<DataItem> dataItemList = new ArrayList<DataItem>();

        for (int i = 0; i < nodes.size(); i++) {
            Selectable title = nodes.get(i).$("li > span:nth-child(1) > font.cont_tit03");
            Selectable date = nodes.get(i).$("li > span:nth-child(1) > font.cont_tit02");
            Selectable content = nodes.get(i).$("li > span:nth-child(2)");
            //body > div.home > div > div.center > div.center_list > ul > li:nth-child(1) > span:nth-child(2)
            if (title !=null && date !=null && content !=null) {
                titleNum = title.regex(">([0-9]+).&nbsp",1).toString();
                titleText = title.regex("</script> (.*) </font>").toString();
                dateText = date.regex(">(.*)<",1).toString();
                contentText = content.regex(">(.*)<",1).toString();

                //dataItemList.add(titleNum+"\t"+titleText+"\t"+dateText);
                dataItemList.add(new DataItem(titleNum, titleText, dateText, contentText));
            }
        }
        page.putField("dataItem", dataItemList);
        //body > div.home > div > div.center > div.center_list > ul > li:nth-child(1) > span:nth-child(1) > font.cont_tit03
        //body > div.home > div > div.center > div.center_list > ul > li:nth-child(1) > span:nth-child(1) > font.cont_tit02
        //body > div.home > div > div.center > div.center_list > ul > li:nth-child(1) > span:nth-child(2)
    }

    public Site getSite() {
        return site;
    }
}
