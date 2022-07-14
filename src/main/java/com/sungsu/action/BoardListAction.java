package com.sungsu.action;

import com.sungsu.dao.BoardDAO;
import com.sungsu.dto.BoardDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
페이지 연결을 담당하는 Action class
 */
public class BoardListAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request,
                                 HttpServletResponse response)
            throws ServletException, IOException{

        //DAO 연동, 게시판 목록 출력(비즈니스 로직)
        BoardDAO dao = new BoardDAO();
        List<BoardDTO> list = dao.boardSearchAll();
        request.setAttribute("list", list);

        ActionForward forward = new ActionForward();
        forward.setPath("board/boardList.jsp");
        forward.setRedirect(false); // true : reDirect false : forward()
        return forward;
    }
}
