#!/bin/sh

apt -y update
#apt -y upgrade
apt -y install nano python3

useradd sami --home /home/sami/ --create-home --groups root --shell /bin/bash

mkdir /home/sami/.ssh
echo "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCIvuJ/9CcCb2qG9AYu7YpBvaRI4K82xUEbbvXgFwxNXhwD58+k5PABAV7+kMyQcnZoZj//PoMMW1nCBaxf4QObDVahpSr92d4/Mx7sfNLvR5qy2l/wu0V/s2hRy3k5/yInNzWa1i1LmDOiV6sVrvh/mDYft4szyVETcdaHI1cwdC9GB4Y6R0tE5MQmkTVDk8DjCJ7DN3e2sZ87YF5eZx8Q98wag9SvnVHJhH2yUC1OiAgzrnJrQ+NlcTsU96k+WRnHul7HPaDZ2igLuk/M8XlPXqawoEi+9DfJucb4wPTv77Io8ZNVqIGZuMIIEzNfASMvpuqMXYcU8iI7i/HouTPD LogstashInstance" >> /home/sami/.ssh/authorized_keys
chown -R sami:sami /home/sami/.ssh
chmod -R 0600 /home/sami/.ssh
chmod 0700 /home/sami/.ssh

echo "sami:golgoth99" | chpasswd

usermod -aG sudo sami