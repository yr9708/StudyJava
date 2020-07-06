DROP SEQUENCE BOARDNOSEQ;
DROP SEQUENCE GROUPNOSEQ;

CREATE SEQUENCE BOARDNOSEQ;
CREATE SEQUENCE GROUPNOSEQ;
DROP TABLE ANSWERBOARD;

--글번호 그룹번호 그룹순서 제목탭(공백칸) 제목 내용 작성자 작성일
CREATE TABLE ANSWERBOARD(
	BOARDNO NUMBER PRIMARY KEY,
	GROUPNO NUMBER NOT NULL,
	GROUPSEQ NUMBER NOT NULL,
	TITLETAB NUMBER NOT NULL,
	TITLE VARCHAR2(1000) NOT NULL,
	CONTENT VARCHAR2(4000) NOT NULL,
	WRITER VARCHAR2(500) NOT NULL,
	REGDATE DATE NOT NULL
);

SELECT BOARDNO, GROUPNO, GROUPSEQ, TITLETAB,
      TITLE, CONTENT, WRITER, REGDATE
FROM ANSWERBOARD
ORDER BY GROUPNO DESC, GROUPSEQ;
-- GROUPNO : DESC (내림차순),  GROUPSEQ : SEC (오름차순)

--1번 글 작성
INSERT INTO ANSWERBOARD 
VALUES (BOARDNOSEQ.NEXTVAL, GROUPNOSEQ.NEXTVAL, 1, 0, '첫번째 글 입니다','첫번째 내용 입니다', '관리자', SYSDATE);

INSERT INTO ANSWERBOARD 
VALUES (BOARDNOSEQ.NEXTVAL, GROUPNOSEQ.NEXTVAL, 1, 0, '두번째 글 입니다.','두번째 내용 입니다','아무나', SYSDATE);

--1번 글에 답변글 작성
-- 부모의 글과 같은 그룹에서 부모의 순서 다음순서에 있는 글들을 찾아서 순서+1 먼저 해줘야 한다.
UPDATE ANSWERBOARD
SET GROUPSEQ = GROUPSEQ +1
WHERE GROUPNO = (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO =1)
AND GROUPSEQ > (SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO =1);

-- 답변글 추가 ( 부모의 글과 같은 그룹, 부모의 순서 +1, 부모의 제목 공백 +1 )
INSERT INTO ANSWERBOARD
VALUES (BOARDNOSEQ.NEXTVAL, 
		(SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = 1),
		(SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO = 1) +1 ,
		(SELECT TITLETAB +1 FROM ANSWERBOARD WHERE BOARDNO = 1),
		'ㄴRE:첫번째 글 입니다.',
		'답변글 어렵다.',
		'홍길동',
		SYSDATE
);



-- 답변글 (3번글)에 답변 달자
-- UPDATE (부모와 같은 그룹, 부모 순서 +1)인 글들의 순서를 +1 하자
UPDATE ANSWERBOARD
SET GROUPSEQ = GROUPSEQ +1 
WHERE GROUPNO = (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = 3)
AND GROUPSEQ > (SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO = 3);

-- INSERT : 부모와 같은 그룹, 부모 순서 +1, 부모 제목 공백 +1
INSERT INTO ANSWERBOARD
VALUES (BOARDNOSEQ.NEXTVAL,
		(SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = 3 ),
		(SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO = 3 ) +1,
		(SELECT TITLETAB + 1 FROM ANSWERBOARD WHERE BOARDNO = 3 ),
		'ㄴRE:두번째 글 입니다',
		'ㅎㅎㅎㅎㅎ',
		'강여림',
		SYSDATE
);


-- 첫번째 글에 ㄴ RE 달기
UPDATE ANSWERBOARD
SET GROUPSEQ = GROUPSEQ +1
WHERE GROUPNO = (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = 1)
AND GROUPSEQ > (SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO = 1);

INSERT INTO ANSWERBOARD
VALUES (
	BOARDNOSEQ.NEXTVAL,
	(SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = 1),
	(SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO = 1) +1,
	(SELECT TITLETAB FROM ANSWERBOARD WHERE BOARDNO = 1) +1,
	'ㄴRE:이제 알겠다',
	'리얼?','강여림',SYSDATE
	);
	