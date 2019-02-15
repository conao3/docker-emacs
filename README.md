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
| `#{"alpine-26.1-min"}` | [(Dockerfiles/Dockerfile-alpine-26.1-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-alpine-26.1-min) |
| `#{"alpine-25.1-min"}` | [(Dockerfiles/Dockerfile-alpine-25.1-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-alpine-25.1-min) |
| `#{"alpine-25.2-min"}` | [(Dockerfiles/Dockerfile-alpine-25.2-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-alpine-25.2-min) |
| `#{"alpine-25.3-min"}` | [(Dockerfiles/Dockerfile-alpine-25.3-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-alpine-25.3-min) |
| `#{"alpine-24.1-min"}` | [(Dockerfiles/Dockerfile-alpine-24.1-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-alpine-24.1-min) |
| `#{"alpine-24.2-min"}` | [(Dockerfiles/Dockerfile-alpine-24.2-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-alpine-24.2-min) |
| `#{"alpine-24.3-min"}` | [(Dockerfiles/Dockerfile-alpine-24.3-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-alpine-24.3-min) |
| `#{"alpine-24.4-min"}` | [(Dockerfiles/Dockerfile-alpine-24.4-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-alpine-24.4-min) |
| `#{"alpine-24.5-min"}` | [(Dockerfiles/Dockerfile-alpine-24.5-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-alpine-24.5-min) |
| `#{"alpine-23.3-min"}` | [(Dockerfiles/Dockerfile-alpine-23.3-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-alpine-23.3-min) |
| `#{"alpine-23.4-min"}` | [(Dockerfiles/Dockerfile-alpine-23.4-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-alpine-23.4-min) |
| `#{"ubuntu-26.1-min"}` | [(Dockerfiles/Dockerfile-ubuntu-26.1-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-26.1-min) |
| `#{"ubuntu-25.1-min"}` | [(Dockerfiles/Dockerfile-ubuntu-25.1-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-25.1-min) |
| `#{"ubuntu-25.2-min"}` | [(Dockerfiles/Dockerfile-ubuntu-25.2-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-25.2-min) |
| `#{"ubuntu-25.3-min"}` | [(Dockerfiles/Dockerfile-ubuntu-25.3-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-25.3-min) |
| `#{"ubuntu-24.1-min"}` | [(Dockerfiles/Dockerfile-ubuntu-24.1-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-24.1-min) |
| `#{"ubuntu-24.2-min"}` | [(Dockerfiles/Dockerfile-ubuntu-24.2-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-24.2-min) |
| `#{"ubuntu-24.3-min"}` | [(Dockerfiles/Dockerfile-ubuntu-24.3-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-24.3-min) |
| `#{"ubuntu-24.4-min"}` | [(Dockerfiles/Dockerfile-ubuntu-24.4-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-24.4-min) |
| `#{"ubuntu-24.5-min"}` | [(Dockerfiles/Dockerfile-ubuntu-24.5-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-24.5-min) |
| `#{"ubuntu-23.3-min"}` | [(Dockerfiles/Dockerfile-ubuntu-23.3-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-23.3-min) |
| `#{"ubuntu-23.4-min"}` | [(Dockerfiles/Dockerfile-ubuntu-23.4-min)](https://github.com/conao3/docker-emacs/blob/master/Dockerfiles/Dockerfile-ubuntu-23.4-min) |

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