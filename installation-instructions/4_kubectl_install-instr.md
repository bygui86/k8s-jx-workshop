
# Kubectl

## Installation instructions

* **[MAC-OS-X-USERS-ONLY]** Using brew

		brew install kubectl

* Using cli (same for MacOsX and Linux)

	1. Download the latest release

			curl -LO https://storage.googleapis.com/kubernetes-release/release/$(curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt)/bin/darwin/amd64/kubectl

	2. Make the binary executable

			chmod +x ./kubectl

	3. Move the binary in to your PATH

			sudo mv ./kubectl /usr/local/bin/kubectl


* As part of the Google Cloud SDK (same for MacOsX and Linux)

	1. Run the installation command

			gcloud components install kubectl

	2. Test to ensure the version you installed is sufficiently up-to-date

			kubectl version

---

## Links

* https://kubernetes.io/docs/tasks/tools/install-kubectl/
