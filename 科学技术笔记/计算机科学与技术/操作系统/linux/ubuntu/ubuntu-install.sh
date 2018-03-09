#!/bin/sh

sudo apt-get update
sudo apt-get upgrade
sudo apt-get autoremove

sudo apt-get install -y openssh-server

sudo apt-get install -y tree
sudo apt-get install -y vim

sudo apt-get install -y curl
sudo apt-get install -y wget

sudo apt-get install -y git
sudo apt-get install -y meld
sudo apt-get install -y tig

sudo apt-get install -y gcc
sudo apt-get install -y g++
sudo apt-get install -y make
sudo apt-get install -y libevent-dev

sudo apt-get install -y python2.7-dev

sudo apt-get install -y openjdk-8-jdk
sudo apt-get install -y maven

sudo apt-key adv --keyserver keyserver.ubuntu.com --recv-keys C8CAB6595FDFF622

codename=$(lsb_release -c | awk  '{print $2}')
sudo tee /etc/apt/sources.list.d/ddebs.list << EOF
deb http://ddebs.ubuntu.com/ ${codename}      main restricted universe multiverse
deb http://ddebs.ubuntu.com/ ${codename}-security main restricted universe multiverse
deb http://ddebs.ubuntu.com/ ${codename}-updates  main restricted universe multiverse
deb http://ddebs.ubuntu.com/ ${codename}-proposed main restricted universe multiverse
EOF

sudo apt-get update
sudo apt-get -y install linux-image-$(uname -r)-dbgsym

sudo apt-get -y install systemtap

sudo apt-get autoremove
