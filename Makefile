# -*- mode: makefile; -*-

all:

TAGS :=
TAGS  += alpine-normal-26.1
TAGS  += alpine-normal-25.3
TAGS  += alpine-normal-25.2
TAGS  += ubuntu-normal-26.1
TAGS  += ubuntu-normal-25.3
TAGS  += ubuntu-normal-25.2
TAGS  += ubuntu-normal-25.1
TAGS  += ubuntu-normal-24.5
TAGS  += ubuntu-normal-24.4
TAGS  += ubuntu-normal-24.3
TAGS  += ubuntu-normal-24.2
TAGS  += ubuntu-normal-24.1
TAGS  += ubuntu-normal-23.4
TAGS  += alpine-min-26.1
TAGS  += alpine-min-25.3
TAGS  += alpine-min-25.2
TAGS  += ubuntu-min-26.1
TAGS  += ubuntu-min-25.3
TAGS  += ubuntu-min-25.2
TAGS  += ubuntu-min-25.1
TAGS  += ubuntu-min-24.5
TAGS  += ubuntu-min-24.4
TAGS  += ubuntu-min-24.3
TAGS  += ubuntu-min-24.2
TAGS  += ubuntu-min-24.1
TAGS  += ubuntu-min-23.4

DIRS := .make

##################################################

all: build

build: $(TAGS:%=.make/build-%)
	@:

push: build
	docker push conao3/po4a:$(TAG)

##############################

.make/build-%: Dockerfiles/Dockerfile-% $(DIRS)
	docker image build -t conao3/emacs:$* -f $< .
	docker container run -it conao3/emacs:$* emacs --version
	docker container run -it conao3/emacs:$* emacs --batch --eval "(print emacs-version)"
	touch $@

# docker tag conao3/emacs: conao3/emacs:

.make/push-alpine-normal-26.1: .make/build-alpine-normal-26.1
	docker push conao3/emacs:alpine-normal-26.1
.make/push-alpine-normal-25.3: .make/build-alpine-normal-25.3
	docker push conao3/emacs:alpine-normal-25.3
.make/push-alpine-normal-25.2: .make/build-alpine-normal-25.2
	docker push conao3/emacs:alpine-normal-25.2
.make/push-ubuntu-normal-26.1: .make/build-ubuntu-normal-26.1
	docker push conao3/emacs:ubuntu-normal-26.1
.make/push-ubuntu-normal-25.3: .make/build-ubuntu-normal-25.3
	docker push conao3/emacs:ubuntu-normal-25.3
.make/push-ubuntu-normal-25.2: .make/build-ubuntu-normal-25.2
	docker push conao3/emacs:ubuntu-normal-25.2
.make/push-ubuntu-normal-25.1: .make/build-ubuntu-normal-25.1
	docker push conao3/emacs:ubuntu-normal-25.1
.make/push-ubuntu-normal-24.5: .make/build-ubuntu-normal-24.5
	docker push conao3/emacs:ubuntu-normal-24.5
.make/push-ubuntu-normal-24.4: .make/build-ubuntu-normal-24.4
	docker push conao3/emacs:ubuntu-normal-24.4
.make/push-ubuntu-normal-24.3: .make/build-ubuntu-normal-24.3
	docker push conao3/emacs:ubuntu-normal-24.3
.make/push-ubuntu-normal-24.2: .make/build-ubuntu-normal-24.2
	docker push conao3/emacs:ubuntu-normal-24.2
.make/push-ubuntu-normal-24.1: .make/build-ubuntu-normal-24.1
	docker push conao3/emacs:ubuntu-normal-24.1
.make/push-ubuntu-normal-23.4: .make/build-ubuntu-normal-23.4
	docker push conao3/emacs:ubuntu-normal-23.4
.make/push-alpine-min-26.1: .make/build-alpine-min-26.1
	docker push conao3/emacs:alpine-min-26.1
.make/push-alpine-min-25.3: .make/build-alpine-min-25.3
	docker push conao3/emacs:alpine-min-25.3
.make/push-alpine-min-25.2: .make/build-alpine-min-25.2
	docker push conao3/emacs:alpine-min-25.2
.make/push-ubuntu-min-26.1: .make/build-ubuntu-min-26.1
	docker push conao3/emacs:ubuntu-min-26.1
.make/push-ubuntu-min-25.3: .make/build-ubuntu-min-25.3
	docker push conao3/emacs:ubuntu-min-25.3
.make/push-ubuntu-min-25.2: .make/build-ubuntu-min-25.2
	docker push conao3/emacs:ubuntu-min-25.2
.make/push-ubuntu-min-25.1: .make/build-ubuntu-min-25.1
	docker push conao3/emacs:ubuntu-min-25.1
.make/push-ubuntu-min-24.5: .make/build-ubuntu-min-24.5
	docker push conao3/emacs:ubuntu-min-24.5
.make/push-ubuntu-min-24.4: .make/build-ubuntu-min-24.4
	docker push conao3/emacs:ubuntu-min-24.4
.make/push-ubuntu-min-24.3: .make/build-ubuntu-min-24.3
	docker push conao3/emacs:ubuntu-min-24.3
.make/push-ubuntu-min-24.2: .make/build-ubuntu-min-24.2
	docker push conao3/emacs:ubuntu-min-24.2
.make/push-ubuntu-min-24.1: .make/build-ubuntu-min-24.1
	docker push conao3/emacs:ubuntu-min-24.1
.make/push-ubuntu-min-23.4: .make/build-ubuntu-min-23.4
	docker push conao3/emacs:ubuntu-min-23.4
##################################################

$(DIRS):
	mkdir -p $@

disable-aslr:
	echo 0 > /proc/sys/kernel/randomize_va_space

enable-aslr:
	echo 2 > /proc/sys/kernel/randomize_va_space
