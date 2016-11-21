/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.mongodb.MongoClient;
import dao.PublicPostDAO;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PublicDiscussion;

/**
 *
 * @author BHAVESH GOYAL
 */
public class ActionPublicDetailView implements Action {
    private String viewPage = "PublicDetailedDiscussion.jsp";
String post_id;
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
      //          PublicDiscussion pb = new PublicDiscussion();
          post_id=request.getParameter("postid");
        
                MongoClient mongo = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");

                PublicPostDAO publicPostDao = new PublicPostDAO(mongo);
               
              //  System.out.println("Publicpost action id=" + pb.getPostId());
                  ArrayList<PublicDiscussion> arpb = new ArrayList<PublicDiscussion>();
                PublicDiscussion pb=null;
                  pb=publicPostDao.showDetailPost(post_id);
                request.setAttribute("pb",pb);
            
            
            

             
            
       
        return viewPage;
    }

    
}