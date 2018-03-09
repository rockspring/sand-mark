Solr supports simple atomic updates (also called partial updates) to single documents via field modifiers such as **add** and **inc**.

Optimistic concurrency control is another method of atomically updating documents.

## Modifiers

Solr supports several modifiers that atomically update values of a document.

    * 1. set – set or replace a particular value, or remove the value if null is specified as the new value
    * 2. add – adds an additional value to a list
    * 3. remove – removes a value (or a list of values) from a list
    * 4. inc – increments a numeric value by a specific amount (use a negative value to decrement)

	Note: All original source fields must be stored for field modifiers to work correctly.  This is the default in Solr.

## Update Modifier Example


First, let’s add a document representing a book:

```
$ curl http://localhost:8983/solr/update -H 'Content-type:application/json' -d '
[
 {"id" : "book1", "title" : "Snow Crash",
  "copies_i" : 5, "cat" : "Science Fiction"
 }
]'
```

Now we can update that document, adding the author field, incrementing the number of copies we have, and adding an additional category:

```
$ curl http://localhost:8983/solr/update -H 'Content-type:application/json' -d '
[
 {"id"       : "book1",
  "author"   : {"set":"Neal Stephenson"},
  "copies_i" : {"inc":3},
  "cat"      : {"add":"Cyberpunk"}
 }
]'
```

Now if we retrieve the document using real-time get, we will see the updated fields:

```
$ curl http://localhost:8983/solr/get?id=book1
{
  "doc": {
    "id":"book1",
    "title":["Snow Crash"],
    "copies_i":8,
    "cat":["Science Fiction", "Cyberpunk"],
    "author":"Neal Stephenson",
    "_version_":1408729977723027456}}
```
 

And finally, remove “Cyberpunk” from the cat field:

```
$ curl http://localhost:8983/solr/update -H 'Content-type:application/json' -d '
[
 {"id"       : "book1",
  "cat"      : {"remove":"Cyberpunk"}
 }
]'
```

## Atomic Updates with SolrJ

Here is an example of how to do a partial update via Solr’s Java client, SolrJ:

```
// create the SolrJ client
HttpSolrServer client = new HttpSolrServer("http://localhost:8983/solr");
 
// create the document
SolrInputDocument sdoc = new SolrInputDocument();
sdoc.addField("id","book1");
Map<String,Object> fieldModifier = new HashMap<>(1);
fieldModifier.put("add","Cyberpunk");
sdoc.addField("cat", fieldModifier);  // add the map as the field value
 
client.add( sdoc );  // send it to the solr server
 
client.shutdown();  // shutdown client before we exit
```
