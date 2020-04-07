package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
   //Annotation방식
	@Select("select sysdate from dual")
	public String getTime();
	
	//99
	public String getTime2();//그냥
}
