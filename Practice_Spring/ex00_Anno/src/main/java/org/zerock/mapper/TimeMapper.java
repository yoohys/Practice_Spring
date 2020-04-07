package org.zerock.mapper;
//Annotation방식: JavaConfig방식
import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	@Select("select sysdate from dual")
	public String getTime();
}
