package io.github.swimmingsand.lucene;

/**
 * Created by zlq on 7/31/15.
 */
public interface Bits {
    /**
     * Returns the value of the bit with the specified <code>index</code>.
     * @param index index, should be non-negative and &lt; {@link #length()}.
     *        The result of passing negative or out of bounds values is undefined
     *        by this interface, <b>just don't do it!</b>
     * @return <code>true</code> if the bit is set, <code>false</code> otherwise.
     */
    public boolean get(int index);

    /** Returns the number of bits in this set */
    public int length();

    public static final Bits[] EMPTY_ARRAY = new Bits[1];
}
