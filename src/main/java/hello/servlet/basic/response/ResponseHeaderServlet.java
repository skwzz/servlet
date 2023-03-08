package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setHeader("Content-Type", "text/plain; charset=utf-8");
        //response.setContentType("text/plain");
        //response.setCharacterEncoding("utf-8");
        // 로도 가능
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header", "hello");

        // Cookie
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(60);
        //response.setHeader("Set-Cookie", "myCookie=good; Max-Age=60");
        response.addCookie(cookie);


        //redirect
        //response.setStatus(HttpServletResponse.SC_FOUND);
        //response.setHeader("Location", "/basic/hello-form.html");
        response.getWriter().write("안뇽하세용");
    }
}
