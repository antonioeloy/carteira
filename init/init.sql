USE carteira;
CREATE TABLE `transacoes` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `ticker` varchar(255),
  `data` date,
  `preco` decimal,
  `quantidade` int,
  `tipo` varchar(255)
);
