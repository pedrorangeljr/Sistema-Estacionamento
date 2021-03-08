create database estacionamento;
use estacionamento;

create table veiculos(

   id bigint not null auto_increment,
   veiculo character varying(255),
   placa character varying(255),
   constraint user_pk primary key(id)

);

ALTER TABLE veiculos ADD COLUMN dataFormatada character varying(255); 
ALTER TABLE veiculos ADD COLUMN horaAtual character varying(255); 

select * from veiculos;