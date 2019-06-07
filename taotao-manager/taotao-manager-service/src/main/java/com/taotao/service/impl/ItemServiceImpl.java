package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
@Service
public class ItemServiceImpl  implements ItemService{
	@Autowired
	private TbItemMapper itemMapper;

	public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
		if(page==null)page=1;
		if(rows==null)rows=30;
		
		PageHelper.startPage(page,rows);
		//注入mapper对象
		TbItemExample example=new TbItemExample();
		
		//调用查询方法
		List<TbItem> list = itemMapper.selectByExample(example);
		//得到list集合
		EasyUIDataGridResult eugr=new EasyUIDataGridResult();
		//得到总量
		PageInfo<TbItem> info =new PageInfo<>(list);
		eugr.setRows(list);
		eugr.setTotal((int)info.getTotal());
		return eugr;
	}

	
}
