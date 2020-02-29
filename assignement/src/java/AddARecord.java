
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddARecord extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DBOperation operator = new DBOperation();
        Student s = new Student();
        s.setId(request.getParameter("id"));
        s.setName(request.getParameter("name"));
        s.setAge(request.getParameter("age"));
        if(operator.insertOneRecord(s)){
            System.out.println("success");
            request.setAttribute("function", "InsertOneRecord");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }else{
            System.out.println("fail");
        }
        
    }
}
