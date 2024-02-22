package sit.int202.quizweb.models;

import java.util.ArrayList;

public class Question {
    private static int count = 0;
    private  int  id;
    private String question;
    private ArrayList<Answer> answers;

    public Question(String question){
        this.id = ++count;
        this.question = question;
        this.answers = new ArrayList<>(5);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    public void addAnswer(Answer answer){
        this.answers.add(answer);
    }

    public void addAnswer(String answer){
        this.addAnswer(answer,false);
    }

    public void addAnswer(String answer,boolean isCorrect){
        Answer ans = new Answer(answer,isCorrect);
        this.addAnswer(ans);
    }




}
