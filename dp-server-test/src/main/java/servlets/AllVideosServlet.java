package servlets;

import core.VideoManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AllVideosServlet")
public class AllVideosServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        if (request.getSession().getAttribute("username") != null) {
            String username = (String) request.getSession().getAttribute("username");

            PrintWriter out = response.getWriter();
            out.print(VideoManager.onGetVideoList(username, VideoManager.GetVideoListRequestType.All));
            out.flush();
        }
        else {
            response.setStatus(511); // 511 -> Network Authentication Required
        }
    }
}
