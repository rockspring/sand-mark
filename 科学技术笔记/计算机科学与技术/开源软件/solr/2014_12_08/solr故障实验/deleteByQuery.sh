!/bin/bash

for (( i = 0; i < 1000000; i++ )); do
	curl http://localhost:8983/solr/update --data-binary '<delete><query>unique_id:SP2514N</query></delete>' -H 'Content-type:application/xml'
done
