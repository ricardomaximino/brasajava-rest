package com.brasajava.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class CapoeiraMusic implements Serializable{
	private static final long serialVersionUID = 2791131736262937044L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long capoeiraMusicId;
	private String name;
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<CapoeiraMusicPart> musicParts;
	@ElementCollection
	@CollectionTable(name="capoeira_music_tags")
	private List<String> tags;
	@ElementCollection
	@CollectionTable(name="capoeira_music_sequence")
	private List<Integer> musicPartSequence;
	private String author;
	private String observations;
	
	public long getCapoeiraMusicId() {
		return capoeiraMusicId;
	}
	public void setCapoeiraMusicId(long capoeiraMusicId) {
		this.capoeiraMusicId = capoeiraMusicId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<CapoeiraMusicPart> getMusicParts() {
		return musicParts;
	}
	public void setMusicParts(List<CapoeiraMusicPart> musicParts) {
		this.musicParts = musicParts;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public List<Integer> getMusicPartSequence() {
		return musicPartSequence;
	}
	public void setMusicPartSequence(List<Integer> musicPartSequence) {
		this.musicPartSequence = musicPartSequence;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
}
