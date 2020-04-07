package org.zerock.mapper;

import org.apache.ibatis.annotations.Insert;

public interface Sample1Mapper {//tbl_sample1에 데이터 삽입

	@Insert("insert into tbl_sample1 (col1) values(#{data})")
	public int insertCol1(String data);
	
}
