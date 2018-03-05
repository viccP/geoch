package com.jlu.magmalab.page;

import java.util.List;

import org.jooq.Select;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PageHelper<T> {

	@Autowired
	private DefaultDSLContext dsl;

	public Page<T> get(int page, int rows, Select<?> sql, Class<T> clazz) {

		// 获取总数
		int total = dsl.fetchCount(sql);
		int totalPage = (int) Math.ceil(((double) total / (double) rows));

		// 添加分页节
		if (page > 0) {
			sql = dsl.select().from(sql).limit((page - 1) * rows, page * rows);
		}

		// 获取查询结果
		List<T> list = sql.fetchInto(clazz);

		// 构造分页信息
		Page<T> pageBean = new Page<T>();
		pageBean.setRows(list);
		pageBean.setPage(page);
		pageBean.setPageSize(rows);
		pageBean.setRecords(total);
		pageBean.setTotal(totalPage);

		return pageBean;

	}
}
