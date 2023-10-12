package org.logstashplugins;

import co.elastic.logstash.api.Configuration;
import co.elastic.logstash.api.Event;
import org.junit.Assert;
import org.junit.Test;
import org.logstash.plugins.ConfigurationImpl;

import java.io.ByteArrayOutputStream;
import java.time.Instant;
import java.util.*;

public class OutputYDBTest {

    private static Configuration getConfiguration() {
        String connectionString = "";
        String saKeyFile = "";
        String tableName = "test_table";
        String column = "time, Timestamp, number, Int64, date, Datetime, smallNumber, Int16";
        Map<String, Object> configValues = new HashMap<>();
        configValues.put(OutputYDB.CONNECTION_STRING.name(), connectionString);
        configValues.put(OutputYDB.TABLE_NAME.name(), tableName);
        configValues.put(OutputYDB.SA_KEY_FILE.name(), saKeyFile);
        configValues.put(OutputYDB.COLUMNS.name(), column);
        return new ConfigurationImpl(configValues);
    }

    @Test
    public void testJavaOutputExample() {
        Configuration config = getConfiguration();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        OutputYDB output = new OutputYDB("id", config, null, baos);

        String sourceField = "message";
        int eventCount = 5;
        Collection<Event> events = new ArrayList<>();
        for (int k = 0; k < eventCount; k++) {
            Event e = new org.logstash.Event();
            e.setField(sourceField, "message " + k);
            Long time = Instant.now().getEpochSecond();
            e.setField("time", time);
            Long number = 100L + k;
            e.setField("number", number);
            e.setField("date", time);
            Short smallNumber = 1;
            e.setField("smallNumber", smallNumber);
            events.add(e);
        }

        output.output(events);

        String outputString = baos.toString();
        int index = 0;
        int lastIndex = 0;
        while (index < eventCount) {
            lastIndex = outputString.indexOf("message", lastIndex);
            Assert.assertTrue("Prefix should exist in output string", lastIndex > -1);
            lastIndex = outputString.indexOf("message " + index);
            Assert.assertTrue("Message should exist in output string", lastIndex > -1);
            index++;
        }
    }



}
