package com.bw.mapper;

import java.util.List;
import java.util.Map;

import com.bw.entity.Cin_Type;
import com.bw.entity.Cinemal;
import com.bw.entity.Type;

public interface CinemalDao {

	public List<Cinemal> findAll(Map<String, Object> map);

	public List<Type> findTypeAll();

	public int insertCinemal(Cinemal cin);

	public int updateCinemal(Cinemal cin);

	public void insertCin_Type(Cin_Type ct);

	public Cinemal findCinemalByCid(Integer cid);

	public void deleteCin_TypeByCid(Integer cid);

	public void deleteCinemal(String[] cid);

	public void deleteCin_Type(String[] cid);

}
