shg4873@shg4873:/usr/local/apache2/bin$ ./ab -c 100 -n 5000 http://192.168.190.93:8080/
This is ApacheBench, Version 2.3 <$Revision: 1430300 $>
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Benchmarking 192.168.190.93 (be patient)
Completed 500 requests
Completed 1000 requests
Completed 1500 requests
Completed 2000 requests
Completed 2500 requests
Completed 3000 requests
Completed 3500 requests
Completed 4000 requests
Completed 4500 requests
Completed 5000 requests
Finished 5000 requests


Server Software:
Server Hostname: 192.168.190.93
Server Port: 8080

Document Path: /
Document Length: 13 bytes

Concurrency Level: 100
Time taken for tests: 0.343 seconds
Complete requests: 5000
Failed requests: 0
Write errors: 0
Total transferred: 745000 bytes
HTML transferred: 65000 bytes
Requests per second: 14559.18 [#/sec] (mean)
Time per request: 6.869 [ms] (mean)
Time per request: 0.069 [ms] (mean, across all concurrent requests)
Transfer rate: 2118.47 [Kbytes/sec] received

Connection Times (ms)
min mean[+/-sd] median max
Connect: 0 1 0.8 1 5
Processing: 2 6 1.7 5 12
Waiting: 1 5 1.7 5 12
Total: 4 7 1.7 6 15

Percentage of the requests served within a certain time (ms)
50% 6
66% 7
75% 7
80% 7
90% 9
95% 10
98% 12
99% 13
100% 15 (longest request)
shg4873@shg4873:/usr/local/apache2/bin$ ./ab -c 100 -n 5000 http://192.168.190.93:8080/
This is ApacheBench, Version 2.3 <$Revision: 1430300 $>
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Benchmarking 192.168.190.93 (be patient)
Completed 500 requests
Completed 1000 requests
Completed 1500 requests
Completed 2000 requests
Completed 2500 requests
Completed 3000 requests
Completed 3500 requests
Completed 4000 requests
Completed 4500 requests
Completed 5000 requests
Finished 5000 requests


Server Software:
Server Hostname: 192.168.190.93
Server Port: 8080

Document Path: /
Document Length: 13 bytes

Concurrency Level: 100
Time taken for tests: 0.338 seconds
Complete requests: 5000
Failed requests: 0
Write errors: 0
Total transferred: 745000 bytes
HTML transferred: 65000 bytes
Requests per second: 14812.36 [#/sec] (mean)
Time per request: 6.751 [ms] (mean)
Time per request: 0.068 [ms] (mean, across all concurrent requests)
Transfer rate: 2155.31 [Kbytes/sec] received

Connection Times (ms)
min mean[+/-sd] median max
Connect: 0 1 0.7 1 4
Processing: 1 6 1.9 5 14
Waiting: 1 5 1.9 5 14
Total: 3 7 1.7 6 14

Percentage of the requests served within a certain time (ms)
50% 6
66% 7
75% 7
80% 8
90% 9
95% 11
98% 12
99% 12
100% 14 (longest request)

 

shg4873@shg4873:/usr/local/apache2/bin$ ./ab -c 100 -n 5000 http://192.168.190.93:8080/
This is ApacheBench, Version 2.3 <$Revision: 1430300 $>
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Benchmarking 192.168.190.93 (be patient)
Completed 500 requests
Completed 1000 requests
Completed 1500 requests
Completed 2000 requests
Completed 2500 requests
Completed 3000 requests
Completed 3500 requests
Completed 4000 requests
Completed 4500 requests
Completed 5000 requests
Finished 5000 requests


Server Software:
Server Hostname: 192.168.190.93
Server Port: 8080

Document Path: /
Document Length: 13 bytes

Concurrency Level: 100
Time taken for tests: 0.403 seconds
Complete requests: 5000
Failed requests: 0
Write errors: 0
Total transferred: 745000 bytes
HTML transferred: 65000 bytes
Requests per second: 12416.16 [#/sec] (mean)
Time per request: 8.054 [ms] (mean)
Time per request: 0.081 [ms] (mean, across all concurrent requests)
Transfer rate: 1806.65 [Kbytes/sec] received

Connection Times (ms)
min mean[+/-sd] median max
Connect: 0 2 1.1 2 6
Processing: 1 6 2.7 6 15
Waiting: 1 6 2.9 5 15
Total: 4 8 2.4 7 20

Percentage of the requests served within a certain time (ms)
50% 7
66% 8
75% 10
80% 10
90% 11
95% 12
98% 14
99% 15
100% 20 (longest request)

 

shg4873@shg4873:/usr/local/apache2/bin$ ./ab -c 100 -n 5000 http://192.168.190.93:8080/
This is ApacheBench, Version 2.3 <$Revision: 1430300 $>
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Benchmarking 192.168.190.93 (be patient)
Completed 500 requests
Completed 1000 requests
Completed 1500 requests
Completed 2000 requests
Completed 2500 requests
Completed 3000 requests
Completed 3500 requests
Completed 4000 requests
Completed 4500 requests
Completed 5000 requests
Finished 5000 requests


Server Software:
Server Hostname: 192.168.190.93
Server Port: 8080

Document Path: /
Document Length: 13 bytes

Concurrency Level: 100
Time taken for tests: 0.383 seconds
Complete requests: 5000
Failed requests: 0
Write errors: 0
Total transferred: 745000 bytes
HTML transferred: 65000 bytes
Requests per second: 13046.89 [#/sec] (mean)
Time per request: 7.665 [ms] (mean)
Time per request: 0.077 [ms] (mean, across all concurrent requests)
Transfer rate: 1898.42 [Kbytes/sec] received

Connection Times (ms)
min mean[+/-sd] median max
Connect: 0 1 0.9 1 5
Processing: 1 6 2.6 6 14
Waiting: 1 6 2.7 5 14
Total: 3 8 2.3 7 17

Percentage of the requests served within a certain time (ms)
50% 7
66% 8
75% 9
80% 10
90% 11
95% 12
98% 13
99% 14
100% 17 (longest request)
shg4873@shg4873:/usr/local/apache2/bin$ ./ab -c 100 -n 5000 http://192.168.190.93:8080/
This is ApacheBench, Version 2.3 <$Revision: 1430300 $>
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Benchmarking 192.168.190.93 (be patient)
Completed 500 requests
Completed 1000 requests
Completed 1500 requests
Completed 2000 requests
Completed 2500 requests
Completed 3000 requests
Completed 3500 requests
Completed 4000 requests
Completed 4500 requests
Completed 5000 requests
Finished 5000 requests


Server Software:
Server Hostname: 192.168.190.93
Server Port: 8080

Document Path: /
Document Length: 13 bytes

Concurrency Level: 100
Time taken for tests: 0.374 seconds
Complete requests: 5000
Failed requests: 0
Write errors: 0
Total transferred: 745000 bytes
HTML transferred: 65000 bytes
Requests per second: 13377.00 [#/sec] (mean)
Time per request: 7.476 [ms] (mean)
Time per request: 0.075 [ms] (mean, across all concurrent requests)
Transfer rate: 1946.46 [Kbytes/sec] received

Connection Times (ms)
min mean[+/-sd] median max
Connect: 0 1 0.9 1 5
Processing: 1 6 2.2 5 13
Waiting: 1 6 2.3 5 13
Total: 4 7 2.1 7 16

Percentage of the requests served within a certain time (ms)
50% 7
66% 8
75% 9
80% 9
90% 11
95% 11
98% 12
99% 13
100% 16 (longest request)