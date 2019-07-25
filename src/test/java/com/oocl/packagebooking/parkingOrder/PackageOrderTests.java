package com.oocl.packagebooking.parkingOrder;

import com.oocl.packagebooking.entity.PackageOrder;
import com.oocl.packagebooking.repository.PackageOrderRepository;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class PackageOrderTests {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private PackageOrderRepository packageOrderRepository;
	@Before
	public void befroe_test(){
		packageOrderRepository.deleteAll();
	}
	@Test
	public void should_add_an_package_order_when_post_a_package_order() throws Exception {
		//Given
		PackageOrder packageOrder = new PackageOrder("123","wang",13726);
		JSONObject packageOrderJsonObject = new JSONObject(packageOrder);
		//When
		final MvcResult mvcResult = this.mockMvc.perform(post("/package-orders").
				contentType(MediaType.APPLICATION_PROBLEM_JSON_UTF8).content(packageOrderJsonObject.toString())).andExpect(status().isCreated()).andReturn();
		List<PackageOrder> packageOrders = packageOrderRepository.findAll();
		//Then
		assertEquals(1,packageOrders.size());
	}
	@Test
	public void should_get_all_package_orders_when_get_all_orders_() throws Exception {
		//Given
		packageOrderRepository.save(new PackageOrder("123","wang",13726));
		packageOrderRepository.save(new PackageOrder("124","wang",13726));
		//When

		final MvcResult mvcResult = this.mockMvc.perform(get("/package-orders").
				contentType(MediaType.APPLICATION_PROBLEM_JSON_UTF8)).andExpect(status().isCreated()).andReturn();
		List<PackageOrder> packageOrders = packageOrderRepository.findAll();
		//Then
		assertEquals(124,packageOrders.get(1).getOrderID());
		assertEquals(123,packageOrders.get(0).getOrderID());
	}
}
