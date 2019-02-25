# -*- mode: makefile; -*-

all:

TAGS :=
TAGS  += alpine-26.1-normal
TAGS  += alpine-25.3-normal
TAGS  += alpine-25.2-normal
TAGS  += ubuntu-26.1-normal
TAGS  += ubuntu-25.3-normal
TAGS  += ubuntu-25.2-normal
TAGS  += ubuntu-25.1-normal
TAGS  += ubuntu-24.5-normal
TAGS  += ubuntu-24.4-normal
TAGS  += ubuntu-24.3-normal
TAGS  += ubuntu-24.2-normal
TAGS  += ubuntu-24.1-normal
TAGS  += ubuntu-23.4-normal
TAGS  += alpine-26.1-min
TAGS  += alpine-25.3-min
TAGS  += alpine-25.2-min
TAGS  += ubuntu-26.1-min
TAGS  += ubuntu-25.3-min
TAGS  += ubuntu-25.2-min
TAGS  += ubuntu-25.1-min
TAGS  += ubuntu-24.5-min
TAGS  += ubuntu-24.4-min
TAGS  += ubuntu-24.3-min
TAGS  += ubuntu-24.2-min
TAGS  += ubuntu-24.1-min
TAGS  += ubuntu-23.4-min

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

.make/push-alpine-26.1-normal: .make/build-alpine-26.1-normal
	docker push conao3/emacs:alpine-26.1-normal
.make/push-alpine-25.3-normal: .make/build-alpine-25.3-normal
	docker push conao3/emacs:alpine-25.3-normal
.make/push-alpine-25.2-normal: .make/build-alpine-25.2-normal
	docker push conao3/emacs:alpine-25.2-normal
.make/push-ubuntu-26.1-normal: .make/build-ubuntu-26.1-normal
	docker push conao3/emacs:ubuntu-26.1-normal
.make/push-ubuntu-25.3-normal: .make/build-ubuntu-25.3-normal
	docker push conao3/emacs:ubuntu-25.3-normal
.make/push-ubuntu-25.2-normal: .make/build-ubuntu-25.2-normal
	docker push conao3/emacs:ubuntu-25.2-normal
.make/push-ubuntu-25.1-normal: .make/build-ubuntu-25.1-normal
	docker push conao3/emacs:ubuntu-25.1-normal
.make/push-ubuntu-24.5-normal: .make/build-ubuntu-24.5-normal
	docker push conao3/emacs:ubuntu-24.5-normal
.make/push-ubuntu-24.4-normal: .make/build-ubuntu-24.4-normal
	docker push conao3/emacs:ubuntu-24.4-normal
.make/push-ubuntu-24.3-normal: .make/build-ubuntu-24.3-normal
	docker push conao3/emacs:ubuntu-24.3-normal
.make/push-ubuntu-24.2-normal: .make/build-ubuntu-24.2-normal
	docker push conao3/emacs:ubuntu-24.2-normal
.make/push-ubuntu-24.1-normal: .make/build-ubuntu-24.1-normal
	docker push conao3/emacs:ubuntu-24.1-normal
.make/push-ubuntu-23.4-normal: .make/build-ubuntu-23.4-normal
	docker push conao3/emacs:ubuntu-23.4-normal
.make/push-alpine-26.1-min: .make/build-alpine-26.1-min
	docker push conao3/emacs:alpine-26.1-min
.make/push-alpine-25.3-min: .make/build-alpine-25.3-min
	docker push conao3/emacs:alpine-25.3-min
.make/push-alpine-25.2-min: .make/build-alpine-25.2-min
	docker push conao3/emacs:alpine-25.2-min
.make/push-ubuntu-26.1-min: .make/build-ubuntu-26.1-min
	docker push conao3/emacs:ubuntu-26.1-min
.make/push-ubuntu-25.3-min: .make/build-ubuntu-25.3-min
	docker push conao3/emacs:ubuntu-25.3-min
.make/push-ubuntu-25.2-min: .make/build-ubuntu-25.2-min
	docker push conao3/emacs:ubuntu-25.2-min
.make/push-ubuntu-25.1-min: .make/build-ubuntu-25.1-min
	docker push conao3/emacs:ubuntu-25.1-min
.make/push-ubuntu-24.5-min: .make/build-ubuntu-24.5-min
	docker push conao3/emacs:ubuntu-24.5-min
.make/push-ubuntu-24.4-min: .make/build-ubuntu-24.4-min
	docker push conao3/emacs:ubuntu-24.4-min
.make/push-ubuntu-24.3-min: .make/build-ubuntu-24.3-min
	docker push conao3/emacs:ubuntu-24.3-min
.make/push-ubuntu-24.2-min: .make/build-ubuntu-24.2-min
	docker push conao3/emacs:ubuntu-24.2-min
.make/push-ubuntu-24.1-min: .make/build-ubuntu-24.1-min
	docker push conao3/emacs:ubuntu-24.1-min
.make/push-ubuntu-23.4-min: .make/build-ubuntu-23.4-min
	docker push conao3/emacs:ubuntu-23.4-min
##################################################

$(DIRS):
	mkdir -p $@

disable-aslr:
	echo 0 > /proc/sys/kernel/randomize_va_space

enable-aslr:
	echo 2 > /proc/sys/kernel/randomize_va_space
