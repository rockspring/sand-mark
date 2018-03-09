# awk实战

先按正则表达式过滤，再分组统计平均值

cat request.2014_11_27.log.update | awk '/2014:09:/{t[substr($4,0,18)]++;d[substr($4,0,18)]+=$11}END{for (i in t) print i, d[i]/t[i]}' | sort -k1,1n

cat request.2014_11_27.log.update | awk '/2014:10:/{t[substr($4,0,18)]++;d[substr($4,0,18)]+=$11}END{for (i in t) print i, d[i]/t[i]}' | sort -k1,1n


cat solr.log.2014-11-27.DBQs |awk '{t[substr($4,0,8)]++}END{for (i in t) print i, t[i]}' | sort -k1,1n

cat solr.log.2014-11-27.DBQs |awk '{ print substr($4,0,8)}'

cat solr.log.2014-11-27.DBQs |awk '{t[substr($4,0,5)]++}END{for (i in t) print i, t[i]}' | sort -k1,1n

cat solr.log.2014-11-27.DBQs |awk '{t[substr($4,0,2)]++}END{for (i in t) print i, t[i]}' | sort -k1,1n



grep "Reordered DBQs detected" solr.log.2014-11-28 >solr.log.2014-11-28.DBQs

cat solr.log.2014-11-28.DBQs |awk '{t[substr($4,0,2)]++}END{for (i in t) print i, t[i]}' | sort -k1,1n > solr.log.2014-11-28.DBQs.hour_count

cat solr.log.2014-11-28.DBQs |awk '{t[substr($4,0,5)]++}END{for (i in t) print i, t[i]}' | sort -k1,1n > solr.log.2014-11-28.DBQs.min_count

cat solr.log.2014-11-28.DBQs |awk '{t[substr($4,0,8)]++}END{for (i in t) print i, t[i]}' | sort -k1,1n > solr.log.2014-11-28.DBQs.second_count


grep "Reordered DBQs detected" solr.log.2014-11-29 >solr.log.2014-11-29.DBQs

cat solr.log.2014-11-29.DBQs |awk '{t[substr($4,0,2)]++}END{for (i in t) print i, t[i]}' | sort -k1,1n > solr.log.2014-11-29.DBQs.hour_count

cat solr.log.2014-11-29.DBQs |awk '{t[substr($4,0,5)]++}END{for (i in t) print i, t[i]}' | sort -k1,1n > solr.log.2014-11-29.DBQs.min_count

cat solr.log.2014-11-29.DBQs |awk '{t[substr($4,0,8)]++}END{for (i in t) print i, t[i]}' | sort -k1,1n > solr.log.2014-11-29.DBQs.second_count