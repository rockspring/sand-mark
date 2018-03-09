package io.bamboozhou.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zlq on 1/23/16.
 */

@Component("player")
public class CDplayer implements MediaPlayer{
    private CompactDisc cd;

    @Autowired
    public CDplayer(CompactDisc cd) {
        this.cd = cd;
    }

    public CompactDisc getCd() {
        return cd;
    }

    @Autowired(required = false)
    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }

    public void play() {
        cd.play();
    }
}
