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

	//注入service
	@Resource
	private CinemalService service;
	
	
	//列表展示
	@RequestMapping("list.do")
	public String list(Model model,String cname,@RequestParam(defaultValue="1") Integer pageNum){
		
		//创建map集合
		Map<String, Object> map = new HashMap<String, Object>();
		
		//将模糊值放入区间
		map.put("cname", cname);
		
		//使用分页工具类
		PageHelper page = new PageHelper();
		page.startPage(pageNum, 2);
		//调用业务层方法获取列表集合
		List<Cinemal> list = service.findAll(map);
		
		//获取分页信息
		PageInfo<Cinemal> info = new PageInfo<Cinemal>(list);
		
		//将分页信息放入model对象
		model.addAttribute("info", info);
		
		//返回list页面
		return "list";
	}
	
	//查询所有分类请求
	@RequestMapping("findTypeAll.do")
	@ResponseBody
	public List<Type> findTypeAll(){
		//获取电影分类集合
		List<Type> list = service.findTypeAll();
		//返回响应ajax
		return list;
	}
	
	//添加或者修改
	@RequestMapping("insertOrupdate.do")
	@ResponseBody
	public boolean insertOrupdate(Cinemal cin){
		//调用业务层方法
		boolean flag = service.insertOrupdate(cin);
		
		//返回响应Ajax
		return flag;
	}
	
	//根据cid查询电影信息
	@RequestMapping("findCinemalByCid.do")
	@ResponseBody
	public Map<String, Object> findCinemalByCid(Integer cid){
		//创建map集合
		Map<String, Object> map = new HashMap<String, Object>();
		//获取影视分类集合
		List<Type> list = service.findTypeAll();
		//获取查询到的影视信息
		Cinemal cin = service.findCinemalByCid(cid);
		
		//存入map集合
		map.put("list", list);
		map.put("cin", cin);
		
		//返回map集合，响应Ajax
		return map;
	}
	
	//批量删除
	@RequestMapping("deleteCinemal.do")
	@ResponseBody
	public boolean deleteCinemal(String ids){
		//将jsp页面传过来的数据已“，”进行分割
		String[] cid = ids.split(",");
		//将分割好的字符数组传入业务层方法
		service.deleteCinemal(cid);
		
		//返回true响应ajax
		return true;
	}
}
