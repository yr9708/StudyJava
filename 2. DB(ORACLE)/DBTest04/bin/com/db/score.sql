DROP TABLE SCORE;
-- 이름, 국어, 영어, 수학, 총점, 평균, 등급
CREATE TABLE SCORE(
	S_NAME VARCHAR2(20) PRIMARY KEY,
	S_KOR NUMBER NOT NULL,
	S_ENG NUMBER NOT NULL,
	S_MATH NUMBER NOT NULL,
	S_SUM NUMBER,
	S_AVG NUMBER,
	S_GRADE VARCHAR2(2) CHECK (S_GRADE IN ('A','B','C','D','F'))
);

INSERT INTO SCORE VALUES ('KANG',100,100,100,300,100.00,'A');
INSERT INTO SCORE VALUES ('이제훈',40,60,70,170,56.67,'F');
INSERT INTO SCORE VALUES ('서강준',100,40,60,200,66.67,'D');
INSERT INTO SCORE VALUES ('박보검',80,70,60,210, 70,'C');


SELECT S_NAME, S_KOR, S_ENG, S_MATH, S_SUM, S_AVG, S_GRADE FROM SCORE;

--1등 출력, 2등 출력
SELECT R, S_NAME, S_KOR, S_ENG, S_MATH, S_SUM, S_AVG, S_GRADE
FROM
	(SELECT ROWNUM AS R, S_NAME, S_KOR, S_ENG, S_MATH, S_SUM, S_AVG, S_GRADE
	FROM 
		(SELECT S_NAME, S_KOR, S_ENG, S_MATH, S_SUM, S_AVG, S_GRADE
		FROM SCORE
		ORDER BY S_AVG DESC) A 
		) B
WHERE R = 3;

--n등 출력