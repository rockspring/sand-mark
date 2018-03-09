package io.github.swimmingsand;

/**
 * Created by zlq on 11/30/15.
 */
public class DataItem {
    public DataItem(String titleNum, String titleText, String dateText, String content) {
        this.titleNum = titleNum;
        this.titleText = titleText;
        this.dateText = dateText;
        this.content = content;
    }
    public String titleNum;
    public String titleText;
    public String dateText;
    public  String content;
}
