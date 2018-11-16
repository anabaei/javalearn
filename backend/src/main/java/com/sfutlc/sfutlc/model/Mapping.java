package com.sfutlc.sfutlc.model;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class Mapping {
	
	private BigInteger mapID;
	private String assignment;
	private String title;
	private int creationDate;
	private int lastEditedDate;
	private String theisBlue;
	private String theisYellow;
	private String conclusion;
	public BigInteger getMapID() {
		return mapID;
	}

	public void setMapID(BigInteger mapID) {
		this.mapID = mapID;
	}

	public String getAssignment() {
		return assignment;
	}

	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(int i) {
		this.creationDate = i;
	}

	public int getLastEditedDate() {
		return lastEditedDate;
	}

	public void setLastEditedDate(int i) {
		this.lastEditedDate = i;
	}

	public String getTheisBlue() {
		return theisBlue;
	}

	public void setTheisBlue(String theisBlue) {
		this.theisBlue = theisBlue;
	}

	public String getTheisYellow() {
		return theisYellow;
	}

	public void setTheisYellow(String theisYellow) {
		this.theisYellow = theisYellow;
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public List<Map<String, Object>> getReasons() {
		return reasons;
	}

	public void setReasons(List<Map<String, Object>> reasons) {
		this.reasons = reasons;
	}

	public List<Map<String, Object>> getEvidences() {
		return evidences;
	}

	public void setEvidences(List<Map<String, Object>> evidences) {
		this.evidences = evidences;
	}

	private List<Map<String, Object>> reasons;
	private List<Map<String, Object>> evidences;
	
	public Mapping() {
		
	}

}
