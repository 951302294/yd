package com.bw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bw.entity.Cinemal;
import com.bw.entity.Type;
import com.bw.service.CinemalService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class CinemalController {

	//ע��service
	@Resource
	private CinemalService service;
	
	
	//�б�չʾ
	@RequestMapping("list.do")
	public String list(Model model,String cname,@RequestParam(defaultValue="1") Integer pageNum){
		
		//����map����
		Map<String, Object> map = new HashMap<String, Object>();
		
		//��ģ��ֵ��������
		map.put("cname", cname);
		
		//ʹ�÷�ҳ������
		PageHelper page = new PageHelper();
		page.startPage(pageNum, 2);
		//����ҵ��㷽����ȡ�б���
		List<Cinemal> list = service.findAll(map);
		
		//��ȡ��ҳ��Ϣ
		PageInfo<Cinemal> info = new PageInfo<Cinemal>(list);
		
		//����ҳ��Ϣ����model����
		model.addAttribute("info", info);
		
		//����listҳ��
		return "list";
	}
	
	//��ѯ���з�������
	@RequestMapping("findTypeAll.do")
	@ResponseBody
	public List<Type> findTypeAll(){
		//��ȡ��Ӱ���༯��
		List<Type> list = service.findTypeAll();
		//������Ӧajax
		return list;
	}
	
	//��ӻ����޸�
	@RequestMapping("insertOrupdate.do")
	@ResponseBody
	public boolean insertOrupdate(Cinemal cin){
		//����ҵ��㷽��
		boolean flag = service.insertOrupdate(cin);
		
		//������ӦAjax
		return flag;
	}
	
	//����cid��ѯ��Ӱ��Ϣ
	@RequestMapping("findCinemalByCid.do")
	@ResponseBody
	public Map<String, Object> findCinemalByCid(Integer cid){
		//����map����
		Map<String, Object> map = new HashMap<String, Object>();
		//��ȡӰ�ӷ��༯��
		List<Type> list = service.findTypeAll();
		//��ȡ��ѯ����Ӱ����Ϣ
		Cinemal cin = service.findCinemalByCid(cid);
		
		//����map����
		map.put("list", list);
		map.put("cin", cin);
		
		//����map���ϣ���ӦAjax
		return map;
	}
	
	//����ɾ��
	@RequestMapping("deleteCinemal.do")
	@ResponseBody
	public boolean deleteCinemal(String ids){
		//��jspҳ�洫�����������ѡ��������зָ�
		String[] cid = ids.split(",");
		//���ָ�õ��ַ����鴫��ҵ��㷽��
		service.deleteCinemal(cid);
		
		//����true��Ӧajax
		return true;
	}
}
