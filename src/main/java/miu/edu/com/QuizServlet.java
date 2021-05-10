package miu.edu.com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/quizImproved"}, initParams = {
		@WebInitParam(name = "location", value = "D:/Uploads"),
		@WebInitParam(name = "maxUploadSize", value = "9900000") })
public class QuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int count = 0;
	int score = 0;
	String nextQuestion;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setAttribute("score",score);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			HttpSession s = request.getSession();
			String answer = request.getParameter("answer");
			if (answer.isEmpty()) { answer = String.valueOf(-100); }

			miu.edu.com.Quiz quiz= (miu.edu.com.Quiz)s.getAttribute("quiz");
			if (quiz==null){
				quiz = new miu.edu.com.Quiz();
				s.setAttribute("quiz", quiz);
				s.setAttribute("index", 0);
			}
			int index = s.getAttribute("index") == null?0:(int)s.getAttribute("index");
			if(request.getParameter("response").isEmpty())
					doGet(request,response);
				else{
				if (quiz.getAnswer(index) == Integer.parseInt(answer)){
					quiz.setScore(quiz.getScore()+1);
				}
				doGet(request, response);
			}
			if(index >= quiz.sizeQuiz){ //list.size = 5
				request.getRequestDispatcher("final.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}
	}

}
