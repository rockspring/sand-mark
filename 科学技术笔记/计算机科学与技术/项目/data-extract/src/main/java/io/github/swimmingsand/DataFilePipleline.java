package io.github.swimmingsand;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;
import java.util.Map;

/**
 * Created by zlq on 11/30/15.
 */
public class DataFilePipleline implements Pipeline {

    public void process(ResultItems resultItems, Task task) {
        //遍历所有结果，输出到控制台，上面例子中的"author"、"name"、"readme"都是一个key，其结果则是对应的value
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            List<DataItem> dataItems =(List<DataItem>)entry.getValue();
            for (DataItem dataItem : dataItems) {
                if (dataItem != null) {
                    synchronized (this) {
                        System.out.println(dataItem.titleNum+"\t"+dataItem.dateText +"\t"+dataItem.titleText+"\t"+dataItem.content);
                    }
                }
            }
        }
    }
}
