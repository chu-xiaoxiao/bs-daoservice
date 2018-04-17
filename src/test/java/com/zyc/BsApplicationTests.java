package com.zyc;

import com.alibaba.druid.sql.PagerUtils;
import com.zyc.model.Example.PaperExample;
import com.zyc.model.Paper;
import com.zyc.model.Paperconfig;
import com.zyc.service.PaperService;
import com.zyc.util.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class BsApplicationTests {
	private MockMvc mockMvc;
	@Autowired
	private PaperService paperService;


	@Test
	public void contextLoads() throws Exception {
		/*System.out.println(mockMvc.perform(MockMvcRequestBuilders.get("/study/hello").accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string(Matchers.eq("1"))));*/
	}

	@Test
	public void testCreatePaper(){
		Paperconfig paperconfig = new Paperconfig();
		paperconfig.setMcqnum(5);
		paperconfig.setMcavalue(3.1);
		paperconfig.setScqnum(3);
		paperconfig.setScqvalue(5.2);
		paperconfig.setTfqnum(2);
		paperconfig.setTfqvalue(1.3);
		paperconfig.setPqnum(1);
		paperconfig.setPqvalue(20.9);
		Paper paper = paperService.createPaper(paperconfig,1);
		System.out.println(paper.getPaperid());
	}
}
