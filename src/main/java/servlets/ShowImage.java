package servlets;

import Beans.Book;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class ShowImage extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");
        List<Book> books = (List<Book>) request.getSession().getAttribute("currentBooks");
        try(OutputStream out = response.getOutputStream()){
            int index = Integer.valueOf(request.getParameter("index"));
            Book book = books.get(index);
            response.setContentLength(book.getImage().length);
            out.write(book.getImage());
        }
    }

    public void destroy() {
    }
}