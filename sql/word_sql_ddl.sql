-- ddl

-- �մܾ� ���̺�

create table forward_word (
	forward_word_num number,
	forward_word_word varchar2(10)
);

alter table forward_word add constraint forward_word_num_pk primary key(num);

-- �޴ܾ� ���̺�

create table back_word (
	back_word_num number,
	back_word_word varchar2(10)
);

alter table back_word add constraint back_word_num_pk primary key(num);