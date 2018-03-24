package com.ourteam.pcd;

import java.util.Locale;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class Test {

	@RequestMapping(value = "/malek", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("Malek");
		return "home";
	}
}
