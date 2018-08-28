
# End-to-End Continuous Delivery on Kubernetes - Preliminary steps

We are looking forward to work with you at the [Workshop Tage 2018][workshop-tage] at the ETH Zurich!

## Required accounts

First of all we need a couple of **FREE** accounts:

1. A free **GitHub** account. If you don't have it already, open it [here][github]

2. A free **Google** account. If you don't have it already, open it [here][google]

3. Once your Google account is active, you have to activate the **Google Cloud Platform (GCP)** **free trial**. To activate it, follow the instrcutions on [this site][gcp]

---

## Configuring local environment

1. **[OPTIONAL]** **[MAC-OS-X-USERS]** If you are using MacOsX, please install the **brew cli** following official [instructions][brew]. This is going to be really useful from now on. Linux users should have already by default apt-get or yum.

2. Install the **Google Cloud SDK** following official [instructions][gcloud-sdk]. **Before install**, have a look on [prerequisites][gcloud-sdk-pre].

3. Install the **Kubectl CLI** following official [instructions][kubectl]

4. Install the **Minikube CLI** following official [instructions][minikube].

**PLEASE NOTE: in this [installation-instructions][local-instructions] subfolder you can also find some examples in order to install the tools**

**PLEASE NOTE: We will try to work on the GCP, but if for any reason this is not going to work, the Minikube is a pretty good alternative.**

---

## Sample applications

* **producer-service**

	This is a simple stand-alone service exposing 2 endpoints:
	* "/greetings": returning a greeting string
	* "/info": return a json object with application name, id and datetime of the response

* **consumer-service**

	This is simple service depending on the producer-service, exposing 4 endpoints:
	* "/greetings": returning a greeting string
	* "/greetings/all": returning a list of greeting strings, from current application and from the producer-service
	* "/info": return a json object with application name, id and datetime of the response
	* "/info/all": return a list of json objects, from current application and from the producer-service



<!-- Referenced links -->
[github]: https://github.com/join "GitHub"
[local-instructions]: https://github.com/Solidarchitectures/k8s-jx-workshop/tree/master/installation-instructions "Instructions"
[google]: https://accounts.google.com/signup/v2/webcreateaccount?continue=https%3A%2F%2Fwww.google.com%2F%3Fgws_rd%3Dssl&hl=en&flowName=GlifWebSignIn&flowEntry=SignUp "Google"
[gcp]: https://console.cloud.google.com/freetrial?_ga=2.75722837.-1917212227.1535443408 "Google Cloud Platform"
[brew]: https://brew.sh/ "brew"
[gcloud-sdk-pre]: https://cloud.google.com/sdk/install "Google Cloud SDK Prerequisites"
[gcloud-sdk]: https://cloud.google.com/sdk/docs/downloads-interactive "Google Cloud SDK"
[kubectl]: https://kubernetes.io/docs/tasks/tools/install-kubectl/ "Kubectl"
[minikube]: https://github.com/kubernetes/minikube/releases "Minikube"
[virtualbox]: https://www.virtualbox.org/wiki/Downloads "VirtualBox"
[jx]: https://jenkins-x.io/ "JenkinsX"
[workshop-tage]: https://workshoptage.ch/workshops/2018/end-to-end-continuous-delivery-on-kubernetes/ "WorkshopTage"
[k8s-jx-workshop]: https://github.com/Solidarchitectures/k8s-jx-workshop "k8s-jx-workshop"
