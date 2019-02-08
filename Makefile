TAG := latest

build: emacs .make-build-alpine-26.1-min
	@:

.make-build-%: Dockerfiles/Dockerfile-%
	docker image build -t conao3/emacs:$* -f $< .

push: build
	docker push conao3/po4a:$(TAG)

emacs:
	git clone https://git.savannah.gnu.org/git/emacs.git

disable-aslr:
	echo 0 > /proc/sys/kernel/randomize_va_space

enable-aslr:
	echo 2 > /proc/sys/kernel/randomize_va_space
