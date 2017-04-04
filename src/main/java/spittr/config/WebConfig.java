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
//����Mvc
@EnableWebMvc
//�������ɨ��
@ComponentScan("spittr.web")
public class WebConfig extends WebMvcConfigurerAdapter {
	
	//����JSP��ͼ������
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
	//���þ�̬��Դ�Ĵ���
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
	{
		configurer.enable();
	}

}
