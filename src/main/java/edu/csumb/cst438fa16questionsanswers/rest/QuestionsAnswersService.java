package edu.csumb.cst438fa16questionsanswers.rest;

import edu.csumb.cst438fa16questionsanswers.QuestionsAnswers;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * REST service that greets requests.
 *
 * This is a "root resource class" as explained in
 * https://jersey.java.net/documentation/latest/jaxrs-resources.html
 */
@Path("/")
public class QuestionsAnswersService {
    
    public static QuestionsAnswers qa = new QuestionsAnswers();
    
    @GET
    @Path("/test")
    public String test() {
        return "This must work";
    }
    
    @GET
    @Path("/randomquestion")
    public String randomquestion(){
        qa.put("The grass is ", "green");
        qa.put("2 plus 2 is ", "4");
        qa.put("How many continents are there? ", "7");
        //return qa.getRandomQuestion();
        return "THIS SHOULD WORK";
    }

    @GET
    @Path("/testanswer")
    public Response answerQuestion(@QueryParam("question") String question, @QueryParam("answer") String answer) {
        if (answer == null || answer.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else if(qa.testAnswer(question, answer)) {
            return Response.ok("Correct!").build();
        } else {
            return Response.ok("Wrong!").build();
        }
    }
}
