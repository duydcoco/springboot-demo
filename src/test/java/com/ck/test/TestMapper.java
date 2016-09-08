package com.ck.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ck.springbootdemo.modules.Application;
import com.ck.springbootdemo.modules.entity.Student;
import com.ck.springbootdemo.modules.mapper.StudentMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(Application.class)
public class TestMapper{

	@Autowired
	private StudentMapper studentMapper;
	
	@Test
	public void testInsert() throws Exception {
		for(int x = 2;x<=25;x++){
			Student student = new Student();
			char ch = (char) ((char)x+(char)65);
			student.setName(ch+"");
			student.setAge(x);
			student.setSocre(x);
			studentMapper.insert(student);
		}
	}
	@Test
	public void testPage() throws Exception {
		PageHelper.startPage(1,10);
		List<Student> list = studentMapper.selectAll();
		PageHelper.startPage(2,5);
		List<Student> list2 = studentMapper.selectAll();
		for (Student student : list2) {
			System.out.println(student.getId());
		}
		PageInfo pageInfo = new PageInfo<Student>(list);
		pageInfo.setNextPage(3);
		System.out.println(pageInfo.getList());
	}
}
