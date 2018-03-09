Optimistic concurrency control is a Solr NoSQL feature that allows a conditional update based on document **\_version\_**. Using optimistic concurrency normally involves the following READ-MODIFY-WRITE process:

    * 1. client reads a document
    * 2. client changes the document locally
    * 3. client resubmits the changed document to solr
    * 4. go back to step 1 if step 3 fails with HTTP error code 409 (version conflict)

For simple field updates or modifications, see [Atomic Updates](http://heliosearch.org/solr/atomic-updates/)


## Versioning

Solr automatically adds a _version_ field to all documents. A client can specify a value for _version_ on any update to invoke optimistic concurrency control.

The following table summarizes the semantics of specifying _version_ for an update:

| \_version\_ |	semantics |
| --- | --- | --- |
| \> 1 |	Document version must exactly match |
| 1 |	Document must exist |
| < 0 |	Document must not exist |
| 0 |	Don’t care (normal overwrite if exists) |


### Specifying version on an update

For an add, it’s easiest to simply specify _version_ by adding it as a field in the document along with the other fields (see the Example below).

It’s also possible to specify _version_ as a request parameter in the URL:
```
$ curl http://localhost:8983/solr/update?_version_=7 -H 'Content-type:application/json' -d '[{"id":"smalldoc"}]'
```

Delete operations with optimistic concurrency currently need to use the URL method to specify _version_.

## Optimistic Concurrency Example

First, let’s add a document representing a book:

```
$ curl http://localhost:8983/solr/update -H 'Content-type:application/json' -d '
[
 {"id":"book1", "title":"Neuromancer","author":"William Gibson",
  "copiesIn_i":7, "copiesOut_i":3
 }
]'
```

Now let’s pretend that someone is checking out a copy and we want to decrement copiesIn and increment copiesOut. First we retrieve the latest version of the document with real-time get:

```
$ curl http://localhost:8983/solr/get?id=book1
{
  "doc":
  {
    "id":"book1",
    "title":["Neuromancer"],
    "author":"William Gibson",
    "copiesIn_i":7,
    "copiesOut_i":3,
    "_version_":1408813562908901376}}
```

Now we will modify the document fields and send it back to Solr (making sure we did *not* modify the _version_ field):

```
curl http://localhost:8983/solr/update -H 'Content-type:application/json' -d '
[  {
    "id":"book1",
    "title":["Neuromancer"],
    "author":"William Gibson",
    "copiesIn_i":6,
    "copiesOut_i":4,
    "_version_":1408813562908901376}
]'
```

The presence of the _version_ field instructs Solr to accept the update only if the document version matches exactly. After the update has successfully completed, the document will have a new _version_ that is guaranteed to be higher than the last.

```
curl http://localhost:8983/solr/get?id=book1
{
  "doc":
  {
    "id":"book1",
    "title":["Neuromancer"],
    "author":"William Gibson",
    "copiesIn_i":6,
    "copiesOut_i":4,
    "_version_":1408814192853516288}}
```

Of course this was just an example, and we could have used Solr’s Atomic Update feature to do this much easier.

## Example Failure

If the client specifies a _version_ that does not match what currently exists in Solr, an HTTP error with code 409 (Conflict) will be returned.

```
$ curl -i http://localhost:8983/solr/update -H 'Content-type:application/json' -d '
[{"id":"book1", "author":"Mr Bean", "_version_":12345}]'
HTTP/1.1 409 Conflict
Content-Type: text/plain;charset=UTF-8
Transfer-Encoding: chunked
 
{
  "responseHeader":{
    "status":409,
    "QTime":1},
  "error":{
    "msg":"version conflict for book1 expected=12345 actual=1408814192853516288",
    "code":409}}
```

Note that we used the curl option -i to show the response HTTP headers to verify that this generated an HTTP-level error in addition to the Solr-level error in the body of the response.