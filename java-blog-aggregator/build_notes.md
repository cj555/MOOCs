[reference](https://www.youtube.com/watch?v=U7i1gRv5nZY&index=4&list=PLmcxdcWPhFqMq2BctGktOcIJKUw23wJeh) 

## hello world to jetty server 


1. download and install java sdk8
2. download and install java ee spring suite 
3. add and select java ee prospective
4. create a maven project and make sure that your have JAX-WS Web serves folder 

> **ERROR** 
web.xml is missing and <failOnMissingWebXml> is set to true
[solution](http://stackoverflow.com/questions/31835033/web-xml-is-missing-and-failonmissingwebxml-is-set-to-true)


5. add plugins to pom.xml


```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>io.cj555</groupId>
  <artifactId>java-blog-aggregator</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <packaging>war</packaging>

  <build>
  	<plugins>
  		<plugin>
  			<groupId>org.apache.maven.plugins</groupId>
  			<artifactId>maven-compiler-plugin</artifactId>
  			<version>3.5.1</version>
  			<configuration>
  				<source>1.6</source>
  				<target>1.6</target>

  			</configuration>
  		</plugin>


  		<plugin>
  			<groupId>org.eclipse.jetty</groupId>
  			<artifactId>jetty-maven-plugin</artifactId>
  			<version>9.3.8.RC0</version>
  		</plugin>
  	</plugins>
  </build>
</project>

```

6. run as maven build 

jetty:run 

7. check localhost:8080

You will see a hello world 

## use Spring framework 

1. add dependencies of spring framework 


**NOTE:** don't forget to change the version

Find dependencies [here](http://spring.io/blog/2009/12/02/obtaining-spring-3-artifacts-with-maven/). 



2. Create a dispatcherServlet 

[Reference](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/)

3. register the dispatcherServlet in web.xml 

```xml 

<servlet>
        <servlet-name>dispatcher</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>dispatcher</servlet-name>
        <url-pattern>*.html</url-pattern>
        <url-pattern>*.json</url-pattern>
        <url-pattern>*.xml</url-pattern>
        <url-pattern>*.htm</url-pattern>
    </servlet-mapping>



```



4. add spring bean configuration file in WEB-INF folder 

**NOTE: ** don't forget to change the base-package to your group-id 



```xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.2.xsd">


<context:component-scan base-package="io.cj555.controller"/>


</beans>


```
5. create Pacakge **your_pkg.controller** in main folder 

6. add the first controller in Pacakge **your_pkg.controller** 


The annnotation `@Controller` and `@RequestMapping` are  important 



```java

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  
public class IndexController {
		
	@RequestMapping("/index")
	public String index(){
		return "/WEB-INF/jsp/index.jsp";
		
	}
	
	

}

```



6. restart jettey

**ERROR**: False java.net.BindException: Address already in use on Jetty

Solution: stop tomcat first by clict stop sign.

7. check localhost:8080/index






































































