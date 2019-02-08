all:

TAG := latest

DIRS := .make

##################################################

all: $(DIRS) build

$(DIRS):
	mkdir -p $@

build: emacs .make/build-alpine-26.1-min
	@:

push: build
	docker push conao3/po4a:$(TAG)

##############################

.make/build-%: Dockerfiles/Dockerfile-%
	docker image build -t conao3/emacs:$* -f $< .
	touch $@

##################################################

emacs:
	git clone https://git.savannah.gnu.org/git/emacs.git

disable-aslr:
	echo 0 > /proc/sys/kernel/randomize_va_space

enable-aslr:
	echo 2 > /proc/sys/kernel/randomize_va_space
