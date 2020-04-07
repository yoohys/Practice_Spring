package com.practice.board.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
//파라미터가 없는 기본생성자를 추가하는 어노테이션
@Getter
@Entity
@Table(name = "board")
public class BoardEntity extends TimeEntity {
    @Id
    @SequenceGenerator(
            name = "USER_SEQ_GEN", //시퀀스 제너레이터 이름
            sequenceName = "SQ_CINDY", //시퀀스 이름
            initialValue = 1, //시작값
            allocationSize = 1 //메모리를 통해 할당할 범위 사이즈
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ_GEN")
//  기본키로 대체키를 사용할 때, 기본키 값 생성 전략을 명시
    private Long id;

    @Column(length = 10, nullable = false)
    private String writer;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Builder
//  빌더패턴 클래스를 생성
    public BoardEntity(Long id, String title, String content, String writer) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;

    }
}
