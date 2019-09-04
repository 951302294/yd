package com.bw.service;

import java.util.List;
import java.util.Map;

import com.bw.entity.Cinemal;
import com.bw.entity.Type;

public interface CinemalService {

	public List<Cinemal> findAll(Map<String, Object> map);

	public List<Type> findTypeAll();

	public boolean insertOrupdate(Cinemal cin);

	public Cinemal findCinemalByCid(Integer cid);

	public void deleteCinemal(String[] cid);

}
