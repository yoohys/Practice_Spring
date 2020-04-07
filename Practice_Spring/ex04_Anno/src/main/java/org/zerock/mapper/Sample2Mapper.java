package org.zerock.mapper;

import org.apache.ibatis.annotations.Insert;

public interface Sample2Mapper {//tbl_sample2에 데이터 삽입

	@Insert("insert into tbl_sample2 (col2) values(#{data})")
	public int insertCol2(String data);
	
}
