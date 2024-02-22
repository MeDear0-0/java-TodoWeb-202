package sit.int202.todoweb.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.todoweb.models.TaskList;

import java.io.IOException;

@WebServlet(name = "TodoServlet", value = "/todo")
public class TodoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TaskList taskList = new TaskList();
        request.setAttribute("tasks", taskList.getTasks());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/todo.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
