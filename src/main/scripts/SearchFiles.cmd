rem java -cp D:\Apps\Lucene\lucene-8.7.0\analysis\common\lucene-analyzers-common-8.7.0.jar;D:\Apps\Lucene\lucene-8.7.0\core\lucene-core-8.7.0.jar;D:\Apps\Lucene\lucene-8.7.0\demo\lucene-demo-8.7.0.jar org.apache.lucene.demo.IndexFiles -index D:\git\CodingChallenges\lucene -docs D:\Apps\Java\jdk-11.0.5\lib\src\java.base\java
rem IndexFiles D:\Apps\Java\jdk-11.0.5\lib\src\java.base\javaD:\Apps\Java\jdk-11.0.5\lib\src\java.base\java
rem IndexFiles D:\Apps\Java\jdk-11.0.5\lib\src\java.base\javaD:\Apps\Java\jdk-11.0.5\lib\src\java.base\java
java -cp D:\Apps\Lucene\lucene-8.7.0\queryparser\lucene-queryparser-8.7.0.jar;D:\Apps\Lucene\lucene-8.7.0\analysis\common\lucene-analyzers-common-8.7.0.jar;D:\Apps\Lucene\lucene-8.7.0\core\lucene-core-8.7.0.jar;D:\Apps\Lucene\lucene-8.7.0\demo\lucene-demo-8.7.0.jar org.apache.lucene.demo.SearchFiles -index D:\git\CodingChallenges\lucene -repeat 1 -paging 10 -query %1