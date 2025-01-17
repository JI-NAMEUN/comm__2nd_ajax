package com.ll.exam;

import com.ll.exam.article.ArticleController;
import com.ll.exam.chat.ChatController;
import com.ll.exam.member.MemberController;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/usr/*")
public class DispatchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Rq rq = new Rq(req, resp);

        MemberController memberController = new MemberController();
        ArticleController articleController = new ArticleController();
        ChatController chatController = new ChatController();

        switch (rq.getRouteMethod()) {
            case "GET":
                switch (rq.getActionPath()) {
                    case "/usr/chat/createRoom":
                        chatController.showCreateRoom(rq);
                        break;
                    case "/usr/chat/modifyRoom":
                        chatController.showModifyRoom(rq);
                        break;
                    case "/usr/chat/roomList":
                        chatController.showRoomList(rq);
                        break;
                    case "/usr/chat/room":
                        chatController.showRoom(rq);
                    case "/usr/chat/roomManual":
                        chatController.showRoomManual(rq);
                        break;

                    case "/usr/article/modify":
                        articleController.showModify(rq);
                        break;
                    case "/usr/article/detail":
                        articleController.showDetail(rq);
                        break;
                    case "/usr/article/list":
                        articleController.showList(rq);
                        break;
                    case "/usr/article/listAuto":
                        articleController.showListAuto(rq);
                        break;
                    case "/usr/article/getArticles":
                        articleController.getArticles(rq);
                        break;
                    case "/usr/article/write":
                        articleController.showWrite(rq);
                        break;
                    case "/usr/member/login":
                        memberController.showLogin(rq);
                        break;
                }
                break;
            case "POST":
                switch (rq.getActionPath()) {
                    case "/usr/chat/writeMessage":
                        chatController.doWriteMessage(rq);
                        break;
                    case "/usr/chat/createRoom":
                        chatController.doCreateRoom(rq);
                        break;
                    case "/usr/chat/modifyRoom":
                        chatController.doModifyRoom(rq);
                        break;
                    case "/usr/article/write":
                        articleController.doWrite(rq);
                        break;
                    case "/usr/article/modify":
                        articleController.doModify(rq);
                        break;
                }
                break;
            case "DELETE":
                switch (rq.getActionPath()) {
                    case "/usr/chat/deleteRoom":
                        chatController.deleteRoom(rq);
                        break;
                    case "/usr/article/delete":
                        articleController.doDelete(rq);
                        break;
                }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }
}

