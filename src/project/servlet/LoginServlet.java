package project.servlet;

import project.entity.User;
import project.service.Impl.LoginServiceImpl;
import project.service.LoginService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Access-Control-Allow-Origin", "*"); // 允许任何来源
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS"); // 允许的请求方式
        resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept"); // 允许的头信息
        resp.setContentType("application/json;charset=UTF-8");
        String id=req.getParameter("id");
        String password=req.getParameter("password");

        User user = new User();

        String jumpTo = null;
        LoginService loginService = new LoginServiceImpl();
        jumpTo=loginService.login(id,password);
        if(jumpTo!=null){

            user.setCurrentState("true");
            user.setUrl(jumpTo);
            String jsonString = JSON.toJSONString(user);
            HttpSession session = req.getSession(false);
            if (session != null) {
                session.setAttribute("id", id);
            }

        }
        else {
            user.setUrl("");
            user.setCurrentState("fail");
        }
        String jsonString = JSON.toJSONString(user);

        resp.setContentType("application/json"); // 设置响应类型为JSON
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonString);
    }

    protected void login(){
        //这里可能要处理过滤器信息
    }
}
