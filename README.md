# Untitled Language that Compiles and Interprets (ULCI / Untitled)

Untitled Language that Compiles and Interprets (ULCI or Untitled for short) is
a hobbyist programming language created
by me, a (at this time of writing) 17-year-old high-school junior.
It's simple, bare-bones, and very prone to &#10024;**bugs and stuff**&#10024;.

Also, this README is currently WIP, so at one point, I'll add more to this.

**Right now, there is no compiling, but I promise there will be.**

This project is written in **Java 25** (Temurin), and the build system used is **Gradle 9.10**. The IDE used is **IntelliJ IDEA CE**.

## Building (or running, I should say)

The Dependencies needed are:
* Java 25 SDK

Right now, there is no compiler, so to use the interpreter,

    git clone https://github.com/AnOzen/untitled-lang
    cd untitled-lang

    ./gradlew clean run --args="<filepath>"

## Grammar

Here is the current Grammar:

$$
\Large
\begin{align}
[\text{Exit}] &\to \text{exit}([\text{Expr}]);\\
[\text{Expr}] &\to
\begin{cases}
\text{Integer}\\
\end{cases}
\end{align}
$$

The standalone file for this is `docs/grammar.md`.