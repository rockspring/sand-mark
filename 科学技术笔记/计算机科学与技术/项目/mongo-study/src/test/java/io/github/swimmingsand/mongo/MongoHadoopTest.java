package io.github.swimmingsand.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.hadoop.io.BSONWritable;
import com.mongodb.hadoop.io.MongoUpdateWritable;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version.Main;
import de.flapdoodle.embed.process.runtime.Network;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.bson.BSONObject;
import org.bson.BasicBSONObject;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by zlq on 2/15/15.
 */
public class MongoHadoopTest {

    //@Test
    public void testMongo() throws Exception{
        MongodStarter starter = MongodStarter.getDefaultInstance();

        int port = 12345;
        IMongodConfig mongodConfig = new MongodConfigBuilder()
                .version(Main.PRODUCTION)
                .net(new Net(port, Network.localhostIsIPv6()))
                .build();

        MongodExecutable mongodExecutable = null;
        try {
            mongodExecutable = starter.prepare(mongodConfig);
            MongodProcess mongod = mongodExecutable.start();

            MongoClient mongo = new MongoClient("localhost", port);
            DB db = mongo.getDB("test");
            DBCollection col = db.createCollection("testCol", new BasicDBObject());
            col.save(new BasicDBObject("testDoc", new Date()));

        } finally {
            if (mongodExecutable != null)
                mongodExecutable.stop();
        }
    }

    MapDriver<Object, BSONWritable, Text, Text> mapDriver;
    ReduceDriver<Text, Text, NullWritable, MongoUpdateWritable> reduceDriver;
    MapReduceDriver<LongWritable, Text, Text, IntWritable, Text, IntWritable> mapReduceDriver;

    @Before
    public void setUp() {
        MongoHadoop mongoHadoop = new MongoHadoop();
        MongoHadoop.DeviceMapper mapper = mongoHadoop.new DeviceMapper();
        MongoHadoop.DeviceReducer reducer = mongoHadoop.new DeviceReducer();
        mapDriver = MapDriver.newMapDriver(mapper);
        reduceDriver = ReduceDriver.newReduceDriver(reducer);
    }

    @Test
    public void testMapper() throws IOException {
        /**
         * {
         "_id": ObjectId("51b792d381c3e67b0a18d0ed"),
         "name": "730LsNaN",
         "type": "pressure",
         "owner": "lswNxts07k",
         "model": 18,
         "created_at": ISODate("2003-12-02T11:15:09.555-0500")
         }
         */
        BSONObject bsonObject = new BasicDBObject();

        bsonObject.put("_id", new ObjectId("51b792d381c3e67b0a18d0ed"));
        bsonObject.put("name", "730LsNaN");
        bsonObject.put("type", "pressure");
        bsonObject.put("owner", "lswNxts07k");
        bsonObject.put("model", 18);
        //bsonObject.put("created_at", new Date());
        BSONWritable bsonWritable = new BSONWritable(bsonObject);
        mapDriver.withInput(new LongWritable(), bsonWritable);

        //mapDriver.withInput(new LongWritable(), new Text(""));
        //mapDriver.withOutput(new Text("200"), new IntWritable(1)); //8
        //mapDriver.withOutput(new Text("200"), new IntWritable(1)); //8
        mapDriver.withOutput(new Text("lswNxts07k pressure"), new Text("51b792d381c3e67b0a18d0ed")); //8

        mapDriver.runTest();
    }

    @Test
    public void testReducer() throws IOException {
        Text key = new Text("lswNxts07k pressure");
        ArrayList<Text> values = new ArrayList<Text>();
        values.add(new Text("51b792d381c3e67b0a18d0ed"));

        reduceDriver.withInput(key, values);

        BasicBSONObject query = new BasicBSONObject("_id", "51b792d381c3e67b0a18d0ed");
        ArrayList<ObjectId> devices = new ArrayList<ObjectId>();
        devices.add(new ObjectId("51b792d381c3e67b0a18d0ed"));
        BasicBSONObject devices_list = new BasicBSONObject("devices", devices);
        BasicBSONObject update = new BasicBSONObject("$pushAll", devices_list);

        reduceDriver.withOutput(NullWritable.get(), new MongoUpdateWritable(query, update, true, false));

    }
}
