package com.Library.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Library.Model.Library;
import com.Library.service.Libservice;

public class CreLibServ extends HttpServlet{
	protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		System.out.println("hi");
		String name=req.getParameter("name");
		String author=req.getParameter("author");
		int price=Integer.parseInt(req.getParameter("price"));
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		Library abc=new Library();
		abc.setName(name);
		abc.setAuthor(author);
		abc.setPrice(price);
		abc.setQuantity(quantity);
		Libservice ls=new Libservice();
		String r=ls.createLib(abc);
		req.setAttribute("rrr", r);
		req.getRequestDispatcher("createres.jsp").forward(req, res);
	}

}
