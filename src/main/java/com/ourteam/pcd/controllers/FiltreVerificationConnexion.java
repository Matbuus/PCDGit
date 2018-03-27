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

// Filtre pour verifier que le client est connecté pour qu'il puisse acceder aux services

@WebFilter("/*")
public class FiltreVerificationConnexion implements Filter {
	private final String lienConnexion = "/connexion";
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
        
        // Si cet attibut est nul, cela signifie que la connexion n'a pas encore eu lieu
        
        if(session.getAttribute("Compte") == null) {
        		// forwarding vers la page de connexion
        		request.getRequestDispatcher(lienConnexion).forward(request, response);
        }
        else {
        	
        	// La connexion a eu lieu -> chainage des filtres 
        	
      //  	System.out.println("VOUS ETES CONNECTE, "+session.getAttribute("USER_NAME"));
        	chain.doFilter(request, response);
        }
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
