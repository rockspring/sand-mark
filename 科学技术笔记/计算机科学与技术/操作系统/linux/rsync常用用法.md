# rsync常用用法

-P                          same as --partial --progress

--bwlimit=RATE          limit socket I/O bandwidth

-a, --archive               archive mode; equals -rlptgoD (no -H,-A,-X)
    --no-OPTION             turn off an implied OPTION (e.g. --no-D)


RSYNC_PASSWORD
	Setting  RSYNC_PASSWORD  to  the  required password allows you to run authenticated rsync connections to an rsync daemon without user intervention. Note that this
    does not supply a password to a remote shell transport such as ssh; to learn how to do that, consult the remote shell’s documentation.


访问daemon模式运行的rsync，host::module


```
rsync -aP --bwlimit=20000 user@remote-host::module/path/to/ .
```

```
export RSYNC_PASSWORD=xxx
```
