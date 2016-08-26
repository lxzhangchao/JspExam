#  创建Exam1
mvn archetype:generate -DgroupId=com.hand -DartifactId=Exam1 -DarchetypeArtifactId=maven-archetype-webapp -Dinteracti
veMode=false -DarchetypeCatalog=internal

dbconfig.properties位置
JspExam\Exam1\src\main\java

#执行项目
cd Exam1

运行tomcat7
mvn tomcat7:run

在网页输入
http://localhost:8080/Exam1

