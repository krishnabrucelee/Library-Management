/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krishna.web;

import com.krishna.model.BookService;
import com.krishna.model.BookServiceImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sony
 */
public class ServletController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        /**
         * get the bookName from Student
         */
        String book = req.getParameter("book");
        String bookId = req.getParameter("book_id");
        String authorName = req.getParameter("author_name");

        /**
         * Model Object which has business logic which can be reusable
         */
        BookService bookService = new BookServiceImpl();

        /**
         * get the list of books names
         */
        List<String> listOfBooks = bookService.getBook(book, bookId, authorName);
        
//        List<String> listOfBookIds = bookService.getBookId(bookId);
//
//        List<String> listOfAuthorName = bookService.getAuthorNmae(authorName);

        /**
         * set the book to request
         */
        req.setAttribute("bookService", listOfBooks);
      //  req.setAttribute(n, book);
//        req.setAttribute("bookService", listOfBookIds);
//        req.setAttribute("bookService", listOfAuthorName);

        /**
         * get the requestDispatcher and forward the request/response to
         * appropriate JSP page
         */
        RequestDispatcher rd = req.getRequestDispatcher("return.jsp");

        rd.forward(req, resp);
    }
}
