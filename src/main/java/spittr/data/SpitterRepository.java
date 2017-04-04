package spittr.data;

import spittr.Spitter;

public interface SpitterRepository {

	public void save(Spitter spitter);
	Spitter findByUserName(String userName);
}
