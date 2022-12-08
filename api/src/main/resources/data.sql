insert into tb_empregado values (1, now(), 'GERENCIA', 'admin', 'Administrador', 'senha123');
insert into tb_empregado values (2, now(), 'COMPRAS', 'user1', 'Usuario1', 'senha123');
insert into tb_empregado values (3, now(), 'VENDAS', 'user2', 'Usuario2', 'senha123');

insert into tb_roles_empregado values (1,'ADMIN', 1,1);
insert into tb_roles_empregado values (2,'USER', 1,2);
insert into tb_roles_empregado values (3,'USER', 2,2);
insert into tb_roles_empregado values (4,'USER', 3,2);