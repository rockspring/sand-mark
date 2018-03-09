package org.apache.lucene.util.automaton;

import org.apache.lucene.util.BytesRef;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by zlq on 5/12/15.
 */
public class DaciukMihovAutomatonBuilderTest {

    @Test
    public void testOne() {
        Collection<BytesRef> utf8Strings = new ArrayList<BytesRef>();
        utf8Strings.add(new BytesRef("abc"));
        utf8Strings.add(new BytesRef("adc"));
        Automaton automaton = DaciukMihovAutomatonBuilder.build(utf8Strings);
        int numStates = automaton.getNumStates();

        System.out.println(numStates);
    }
}
