package com.ourteam.pcd.controllers;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/etudiant/*")
public class FiltreEtudiant implements Filter {
	private final String badRequest = "/badrequest";
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession();
        if(session.getAttribute("USER_TYPE").equals("ETUDIANT")) {
        	//  	System.out.println("ETUDIANT");
         	chain.doFilter(request, response);
        		
        }
        else {
        	//  	System.out.println("NOT ETUDIANT");
        	request.getRequestDispatcher(badRequest).forward(request, response);
        }
		
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
