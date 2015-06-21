/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krishna.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sony
 */
public class BookServiceImpl implements BookService{

    public List<String> getBook(String book, String bookId, String authorName) {
        /**
         * create instance of arraylist
         */
        List<String> listOfBooks = new ArrayList<String>();
            
            if("takeBook".equals(book)&& "r2020".equals(bookId) && "cb".equals(authorName)) {
            
            listOfBooks.add(" Revolution 2020 chethan ");
        } else if("takeBook".equals(book) && "2States".equals(bookId) && "cb".equals(authorName)) {
            
            listOfBooks.add("2 States Chethan");
        } else if("takeBook".equals(book)&&"skull".equals(bookId) && "kr".equals(authorName)) { 
            listOfBooks.add("Skull Krishna");
        }
            else {
            listOfBooks.add(" Wrong!! Try next time");
        }
    
        
        return listOfBooks;
    }

//    public List<String> getBookId(String id) {
//        
//        List<String> listOfBookIds = new ArrayList<String>();
//     
//        if("book_id".equals(id)) {
//            listOfBookIds.add("0001");
//            
//        }else  {
//            listOfBookIds.add("0002");
//        }
//        return listOfBookIds;
//        
//    }
//
//    @Override
//    public List<String> getAuthorNmae(String authorName) {
//      
//        List<String> listOfAuthorName = new ArrayList<String>();
//        
//        if("book_id".equals(authorName)) {
//            listOfAuthorName.add("abcd");
//            
//        }else  {
//            listOfAuthorName.add("efgh+");
//        }
//            
//        
//        return listOfAuthorName;
//     
//    }
    }

    


