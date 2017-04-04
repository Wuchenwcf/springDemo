package spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import spittr.data.SpitterRepository;
import spittr.data.SpitterRepositoryImp;
import spittr.data.SpittleRepository;
import spittr.data.SpittleRepositoryImp;

@Configuration
//启用Mvc
@EnableWebMvc
//启用组件扫描
@ComponentScan("spittr.web")
public class WebConfig extends WebMvcConfigurerAdapter {
	
	//配置JSP视图解析器
	@Bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}
	
	@Bean
	public SpittleRepository sp()
	{
		return new SpittleRepositoryImp();
	}
	
	@Bean
	public SpitterRepository spitterr()
	{
		return new SpitterRepositoryImp();
	}
	//配置静态资源的处理
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
	{
		configurer.enable();
	}

}
