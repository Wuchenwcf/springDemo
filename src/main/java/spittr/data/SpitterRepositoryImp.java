package spittr.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import spittr.Spitter;

public class SpitterRepositoryImp implements SpitterRepository{
	

	List<Spitter> list;
	public SpitterRepositoryImp()
	{
		list=new ArrayList<Spitter>();
	}
	public void save(Spitter spitter) {
		// TODO Auto-generated method stub
		list.add(spitter);
		
	}
	public Spitter findByUserName(String userName) {
		// TODO Auto-generated method stub
		Spitter temp=null;
		System.out.println(list.size());
		System.out.println("username="+userName);
		for(Iterator<Spitter> it=list.iterator();it.hasNext(); )
		{
			temp=it.next();
		
			if(temp.getUserName().equals(userName))
			{
		
		      return temp;
			}
		}
		System.out.println(temp);
		
		return temp;
	}


}
