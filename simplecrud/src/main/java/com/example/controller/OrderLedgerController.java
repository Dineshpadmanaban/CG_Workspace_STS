package com.example.controller;

import java.util.List;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.OrderLedger;
import com.example.service.OrderLedgerService;

@RestController
@RequestMapping("/service/orderLedger")
public class OrderLedgerController {

	@Autowired
	OrderLedgerService orderLedgerService;

//creating a get mapping that retrieves all the orderLedgers detail from the database   
	@GetMapping("/get")
	private List<OrderLedger> getAllOrderLedger() {
		return orderLedgerService.getAllOrderLedger();
	}

//creating a get mapping that retrieves the detail of a specific orderLedger  
	@GetMapping("/get/{orderLedgerid}")
	private OrderLedger getOrderLedger(@PathVariable("orderLedgerno") int orderLedgerid) {
		return orderLedgerService.getOrderLedgerById(orderLedgerid);
	}

//creating a delete mapping that deletes a specified orderLedger  
	@DeleteMapping("/orderLedger/{orderLedgerno}")
	private void deleteOrderLedger(@PathVariable("orderLedgerno") int orderLedgerid) {
		orderLedgerService.delete(orderLedgerid);
	}

//creating post mapping that post the orderLedger detail in the database  
	@PostMapping("/add")
	private int saveOrderLedger(@RequestBody OrderLedger orderLedgers) {
		orderLedgerService.saveOrUpdate(orderLedgers);
		return orderLedgers.getOrderId();
	}

//creating put mapping that updates the orderLedger detail   
	@PutMapping("/update")
	private OrderLedger update(@RequestBody OrderLedger orderLedger) {
		orderLedgerService.saveOrUpdate(orderLedger);
		return orderLedger;
	}
	
	@SuppressWarnings("null")
	@PostMapping(path = "/order")
	public String order(@RequestBody OrderLedger orderLedger) throws Exception {
		JSONObject output = new JSONObject();
		try {
			List<OrderLedger> orderLedgers = orderLedgerService.getAllOrderLedger();
			List<OrderLedger> userOrderLedgers = null;
			for (OrderLedger orderLedger2 : orderLedgers) {
				if (orderLedger.getLoginId().equals(orderLedger2.getLoginId())) {
					userOrderLedgers.add(orderLedger2);
				}
			}
			int totalPurchase = 0;
			if (userOrderLedgers.isEmpty()) {
				orderLedgerService.saveOrUpdate(orderLedger);
			} else {
				for (OrderLedger order : userOrderLedgers) {
					totalPurchase = totalPurchase + order.getTotalPurchase();
				}
				int remainingAmount = 50000 - totalPurchase;
				if (orderLedger.getTotalPurchase() > remainingAmount) {
					output.put("ERROR", "Not Enough Remaining Balance");
				} else {
					orderLedgerService.saveOrUpdate(orderLedger);
					output.put("SUCCESS", "Order placed Successfully!");
				}
			}
		} catch (Exception e) {
			output.put("ERROR", "Error from Server: /orderLedger/order");
			return output.toString();
		}
		return output.toString();
	}
}
