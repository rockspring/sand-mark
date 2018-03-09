solr-6.2.1

bin/solr start  -m 4g -s example/techproducts/solr -a "-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=1044"

bash bin/solr stop

{q=hello&defType=edismax&df=text&preferLocalShards=false&qf=text&echoParams=explicit&pf=text&boost=popularity&rows=10}



http://localhost:8983/solr/techproducts/select?defType=edismax&q=hello&pf=text&qf=text&boost=popularity


userQuery | "hello"

boost(+(text:hello) (),int(popularity))



http://localhost:8983/solr/techproducts/select?q=video&defType=edismax&qf=features^20.0+text^0.3&bq=cat:electronics^5.0


+((features:video)^20.0 | (text:video)^0.3) (cat:electronics)^5.0

BooleanQuery(+DisjunctionMaxQuery(BoostQuery(TermQuery,boost),BoostQuery(TermQuery,boost)) BoostQuery(TermQuery,boost))

BooleanQuery
	DisjunctionMaxQuery(MUST)
		BoostQuery
			TermQuery
		BoostQuery
			TermQuery
	BoostQuery(SHOULD)
		TermQuery

http://localhost:8983/solr/techproducts/select?defType=edismax&q=hello&pf=text&qf=text&boost=popularity&boost=price



boost(+(text:hello) (),product(int(popularity),float(price)))


BoostedQuery
	BooleanQuery
		DisjunctionMaxQuery
			TermQuery
		BooleanQuery
	ProductFloatFunction
		IntFieldSource
		FloatFieldSource



http://localhost:8983/solr/techproducts/select?defType=edismax&q=hello&pf=text&qf=text&boost=popularity&boost=price&bf=max(popularity)


BoostedQuery
	BooleanQuery
		DisjunctionMaxQuery
			TermQuery
		BooleanQuery
		FunctionQuery
			MaxFloatFunction
	ProductFloatFunction
		IntFieldSource
		FloatFieldSource

http://localhost:8983/solr/techproducts/select?defType=edismax&q=hello with&pf=text&qf=text&boost=popularity

boost(+((text:hello) (text:with)) (text:"hello with"),int(popularity))



http://localhost:8983/solr/techproducts/select?defType=edismax&q=%22hello%20with%22%20an&pf=text&qf=text&boost=popularity

boost(+((text:"hello with") (text:an)) (),int(popularity))



http://localhost:8983/solr/techproducts/select?defType=edismax&q=%22hello%20with%22%20an&pf=text&qf=text&boost=popularity&qs=2

boost(+((text:"hello with"~2) (text:an)) (),int(popularity))



http://localhost:8983/solr/techproducts/select?defType=edismax&q="hello with"^20 an&pf=text&qf=text&boost=popularity&qs=2


boost(+(((text:"hello with"~2))^20.0 (text:an)) (text:"20 an"),int(popularity))

BoostedQuery
	BooleanQuery
		BooleanQuery
			BoostQuery
				DisjunctionMaxQuery
					PhraseQuery
						Term
						Term
						slop
				boost
			DisjunctionMaxQuery
				TermQuery
		DisjunctionMaxQuery
	IntFieldSource



http://localhost:8983/solr/techproducts/select?defType=edismax&q=hello with an&pf=text&pf2=text&ps2=3&qf=text&boost=popularity&qs=2


boost(+((text:hello) (text:with) (text:an)) (text:"hello with an") ((text:"hello with"~3) (text:"with an"~3)),int(popularity))

http://localhost:8983/solr/techproducts/select?defType=edismax&q=hello with an&pf=text&pf2=text&ps2=3&pf3=text&ps3=4&qf=text&boost=popularity&qs=2

boost(+((text:hello) (text:with) (text:an)) (text:"hello with an") ((text:"hello with"~3) (text:"with an"~3)) (text:"hello with an"~4),int(popularity))


http://localhost:8983/solr/techproducts/select?defType=edismax&q=hello^80 with an&pf=text^30&pf2=text^50&ps2=3&pf3=text&ps3=4&qf=text^70&boost=popularity&qs=2


boost(+((((text:hello)^70.0))^80.0 ((text:with)^70.0) ((text:an)^70.0)) ((text:"hello 80 with an")^30.0) (((text:"hello 80 with"~3)^50.0) ((text:"with an"~3)^50.0)) (text:"hello 80 with an"~4),int(popularity))



uf=-*

http://localhost:8983/solr/techproducts/select?defType=edismax&q=hello^80 with an&pf=text^30&pf2=text^50&ps2=3&pf3=text&ps3=4&qf=text^70&boost=popularity&qs=2&uf=-*


boost(+((((text:hello)^70.0))^80.0 ((text:with)^70.0) ((text:an)^70.0)) ((text:"hello 80 with an")^30.0) (((text:"hello 80 with"~3)^50.0) ((text:"with an"~3)^50.0)) (text:"hello 80 with an"~4),int(popularity))


http://localhost:8983/solr/techproducts/select?defType=edismax&q=name:hello^80 with an&pf=text^30&pf2=text^50&ps2=3&pf3=text&ps3=4&qf=text^70&boost=popularity&qs=2&uf=-*


boost(+((((text:name:hello)^70.0))^80.0 ((text:with)^70.0) ((text:an)^70.0)) ((text:"name:hello 80 with an")^30.0) (((text:"name:hello 80 with"~3)^50.0) ((text:"with an"~3)^50.0)) (text:"name:hello 80 with an"~4),int(popularity))

用户可以q中指定字段
http://localhost:8983/solr/techproducts/select?defType=edismax&q=name:hello^80 with an&pf=text^30&pf2=text^50&ps2=3&pf3=text&ps3=4&qf=text^70&boost=popularity&qs=2


boost(+((name:hello)^80.0 ((text:with)^70.0) ((text:an)^70.0)) ((text:"with an")^30.0) ((text:"with an"~3)^50.0),int(popularity))


http://localhost:8983/solr/techproducts/select?defType=edismax&fq=popularity:[10%20TO%20*]&q=name:hello^80%20with%20an&pf=text^30&pf2=text^50&ps2=3&pf3=text&ps3=4&qf=text^70&boost=popularity&qs=2


boost(+((name:hello)^80.0 ((text:with)^70.0) ((text:an)^70.0)) ((text:"with an")^30.0) ((text:"with an"~3)^50.0),int(popularity))


org/apache/solr/search/SolrIndexSearcher.java

+boost(+((name:hello)^80.0 ((text:with)^70.0) ((text:an)^70.0)) ((text:"with an")^30.0) ((text:"with an"~3)^50.0),int(popularity)) #SortedIntDocSetTopFilter