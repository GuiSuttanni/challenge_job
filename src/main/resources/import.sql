-- INSERT para a tabela pais
INSERT INTO pais (id_pais, nome_pais) VALUES (1, 'Brasil');
INSERT INTO pais (id_pais, nome_pais) VALUES (2, 'Estados Unidos');
INSERT INTO pais (id_pais, nome_pais) VALUES (3, 'Franca');

-- INSERT para a tabela estado
INSERT INTO estado (id_estado, nome_estado, id_pais) VALUES (1, 'Parana', 1);
INSERT INTO estado (id_estado, nome_estado, id_pais) VALUES (2, 'California', 2);
INSERT INTO estado (id_estado, nome_estado, id_pais) VALUES (3, 'Ile-de-France', 3);

-- INSERT para a tabela municipio
INSERT INTO municipio (id_municipio, nome_municipio, id_estado) VALUES (1, 'Campo Mourao', 1);
INSERT INTO municipio (id_municipio, nome_municipio, id_estado) VALUES (2, 'Los Angeles', 2);
INSERT INTO municipio (id_municipio, nome_municipio, id_estado) VALUES (3, 'Paris', 3);

-- INSERT para a tabela estado_civil
INSERT INTO estado_civil (id_estado_civil, nome_estado_civil) VALUES (1, 'Solteiro(a)');
INSERT INTO estado_civil (id_estado_civil, nome_estado_civil) VALUES (2, 'Casado(a)');
INSERT INTO estado_civil (id_estado_civil, nome_estado_civil) VALUES (3, 'Divorciado(a)');

-- INSERT para a tabela grupo_produto
INSERT INTO grupo_produto (id_grupo_produto, nome) VALUES (1, 'Fertilizante');
INSERT INTO grupo_produto (id_grupo_produto, nome) VALUES (2, 'Corretivos');
INSERT INTO grupo_produto (id_grupo_produto, nome) VALUES (3, 'Herbicidas');
INSERT INTO grupo_produto (id_grupo_produto, nome) VALUES (4, 'Fungicidas');
INSERT INTO grupo_produto (id_grupo_produto, nome) VALUES (5, 'Inseticidas');

-- INSERT para a tabela pessoa_fisica
INSERT INTO pessoa_fisica (id_pessoa_fisica, nome, cpf, rg, data_nascimento, id_pais, id_estado_civil) VALUES (1, 'Joaoo da Silva', '111.111.111-11', 'MG1234567', '1985-05-10', 1, 1);
INSERT INTO pessoa_fisica (id_pessoa_fisica, nome, cpf, rg, data_nascimento, id_pais, id_estado_civil) VALUES (2, 'Maria Souza', '222.222.222-22', 'SP9876543', '1990-12-15', 1, 2);
INSERT INTO pessoa_fisica (id_pessoa_fisica, nome, cpf, rg, data_nascimento, id_pais, id_estado_civil) VALUES (3, 'Pedro Santos', '333.333.333-33', 'RJ5678901', '1988-08-20', 2, 2);

-- INSERT para a tabela pessoa_juridica
INSERT INTO pessoa_juridica (id_pessoa_juridica, nome, data_fundacao_empresa) VALUES (1, 'ExemploTech', '2000-01-15');
INSERT INTO pessoa_juridica (id_pessoa_juridica, nome, data_fundacao_empresa) VALUES (2, 'QuímicaClean', '1995-07-22');

-- INSERT para a tabela socios
INSERT INTO socios (id_socio, nome, cpf, rg, data_nascimento, id_pais, id_pessoa_juridica) VALUES (1, 'Ana Oliveira', '444.444.444-44', 'SP7654321', '1978-04-05', 1, 1);
INSERT INTO socios (id_socio, nome, cpf, rg, data_nascimento, id_pais, id_pessoa_juridica) VALUES (2, 'Carlos Rodrigues', '555.555.555-55', 'RJ4321098', '1982-11-25', 1, 1);
INSERT INTO socios (id_socio, nome, cpf, rg, data_nascimento, id_pais, id_pessoa_juridica) VALUES (3, 'Fernanda Souza', '666.666.666-66', 'MG8765432', '1975-09-18', 1, 2);

