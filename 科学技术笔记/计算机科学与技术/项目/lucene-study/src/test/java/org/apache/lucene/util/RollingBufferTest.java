package org.apache.lucene.util;

/**
 * Created by zlq on 6/12/15.
 */
public class RollingBufferTest {
    private static class Position implements RollingBuffer.Resettable {
        // Any tokens that ended at our position arrive to this state:
        int arriving = -1;

        // Any tokens that start at our position leave from this state:
        int leaving = -1;

        //@Override
        public void reset() {
            arriving = -1;
            leaving = -1;
        }
    }

    private static class Positions extends RollingBuffer<Position> {
        @Override
        protected Position newInstance() {
            return new Position();
        }
    }
}
