package io.github.swimmingsand.lucene;

import org.junit.internal.AssumptionViolatedException;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.util.ArrayList;
import java.util.List;


/**
 *
 */
public final class TestRuleMarkFailure implements TestRule {
    private final TestRuleMarkFailure [] chained;
    private volatile boolean failures;

    public TestRuleMarkFailure(TestRuleMarkFailure... chained) {
        this.chained = chained;
    }

    public Statement apply(final Statement s, Description d) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                // Clear status at start.
                failures = false;

                try {
                    s.evaluate();
                } catch (Throwable t) {
                    if (!isAssumption(t)) {
                        markFailed();
                    }
                    throw t;
                }
            }
        };
    }

    /**
     * Is a given exception (or a MultipleFailureException) an
     * {@link org.junit.internal.AssumptionViolatedException}?
     */
    public static boolean isAssumption(Throwable t) {
        for (Throwable t2 : expandFromMultiple(t)) {
            if (!(t2 instanceof AssumptionViolatedException)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Expand from multi-exception wrappers.
     */
    private static List<Throwable> expandFromMultiple(Throwable t) {
        return expandFromMultiple(t, new ArrayList<Throwable>());
    }

    /** Internal recursive routine. */
    private static List<Throwable> expandFromMultiple(Throwable t, List<Throwable> list) {
        if (t instanceof org.junit.runners.model.MultipleFailureException) {
            for (Throwable sub : ((org.junit.runners.model.MultipleFailureException) t).getFailures()) {
                expandFromMultiple(sub, list);
            }
        } else {
            list.add(t);
        }

        return list;
    }

    /**
     * Taints this object and any chained as having failures.
     */
    public void markFailed() {
        failures = true;
        for (TestRuleMarkFailure next : chained) {
            next.markFailed();
        }
    }

    /**
     * Check if this object had any marked failures.
     */
    public boolean hadFailures() {
        return failures;
    }

    /**
     * Check if this object was successful (the opposite of {@link #hadFailures()}).
     */
    public boolean wasSuccessful() {
        return !hadFailures();
    }
}
