# n-loops
Creating dynamic nested loops on Java

###

![build](https://github.com/0x100/n-loops/workflows/build/badge.svg?branch=master)
[![](https://jitpack.io/v/0x100/n-loops.svg)](https://jitpack.io/#0x100/n-loops)
##

### The problem

Suppose you need to create such nested loops dynamically:

```java
for (int i = 0; i < 2; i++) {
    for (int j = 1; j < 3; j++) {
        for (int k = 2; k < 4; k++) {
            System.out.println(Arrays.asList(i, j, k));
        }
    }
}
```

### Solution

With the `n-loops` library you can make it with the simple builder:

```java
new NLoops()
    .from(0).to(2)
    .from(1).to(3)
    .from(2).to(4)
    .action(System.out::println);
```

Result output:
```
[0, 1, 2]
[0, 1, 3]
[0, 2, 2]
[0, 2, 3]
[1, 1, 2]
[1, 1, 3]
[1, 2, 2]
[1, 2, 3]
```

### More flexible cases

Suppose we need to generate loops like this:
```java
for (int i = 0; i < 3; i += 2) {
    for (int j = 7; j > 2; j--) {
        for (int k = 18; k > 5; k -= 3) {
            for (int l = 1; l < 4; l++) {
                System.out.println(Arrays.asList(i, j, k, l));
            }
        }
    }
}
```

This is also pretty straightforward to implement with the library's DSL:
```java
new NLoops()
    .from(0).to(3).inc(2)
    .from(7).to(2)
    .from(18).to(5).dec(3)
    .from(1).to(4)
    .action(System.out::println);
```

Result output:
```
[0, 5]
[0, 4]
[0, 3]
[2, 5]
[2, 4]
[2, 3]
```

## How to add the library in your project

1. Add the `jitpack` repository in your `pom.xml`

    ```xml
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>
    ```

2. Add the `n-loop` dependency

```xml
    <dependency>
        <groupId>com.github.0x100</groupId>
        <artifactId>n-loops</artifactId>
        <version>1.0-release</version>
    </dependency>
```

## How to contribute
Fork the repository, make changes, write a test for your code, send me a pull request. 
I will review your changes and apply them to the master branch shortly, provided they don't violate quality standards. 
To avoid frustration, before sending a pull request please compile the project.

##

Good luck and have fun!