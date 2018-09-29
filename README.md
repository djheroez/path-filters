# Path filters

A set of filters for Java 7 [paths](https://docs.oracle.com/javase/8/docs/api/?java/nio/file/Path.html) inspired by the file filters of [Apache Commons IO](https://commons.apache.org/proper/commons-io/).

### Example of usage
```java
Path home = Paths.get("/home/user");
Files.newDirectoryStream(home, new FilePathFilter());
```
