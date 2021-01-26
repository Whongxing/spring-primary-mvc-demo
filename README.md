# spring-primary-mvc-demo
IDEA新建一个SpringMVC项目学习

# 环境
  - IDEA 2019.3
  - jdk 1.8
  - 外部TomCat 7，
  
     - 使用TomCat6 的时候会报找不到javax.servlet.http.HttpServletRequest httpServletRequest的某个方法到时候了解一下这个问题是什么原因
# Demo开始
### 一、在IDEA中新建一个SpringMvc项目

很简单，依赖包选择download就好了，等新建完项目后，就会生成web目录

![](https://github.com/Whongxing/spring-primary-mvc-demo/blob/master/src/image/mvc-web%E7%94%9F%E6%88%90.PNG)

后面就不上传图片了，源码就是上面的代码
### 二、在dispatcher-servler.xml中配置请求
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!-- 非注解 处理器映射器 http://localhost:8080/helloWorld.form-->
    <bean class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping" />
    <!-- 视图解析器 -->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" />
    <!-- 一个可以被url 映射的 Handler 的 bean， 供处理器映射器查找-->
    <bean name="/helloWorld.form" class="spring.mvc.controller.HelloWorldController" />

</beans>
```

可以看到，通过配置/helloWorld.form请求，我们会对应到SpringController一个类

### 非注解的方式，这个类实现了SpringMVC提供的Controller接口

```
package spring.mvc.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@org.springframework.stereotype.Controller
public class HelloWorldController implements Controller {
    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        // 创建模型
        ModelAndView modelAndView = new ModelAndView();

        // 向模型中添加数据
        modelAndView.addObject("message", "Hello World");

        // 返回逻辑视图
        modelAndView.setViewName("/WEB-INF/page/test.jsp");
        return modelAndView;

    }
}
```


