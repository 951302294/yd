package com.bw.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.entity.Cin_Type;
import com.bw.entity.Cinemal;
import com.bw.entity.Type;
import com.bw.mapper.CinemalDao;

@Service
public class CinemalServiceImpl implements CinemalService {

	//注入dao
	@Resource
	private CinemalDao dao;

	public List<Cinemal> findAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.findAll(map);
	}

	public List<Type> findTypeAll() {
		// TODO Auto-generated method stub
		return dao.findTypeAll();
	}

	public boolean insertOrupdate(Cinemal cin) {
		//判断cid是否为空，如果为空执行添加，不为空执行修改
		if (cin.getCid() == null) {
			//对影视信息进行添加
			int num = dao.insertCinemal(cin);
			//添加返回主键，获取添加后的主键cid
			Integer cid = cin.getCid();
			//对jsp传过来的tid进行获取并且以“，”进行分割
			String[] split = cin.getTid().split(",");
			//循环分割好的字符字符串数组
			for (String tid : split) {
				//创建中间表对象
				Cin_Type ct = new Cin_Type(null, cid, Integer.parseInt(tid));
				//每循环一次对中间表添加一次数据
				dao.insertCin_Type(ct);
			}
			if (num>0) {
				return true;
			}
		}else{
			//修改影视信息
			int num = dao.updateCinemal(cin);
			//删除该影视所对应的中间表信息
			dao.deleteCin_TypeByCid(cin.getCid());
			//对jsp传过来的tid进行获取并且以“，”进行分割
			String[] split = cin.getTid().split(",");
			//循环分割好的字符字符串数组
			for (String tid : split) {
				//创建中间表对象
				Cin_Type ct = new Cin_Type(null, cin.getCid(), Integer.parseInt(tid));
				//重新添加中间表，每循环一次对中间表添加一次数据
				dao.insertCin_Type(ct);
			}
			System.out.println(num);
			if (num>0) {
				return true;
			}
		}
		return true;
	}

	public Cinemal findCinemalByCid(Integer cid) {
		// TODO Auto-generated method stub
		return dao.findCinemalByCid(cid);
	}

	public void deleteCinemal(String[] cid) {
		//先删除影视表的信息
		dao.deleteCinemal(cid);
		//再删除该影视对应的中间表的信息
		dao.deleteCin_Type(cid);
		
	}
	
}
