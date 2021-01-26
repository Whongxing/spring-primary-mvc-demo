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
