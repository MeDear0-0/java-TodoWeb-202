package sit.int202.quizweb.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.quizweb.models.Answer;
import sit.int202.quizweb.models.Question;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "QuizServlet", value = "/quiz")

public class QuizServlet extends HttpServlet {
    private ArrayList<Question> questions;

    public void init() throws ServletException {
        questions = new ArrayList<>(2);

        Question question = new Question("1+2 = ?");
        Answer answer = new Answer("2");
        question.addAnswer(answer);
        question.addAnswer(new Answer("3",true));
        question.addAnswer(new Answer("4"));
        question.addAnswer(new Answer("5"));

        questions.add(question);

        question = new Question("1%2 = ?");
        question.addAnswer(new Answer("0"));
        question.addAnswer(new Answer("1",true));
        question.addAnswer(new Answer("null"));

        questions.add(question);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Quiz</h1>");
        out.println("<h2>Three are "+questions.size()+" questions.</h2>");
        for (Question question: questions){
            out.println("<b>"+question.getId()+"). "+question.getQuestion()+"</b>");
            out.println("<ol type='a'>");
            for (Answer answer: question.getAnswers()){
                out.println("<li>"+answer.getAnswer()+"</li>");
            }
            out.println("</ol>");
        }
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}