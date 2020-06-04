echo "docker.sh STARTED"

apt -y update
apt -y install apt-transport-https ca-certificates curl gnupg-agent software-properties-common
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | apt-key add - 
add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"
apt -y update
apt -y install docker-ce docker-ce-cli 
usermod -aG docker vagrant
apt install -y docker-compose



#
echo "docker.sh ENDING"