package sit.int202.todoweb.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.todoweb.models.Task;
import sit.int202.todoweb.models.TaskList;

import java.io.IOException;

@WebServlet(name = "ToggleTodoServlet", value = "/toggle-todo")
public class ToggleTodoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        if (title != null && title.length()>0) {
            TaskList taskList = new TaskList();
            Task task = taskList.find(title);
            if (task != null) {
                task.toggleStatus();
            }
        }
        response.sendRedirect("todo");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
