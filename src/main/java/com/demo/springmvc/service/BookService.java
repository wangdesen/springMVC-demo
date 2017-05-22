package com.demo.springmvc.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.demo.springmvc.dao.GenericDao;
import com.demo.springmvc.model.Book;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.AxisLine;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.SplitLine;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.code.X;
import com.github.abel533.echarts.code.Y;
import com.github.abel533.echarts.data.PieData;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.series.Pie;
import com.github.abel533.echarts.style.LineStyle;

@Service("bookService")
public class BookService extends GenericService<Book, Integer> {

	@Resource(name="bookDao")
	public void setGenericDao(GenericDao<Book, Integer> genericDao) {
		this.genericDao = genericDao;
	}
	
	public boolean AddBookUser(Book book){
		
		this.genericDao.save(book);	
		if (book.getId()==3) {
			throw new RuntimeException();
		}
		return true;
		//throw new RuntimeException();
	}
	
	public Option selectRemoveCauses() {
		
		 //EnhancedOption option = new EnhancedOption();
		
		//获取数据
		List<Book> list = this.genericDao.findAll();

		//创建Option对象
		Option option = new Option();

		//设置图表标题，并且居中显示
		option.title().text("最近7天访问量图表").x(X.center);

		//设置图例,居中底部显示，显示边框
		option.legend().data("访问量").x(X.center).y(Y.bottom).borderWidth(1);

		//设置y轴为值轴，并且不显示y轴，最大值设置400，最小值-100（OSC为什么要有-100呢？）
		option.yAxis(new ValueAxis().name("IP")
		        .axisLine(new AxisLine().show(true).lineStyle(new LineStyle().width(0)))
		        .max(400).min(-100));

		//创建类目轴，并且不显示竖着的分割线，onZero=false
		CategoryAxis categoryAxis = new CategoryAxis()
		        .splitLine(new SplitLine().show(false))
		        .axisLine(new AxisLine().onZero(false));

		//不显示表格边框，就是围着图标的方框
		option.grid().borderWidth(0);
		
		
		
		
		
		//创建Line数据
		Line line = new Line("访问量").smooth(true);

		//根据获取的数据赋值
		for (Book book : list) {
		    //增加类目，值为日期
		    categoryAxis.data(book.getName());

		    //日期对应的数据
		    line.data(book.getPrice());
		}

		//设置x轴为类目轴
		option.xAxis(categoryAxis);

		//设置数据
		option.series(line);
	    
	    return option;  
	}
	
}
