# Gradle Include Builder

[![Build](https://img.shields.io/github/actions/workflow/status/DanielLiu1123/gradle-include-builder/build.yml?branch=main)](https://github.com/DanielLiu1123/gradle-include-builder/actions)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Gradle Include Builder is a script that aims to use source code of the dependencies to build gradle project,
keep the code always updated, and make customization and extension easier.

Are you still:

- Maintaining a private repository to share your Java libraries?
- Waiting for a dependency to release a new version to fix your issue?

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
      // From https://github.com/DanielLiu1123/httpexchange-spring-boot-starter (git)
      // Just like a normal dependency but without version
      implementation 'io.github.danielliu1123:httpexchange-spring-boot-starter'
  
      // From ../another-gradle-project (dir)
      implementation 'com.example:another-gradle-project'
  
      // From https://repo1.maven.org/maven2/com/google/code/gson/gson/2.10.1/gson-2.10.1.jar (jar)
      // Use jar file as dependency
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
