DROP SEQUENCE MEMBERNOSEQ;
DROP TABLE MYMEMBER;

CREATE SEQUENCE MEMBERNOSEQ;
CREATE TABLE MYMEMBER(
	MEMBERNO NUMBER PRIMARY KEY,
	MEMBERID VARCHAR2(500) NOT NULL,
	MEMBERPW VARCHAR2(500) NOT NULL,
	MEMBERNAME VARCHAR2(500) NOT NULL
)

INSERT INTO MYMEMBER
VALUES(MEMBERNOSEQ.NEXTVAL, 'admin', 'admin1234','관리자');

SELECT MEMBERNO, MEMBERID, MEMBERPW, MEMBERNAME
FROM MYMEMBER
ORDER BY MEMBERNO DESC;

DELETE MYMEMBER WHERE MEMBERNO = 24;