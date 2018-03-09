package io.bamboozhou.component;

import org.springframework.stereotype.Component;

/**
 * Created by zlq on 1/23/16.
 */
@Component("lonelyHeartsClub")
public class SgtPeppers implements CompactDisc {
    @Override
    public void play() {
        System.out.println("Playing");
    }
}
