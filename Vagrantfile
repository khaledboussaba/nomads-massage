Vagrant.configure("2") do |config|
  config.vm.box = "ubuntu/bionic64"
  
  config.vm.provision "ansible_local" do |ansible|
    ansible.become=true
    ansible.playbook = "_vagrant/dist/docker/playbook.yml"
    ansible.galaxy_role_file = "_vagrant/dist/docker/requirement.yml"
    ansible.galaxy_roles_path = "/etc/ansible/roles"
    ansible.galaxy_command="sudo ansible-galaxy install --role-file=%{role_file} --roles-path=%{roles_path} --force"
    ansible.verbose = false
    ansible.compatibility_mode = "2.0"
    ansible.extra_vars = {ansible_python_interpreter:"/usr/bin/python3.6"}
  end
  
  config.vm.provision "ansible_local" do |ansible|
    ansible.playbook = "_vagrant/dist/provision/playbook.yml"
	ansible.verbose = false
	ansible.compatibility_mode = "2.0"
	ansible.extra_vars = {ansible_python_interpreter:"/usr/bin/python3.6"}
  end
  
  config.vm.hostname = "web-rest"
  config.vm.network "private_network", ip: "10.10.10.10"
  config.vm.provider "virtualbox" do |vb|
     vb.gui = false
     vb.memory = "4096"
	 vb.cpus=4
   end
   config.vm.provision "shell", path: "_vagrant/Vagrant.sh"
end

