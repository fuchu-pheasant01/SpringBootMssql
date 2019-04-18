package com.mssql.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SyohinController {

	@Autowired
	SyohinDataEntityRepository repository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("title", "商品一覧");
		List<SyohinDataEntity> data = repository.findAll();
		model.addAttribute("data", data);
		return "sqlview";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String form(@RequestParam("find")String find, Model model) {
		model.addAttribute("title", "商品一覧(抽出)");
		model.addAttribute("value", find);
		List<SyohinDataEntity> data = repository.findByName(find);
		model.addAttribute("data", data);
		return "sqlview";
	}
}
