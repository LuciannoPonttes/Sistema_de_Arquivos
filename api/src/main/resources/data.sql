insert into tb_empregado values (1, now(), 'GERENCIA','admin@arquivo.org', 'admin', 'Administrador', 'senha123');
insert into tb_empregado values (2, now(), 'COMPRAS','user1@arquivo.org', 'user1', 'Usuario1', 'senha123');
insert into tb_empregado values (3, now(), 'VENDAS','user2@arquivo.org', 'user2', 'Usuario2', 'senha123');

insert into tb_roles_empregado values (1,'ADMIN', 1,1);
insert into tb_roles_empregado values (2,'USER', 1,2);
insert into tb_roles_empregado values (3,'USER', 2,2);
insert into tb_roles_empregado values (4,'USER', 3,2);

insert into tb_unidade_pagamento values (1,'CONT','CONTABILIDADE GERAL');
insert into tb_unidade_pagamento values (2,'GERA','GASTOS GERAIS');
insert into tb_unidade_pagamento values (3,'EXTR','GASTOS EXTRAORDINARIOS');
insert into tb_unidade_pagamento values (4,'OPER','GASTOS OPERATIVOS');
insert into tb_unidade_pagamento values (5,'INV','INVESTIMENTO');

insert into tb_unidade_produtora values (1,'AUTO','DIVISAO AUTOMOVILES');
insert into tb_unidade_produtora values (2,'ALIM','DIVISAO ALIMENTOS');
insert into tb_unidade_produtora values (3,'FARM','DIVISAO FARMACIA');

insert into tb_classificacao_documental values (1,'DOCGERA','DOCUMENTO GERAL');
insert into tb_classificacao_documental values (2,'DOCEXTR','DOCUMENTO EXTRAORDINARIO');
insert into tb_classificacao_documental values (3,'DOCANEX','ANEXO A DOCUMENTO');
insert into tb_classificacao_documental values (4,'DOCANUL','RESOLUCAO ANULACAO');


