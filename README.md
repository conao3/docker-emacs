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
| `["alpine-normal-26.1" "26.1-alpine-normal" "26.1-alpine" "26-alpine"]` | [(Dockerfiles/Dockerfile-alpine-normal-26.1)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-alpine-normal-26.1) |
| `["alpine-normal-25.3" "25.3-alpine-normal" "25.3-alpine" "25-alpine"]` | [(Dockerfiles/Dockerfile-alpine-normal-25.3)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-alpine-normal-25.3) |
| `["alpine-normal-25.2" "25.2-alpine-normal" "25.2-alpine"]` | [(Dockerfiles/Dockerfile-alpine-normal-25.2)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-alpine-normal-25.2) |
| `["ubuntu-normal-26.1" "26.1-normal" "26.1" "26-normal" "26"]` | [(Dockerfiles/Dockerfile-ubuntu-normal-26.1)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-normal-26.1) |
| `["ubuntu-normal-25.3" "25.3-normal" "25.3" "25-normal" "25"]` | [(Dockerfiles/Dockerfile-ubuntu-normal-25.3)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-normal-25.3) |
| `["ubuntu-normal-25.2" "25.2-normal" "25.2"]` | [(Dockerfiles/Dockerfile-ubuntu-normal-25.2)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-normal-25.2) |
| `["ubuntu-normal-25.1" "25.1-normal" "25.1"]` | [(Dockerfiles/Dockerfile-ubuntu-normal-25.1)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-normal-25.1) |
| `["ubuntu-normal-24.5" "24.5-normal" "24.5" "24-normal" "24"]` | [(Dockerfiles/Dockerfile-ubuntu-normal-24.5)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-normal-24.5) |
| `["ubuntu-normal-24.4" "24.4-normal" "24.4"]` | [(Dockerfiles/Dockerfile-ubuntu-normal-24.4)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-normal-24.4) |
| `["ubuntu-normal-24.3" "24.3-normal" "24.3"]` | [(Dockerfiles/Dockerfile-ubuntu-normal-24.3)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-normal-24.3) |
| `["ubuntu-normal-24.2" "24.2-normal" "24.2"]` | [(Dockerfiles/Dockerfile-ubuntu-normal-24.2)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-normal-24.2) |
| `["ubuntu-normal-24.1" "24.1-normal" "24.1"]` | [(Dockerfiles/Dockerfile-ubuntu-normal-24.1)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-normal-24.1) |
| `["ubuntu-normal-23.4" "23.4-normal" "23.4" "23-normal" "23"]` | [(Dockerfiles/Dockerfile-ubuntu-normal-23.4)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-normal-23.4) |
| `["alpine-min-26.1" "26.1-alpine-min" "26-alpine-min"]` | [(Dockerfiles/Dockerfile-alpine-min-26.1)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-alpine-min-26.1) |
| `["alpine-min-25.3" "25.3-alpine-min" "25-alpine-min"]` | [(Dockerfiles/Dockerfile-alpine-min-25.3)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-alpine-min-25.3) |
| `["alpine-min-25.2" "25.2-alpine-min"]` | [(Dockerfiles/Dockerfile-alpine-min-25.2)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-alpine-min-25.2) |
| `["ubuntu-min-26.1" "26.1-min" "26-min"]` | [(Dockerfiles/Dockerfile-ubuntu-min-26.1)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-min-26.1) |
| `["ubuntu-min-25.3" "25.3-min" "25-min"]` | [(Dockerfiles/Dockerfile-ubuntu-min-25.3)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-min-25.3) |
| `["ubuntu-min-25.2" "25.2-min"]` | [(Dockerfiles/Dockerfile-ubuntu-min-25.2)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-min-25.2) |
| `["ubuntu-min-25.1" "25.1-min"]` | [(Dockerfiles/Dockerfile-ubuntu-min-25.1)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-min-25.1) |
| `["ubuntu-min-24.5" "24.5-min" "24-min"]` | [(Dockerfiles/Dockerfile-ubuntu-min-24.5)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-min-24.5) |
| `["ubuntu-min-24.4" "24.4-min"]` | [(Dockerfiles/Dockerfile-ubuntu-min-24.4)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-min-24.4) |
| `["ubuntu-min-24.3" "24.3-min"]` | [(Dockerfiles/Dockerfile-ubuntu-min-24.3)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-min-24.3) |
| `["ubuntu-min-24.2" "24.2-min"]` | [(Dockerfiles/Dockerfile-ubuntu-min-24.2)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-min-24.2) |
| `["ubuntu-min-24.1" "24.1-min"]` | [(Dockerfiles/Dockerfile-ubuntu-min-24.1)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-min-24.1) |
| `["ubuntu-min-23.4" "23.4-min" "23-min"]` | [(Dockerfiles/Dockerfile-ubuntu-min-23.4)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-min-23.4) |

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
