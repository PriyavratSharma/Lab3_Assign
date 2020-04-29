package com.cg.gla.controller;
import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.gla.model.Product;
@RestController
public class ProductController {
public static Map<String,Product> pdata=new LinkedHashMap();

static
{
	Product p1=new Product();
	p1.setId("pr1");p1.setName("Laptop");p1.setPrice(45000);pdata.put(p1.getId(),p1);
	Product p2=new Product();
	p2.setId("pr2");p2.setName("Mobile");p2.setPrice(10000);pdata.put(p2.getId(),p2);
	Product p3=new Product();
	p3.setId("pr3");p3.setName("IPhone");p3.setPrice(80000);pdata.put(p3.getId(),p3);
	Product p4=new Product();
	p4.setId("pr4");p4.setName("KeyBoard");p4.setPrice(3500);pdata.put(p4.getId(),p4);
}
@RequestMapping(value="/products",method=RequestMethod.GET)
public ResponseEntity<Object> gets()
{
	return new ResponseEntity<>(pdata.values(),HttpStatus.OK);
}
@RequestMapping(value="/products",method=RequestMethod.POST)
public ResponseEntity<Object> insert(@RequestBody Product p)
{
	pdata.put(p.getId(),p);
	return new ResponseEntity<>("Product is Created SuccessFully",HttpStatus.OK);
}
}
