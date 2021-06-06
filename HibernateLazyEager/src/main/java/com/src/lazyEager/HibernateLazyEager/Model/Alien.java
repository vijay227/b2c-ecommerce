package com.src.lazyEager.HibernateLazyEager.Model;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Alien 
{
	@Id
	private int aid;
	private String aname;
	
	@OneToMany(mappedBy = "alien",fetch=FetchType.EAGER)
	private Collection<Laptop> laps = new ArrayList<Laptop>();
	
	
	public Collection<Laptop> getLaps() {
		return laps;
	}
	public void setLaps(Collection<Laptop> laps) {
		this.laps = laps;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + " ]";
	}
	
			
}