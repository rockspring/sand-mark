package io.github.swimmingsand.hadoop2x;

import org.apache.hadoop.conf.Configuration;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by zlq on 3/31/15.
 */
public class ConfigurationTest {

    @Test
    public void testGet() {
        Configuration configuration = new Configuration();
        configuration.addResource("configuration-1.xml");
        Assert.assertThat(configuration.get("color"), Is.is("yellow"));
        Assert.assertThat(configuration.getInt("size", 0), Is.is(10));
        Assert.assertThat(configuration.get("breadth", "wide"), Is.is("wide"));
    }

    @Test
    public void testOverrideGet() {
        Configuration configuration = new Configuration();
        configuration.addResource("configuration-1.xml");
        configuration.addResource("configuration-2.xml");
        Assert.assertThat(configuration.getInt("size", 0), Is.is(12));
        Assert.assertThat(configuration.get("weight"), Is.is("heavy"));
    }

    @Test
    public void testVariableExpansion() {
        Configuration configuration = new Configuration();
        configuration.addResource("configuration-1.xml");
        Assert.assertThat(configuration.getInt("size", 0), Is.is(10));
        Assert.assertThat(configuration.get("size-weight"), Is.is("10,heavy"));

        System.setProperty("size", "14");
        Assert.assertThat(configuration.getInt("size", 0), Is.is(14));
        Assert.assertThat(configuration.get("size-weight"), Is.is("14,heavy"));
    }

    @Test
    public void testVariableExpansionBySystem() {
        System.setProperty("size", "14");

        Configuration configuration = new Configuration();

        configuration.addResource("configuration-1.xml");
        Assert.assertThat(configuration.get("size-weight"), Is.is("14,heavy"));
    }
}
