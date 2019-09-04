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

	//ע��dao
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
		//�ж�cid�Ƿ�Ϊ�գ����Ϊ��ִ����ӣ���Ϊ��ִ���޸�
		if (cin.getCid() == null) {
			//��Ӱ����Ϣ�������
			int num = dao.insertCinemal(cin);
			//��ӷ�����������ȡ��Ӻ������cid
			Integer cid = cin.getCid();
			//��jsp��������tid���л�ȡ�����ԡ��������зָ�
			String[] split = cin.getTid().split(",");
			//ѭ���ָ�õ��ַ��ַ�������
			for (String tid : split) {
				//�����м�����
				Cin_Type ct = new Cin_Type(null, cid, Integer.parseInt(tid));
				//ÿѭ��һ�ζ��м�����һ������
				dao.insertCin_Type(ct);
			}
			if (num>0) {
				return true;
			}
		}else{
			//�޸�Ӱ����Ϣ
			int num = dao.updateCinemal(cin);
			//ɾ����Ӱ������Ӧ���м����Ϣ
			dao.deleteCin_TypeByCid(cin.getCid());
			//��jsp��������tid���л�ȡ�����ԡ��������зָ�
			String[] split = cin.getTid().split(",");
			//ѭ���ָ�õ��ַ��ַ�������
			for (String tid : split) {
				//�����м�����
				Cin_Type ct = new Cin_Type(null, cin.getCid(), Integer.parseInt(tid));
				//��������м��ÿѭ��һ�ζ��м�����һ������
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
		//��ɾ��Ӱ�ӱ����Ϣ
		dao.deleteCinemal(cid);
		//��ɾ����Ӱ�Ӷ�Ӧ���м�����Ϣ
		dao.deleteCin_Type(cid);
		
	}
	
}
