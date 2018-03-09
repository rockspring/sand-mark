## 例子

```
curl -sSL https://get.docker.com/ubuntu/ | sudo sh
```

-s, --silent
      Silent or quiet mode. Don't show progress meter or error messages.  Makes Curl mute. It will still output the data you ask for, potentially even to
      the terminal/stdout unless you redirect it.

-S, --show-error
      When used with -s it makes curl show an error message if it fails.


-L, --location
      (HTTP/HTTPS)  If the server reports that the requested page has moved to a different location (indicated with a Location: header and a 3XX response
      code), this option will make curl redo the request on the new place. If used together with -i, --include or -I, --head, headers from all  requested
      pages  will  be  shown.  When  authentication is used, curl only sends its credentials to the initial host. If a redirect takes curl to a different
      host, it won't be able to intercept the user+password. See also --location-trusted on how to change this. You can limit the amount of redirects  to
      follow by using the --max-redirs option.

      When  curl follows a redirect and the request is not a plain GET (for example POST or PUT), it will do the following request with a GET if the HTTP
      response was 301, 302, or 303. If the response code was any other 3xx code, curl will re-send the  following  request  using  the  same  unmodified
      method.

```
curl -w '{\n"time_namelookup": %{time_namelookup},\n"time_connect": %{time_connect},\n"time_appconnect": %{time_appconnect},\n"time_pretransfer": %{time_pretransfer},\n"time_redirect": %{time_redirect},\n"time_starttransfer": %{time_starttransfer},\n"time_total": %{time_total},\n"speed_download": %{speed_download},\n"speed_upload": %{speed_upload},\n"remote_ip": "%{remote_ip}",\n"remote_port": "%{remote_port}",\n"local_ip": "%{local_ip}",\n"local_port": "%{local_port}"\n}' -D /tmp/tmpOUQ_P_ -o /tmp/tmpAUjoDh -s -S 'http://www.189.cn/sh/'
```


```
{
"time_namelookup": 0.060884,
"time_connect": 0.098271,
"time_appconnect": 0.000000,
"time_pretransfer": 0.098329,
"time_redirect": 0.000000,
"time_starttransfer": 0.193558,
"time_total": 0.421702,
"speed_download": 168658.000,
"speed_upload": 0.000,
"remote_ip": "114.80.57.6",
"remote_port": "80",
"local_ip": "10.0.2.15",
"local_port": "36414"
}
```