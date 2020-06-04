@set "VAGRANT_VAGRANTFILE=Vagrantfile-local"
vagrant reload --provision

@set "VAGRANT_VAGRANTFILE=Vagrantfile-dist"
vagrant reload --provision

