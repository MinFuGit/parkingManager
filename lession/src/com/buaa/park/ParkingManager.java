package com.buaa.park;

import java.util.HashSet;
import java.util.List;

import com.buaa.park.exception.NoParkingBoyInControle;
import com.buaa.park.exception.NoPlaceException;

/**
 * @Author: Min Fu 
 * CreateDate: 2012-12-13
 * @version 1.0.0
 */
public class ParkingManager extends ParkService{
	private static int ManagerID=0;
	private int id;
	private HashSet<ParkingBoy> parkingBoys;
	public ParkingManager(List<ParkPlace> parkPlaceList,HashSet<ParkingBoy> parkingBoys) {
		super(parkPlaceList);
		this.parkingBoys=parkingBoys;
		id=(++ManagerID);
	}
	/**
	 * ��Ŀ�����ƶ�ͣ����ȥͣ��
	 * @param parkBoy
	 * @param c
	 * @return
	 * @throws NoPlaceException
	 * @throws NoParkingBoyInControle
	 */
	public Ticket parking(ParkingBoy parkBoy,Car c) throws NoPlaceException,NoParkingBoyInControle {
		if(parkingBoys.contains(parkBoy)){
			return parkBoy.parking(c);
		}else{
			throw new NoParkingBoyInControle("��Ŀ����û�й����ͣ���С�");
		}
	}
	public String getParkingRoleName() {
		return "ParkingManager_"+this.id;
	}
	public HashSet<ParkingBoy> getParkingBoys(){
		return this.parkingBoys;
	}
	public String reportInfo(){
		StringBuilder sb=new StringBuilder("");
		sb.append("��Ŀ������:"+getParkingRoleName()+"\t��λ������"+getMaxParkingNum()+"\t��λ����"+getAvailableNum()+"\n");
		sb.append(super.reportInfo()+"\n");
//		sb.append("\n+++++\n");
		for(ParkingBoy parkBoy:parkingBoys){
			sb.append(parkBoy.reportInfo());
		}
//		sb.append("\n+++++\n");
//		sb.append("------ParkingManager���� end---------------\n");
		return sb.toString();
	}
}
