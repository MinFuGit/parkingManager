package com.buaa.park;

import java.util.HashMap;
import java.util.Map;

import com.buaa.park.exception.NoCarException;
import com.buaa.park.exception.NoPlaceException;

/**
 * @Author: Min Fu 
 * CreateDate: 2012-12-13
 * @version 1.0.0
 */
public class ParkPlace {
	private static int PARK_ID=0;
    private Map<Ticket, Car> parkedCarList = new HashMap<Ticket, Car>();
    private Integer maxParkingNum;
    private Integer parkNO;
    public String toString(){
    	return "停车场编号:"+this.parkNO+"\n\t车位数:"+this.maxParkingNum+"\n\t空位数:"+this.getAvailableNum();
    }
    /**
     * 获取停车场当前可用的停车位的总数
     * @return
     */
    public Integer getAvailableNum() {
        return maxParkingNum - parkedCarList.size();
    }
    /**
     * 
     * @return
     */
    public Integer getMaxParkingNum(){
    	return this.maxParkingNum;
    }
    /**
     * 
     * @param maxParkingNum 最小值为2，如果取值小于等于2就会被设置成2
     */
    public ParkPlace(int maxParkingNum) {
    	if(maxParkingNum<=2){
    		 this.maxParkingNum = 2;
    	}else{
    		 this.maxParkingNum = maxParkingNum;
    	}
        this.parkNO=(++PARK_ID);
    }
    public Integer getParkNO(){
    	return this.parkNO;
    }
    @Override
    public int hashCode(){
    	return parkNO.hashCode();
    }
    public Ticket parking(Car c)throws NoCarException,NoPlaceException{
    	if(c==null){
    		 throw new NoCarException("车不能为空");
    	}
    	if(getAvailableNum()<=0){
    		 throw new NoPlaceException("没有停车位子");
    	}
    	Ticket t=new Ticket();
    	parkedCarList.put(t, c);
    	return t;
    }
    public Car getParkedCar(Ticket pp) throws NoCarException {
        if (parkedCarList.containsKey(pp)) {
            return parkedCarList.remove(pp);
        }
        throw new NoCarException("没有此车 请拨打110！");
    }
    /**
     * 获取停车证和停车的信息的对应关系 集合
     * @return
     */
    public Map<Ticket, Car> getParkedCarList(){
    	return this.parkedCarList;
    }
}
