package com.mobwink.percentoff;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mobwink.percentoff.model.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PercentOffApplicationTests {

	@Test
	public void contextLoads() {
		Product p = new Product();
		p.setId(1l);
		p.setTitle("Prod 1");
		p.setDescription("Descrição do produto 1");
		p.setBestPrice(new BigDecimal(22.5));
		p.setOldPrice(new BigDecimal(80));
		p.setUrl("http://mobwink.com/produto/1");
		
		System.out.println("Desconto de " + p.getDiscount() + " %");
		assertEquals(28.12f, p.getDiscount().floatValue(), 1);
	}

}
