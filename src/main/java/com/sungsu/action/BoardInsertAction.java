package com.sungsu.action;

import com.sungsu.dao.BoardDAO;
import com.sungsu.dto.BoardDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BoardInsertAction implements Action{

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String writer = request.getParameter("writer") ;
        String password = request.getParameter("password") ;
        String title = request.getParameter("title") ;
        String text = request.getParameter("text") ;

        BoardDTO dto = new BoardDTO(writer, password, title, text);

        //비즈니스 로직 : DAO 연동(DB 접속, 쿼리 수행)
        BoardDAO dao = new BoardDAO();
        int succ = dao.boardInsert(dto);

        //프레젠테이션 로직 : alert 창을 사용 -> PrintWriter를 이용한 script 코드 구현
        response.setContentType("text/html; charset = utf-8");
        PrintWriter out = response.getWriter();
        if(succ > 0){
            out.println("<script> alert('등록 완료되었습니다.');");
            out.println("location.href = 'boardList.do';</script>");
        }else{
            out.println("<script> alert('등록 실패했습니다.');");
            out.println("location.href = 'boardList.do';</script>");
        }
        return null;    //위 코드에서(script) 페이지 전환이 이뤄지므로 ActionForward가 필요 없다. -> null 리턴
    }
}
