	CREATE TABLE IF NOT EXISTS USERS(
ID VARCHAR(255) PRIMARY KEY, 
NAME VARCHAR(255),  
EMAIL VARCHAR(255),
ACTIVE BOOLEAN
);



CREATE TABLE IF NOT EXISTS PHONES(
ID VARCHAR(255) PRIMARY KEY, 
NUMBER VARCHAR(64),
COUNTRY_CODE VARCHAR(64),
USER_ID VARCHAR(64) NOT NULL,
CONSTRAINT fk_user FOREIGN KEY (USER_ID) REFERENCES USERS(ID)
);

insert into  users(id, name, email) 
    values('777', 'denisseBlum', 'dense.blum@gmail.com');
    
insert into  phones(id, number, city_code, country_code, user_id) 
    values('888', '456456456', 'ec','ec090512','777') ;
	