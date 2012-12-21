package com.buaa.park;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.buaa.park.exception.NoCarException;
import com.buaa.park.exception.NoPlaceException;

/**
 * @Author: Min Fu 
 * CreateDate: 2012-12-13
 * @version 1.0.0
 */
public class ParkServiceTest {

	private ParkService parkPlaceListManager;
	
	@Before
	public void init(){
		List<ParkPlace> parkPlaceList=new ArrayList<ParkPlace>();
		parkPlaceList.add(new ParkPlace(10));
		parkPlaceList.add(new ParkPlace(11));
		parkPlaceList.add(new ParkPlace(12));
		parkPlaceList.add(new ParkPlace(13));
		parkPlaceListManager=new ParkService(parkPlaceList);
	}
	    @Test
	    public void parkPlace_GetCar(){
	        Car car = new Car();
	        Ticket proof =  parkPlaceListManager.parking(car) ;
	        Assert.assertSame(car,parkPlaceListManager.getParkedCar(proof));
	    }
	    @Test    ( expected = NoCarException.class)
	    public void parkPlace_GetCar_NoThisCar() {
	        Ticket proof =  parkPlaceListManager.parking( new Car()) ;
	        parkPlaceListManager.getParkedCar(proof);
	        parkPlaceListManager.getParkedCar(proof);
	    }
	    @Test
	    public void parkPlace_getAvailableNum_after_park()  {
	        parkPlaceListManager.parking( new Car()) ;
	        parkPlaceListManager.parking( new Car()) ;
	        Assert.assertEquals(Integer.valueOf(44),parkPlaceListManager.getAvailableNum());
	    }
	    @Test
	    public void parkPlace_getAvailableNum_after_park_full()  {
	    	for(int i=0;i<46;i++){
	    		 parkPlaceListManager.parking( new Car()) ;
	    	}
	        Assert.assertEquals(Integer.valueOf(0),parkPlaceListManager.getAvailableNum());
	    }
	    @Test
	    public void parkPlace_getAvailableNum(){
	    	Assert.assertEquals(Integer.valueOf(46),parkPlaceListManager.getAvailableNum());
	    }
	    @Test
	    public void parkPlace_getMaxParkingNum(){
	    	Assert.assertEquals(Integer.valueOf(46),parkPlaceListManager.getMaxParkingNum());
	    }
	    @Test
	    public void parkPlace_getMaxParkingNum_after_park(){
	    	parkPlaceListManager.parking( new Car()) ;
	        parkPlaceListManager.parking( new Car()) ;
	    	Assert.assertEquals(Integer.valueOf(46),parkPlaceListManager.getMaxParkingNum());
	    }
	    
	    @Test
	    public void parkPlace_getUsedParkPlaceCount(){
	    	Assert.assertEquals(Integer.valueOf(0),parkPlaceListManager.getUsedParkPlaceCount());
	    }
	    @Test
	    public void parkPlace_getUsedParkPlaceCount_after_park(){
	    	parkPlaceListManager.parking( new Car()) ;
	        parkPlaceListManager.parking( new Car()) ;
	        parkPlaceListManager.parking( new Car()) ;
	        parkPlaceListManager.parking( new Car()) ;
	    	Assert.assertEquals(Integer.valueOf(4),parkPlaceListManager.getUsedParkPlaceCount());
	    }
	    
	    @Test
	    public void parkPlace_getMaxAvailableParkPlace(){
	    	Assert.assertEquals(Integer.valueOf(13),parkPlaceListManager.getMaxAvailableParkPlace().getAvailableNum());
	    }
	    @Test
	    public void parkPlace_getMaxAvailableParkPlace_after_park_1(){
	    	parkPlaceListManager.parking( new Car()) ;
	    	Assert.assertEquals(Integer.valueOf(12),parkPlaceListManager.getMaxAvailableParkPlace().getAvailableNum());
	    }
	    @Test
	    public void parkPlace_getMaxAvailableParkPlace_after_park_2(){
	    	parkPlaceListManager.parking( new Car()) ;
	    	parkPlaceListManager.parking( new Car()) ;
	    	Assert.assertEquals(Integer.valueOf(12),parkPlaceListManager.getMaxAvailableParkPlace().getAvailableNum());
	    }
	    @Test
	    public void parkPlace_getMaxAvailableParkPlace_after_park_3(){
	    	parkPlaceListManager.parking( new Car()) ;
	    	parkPlaceListManager.parking( new Car()) ;
	    	parkPlaceListManager.parking( new Car()) ;
	    	Assert.assertEquals(Integer.valueOf(11),parkPlaceListManager.getMaxAvailableParkPlace().getAvailableNum());
	    }
	    @Test
	    public void parkPlace_getMaxAvailableParkPlace_after_park_4(){
	    	parkPlaceListManager.parking( new Car()) ;
	    	parkPlaceListManager.parking( new Car()) ;
	    	parkPlaceListManager.parking( new Car()) ;
	    	parkPlaceListManager.parking( new Car()) ;
	    	Assert.assertEquals(Integer.valueOf(11),parkPlaceListManager.getMaxAvailableParkPlace().getAvailableNum());
	    }
	    
	    @Test
		public void parkPlace_Parking_HavePlace() {
			Car car = new Car();
			Ticket proof = parkPlaceListManager.parking(car);
			Assert.assertNotNull(proof);
		}

		@Test(expected = NoPlaceException.class)
		public void parkPlace_Parking_NoPlace() {
			for(int i=0;i<=46;i++){
				parkPlaceListManager.parking(new Car());
			}
		}
}
