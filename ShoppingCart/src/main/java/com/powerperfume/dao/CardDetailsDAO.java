package com.powerperfume.dao;

import java.util.List;

import com.powerperfume.model.CardDetails;

public interface CardDetailsDAO {
	
	public List<CardDetails> list(int sortOrder);
	
	public CardDetails get(int id);
	
	public boolean save(CardDetails cardDetails);
	
	public boolean update(CardDetails cardDetails);
	
	public boolean delete(int id);
	

}
