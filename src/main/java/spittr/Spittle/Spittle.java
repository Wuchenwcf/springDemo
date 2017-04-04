package spittr.Spittle;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Spittle {
	private final Long id;
	private final String message;
	private final Date time;
	private Double latitude;
	private Double longitude;
	public Spittle(String message ,Date time,Double longitude,Double latitude)
	{
		this.id=null;
		this.message=message;
		this.time=time;
		this.setLongitude(longitude);
		this.latitude=latitude;
		this.longitude=null;
	}
	


	public Spittle(String string, Date date) {

		this(string,date,null,null);
	}



	public long getId()
	{
		return this.id;
	}
	
	public String getMessage()
	{
		return this.message;
	}
	
	public Double getLongitude()
	{
		return this.latitude;
	}
	
	public Double getLatitude()
	{
		return this.latitude;
	}
	
	public boolean equals(Spittle That)
	{
		//应用此处代码需要comment-lang依赖
		//return EqualsBuilder.reflectionEquals(this,That);
		return this.message==That.message;
	}
	public int hashCode()
	{
		return HashCodeBuilder.reflectionHashCode(this);
	}



	public Date getTime() {
		return time;
	}



	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

}
