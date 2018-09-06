
# JenkinsX

## Installation instructions

* Mac OS X

	* Using brew

		1. Install the formula repo

			brew tap jenkins-x/jx

		2. Install the cli

			brew install jx
	
	* Using cli

		1. Download the latest release and extract it

			curl -L https://github.com/jenkins-x/jx/releases/download/v1.3.191/jx-darwin-amd64.tar.gz | tar xzv 

		2. Make the binary executable

			chmod +x jx

		3. Move the binary in to your PATH

			sudo mv jx /usr/local/bin

* Linux

	1. Download the latest release and extract it

		curl -L https://github.com/jenkins-x/jx/releases/download/v1.3.191/jx-linux-amd64.tar.gz | tar xzv 

	2. Make the binary executable

		chmod +x jx

	3. Link the binary in to your PATH

		cd /usr/local/bin
		
		sudo ln -s /home/\<user\>/\<path\>/\<to\>/jx

---

## Links

* https://jenkins-x.io/
