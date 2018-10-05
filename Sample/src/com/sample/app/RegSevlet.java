package com.sample.app;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.dao.RegDAOImpl;

public class RegSevlet extends HttpServlet{
	
	
	public void doGet(HttpServletRequest req,HttpServletResponse resp){
		performTask(req,resp);
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse resp){
		performTask(req,resp);
	}
	
	
	public void performTask(HttpServletRequest req,HttpServletResponse resp){

		RegBean bean = new RegBean();
		
		bean.setUserName(req.getParameter("userName"));
		bean.setUserAge(Integer.parseInt(req.getParameter("userAge")));
		bean.setUserGender(req.getParameter("userGender"));
		bean.setUserEmail(req.getParameter("userEmail"));
		bean.setUserAddr(req.getParameter("userAddr"));
		bean.setInsertType(req.getParameter("insertType"));
		
		RegDAOImpl daoObj = new RegDAOImpl();
		
		int status = daoObj.saveUserDetails(bean);
		
		RequestDispatcher rd=req.getRequestDispatcher("/jsp/successPage.jsp");
		try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
