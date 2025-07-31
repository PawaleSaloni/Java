package com.servletdemo.main;

    import java.io.IOException;

    import jakarta.servlet.ServletException;
    import jakarta.servlet.annotation.WebServlet;
    import jakarta.servlet.http.HttpServlet;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;

    @WebServlet("/login")
    public class LoginServlet extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
            
            String username = request.getParameter("username");
            String password = request.getParameter("password");
    
            response.setContentType("text/html");
    
            if ("admin".equals(username) && "1234".equals(password)) {
                response.getWriter().println("<h1>Login Successful</h1>");
     
            } else {
                 response.getWriter().println("<h1>Login failed</h1>");
     
            }
        }
        // Handles GET when user directly visits /login
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

        response.setContentType("text/html");
        response.getWriter().println(
            "<form method='post' action='login'>" +
            "Username: <input type='text' name='username'><br><br>" +
            "Password: <input type='password' name='password'><br><br>" +
            "<input type='submit' value='Login'>" +
            "</form>"
        );
    }
}

    

