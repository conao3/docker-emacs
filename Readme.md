<!-- -*- mode: markdown; -*- -->

# Description

Run Emacs in docker containers!

This project provides different docker images:

- The main images (~500MB) only contain the runtime dependencies for Emacs to run.
- The `-dev` variants (~1400MB) contain additional developer tools such as [Cask](https://cask.readthedocs.io),
  [git](https://git-scm.com) and [Python](https://www.python.org). The Emacs source is available at `/opt/emacs` if
  you need to build Emacs differently.
- The `-alpine` variants (~200MB) follow the same logic as the main images but are based on
  [Alpine Linux](https://alpinelinux.org).

# Tags

| Tags         | Dockerfile |
|--------------|------------|
| `#{"alpine-26.1 26.1-alpine"}` | [(Dockerfiles/Dockerfile-alpine-26.1-normal)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-alpine-26.1-normal) |
| `#{"alpine-25.3 25.3-alpine"}` | [(Dockerfiles/Dockerfile-alpine-25.3-normal)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-alpine-25.3-normal) |
| `#{"alpine-25.2 25.2-alpine"}` | [(Dockerfiles/Dockerfile-alpine-25.2-normal)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-alpine-25.2-normal) |
| `#{"ubuntu-26.1 26.1"}` | [(Dockerfiles/Dockerfile-ubuntu-26.1-normal)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-26.1-normal) |
| `#{"ubuntu-25.3 25.3"}` | [(Dockerfiles/Dockerfile-ubuntu-25.3-normal)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-25.3-normal) |
| `#{"ubuntu-25.2 25.2"}` | [(Dockerfiles/Dockerfile-ubuntu-25.2-normal)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-25.2-normal) |
| `#{"ubuntu-25.1 25.1"}` | [(Dockerfiles/Dockerfile-ubuntu-25.1-normal)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-25.1-normal) |
| `#{"ubuntu-24.5 24.5"}` | [(Dockerfiles/Dockerfile-ubuntu-24.5-normal)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-24.5-normal) |
| `#{"ubuntu-24.4 24.4"}` | [(Dockerfiles/Dockerfile-ubuntu-24.4-normal)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-24.4-normal) |
| `#{"ubuntu-24.3 24.3"}` | [(Dockerfiles/Dockerfile-ubuntu-24.3-normal)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-24.3-normal) |
| `#{"ubuntu-24.2 24.2"}` | [(Dockerfiles/Dockerfile-ubuntu-24.2-normal)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-24.2-normal) |
| `#{"ubuntu-24.1 24.1"}` | [(Dockerfiles/Dockerfile-ubuntu-24.1-normal)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-24.1-normal) |
| `#{"ubuntu-23.4 23.4"}` | [(Dockerfiles/Dockerfile-ubuntu-23.4-normal)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-23.4-normal) |
| `#{"ubuntu-23.3 23.3"}` | [(Dockerfiles/Dockerfile-ubuntu-23.3-normal)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-23.3-normal) |
| `#{"alpine-26.1-min 26.1-alpine-min"}` | [(Dockerfiles/Dockerfile-alpine-26.1-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-alpine-26.1-min) |
| `#{"alpine-25.3-min 25.3-alpine-min"}` | [(Dockerfiles/Dockerfile-alpine-25.3-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-alpine-25.3-min) |
| `#{"alpine-25.2-min 25.2-alpine-min"}` | [(Dockerfiles/Dockerfile-alpine-25.2-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-alpine-25.2-min) |
| `#{"ubuntu-26.1-min 26.1-min"}` | [(Dockerfiles/Dockerfile-ubuntu-26.1-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-26.1-min) |
| `#{"ubuntu-25.3-min 25.3-min"}` | [(Dockerfiles/Dockerfile-ubuntu-25.3-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-25.3-min) |
| `#{"ubuntu-25.2-min 25.2-min"}` | [(Dockerfiles/Dockerfile-ubuntu-25.2-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-25.2-min) |
| `#{"ubuntu-25.1-min 25.1-min"}` | [(Dockerfiles/Dockerfile-ubuntu-25.1-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-25.1-min) |
| `#{"ubuntu-24.5-min 24.5-min"}` | [(Dockerfiles/Dockerfile-ubuntu-24.5-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-24.5-min) |
| `#{"ubuntu-24.4-min 24.4-min"}` | [(Dockerfiles/Dockerfile-ubuntu-24.4-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-24.4-min) |
| `#{"ubuntu-24.3-min 24.3-min"}` | [(Dockerfiles/Dockerfile-ubuntu-24.3-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-24.3-min) |
| `#{"ubuntu-24.2-min 24.2-min"}` | [(Dockerfiles/Dockerfile-ubuntu-24.2-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-24.2-min) |
| `#{"ubuntu-24.1-min 24.1-min"}` | [(Dockerfiles/Dockerfile-ubuntu-24.1-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-24.1-min) |
| `#{"ubuntu-23.4-min 23.4-min"}` | [(Dockerfiles/Dockerfile-ubuntu-23.4-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-23.4-min) |
| `#{"ubuntu-23.3-min 23.3-min"}` | [(Dockerfiles/Dockerfile-ubuntu-23.3-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-23.3-min) |

# Usage

## Console

``` shell
docker run -it --rm silex/emacs
```

## GUI

``` shell
xhost +local:root # WARN: this comes with security issues
docker run -it --rm -e DISPLAY -v /tmp/.X11-unix:/tmp/.X11-unix silex/emacs
```

# Alternatives

- [flycheck/emacs-cask](https://hub.docker.com/r/flycheck/emacs-cask): collection of docker images containing a
  minimal Emacs compiled from source with Cask.
- [flycheck/emacs-travis](https://github.com/flycheck/emacs-travis): makefile which provides targets to
  install Emacs stable and emacs-snapshot, Texinfo and Cask.
- [jgkamat/airy-docker-emacs](https://github.com/jgkamat/airy-docker-emacs): alpine-based docker images that have
  Emacs installed through the package manager.
- [JAremko/docker-emacs](https://github.com/JAremko/docker-emacs): collection of docker images with focus on GUI usage.
- [rejeep/evm](https://github.com/rejeep/evm): pre-built Emacs binaries.

# Contributions

They are very welcome! The basic workflow is as follow:

- Modify files inside the `/resources` directory.
- Run `lein run -- gen` to spread the changes everywhere.

- Run `lein run -- build` to build docker images.
