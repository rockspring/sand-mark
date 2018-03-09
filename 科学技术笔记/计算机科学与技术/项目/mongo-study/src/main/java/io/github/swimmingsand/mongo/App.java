package io.github.swimmingsand.mongo;

import com.mongodb.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception{
        System.out.println( "Hello World!" );
        // To directly connect to a single MongoDB server (note that this will not auto-discover the primary even
// if it's a member of a replica set:
        //MongoClient mongoClient = new MongoClient();
// or
        //MongoClient mongoClient = new MongoClient( "localhost" );
// or
        MongoClient mongoClient = new MongoClient( "192.168.59.103" , 27017 );
// or, to connect to a replica set, with auto-discovery of the primary, supply a seed list of members
        //MongoClient mongoClient = new MongoClient(Arrays.asList(new ServerAddress("localhost", 27017),
        //        new ServerAddress("localhost", 27018),
        //       new ServerAddress("localhost", 27019)));

        DB db = mongoClient.getDB( "mydb" );

        DBCollection coll = db.getCollection("testCollection");
        BasicDBObject doc = new BasicDBObject("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("info", new BasicDBObject("x", 203).append("y", 102));
        coll.insert(doc);


        Set<String> colls = db.getCollectionNames();

        for (String s : colls) {
            System.out.println(s);
        }

        DBObject myDoc = coll.findOne();
        System.out.println(myDoc);

        mongoClient.close();
        //mongoClient.dropDatabase("mydb");
    }
}
