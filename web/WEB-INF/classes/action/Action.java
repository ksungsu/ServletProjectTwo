package main.java.com.sungsu.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
Servlet과 비슷한 역할을 하는 인터페이스
 */
public interface Action {
    public abstract ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
