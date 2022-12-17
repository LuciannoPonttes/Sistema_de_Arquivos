insert into tb_empregado (id_empregado, departamento,email, matricula, nome,senha,ativo) values (1, 1,'admin@arquivo.org', 'admin', 'Administrador', 'senha123', true);
insert into tb_empregado (id_empregado, departamento,email, matricula, nome,senha,ativo) values (2, 2,'user1@arquivo.org', 'user1', 'Usuario1', 'senha123', true);
insert into tb_empregado (id_empregado, departamento,email, matricula, nome,senha,ativo) values (3, 3,'user2@arquivo.org', 'user2', 'Usuario2', 'senha123', true);

insert into tb_roles_empregado values (1,'ADMIN', 1,1);
insert into tb_roles_empregado values (2,'USER', 1,2);
insert into tb_roles_empregado values (3,'USER', 2,2);
insert into tb_roles_empregado values (4,'USER', 3,2);

insert into tb_unidade_pagamento values (1,'CONT','CONTABILIDADE GERAL');
insert into tb_unidade_pagamento values (2,'GERA','GASTOS GERAIS');
insert into tb_unidade_pagamento values (3,'EXTR','GASTOS EXTRAORDINARIOS');
insert into tb_unidade_pagamento values (4,'OPER','GASTOS OPERATIVOS');
insert into tb_unidade_pagamento values (5,'INV','INVESTIMENTO');

insert into tb_classificacao_documental values (100,'OPERAÇÕES E SERVIÇOS AEROPORTUÁRIOS');
insert into tb_classificacao_documental values (101,'Normatização. Regulamentação');
insert into tb_classificacao_documental values (102,'Relacionamento Institucional');
insert into tb_classificacao_documental values (110,'COMERCIALIZAÇÃO DE SERVIÇOS E PRODUTOS AEROPORTUÁRIOS');
insert into tb_classificacao_documental values (111,'Desenvolvimento de produtos e serviços aeroportuários');
insert into tb_classificacao_documental values (112,'Prospecção de clientes e parceiros');
insert into tb_classificacao_documental values (113,'Gestão do Mix Comercial dos aeroportos');
insert into tb_classificacao_documental values (114,'Concessão de áreas dos aeródromos');
insert into tb_classificacao_documental values (115,'Gestão da qualidade de produtos e serviços aeroportuários');


