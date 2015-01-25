package at.compare.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import flexjson.JSONSerializer;

/**
 * This class is only an example of JsonClass to help 
 * writing the parser. If it already exists on the server
 * delete that class.
 * p.s. check if this class is the same as on the server.
 * I added the userName.
 * 
 * @author Manuel Kapferer
 *
 */

@Entity
@Table(name = "loggedroute")
public class LoggedRoute implements Serializable{
 	@Id
 	@GeneratedValue
	private Long id;
    
    private String userName; 
    private int duration;
    private int length;
    private String type;
    private double CO2;
    private double costs;
    private Date date;
    private int referencelength;
    private double referenceco2;
    private double referencecosts;
     
    public LoggedRoute() {
	}
    
    public LoggedRoute(String userName,int duration, int length, String type, double CO2, double costs, Date date,
            int referencelength, double referenceco2, double referencecosts){
    	this.userName = userName;
        this.duration = duration;
        this.length = length;
        this.type = type;
        this.CO2 = CO2;
        this.costs = costs;
        this.date = date;
        this.referencelength=referencelength;
        this.referenceco2=referenceco2;
        this.referencecosts=referencecosts;
    }
    
    
    
    public Long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getDuration() {
        return duration;
    }
 
    public void setDuration(int duration) {
        this.duration = duration;
    }
 
    public int getLength() {
        return length;
    }
 
    public void setLength(int length) {
        this.length = length;
    }
 
    public String getType() {
        return type;
    }
 
    public void setType(String type) {
        this.type = type;
    }

 
    public double getCO2() {
        return CO2;
    }
 
    public void setCO2(double cO2) {
        CO2 = cO2;
    }
 
    public double getCosts() {
        return costs;
    }
 
    public void setCosts(double costs) {
        this.costs = costs;
    }
 
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "duration="+duration+" distance="+length+" type="+type+" polyline=xxx text=xxx Co2="+CO2+" costs="+costs;
    }
 
    public Date getDate() {
        return date;
    }
 
    public void setDate(Date date) {
        this.date = date;
    }
 
    public int getReferencelength() {
        return referencelength;
    }
 
    public void setReferencelength(int referencelength) {
        this.referencelength = referencelength;
    }
 
    public double getReferenceco2() {
        return referenceco2;
    }
 
    public void setReferenceco2(double referenceco2) {
        this.referenceco2 = referenceco2;
    }
 
    public double getReferencecosts() {
        return referencecosts;
    }
 
    public void setReferencecosts(double referencecosts) {
        this.referencecosts = referencecosts;
    }
    public String toJson() {
		   return new JSONSerializer().exclude("*.class").serialize(this);
	}
}