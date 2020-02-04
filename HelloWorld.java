// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class HelloWorld extends HttpServlet {
 
   private String message;
   private String message1;


   public void init() throws ServletException {
      // Do required initialization
      message = "<html>\n"+
               "<body>\n"+
               "<center><b>MY ASSIGNMENT</center></b>\n"+
               "<br />\n"+
               "<br />\n"+
               "<br />\n"+
               "<body bgcolor='cyan'><center>\n"+
               "<form action='HelloWorld' method='GET'>\n"+
               "VALUE1:<input type='number' VALUE 1 name = 'value1'/>\n"+
               "VALUE2<input type='number' VALUE 2 name = 'value2'/>\n"+
               "<button>SOLVE</button><br />\n"+
               "<center /><br /> Operation: <input type='text' length='2' name = 'operation'/>\n";
             

      message1 = "</center></body>\n"+
               "</form>\n"+
               "</body>\n" + "</html>";
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
      // Set response content type
      response.setContentType("text/html");


      // Actual logic goes here.
      if(request.getParameter("value1") != "" && request.getParameter("value1") != null && request.getParameter("value2") != "" && request.getParameter("value2") != null && request.getParameter("operation") != null && request.getParameter("operation") != ""){

         if(Integer.parseInt(request.getParameter("value1"))>=0 && Integer.parseInt(request.getParameter("value2"))>=0 ){
            char op = request.getParameter("operation").charAt(0);
            double result=0;
            if(op=='+'){
               result = Integer.parseInt(request.getParameter("value1")) + Integer.parseInt(request.getParameter("value2"));
            }else  if(op=='-'){
               result = Integer.parseInt(request.getParameter("value1")) - Integer.parseInt(request.getParameter("value2"));
            }else  if(op=='x'){
               result = Integer.parseInt(request.getParameter("value1")) * Integer.parseInt(request.getParameter("value2"));
            }else  if(op=='/'){
               result = (double) Integer.parseInt(request.getParameter("value1")) /(double) Integer.parseInt(request.getParameter("value2"));
            }

            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>" +message+"<br /> <label>"+request.getParameter("value1")+" "+op+" "+request.getParameter("value2")+" = "+result+"</label>"+message1);
         }


      }else{
         PrintWriter out = response.getWriter();
         out.println("<!DOCTYPE html>" +message+message1);
      }
      
   }

   public void destroy() {
      // do nothing.
   }
}