sudo apt -y update
sudo apt -y upgrade
sudo apt -y install ansible
sudo cp /vagrant/_vagrant/hosts.txt /etc/ansible/hosts
cp /vagrant/_vagrant/key.pem ~/.ssh/id_rsa
sudo cp /vagrant/_vagrant/key.pem /root/.ssh/id_rsa
chmod 0600 ~/.ssh/id_rsa
chmod 0600 /root/.ssh/id_rsa

sudo ansible-galaxy install -r /vagrant/_vagrant/dist/docker/requirement.yml
ansible-playbook /vagrant/_vagrant/dist/docker/playbook.yml
ansible-playbook /vagrant/_vagrant/dist/provision/playbook.yml

