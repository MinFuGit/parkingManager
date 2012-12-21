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
    	return "ͣ�������:"+this.parkNO+"\n\t��λ��:"+this.maxParkingNum+"\n\t��λ��:"+this.getAvailableNum();
    }
    /**
     * ��ȡͣ������ǰ���õ�ͣ��λ������
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
     * @param maxParkingNum ��СֵΪ2�����ȡֵС�ڵ���2�ͻᱻ���ó�2
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
    		 throw new NoCarException("������Ϊ��");
    	}
    	if(getAvailableNum()<=0){
    		 throw new NoPlaceException("û��ͣ��λ��");
    	}
    	Ticket t=new Ticket();
    	parkedCarList.put(t, c);
    	return t;
    }
    public Car getParkedCar(Ticket pp) throws NoCarException {
        if (parkedCarList.containsKey(pp)) {
            return parkedCarList.remove(pp);
        }
        throw new NoCarException("û�д˳� �벦��110��");
    }
    /**
     * ��ȡͣ��֤��ͣ������Ϣ�Ķ�Ӧ��ϵ ����
     * @return
     */
    public Map<Ticket, Car> getParkedCarList(){
    	return this.parkedCarList;
    }
}
