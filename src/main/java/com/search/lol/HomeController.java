package com.search.lol;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import INFO.MatchInfoDtl;
import INFO.UserInfo;
import SERVICE.lolService;
import SERVICE.lolUserService;
import SERVICE.ServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	lolService ServiceImpl;
	
	@Autowired
	lolUserService UserServiceImpl;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		//Service service = new ServiceImpl();
		//int level =service.getUserInfo("plznodiee").getSummonerLevel();
		//service.getMatchInfo("plznodiee");
		//service.getMatchInfoDtl("plznodiee");
		
		//                             (getMatchInfoDtl메소드 리턴타입이 matchInfoDtl 여야함)
		//int totalDamageDealtToChampions =service.getMatchInfoDtl("plznodiee").getTotalDamageDealtToChampions();
		//model.addAttribute("totalDamageDealtToChampions", totalDamageDealtToChampions );
		
		//model.addAttribute("level", level );
		
		
		//List<MatchInfoDtl>pvpList = service.getMatchInfoDtl("plznodiee");
		//model.addAttribute("pvpList", pvpList );
		UserServiceImpl.print();
		
		return "home";
	}
	
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String Search(Locale locale, Model model,@RequestParam("nickname") String nickname) {
		
		List<MatchInfoDtl>pvpList = ServiceImpl.getMatchInfoDtl(nickname);
		//List<MatchInfoDtl>pvpList2 = service.getAllMatchInfoDtl(nickname);
		model.addAttribute("pvpList", pvpList );
		model.addAttribute("nickname", nickname );
		//model.addAttribute("pvpList2", pvpList2 );
		
		
		return "home";
	
	}
	@RequestMapping(value = "/searchDtl", method = RequestMethod.GET)
	public String SearchDtl(Locale locale, Model model,@RequestParam("nickname") String nickname,@RequestParam("matchNum") int matchNum) {
		
		//List<MatchInfoDtl>pvpList = service.getMatchInfoDtl(nickname);
		MatchInfoDtl pvpList2 = ServiceImpl.getAllMatchInfoDtl(nickname,matchNum);
		//model.addAttribute("pvpList", pvpList );
		model.addAttribute("pvpList2", pvpList2 );
		
		return "searchDtl";
		
	}


	
}

