package io.github.swimmingsand.lucene;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.MultipleFailureException;
import org.junit.runners.model.Statement;

import java.util.ArrayList;

/**
 * Created by zlq on 3/28/15.
 */
abstract class AbstractBeforeAfterRule implements TestRule {
    public Statement apply(final Statement s, final Description d) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                final ArrayList<Throwable> errors = new ArrayList<Throwable>();

                try {
                    before();
                    s.evaluate();
                } catch (Throwable t) {
                    errors.add(t);
                }

                try {
                    after();
                } catch (Throwable t) {
                    errors.add(t);
                }

                MultipleFailureException.assertEmpty(errors);
            }
        };
    }

    protected void before() throws Exception {}
    protected void after() throws Exception {}
}