
# Makefile
# see https://www.gnu.org/software/make/manual/make.html


# VARIABLES

NAME := producer-service

BUILD_TOOL := ./mvnw
JAR_FILE := $(shell find target -name '*.jar' 2>/dev/null)

IMAGE_NAME := samples/$(NAME)
IMAGE_TAG := latest
IMAGE_EXPOSE_PORT := 8080
DOCKER_HOST_IP := localhost
DOCKER_HOST_PORT := 5000

# see https://docs.spring.io/spring-boot/docs/2.0.3.RELEASE/maven-plugin/run-mojo.html#jvmArguments
MEM_OPTS := -Xms128m -Xmx128m
JMX_OPTS := -XX:+UnlockCommercialFeatures -XX:+FlightRecorder -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=3$(IMAGE_EXPOSE_PORT) -Dcom.sun.management.jmxremote.local.only=false -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false
DEBUG_OPTS := -Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005
OTHER_OPTS := -Dspring.profiles.active=local

.PHONY: help
.DEFAULT_GOAL := help


# GENERAL

help :		## Help
	@echo ""
	@echo "*** $(NAME) Makefile help ***"
	@echo ""
	@echo "Targets list:"
	@grep -E '^[a-zA-Z_-]+ :.*?## .*$$' $(MAKEFILE_LIST) | sort -k 1,1 | awk 'BEGIN {FS = ":.*?## "}; {printf "\t\033[36m%-30s\033[0m %s\n", $$1, $$2}'
	@echo ""

print-variables :		## Print variables values
	@echo "MAKE: $(MAKE)"
	@echo "MAKEFILES: $(MAKEFILES)"
	@echo "MAKEFILE_LIST: $(MAKEFILE_LIST)"
	@echo "- - - "
	@echo "NAME: $(NAME)"
	@echo "- - - "
	@echo "BUILD_TOOL: $(BUILD_TOOL)"
	@echo "GIT_COMMIT_HASH: $(GIT_COMMIT_HASH)"
	@echo "JAR_FILE: $(JAR_FILE)"
	@echo "- - - "
	@echo "IMAGE_NAME: $(IMAGE_NAME)"
	@echo "IMAGE_TAG: $(IMAGE_TAG)"
	@echo "IMAGE_EXPOSE_PORT: $(IMAGE_EXPOSE_PORT)"
	@echo "DOCKER_HOST_IP: $(DOCKER_HOST_IP)"
	@echo "DOCKER_HOST_PORT: $(DOCKER_HOST_PORT)"
	@echo "- - - "
	@echo "MEM_OPTS: $(MEM_OPTS)"
	@echo "JMX_OPTS: $(JMX_OPTS)"
	@echo "DEBUG_OPTS: $(DEBUG_OPTS)"
	@echo "OTHER_OPTS: $(OTHER_OPTS)"


# BUILDING

build :		## Build the application including UnitTests
	$(BUILD_TOOL) -Dtest=*UnitTest -DfailIfNoTests=false package

build-no-tests :		## Build the application excluding tests
	$(BUILD_TOOL) package -DskipTests

clean :		## Clean the application
	$(BUILD_TOOL) clean

clean-build :		## Clean and Build the application excluding tests
	$(BUILD_TOOL) -Dtest=*UnitTest -DfailIfNoTests=false clean package

clean-build-no-tests :		## Clean and Build the application excluding tests
	$(BUILD_TOOL) clean package -DskipTests

install : clean-build		## Install the library into maven repo
	$(BUILD_TOOL) install

dependencies :		## Show dependency tree
	$(BUILD_TOOL) dependency:tree -Dverbose


# TESTING

test :		## Run all tests in the application
	$(BUILD_TOOL) -DfailIfNoTests=false test

unit-test :		## Run Unit tests in the application
	$(BUILD_TOOL) -Dtest=*UnitTest -DfailIfNoTests=false test

integration-test :		## Run Integration tests in the application
	$(BUILD_TOOL) -Dtest=*IntegrationTest -DfailIfNoTests=false test

# TO BE TESTED -> make ARGS="<TEST_CLASS_NAME | TEST_PACKAGE_NAME>" specific-test
specific-test :		## Run Specific tests in the application
	$(BUILD_TOOL) -Dtest=${TESTS} -DfailIfNoTests=false test


# RUNNING

run :		## Run the application through Spring Boot plugin
	$(BUILD_TOOL) spring-boot:run -DskipTests -Dspring-boot.run.jvmArguments='$(MEM_OPTS) $(JMX_OPTS) $(OTHER_OPTS)'

debug :		## Run the application in debug mode through Spring Boot plugin
	$(BUILD_TOOL) spring-boot:run -DskipTests -Dspring-boot.run.jvmArguments='$(MEM_OPTS) $(JMX_OPTS) $(DEBUG_OPTS) $(OTHER_OPTS)'

java-run :		## Run the application through the generated fat-jar
	java $(MEM_OPTS) $(JMX_OPTS) $(OTHER_OPTS) -jar $(JAR_FILE)

java-debug :		## Run the application in debug mode through the generated fat-jar
	java $(MEM_OPTS) $(JMX_OPTS) $(DEBUG_OPTS) $(OTHER_OPTS) -jar $(JAR_FILE)


# DOCKER

docker-prepare :		## Prepare application to be containerised
	$(BUILD_TOOL) -DfailIfNoTests=false clean package

docker-build : docker-prepare		## Build docker image
	docker build -t $(IMAGE_NAME):$(IMAGE_TAG) .

docker-run :		## Run docker image as deamon
	docker run -d --rm --name $(NAME) -p $(IMAGE_EXPOSE_PORT):$(IMAGE_EXPOSE_PORT) $(IMAGE_NAME):$(IMAGE_TAG)

docker-run-temp :		## Run docker image as temporary foreground
	docker run -ti --rm --name $(NAME) -p $(IMAGE_EXPOSE_PORT):$(IMAGE_EXPOSE_PORT) $(IMAGE_NAME):$(IMAGE_TAG)

docker-stop :		## Stop docker image
	docker container stop $(NAME)

docker-kill :		## Kill docker image
	docker container kill $(NAME)

docker-push : docker-build		## Push docker image to docker registry
	docker push $(DOCKER_HOST_IP):$(DOCKER_HOST_PORT)/$(IMAGE_NAME):$(IMAGE_TAG)

docker-delete-local : docker-stop		## Delete docker image from local
	docker container rm -f $(NAME)
	docker image rm -f $(NAME)

docker-delete-remote : docker-stop		## Delete the docker image from remote
	docker image remove $(DOCKER_HOST_IP):$(DOCKER_HOST_PORT)/$(IMAGE_NAME):$(IMAGE_TAG)
