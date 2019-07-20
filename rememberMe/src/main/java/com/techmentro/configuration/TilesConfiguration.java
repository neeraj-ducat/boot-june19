package com.techmentro.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
public class TilesConfiguration {

	@Bean
	public TilesViewResolver tilesViewResolver()
	{
		TilesViewResolver viewResolver=new TilesViewResolver();
		viewResolver.setViewClass(TilesView.class);
		return viewResolver;
		
	}
	
	@Bean
	public TilesConfigurer tilesConfigurer()
	{
		TilesConfigurer configurer=new TilesConfigurer();
		configurer.setDefinitions(
				new String[]{"/WEB-INF/tiles.xml"});
		return configurer;
		
	}
}
