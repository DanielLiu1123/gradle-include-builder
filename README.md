# Gradle Include Builder

[![Build](https://img.shields.io/github/actions/workflow/status/DanielLiu1123/gradle-include-builder/build.yml?branch=main)](https://github.com/DanielLiu1123/gradle-include-builder/actions)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Are you still:

- Maintaining a private repository to share your Java libraries?
- Waiting for a dependency to release a new version to fix your issue?

Problems with using Jar files as dependencies:

- Setting up and maintaining a private repository

  This is time-consuming and requires extra costs and expertise. Managing
  the stability and security of a private repository adds complexity to the project, and any disruption can affect
  dependency management and the build process.

- Updates are not timely

  Relying on jar files means waiting for the library author to release a new version. This can
  cause unnecessary delays for urgent bug fixes or security updates.

- Difficult to debug and troubleshoot

  Without the source code, it becomes harder to understand and debug issues in the
  dependency library. Even with source code, you cannot make direct modifications in the project, limiting your ability
  to quickly resolve issues.

- Inconvenient to customize and extend

  When you need to customize or extend library functions, starting from the source
  code to compile and manage your own version is troublesome and prone to errors. Merging these changes with library
  updates is even more challenging.

Why not use Java source code as dependencies?

Gradle provides [Composite Builds](https://docs.gradle.org/current/userguide/composite_builds.html) to include external
projects. This allows you to directly include the source code of the dependency library in your project,
and you can easily customize and extend the library functions.

## Quick Start

- Apply include-builder script

  ```groovy
  // settings.gradle
  apply from: 'https://raw.githubusercontent.com/DanielLiu1123/gradle-include-builder/main/include-build.gradle'
  ```

- Define included projects

  ```yaml
  # include-builder.yaml
  projects:
    - id: httpexchange-spring-boot-starter
      git:
        url: https://github.com/DanielLiu1123/httpexchange-spring-boot-starter
        branch: main
        path: third-party/httpexchange-spring-boot-starter
        extraArgs: --depth 1 --single-branch
    - dir:
        path: ../another-gradle-project
    - jar:
        url: https://repo1.maven.org/maven2/com/google/code/gson/gson/2.10.1/gson-2.10.1.jar
        path: libs/gson.jar
  ```

- Import specified modules

  ```groovy
  // build.gradle
  dependencies {
      implementation 'io.github.danielliu1123:httpexchange-spring-boot-starter'
      implementation 'com.example:another-gradle-project'
      implementation files('libs/gson.jar')
  }
  ```

## Documentation

Go to [Documentation](https://danielliu1123.github.io/gradle-include-builder/docs/intro) to view the full documentation.

## Code of Conduct

This project is governed by the [Code of Conduct](./CODE_OF_CONDUCT.md).
By participating, you are expected to uphold this code of conduct.
Please report unacceptable behavior to llw599502537@gmail.com.

## License

The MIT License.
