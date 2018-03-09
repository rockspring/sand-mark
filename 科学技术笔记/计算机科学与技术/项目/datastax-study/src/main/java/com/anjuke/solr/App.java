package com.anjuke.solr;

import com.datastax.driver.core.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Hello world!
 *
 */
public class App
{
    private Cluster cluster;

    private Session session;

    public Session getSession() {
        return this.session;
    }

    public void connect(String node) {
        cluster = Cluster.builder().addContactPoint(node).build();
        Metadata metadata = cluster.getMetadata();
        System.out.printf("Connected to cluster: %s\n",
                metadata.getClusterName());
        for ( Host host : metadata.getAllHosts() ) {
            System.out.printf("Datacenter: %s; Host: %s; Rack: %s\n",
                    host.getDatacenter(), host.getAddress(), host.getRack());
        }
        session = cluster.connect();
    }

    public void createSchema() {
        session.execute("CREATE KEYSPACE IF NOT EXISTS simplex WITH replication " +
                "= {'class':'SimpleStrategy', 'replication_factor':3};");

        session.execute(
                "CREATE TABLE IF NOT EXISTS simplex.songs (" +
                        "id uuid PRIMARY KEY," +
                        "title text," +
                        "album text," +
                        "artist text," +
                        "tags set<text>," +
                        "data blob" +
                        ");");
        session.execute(
                "CREATE TABLE IF NOT EXISTS simplex.playlists (" +
                        "id uuid," +
                        "title text," +
                        "album text, " +
                        "artist text," +
                        "song_id uuid," +
                        "PRIMARY KEY (id, title, album, artist)" +
                        ");");
    }

    public void loadData() {
        session.execute(
                "INSERT INTO simplex.songs (id, title, album, artist, tags) " +
                        "VALUES (" +
                        "756716f7-2e54-4715-9f00-91dcbea6cf50," +
                        "'La Petite Tonkinoise'," +
                        "'Bye Bye Blackbird'," +
                        "'Joséphine Baker'," +
                        "{'jazz', '2013'})" +
                        ";");
        session.execute(
                "INSERT INTO simplex.playlists (id, song_id, title, album, artist) " +
                        "VALUES (" +
                        "2cc9ccb7-6221-4ccb-8387-f22b6a1b354d," +
                        "756716f7-2e54-4715-9f00-91dcbea6cf50," +
                        "'La Petite Tonkinoise'," +
                        "'Bye Bye Blackbird'," +
                        "'Joséphine Baker'" +
                        ");");
    }

    public void loadData2() {
        PreparedStatement statement = getSession().prepare(
                "INSERT INTO simplex.songs " +
                        "(id, title, album, artist, tags) " +
                        "VALUES (?, ?, ?, ?, ?);");
        BoundStatement boundStatement = new BoundStatement(statement);
        Set<String> tags = new HashSet<String>();
        tags.add("jazz");
        tags.add("2013");
        getSession().execute(boundStatement.bind(
                UUID.fromString("756716f7-2e54-4715-9f00-91dcbea6cf50"),
                "La Petite Tonkinoise'",
                "Bye Bye Blackbird'",
                "Joséphine Baker",
                tags ) );

        statement = getSession().prepare(
                "INSERT INTO simplex.playlists " +
                        "(id, song_id, title, album, artist) " +
                        "VALUES (?, ?, ?, ?, ?);");
        boundStatement = new BoundStatement(statement);
        getSession().execute(boundStatement.bind(
                UUID.fromString("2cc9ccb7-6221-4ccb-8387-f22b6a1b354d"),
                UUID.fromString("756716f7-2e54-4715-9f00-91dcbea6cf50"),
                "La Petite Tonkinoise",
                "Bye Bye Blackbird",
                "Joséphine Baker") );
    }

    public void removeData() {
        session.execute(
                "DELETE FROM simplex.songs where id=756716f7-2e54-4715-9f00-91dcbea6cf50");
        session.execute(
                "DELETE FROM simplex.playlists where id=2cc9ccb7-6221-4ccb-8387-f22b6a1b354d");
    }

    public void querySchema() {
        ResultSet results = session.execute("SELECT * FROM simplex.playlists " +
                "WHERE id = 2cc9ccb7-6221-4ccb-8387-f22b6a1b354d;");
        System.out.println(String.format("%-30s\t%-20s\t%-20s\n%s", "title", "album", "artist",
                "-------------------------------+-----------------------+--------------------"));
        for (Row row : results) {
            System.out.println(String.format("%-30s\t%-20s\t%-20s", row.getString("title"),
                    row.getString("album"),  row.getString("artist")));
        }
        System.out.println();
    }

    public void dropSchema() {
        session.execute("DROP TABLE simplex.songs");
        session.execute("DROP TABLE simplex.playlists");
        session.execute("DROP KEYSPACE simplex");
    }

    public void query() {
        Session session = cluster.connect("mykeyspace");
        for (Row row : session.execute("SELECT * FROM users")) {
            System.out.println(row.getString("fname"));
        }
    }

    public void close() {
        session.close();
        cluster.close();
    }

    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        App client = new App();
        client.connect("127.0.0.1");
        client.createSchema();
        client.loadData2();
        client.querySchema();
        client.removeData();
        client.querySchema();
        //client.dropSchema();
        client.close();
    }
}
