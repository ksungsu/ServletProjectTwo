package com.sungsu.controller;

import com.sungsu.action.Action;
import com.sungsu.action.ActionForward;
import com.sungsu.action.BoardListAction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/BoardFrontController.do")
public class BoardFrontController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //uri에서 contextPath 값 자르기
        String uri = request.getRequestURI();
        String ctx = request.getContextPath();
        String command = uri.substring(ctx.length());

        //클라이언트 요청(*.do -> command)과 실제 처리할 비즈니스 로직(Action Class) 연결
        Action action = null;
        ActionForward forward = null;

        if(command.equals("/boardList.do")){
            action = new BoardListAction(); //상위 객체쪽으로 업캐스팅(다형성)
            forward = action.execute(request, response);
        }

        //페이지 전환(프레젠테이션 로직) : sendRedirect(), forward()
        if(forward != null) {
            if(forward.isRedirect()){          //true : sendRedirect() 페이지 전환
                response.sendRedirect(forward.getPath());
            }
        }else{                                  //false : forward() 페이지 전환
            RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
            rd.forward(request, response);
        }
    }

}
