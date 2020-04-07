package com.practice.board.domain.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
// 테이블로 매핑하지 않고, 자식 클래스(Entity)에게 매핑정보를 상속하기 위한 어노테이션
@EntityListeners(AuditingEntityListener.class)
// JPA에게 해당 Entity는 Auditing 기능을 사용한다는 것을 알리는 어노테이션
public abstract class TimeEntity {
    @CreatedDate
//  Entity가 처음 저장될때 생성일을 주입하는 어노테이션
    @Column(updatable = false)
//  생성일은 update할 필요없으므로, 이것도 추가
    private LocalDateTime createdDate;

    @LastModifiedDate
//  수정될때 수정일자를 입력해주는 어노테이션
    private LocalDateTime modifiedDate;

}
