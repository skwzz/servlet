package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printStartLine(request);
        printHeader(request);
        printHeaderUtils(request);
        printEtc(request);
    }

    private void printEtc(HttpServletRequest request) {
        System.out.println("request.getRemoteUser() = " + request.getRemoteUser());
        System.out.println("request.getRemoteAddr() = " + request.getRemoteAddr());
        System.out.println("request.getRemotePort() = " + request.getRemotePort());
        System.out.println("request.getLocalName() = " + request.getLocalName());
        System.out.println("request.getLocalAddr() = " + request.getLocalAddr());
        System.out.println("request.getLocalPort() = " + request.getLocalPort());
    }

    private void printHeaderUtils(HttpServletRequest request) {
        System.out.println("request.getServerName() = " + request.getServerName());
        System.out.println("request.getServerPort() = " + request.getServerPort());
        request.getLocales().asIterator().forEachRemaining(locale -> System.out.println("locale = " + locale));
        if(request.getCookies() != null){
            Arrays.stream(request.getCookies()).iterator().forEachRemaining(cookie -> System.out.println(cookie.getName()+" : "+cookie.getValue()));
        }
        System.out.println("request.getContentType() = " + request.getContentType());
        System.out.println("request.getContentLength() = " + request.getContentLength());
        System.out.println("request.getCharacterEncoding() = " + request.getCharacterEncoding());
                
    }

    private void printStartLine(HttpServletRequest request) {
        System.out.println("request.getMethod() = " + request.getMethod());
        System.out.println("request.getProtocol() = " + request.getProtocol());
        System.out.println("request.getScheme() = " + request.getScheme());
        System.out.println("request.getRequestURL() = " + request.getRequestURL());
        System.out.println("request = " + request.getRequestURI());
        System.out.println("request.getQueryString() = " + request.getQueryString());
        System.out.println("request.isSecure() = " + request.isSecure());
    }

    private void printHeader(HttpServletRequest request){
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String nextElement = headerNames.nextElement();
            System.out.println(nextElement + " : " +nextElement);
        }

    }
}
