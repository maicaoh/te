create database aposta;
use aposta;

CREATE TABLE IF NOT EXISTS `aposta`.`Equipe` (
  `id_equipe` INT NOT NULL auto_increment,
  `nome_equipe` VARCHAR(45) NOT NULL,
  `numero_de_jogadores` INT NOT NULL,
  `Tecnico` VARCHAR(45) NULL,
  `patrocinador_master` VARCHAR(45) NULL,
  PRIMARY KEY (`id_equipe`));


CREATE TABLE IF NOT EXISTS `aposta`.`Campeonato` (
  `id_campeonato` INT NOT NULL AUTO_INCREMENT,
  `nome_campeonato` VARCHAR(45) NOT NULL,
  `qtd_equipes_max` INT NOT NULL,
  `premiacao` DOUBLE NULL,
  `casa_volta` TINYINT NOT NULL,
  PRIMARY KEY (`id_campeonato`));


CREATE TABLE IF NOT EXISTS `aposta`.`Jogo` (
  `id_jogo` INT NOT NULL AUTO_INCREMENT primary key,
  `gol_casa` INT NULL,
  `gol_fora` INT NULL,
  `Campeonato_id_campeonato` INT NOT NULL,
  `Equipe_id_casa` INT NOT NULL,
  `Equipe_id_fora` INT NOT NULL,
	foreign key (Campeonato_id_campeonato) references Campeonato (id_campeonato),
	foreign key (equipe_id_casa) references equipe (id_equipe),
	foreign key (equipe_id_fora) references equipe (id_equipe))
Delimiter $$
create procedure pontuacao(id_camp int,id_time int)
begin
	declare vitoria int;
    declare empate int;
    declare total int;
    
    select * from jogo;
    
	select count(*) * 3 into vitoria from jogo where 1 = campeonato_id_campeonato and (id_time = equipe_id_casa and  gol_casa > gol_fora) or (equipe_id_fora = id_time and gol_fora > gol_casa );
    select count(*) into empate from jogo where 1 = campeonato_id_campeonato and (id_time = equipe_id_casa and  gol_casa = gol_fora) or (equipe_id_fora = id_time and gol_fora = gol_casa );
    set total = vitoria + empate;
    select total as 'Total',(select nome_equipe from equipe where id_time = id_equipe) as 'Equipe';
end 
$$ Delimiter ;

