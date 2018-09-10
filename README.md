
# End-to-End Continuous Delivery on Kubernetes - Preliminary steps

We are looking forward to working with you at the [Workshop Tage 2018][workshop-tage] at the ETH Zurich!

## 1. Required accounts

First of all we need a couple of **FREE** accounts:

1. A free **GitHub** account. If you don't have it already, open it [here][github]

2. A free **Google** account. If you don't have it already, open it [here][google]

3. Once your Google account is active, you have to activate the **Google Cloud Platform (GCP)** **free trial**. To activate it, follow the instrcutions on [this site][gcp]

---

## 2. Configuring local environment

1. **[OPTIONAL]** **[MAC-OS-X-USERS]** If you are using MacOsX, please install **homebrew** following official [instructions][brew]. This is going to be really useful from now on. Linux users should have already by default apt-get or yum.

2. Install the **Google Cloud SDK**  using these [instructions][gcloud-sdk]. **Before install**, have a look on [prerequisites][gcloud-sdk-pre].

3. Install the **Kubectl CLI** following these [instructions][kubectl]

4. Install the **Minikube** following official [instructions][minikube].

**PLEASE NOTE: We will try to work on the GCP, but if for any reason this is not going to work, the Minikube is a pretty good alternative.**

---

## Workshop

* If you landed directly on GitHub, open [this document][workshop-google-docs] to follow the steps of the workshop

* If you come from the workshop steps document, go back to it and proceed ;)

---

## Sample applications

We have already prepared a [repo][k8s-jx-workshop] with a couple of sample applications:

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
[workshop-tage]: https://workshoptage.ch/workshops/2018/end-to-end-continuous-delivery-on-kubernetes/ "WorkshopTage"
[github]: https://github.com/join "GitHub"
[google]: https://accounts.google.com/signup/v2/webcreateaccount?continue=https%3A%2F%2Fwww.google.com%2F%3Fgws_rd%3Dssl&hl=en&flowName=GlifWebSignIn&flowEntry=SignUp "Google"
[gcp]: https://console.cloud.google.com/freetrial?_ga=2.75722837.-1917212227.1535443408 "Google Cloud Platform"
[brew]: https://brew.sh/ "brew"
[gcloud-sdk-pre]: https://cloud.google.com/sdk/install "Google Cloud SDK Prerequisites"
[gcloud-sdk]: https://github.com/Solidarchitectures/k8s-jx-workshop/blob/master/installation-instructions/3_google-cloud-sdk_install-instr.md "Google Cloud SDK"
[kubectl]: hhttps://github.com/Solidarchitectures/k8s-jx-workshop/blob/master/installation-instructions/4_kubectl_install-instr.md "Kubectl"
[minikube]: https://github.com/kubernetes/minikube/releases "Minikube"
[virtualbox]: https://www.virtualbox.org/wiki/Downloads "VirtualBox"
[jx]: https://jenkins-x.io/ "JenkinsX"
[install-instruc]: https://github.com/Solidarchitectures/k8s-jx-workshop/tree/master/installation-instructions "Installation instructions"
[k8s-jx-workshop]: https://github.com/Solidarchitectures/k8s-jx-workshop "k8s-jx-workshop"
[workshop-google-docs]: http://bit.ly/id-cicd-workshop
