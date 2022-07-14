package com.sungsu.action;

public class ActionForward {
    private String path;    // view page 경로(URL)와 파일명을 저장할 변수
    private boolean isRedirect; // 페이지 전환 방식 true : sendRedirect() false : forward()

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isRedirect() {
        return isRedirect;
    }

    public void setRedirect(boolean redirect) {
        isRedirect = redirect;
    }
}
