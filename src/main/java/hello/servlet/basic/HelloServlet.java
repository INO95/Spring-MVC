package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//서블릿 애노테이션, name : 서블릿 이름, urlPatterns : URL 매핑
@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    // ctrl + o : 메소드 오버라이드
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //HTTP 요청을 통해 매핑된 URL이 호출되면 서블릿 컨테이너는 다음 메서드를 실행한다
        // HTTP 요청이 오면 WAS(서블릿 컨테이너)가 리퀘스트, 리스폰스 객체를 만들어서 서블릿에 던져준다.

        //soutm : 클래스명 메서드명 출력
        System.out.println("HelloServlet.service");
        //soutv
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        //http://localhost:8080/hello?username=ino 여기서 ? 이후 부분을 쿼리 파라미터(스트링)라고 한다.
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        //(헤더 정보)단순 문자로 보낼것이다
        response.setContentType("text/plain");
        //(헤더 정보)문자 세트의 인코딩 정보를 알려준다
        response.setCharacterEncoding("utf-8");
        //HTTP 메시지 바디에 데이터가 들어간다
        response.getWriter().write("hello " + username);
    }
}
