
# Minikube

## Prerequisites

* Kubectl
* VirtualBox

---

## Installation instructions


* Mac OS X

	* Using brew

			brew install homebrew/cask/minikube

	* Using cli

		1. Download the latest release

				curl -Lo minikube https://storage.googleapis.com/minikube/releases/v0.28.2/minikube-darwin-amd64

		2. Make the binary executable

				chmod +x minikube

		3. Move the binary in to your PATH

				sudo mv minikube /usr/local/bin/

* Linux

	1. Download the latest release:

			curl -Lo minikube https://storage.googleapis.com/minikube/releases/v0.28.2/minikube-linux-amd64
	
	2. Make the binary executable

			chmod +x minikube

	3. Move the binary in to your PATH

			sudo mv minikube /usr/local/bin/

---

## Update

* Using brew

		brew cask upgrade minikube

* Using cli, just install it again ;)

---

## Links

* https://kubernetes.io/docs/tasks/tools/install-minikube/
* https://github.com/kubernetes/minikube/releases