-- INSERT para a tabela cooperados
INSERT INTO cooperados (id_cooperado, conceito, id_pessoa_fisica, id_pessoa_juridica) VALUES (1, 'A', 1, NULL);
INSERT INTO cooperados (id_cooperado, conceito, id_pessoa_fisica, id_pessoa_juridica) VALUES (2, 'B', 2, NULL);
INSERT INTO cooperados (id_cooperado, conceito, id_pessoa_fisica, id_pessoa_juridica) VALUES (3, 'C', NULL, 1);
INSERT INTO cooperados (id_cooperado, conceito, id_pessoa_fisica, id_pessoa_juridica) VALUES (4, 'D', NULL, 2);

-- INSERT para a tabela unidades_cooperativa
INSERT INTO unidades_cooperativa (id_unidade, codigo_interno, nome, id_municipio) VALUES (1, 'UN0001', 'Unidade 1', 1);
INSERT INTO unidades_cooperativa (id_unidade, codigo_interno, nome, id_municipio) VALUES (2, 'UN0002', 'Unidade 2', 3);

-- INSERT para a tabela produtos
INSERT INTO produtos (id_produto, codigo_interno, nome_comercial, formula_principio_ativo, unidade_medida_padrao, id_grupo_produto) VALUES (1, 'ALM0001', 'Arroz', 'formulaarroz', 'kg', 1);
INSERT INTO produtos (id_produto, codigo_interno, nome_comercial, formula_principio_ativo, unidade_medida_padrao, id_grupo_produto) VALUES (2, 'ELE0002', 'Saco Feijao', 'ExemploTech', 'un', 2);
INSERT INTO produtos (id_produto, codigo_interno, nome_comercial, formula_principio_ativo, unidade_medida_padrao, id_grupo_produto) VALUES (3, 'LIM0003', 'Soja', 'QuímicaClean', 'kg', 3);

-- INSERT para a tabela vendas
INSERT INTO vendas (id_venda, data_venda, data_vencimento, tipo_venda, id_cooperado, id_unidade) VALUES (1, '2023-07-15', '2023-07-22', 'vista', 1, 1);
INSERT INTO vendas (id_venda, data_venda, data_vencimento, tipo_venda, id_cooperado, id_unidade) VALUES (2, '2023-07-15', '2023-07-21', 'prazo', 2, 2);
INSERT INTO vendas (id_venda, data_venda, data_vencimento, tipo_venda, id_cooperado, id_unidade) VALUES (3, '2023-07-15', '2023-07-25', 'prazp', 3, 1);
INSERT INTO vendas (id_venda, data_venda, data_vencimento, tipo_venda, id_cooperado, id_unidade) VALUES (4, '2023-07-15', '2023-07-30', 'vista', 4, 2);

-- INSERT para a tabela itens_venda
INSERT INTO itens_venda (id_item, quantidade, valor_unitario, desconto_adicional, id_venda, id_produto) VALUES (1, 10, 1.10, 0, 1, 1);
INSERT INTO itens_venda (id_item, quantidade, valor_unitario, desconto_adicional, id_venda, id_produto) VALUES (2, 5, 2.50, 0, 2, 2);
INSERT INTO itens_venda (id_item, quantidade, valor_unitario, desconto_adicional, id_venda, id_produto) VALUES (3, 6, 20.00, 0, 3, 1);
INSERT INTO itens_venda (id_item, quantidade, valor_unitario, desconto_adicional, id_venda, id_produto) VALUES (4, 5, 10.50, 0, 4, 3);

-- INSERT para a tabela dados_tributacoes
INSERT INTO dados_tributacoes (id_tributacao, finalidade_produto, uf_origem, uf_destino, aliquota_icms, id_produto) VALUES (1, 'Uso interno', 'SP', 'SP', 18.00, 1);
INSERT INTO dados_tributacoes (id_tributacao, finalidade_produto, uf_origem, uf_destino, aliquota_icms, id_produto) VALUES (4, 'Venda', 'CA', 'NY', 10.00, 2);
INSERT INTO dados_tributacoes (id_tributacao, finalidade_produto, uf_origem, uf_destino, aliquota_icms, id_produto) VALUES (5, 'Venda', 'FR', 'FR', 20.00, 3);

