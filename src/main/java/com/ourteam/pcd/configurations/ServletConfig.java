package com.ourteam.pcd.configurations;

import static org.ajar.swaggermvcui.SwaggerSpringMvcUi.WEB_JAR_RESOURCE_LOCATION;
import static org.ajar.swaggermvcui.SwaggerSpringMvcUi.WEB_JAR_RESOURCE_PATTERNS;
import static org.ajar.swaggermvcui.SwaggerSpringMvcUi.WEB_JAR_VIEW_RESOLVER_PREFIX;
import static org.ajar.swaggermvcui.SwaggerSpringMvcUi.WEB_JAR_VIEW_RESOLVER_SUFFIX;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

@Configuration
@EnableWebMvc
@EnableSwagger
@ComponentScan("com.ourteam.pcd.controllers")
public class ServletConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private SpringSwaggerConfig springSwaggerConfig;

	@Autowired
	Environment env;

	@Bean
	public SwaggerSpringMvcPlugin customImplementation() {

		SwaggerSpringMvcPlugin swaggerSpringMvcPlugin = new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
				.apiInfo(apiInfo()).includePatterns(".*");

		return swaggerSpringMvcPlugin;
	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo(env.getProperty("swagger.title"), env.getProperty("swagger.description"),
				env.getProperty("swagger.termsOfServiceUrl"), env.getProperty("swagger.contact"),
				env.getProperty("swagger.license"), env.getProperty("swagger.licenseUrl"));

		return apiInfo;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");

		registry.addResourceHandler(WEB_JAR_RESOURCE_PATTERNS).addResourceLocations(WEB_JAR_RESOURCE_LOCATION)
				.setCachePeriod(0);
	}

	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix(WEB_JAR_VIEW_RESOLVER_PREFIX);
		resolver.setSuffix(WEB_JAR_VIEW_RESOLVER_SUFFIX);
		return resolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}
