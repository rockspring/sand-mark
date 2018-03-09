grep -v "loaded class" 8984_delete_query_8983.log.txt | grep  -v "loaded interface" > 8984_delete_query_8983.log.no_loaded.txt

grep -v "loaded class" 8983_delete_query_8983.log.txt | grep  -v "loaded interface" > 8983_delete_query_8983.log.no_loaded.txt