package io.github.swimmingsand.java7.chapter9.code2;

import java.util.List;
import java.util.concurrent.FutureTask;

/**
 * Created by zlq on 6/30/15.
 */
public class Task extends FutureTask<List<String>> {
    private FileSearch fileSearch;

    public Task(Runnable runnable, List<String> result) {
        super(runnable, result);
        this.fileSearch = (FileSearch)runnable;
    }

    @Override
    protected void set(List<String> v) {
        if (v==null) {
            v = fileSearch.getResults();
        }

        super.set(v);
    }
}
