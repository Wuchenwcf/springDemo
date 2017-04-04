package spittr.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.test.web.servlet.MockMvc;

import spittr.Spittle.Spittle;
import spittr.data.SpittleRepository;
import spittr.web.HomeController;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;
import org.junit.Test;
import org.mockito.Mockito;

public class HomeContollerTest {

	@Test
	public void testHomePage() throws Exception
	{
		HomeController controller=new HomeController();
		MockMvc mockMvc=MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.view().name("home"));
		
	}
	
	@Test
	public void shouldShowRecentSpittles() throws Exception
	{
		List<Spittle> expectedSpittes=createSpittleList(20);
		//此处需要在pom.xml中添加Mockito依赖
		SpittleRepository mockRepository=Mockito.mock(SpittleRepository.class);
		Mockito.when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittes);
		
		SpittleController controller=new SpittleController(mockRepository);
		MockMvc mockmvc=MockMvcBuilders.standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
		
		mockmvc.perform(MockMvcRequestBuilders.get("/spittles"))
		.andExpect(MockMvcResultMatchers.view().name("spittles"))
    	.andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"));
		//.andExpect(MockMvcResultMatchers.model().attribute("spittleList", IsCollectionContaining.hasItem(expectedSpittes.toArray())));
		
	}

	private List<Spittle> createSpittleList(int n) {
		// TODO Auto-generated method stub
		List<Spittle> list=new ArrayList<Spittle>();
		for(int i=0;i<n;i++)
			list.add(new Spittle("spittle"+i,new Date()));
		return list;
	}
	
/*
	@Test
	public void shouldShowRegistration() throws Exception
	{
		SpitterController controller=new SpitterController();
		MockMvc mockMvc=MockMvcBuilders.standaloneSetup(controller).build();
		
		mockMvc.perform(MockMvcRequestBuilders.get("/spitter/register")).andExpect(MockMvcResultMatchers.view().name("registerForm"));
	}
	*/
}
