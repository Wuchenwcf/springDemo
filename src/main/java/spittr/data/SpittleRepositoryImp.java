package spittr.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import spittr.Spittle.Spittle;

public class SpittleRepositoryImp implements SpittleRepository{


	public List<Spittle> findSpittles(long max, int count) {
		// TODO Auto-generated method stub
		List<Spittle> list=new ArrayList<Spittle>();
		for(int i=0;i<count;i++)
			list.add(new Spittle("spittle"+i,new Date()));
		return list;
	}
	

}
