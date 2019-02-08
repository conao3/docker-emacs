all:

TAG := latest

DIRS := .make

##################################################

all: build

build: .make/build-alpine-26.1-min
	@:

push: build
	docker push conao3/po4a:$(TAG)

##############################

.make/build-%: Dockerfiles/Dockerfile-% $(DIRS)
	docker image build -t conao3/emacs:$* -f $< .
	touch $@

##################################################

$(DIRS):
	mkdir -p $@

disable-aslr:
	echo 0 > /proc/sys/kernel/randomize_va_space

enable-aslr:
	echo 2 > /proc/sys/kernel/randomize_va_space
