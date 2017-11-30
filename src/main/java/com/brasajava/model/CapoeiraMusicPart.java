package com.brasajava.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CapoeiraMusicPart implements Serializable{
	private static final long serialVersionUID = 4227478113934878480L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long capoeiraMusicPartId;
	private String musicPart;
	
	public long getCapoeiraMusicPartId() {
		return capoeiraMusicPartId;
	}
	public void setCapoeiraMusicPartId(long capoeiraMusicPartId) {
		this.capoeiraMusicPartId = capoeiraMusicPartId;
	}
	public String getMusicPart() {
		return musicPart;
	}
	public void setMusicPart(String musicPart) {
		this.musicPart = musicPart;
	}	

}
