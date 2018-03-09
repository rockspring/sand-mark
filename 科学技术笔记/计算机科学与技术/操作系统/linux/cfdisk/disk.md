cfdisk 磁盘分区

cfdisk /dev/sdb

mkfs -t ext4 /dev/sdb1

mkdir /data2

mount -t ext4 /dev/sdb1 /data2

file -sL /dev/sdb1

```
/dev/sdb1: Linux rev 1.0 ext4 filesystem data, UUID=cab5e79c-15a0-4a5e-937d-a4bd7c288301 (needs journal recovery) (extents) (large files) (huge files)
```

```
-s, --special-files
             Normally, file only attempts to read and determine the type of argument files which stat(2) reports are ordinary files.  This prevents problems, because reading
             special files may have peculiar consequences.  Specifying the -s option causes file to also read argument files which are block or character special files.  This
             is useful for determining the filesystem types of the data in raw disk partitions, which are block special files.  This option also causes file to disregard the
             file size as reported by stat(2) since on some systems it reports a zero size for raw disk partitions.

-L, --dereference
             option causes symlinks to be followed, as the like-named option in ls(1) (on systems that support symbolic links).  This is the default if the environment vari‐
             able POSIXLY_CORRECT is defined.


cat /etc/fstab
```

```
# /etc/fstab: static file system information.
#
# Use 'blkid' to print the universally unique identifier for a
# device; this may be used with UUID= as a more robust way to name devices
# that works even if disks are added and removed. See fstab(5).
#
# <file system> <mount point>   <type>  <options>       <dump>  <pass>
proc            /proc           proc    nodev,noexec,nosuid 0       0
# / was on /dev/sda9 during installation
UUID=5487b35d-48e1-4c48-99f5-be0ad11f7167 /               ext4    errors=remount-ro 0       1
# /boot was on /dev/sda1 during installation
UUID=0dfbcdf0-9017-49c6-9d93-76888189a0d3 /boot           ext4    defaults        0       2
# /home was on /dev/sda8 during installation
UUID=b11cf240-695b-481c-b6fd-b215ffc0e28c /home           ext4    defaults        0       2
# /tmp was on /dev/sda6 during installation
UUID=b73419be-89f1-41c3-a56f-a122535a7571 /tmp            ext4    defaults        0       2
# /var was on /dev/sda5 during installation
UUID=813095b4-132a-4a4e-8011-cef688543ba4 /var            ext4    defaults        0       2
# swap was on /dev/sda7 during installation
UUID=5c82a015-bcba-4974-8dbd-2a323340811d none            swap    sw              0       0

```


blkid locate/print block device attributes


# /data2 was on /dev/sdb1

UUID=968f8595-8ce9-44f3-91fc-3282fdef5a78 /data2          ext4    defaults        0       2