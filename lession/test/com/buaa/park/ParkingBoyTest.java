package com.buaa.park;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * @Author: Min Fu 
 * CreateDate: 2012-12-13
 * @version 1.0.0
 */
public class ParkingBoyTest {

	private ParkingBoy parkBoy;
	@Before
	public void init(){
		List<ParkPlace> list=new ArrayList<ParkPlace>();
		list.add(new ParkPlace(3));
		list.add(new ParkPlace(3));
		list.add(new ParkPlace(3));
		parkBoy=new ParkingBoy(list);
	}
	@Test
	public void test_getParkingRoleName(){
		Assert.assertEquals(ParkingBoy.PARKING_BOY_FLAG+parkBoy.getID(),parkBoy.getParkingRoleName());
	}
	
	@Test
	public void test_report(){
		Assert.assertNotNull(parkBoy.reportInfo());
		System.out.println(parkBoy.reportInfo());
	}
}
