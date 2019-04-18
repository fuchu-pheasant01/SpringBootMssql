package com.mssql.web;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMssqlApplication {

	@Autowired
	SyohinDataEntityRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMssqlApplication.class, args);
	}

	@PostConstruct
	public void initialData() {
		repository.save(new SyohinDataEntity((short) 7500, "ｾﾄｳﾁﾚﾓﾝ", BigDecimal.valueOf(20190417),
				BigDecimal.valueOf(203145), "瀬戸内レモンです"));
		repository.save(new SyohinDataEntity((short) 2840, "ﾘﾝｺﾞｼﾞｭｰｽ", BigDecimal.valueOf(20050923),
				BigDecimal.valueOf(102532), "果汁100%の炭酸飲料です"));
		repository.save(new SyohinDataEntity((short) 1580, "ｶﾌｪｵﾚ", BigDecimal.valueOf(20160716),
				BigDecimal.valueOf(91103), "200ml増量です"));
		repository.save(new SyohinDataEntity((short) 270, "ｳﾒｵﾆｷﾞﾘ", BigDecimal.valueOf(20080825),
				BigDecimal.valueOf(141520), "none"));
		repository.flush();
	}
}
