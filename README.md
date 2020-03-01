# n-loops
Creating dynamic nested loops on Java

#

Suppose you need to create such nested loops:

```java
for (int i = 0; i < 2; i++) {
    for (int j = 1; j < 3; j++) {
        for (int k = 2; k < 4; k++) {
            System.out.println(Arrays.asList(i, j, k));
        }
    }
}
```
So, with the `n-loops` library you can make it with such simple builder:

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

Good luck and have fun!