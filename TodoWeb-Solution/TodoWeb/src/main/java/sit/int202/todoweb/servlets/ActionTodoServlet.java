package sit.int202.todoweb.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.todoweb.models.Task;
import sit.int202.todoweb.models.TaskList;

import java.io.IOException;

@WebServlet(name = "ActionTodoServlet", value = "/action-todo")
public class ActionTodoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") ;
        String title = request.getParameter("title");

        if(title != null && action !=null &&
                         (action.equals("toggle") || action.equals("remove") || action.equals("completed"))){
            System.out.println("action is "+action);

            TaskList taskList = new TaskList() ;
            Task task = taskList.find(title) ;
            switch(action){
                case "completed": if(task != null){
                                    task.completed();
                                  }
                                  break ;
                case "remove": if(task != null) {
                                taskList.remove(title);
                               }
                               break ;
                case "toggle": if(task != null){
                                task.toggleStatus();
                               }
                               break ;
            }
        }

        response.sendRedirect("todo");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
