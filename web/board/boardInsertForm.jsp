<%--
  Created by IntelliJ IDEA.
  User: LG677
  Date: 2022-07-14
  Time: 오후 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Board Insert Form</title>
    <script type="text/javascript">
        function fnSubmit(){
            if (confirm("작성하신 글을 등록하시겠습니까?")){
                return true;
            }
            return false;
        }

        function fnReset() {
            if (confirm("입력하신 내용을 삭제하시겠습니까?")){
                fnLoad();
                    return true;
                }
                return false;
            }

        function fnLoad(){
            //폼에 name 속성을 줘서 폼 - 텍스트창으로 접근한다.
            document.regForm.writer.focus();
        }
    </script>
</head>
<body onload="fnLoad()"><!--입력칸에 자동으로 포커스가 오게끔 설정 -->
<div style="align-content: center">
    <h3>[게시판 글쓰기]</h3>
    <form action="boardInsert.do" mehtod="post" name="regForm"
          onsubmit="return fnSubmit()" onreset="return fnReset()">
        <table style="border: 1px" style="width: 80%;">
            <tr>
                <tr>
                    <th>카테고리</th>
                    <td><select name="category" id="category">
                        <option value="Java">Java</option>
                        <option value="JavaScript">JavaScript</option>
                        <option value="Database">Database</option>
                    </select></td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td><input type="text" name="writer" maxlength="20" required="required"></td>
                </tr>
                <tr>
                    <th>비밀번호</th>
                    <td><input type="password" name="password" maxlength="20" required="required"></td>
                </tr>
                <tr>
                    <th>제목</th>
                    <td><input type="text" name="title" maxlength="20" required="required"></td>
                </tr>

                <tr>
                    <th>내용</th>
                    <td>
                        <textarea name="text" cols="50" rows="10"></textarea>
                    </td>
                </tr>
                <tr>
                    <th>파일 첨부</th>
                </tr>
            </tr>
            <tr style="align-content: center">
                <td colspan="2">
                    <input type="submit" value="등록"/>
                    <input type="button" value="취소" onclick="location.href='boardList.do'"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
