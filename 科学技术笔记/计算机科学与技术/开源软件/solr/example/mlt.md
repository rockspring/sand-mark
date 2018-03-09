curl 'http://localhost:8983/solr/select?q=apache&mlt=true&mlt.fl=manu,cat&mlt.mindf=1&mlt.mintf=1&fl=*&indent=true&wt=json'

```
{
  "responseHeader":{
    "status":0,
    "QTime":3,
    "params":{
      "mlt.mindf":"1",
      "fl":"*",
      "mlt.fl":"manu,cat",
      "indent":"true",
      "q":"apache",
      "mlt.mintf":"1",
      "mlt":"true",
      "wt":"json"}},
  "response":{"numFound":2,"start":0,"docs":[
      {
        "id":"SOLR1000",
        "name":"Solr, the Enterprise Search Server",
        "manu":"Apache Software Foundation",
        "cat":["software",
          "search"],
        "features":["Advanced Full-Text Search Capabilities using Lucene",
          "Optimized for High Volume Web Traffic",
          "Standards Based Open Interfaces - XML and HTTP",
          "Comprehensive HTML Administration Interfaces",
          "Scalability - Efficient Replication to other Solr Search Servers",
          "Flexible and Adaptable with XML configuration and Schema",
          "Good unicode support: héllo (hello with an accent over the e)"],
        "price":0.0,
        "price_c":"0,USD",
        "popularity":10,
        "inStock":true,
        "incubationdate_dt":"2006-01-17T00:00:00Z",
        "_version_":1478913899004690432},
      {
        "id":"UTF8TEST",
        "name":"Test with some UTF-8 encoded characters",
        "manu":"Apache Software Foundation",
        "cat":["software",
          "search"],
        "features":["No accents here",
          "This is an e acute: é",
          "eaiou with circumflexes: êâîôû",
          "eaiou with umlauts: ëäïöü",
          "tag with escaped chars: <nicetag/>",
          "escaped ampersand: Bonnie & Clyde",
          "Outside the BMP:𐌈 codepoint=10308, a circle with an x inside. UTF8=f0908c88 UTF16=d800 df08"],
        "price":0.0,
        "price_c":"0,USD",
        "inStock":true,
        "_version_":1478913899028807680}]
  },
  "moreLikeThis":{
    "SOLR1000":{"numFound":1,"start":0,"docs":[
        {
          "id":"UTF8TEST",
          "name":"Test with some UTF-8 encoded characters",
          "manu":"Apache Software Foundation",
          "cat":["software",
            "search"],
          "features":["No accents here",
            "This is an e acute: é",
            "eaiou with circumflexes: êâîôû",
            "eaiou with umlauts: ëäïöü",
            "tag with escaped chars: <nicetag/>",
            "escaped ampersand: Bonnie & Clyde",
            "Outside the BMP:𐌈 codepoint=10308, a circle with an x inside. UTF8=f0908c88 UTF16=d800 df08"],
          "price":0.0,
          "price_c":"0,USD",
          "inStock":true,
          "_version_":1478913899028807680}]
    },
    "UTF8TEST":{"numFound":1,"start":0,"docs":[
        {
          "id":"SOLR1000",
          "name":"Solr, the Enterprise Search Server",
          "manu":"Apache Software Foundation",
          "cat":["software",
            "search"],
          "features":["Advanced Full-Text Search Capabilities using Lucene",
            "Optimized for High Volume Web Traffic",
            "Standards Based Open Interfaces - XML and HTTP",
            "Comprehensive HTML Administration Interfaces",
            "Scalability - Efficient Replication to other Solr Search Servers",
            "Flexible and Adaptable with XML configuration and Schema",
            "Good unicode support: héllo (hello with an accent over the e)"],
          "price":0.0,
          "price_c":"0,USD",
          "popularity":10,
          "inStock":true,
          "incubationdate_dt":"2006-01-17T00:00:00Z",
          "_version_":1478913899004690432}]
    }}}
```