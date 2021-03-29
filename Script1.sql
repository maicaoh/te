CREATE SCHEMA `bd` DEFAULT CHARACTER SET utf8 ;
USE `bd` ;

-- -----------------------------------------------------
-- Table `mydb`.`equipe`
-- -----------------------------------------------------
CREATE TABLE equipe (
  id_equipe INT NOT NULL AUTO_INCREMENT,
  nome_equipe VARCHAR(100) NOT NULL,
  numero_de_jogadores INT NULL,
  tecnico VARCHAR(45) NULL,
  patrocinador_master VARCHAR(45) NULL,
  PRIMARY KEY (id_equipe));



-- -----------------------------------------------------
-- Table `mydb`.`Campeonato`
-- -----------------------------------------------------
CREATE TABLE Campeonato (
  id_campeonato INT NOT NULL AUTO_INCREMENT,
  nome_campeonato VARCHAR(45) NULL,
  qtd_equipe_max VARCHAR(45) NULL,
  PRIMARY KEY (`id_campeonato`));



-- -----------------------------------------------------
-- Table `mydb`.`jogo`
-- -----------------------------------------------------
CREATE TABLE jogo (
  id_jogo INT NOT NULL AUTO_INCREMENT,
  gol_casa INT NULL,
  gol_fora INT NULL,
  Campeonato_id_campeonato INT NOT NULL,
  equipe_id_casa INT NOT NULL,
  equipe_id_fora INT NOT NULL,
  PRIMARY KEY (id_jogo),
    FOREIGN KEY (Campeonato_id_campeonato)
    REFERENCES Campeonato(id_campeonato),
    FOREIGN KEY (equipe_id_casa)
    REFERENCES equipe(id_equipe),
    FOREIGN KEY (equipe_id_fora)
    REFERENCES equipe(id_equipe));




-- -----------------------------------------------------
-- Table `mydb`.`Equipe_Campeonato`
-- -----------------------------------------------------
CREATE TABLE Equipe_Campeonato (
  equipe_id_equipe INT NOT NULL,
  Campeonato_id_campeonato INT NOT NULL,
  vitoria INT NULL,
  empate INT NULL,
  derrota INT NULL,
  PRIMARY KEY (equipe_id_equipe, Campeonato_id_campeonato),
    FOREIGN KEY (equipe_id_equipe)
    REFERENCES equipe(id_equipe),
    FOREIGN KEY (Campeonato_id_campeonato)
    REFERENCES campeonato(id_campeonato));

delimiter $$
create trigger PreencherEquipeCampeonato after insert
on jogo
for each row
begin 
	if((select count(*) from equipe_campeonato where (equipe_id_equipe = new.equipe_id_casa) and campeonato_id_campeonato = new.campeonato_id_campeonato)<>0 and (select count(*) from equipe_campeonato where (equipe_id_equipe = new.equipe_id_fora) and campeonato_id_campeonato = new.campeonato_id_campeonato)<>0)then
			if(new.gol_casa>new.gol_fora)then
				update equipe_campeonato set vitoria=vitoria+1 where equipe_id_equipe = new.equipe_id_casa and equipe_campeonato.campeonato_id_campeonato = new.campeonato_id_campeonato;
                update equipe_campeonato set derrota=derrota+1 where equipe_id_equipe = new.equipe_id_fora and equipe_campeonato.campeonato_id_campeonato = new.campeonato_id_campeonato;
			elseif(new.gol_casa=new.gol_fora)then
				update equipe_campeonato set empate=empate+1 where equipe_id_equipe = new.equipe_id_casa and equipe_campeonato.campeonato_id_campeonato = new.campeonato_id_campeonato;
				update equipe_campeonato set empate=empate+1  where equipe_id_equipe = new.equipe_id_fora and equipe_campeonato.campeonato_id_campeonato = new.campeonato_id_campeonato;
			else
				update equipe_campeonato set derrota= derrota + 1 where equipe_id_equipe = new.equipe_id_casa and equipe_campeonato.campeonato_id_campeonato = new.campeonato_id_campeonato;
				update equipe_campeonato set vitoria=vitoria + 1  where equipe_id_equipe = new.equipe_id_fora and equipe_campeonato.campeonato_id_campeonato = new.campeonato_id_campeonato;
			end if;
    elseif((select count(*) from equipe_campeonato where (equipe_id_equipe = new.equipe_id_casa) and campeonato_id_campeonato = new.campeonato_id_campeonato) <> 0 and (select count(*) from equipe_campeonato where (equipe_id_equipe = new.equipe_id_fora) and campeonato_id_campeonato = new.campeonato_id_campeonato)=0)then
		if(new.gol_casa>new.gol_fora)then
				update equipe_campeonato set vitoria=vitoria+1 where equipe_id_equipe = new.equipe_id_casa and equipe_campeonato.campeonato_id_campeonato = new.campeonato_id_campeonato;
                insert into equipe_campeonato values (new.equipe_id_fora,new.campeonato_id_campeonato,0,0,1);
		elseif(new.gol_casa=new.gol_fora)then
				update equipe_campeonato set empate=empate+1 where equipe_id_equipe = new.equipe_id_casa and equipe_campeonato.campeonato_id_campeonato = new.campeonato_id_campeonato;
				insert into equipe_campeonato values (new.equipe_id_fora,new.campeonato_id_campeonato,0,1,0);
		else
				update equipe_campeonato set derrota= derrota + 1 where equipe_id_equipe = new.equipe_id_casa and equipe_campeonato.campeonato_id_campeonato = new.campeonato_id_campeonato;
				insert into equipe_campeonato values (new.equipe_id_fora,new.campeonato_id_campeonato,1,0,0); 
		end if;
	elseif((select count(*) from equipe_campeonato where (equipe_id_equipe = new.equipe_id_casa) and campeonato_id_campeonato = new.campeonato_id_campeonato) = 0 and (select count(*) from equipe_campeonato where (equipe_id_equipe = new.equipe_id_fora) and campeonato_id_campeonato = new.campeonato_id_campeonato)<>0)then		
		if(new.gol_casa<new.gol_fora)then
				update equipe_campeonato set vitoria=vitoria+1 where equipe_id_equipe = new.equipe_id_fora and equipe_campeonato.campeonato_id_campeonato = new.campeonato_id_campeonato;
                insert into equipe_campeonato values (new.equipe_id_casa,new.campeonato_id_campeonato,0,0,1);
		elseif(new.gol_casa=new.gol_fora)then
				update equipe_campeonato set empate=empate+1 where equipe_id_equipe = new.equipe_id_fora and equipe_campeonato.campeonato_id_campeonato = new.campeonato_id_campeonato;
				insert into equipe_campeonato values (new.equipe_id_casa,new.campeonato_id_campeonato,0,1,0);
		else
				update equipe_campeonato set derrota= derrota + 1 where equipe_id_equipe = new.equipe_id_fora and equipe_campeonato.campeonato_id_campeonato = new.campeonato_id_campeonato;
				insert into equipe_campeonato values (new.equipe_id_casa,new.campeonato_id_campeonato,1,0,0); 
		end if;
	else
			if(new.gol_casa > new.gol_fora)then
				insert into equipe_campeonato values (new.equipe_id_casa,new.campeonato_id_campeonato,1,0,0);
                insert into equipe_campeonato values (new.equipe_id_fora,new.campeonato_id_campeonato,0,0,1);
			elseif(new.gol_casa = new.gol_fora)then
				insert into equipe_campeonato values (new.equipe_id_casa,new.campeonato_id_campeonato,0,1,0);
                insert into equipe_campeonato values (new.equipe_id_fora,new.campeonato_id_campeonato,0,1,0);
			else
				insert into equipe_campeonato values (new.equipe_id_casa,new.campeonato_id_campeonato,0,0,1);
                 insert into equipe_campeonato values (new.equipe_id_fora,new.campeonato_id_campeonato,1,0,0);
			end if;
	end if;
end;
 $$ delimiter ;

delimiter $$
create procedure classificacao(id_campeonato int)
begin
select nome_equipe,(vitoria*3 + empate *1) as pontos, vitoria,empate,derrota from equipe_campeonato,equipe where equipe.id_equipe = equipe_campeonato.equipe_id_equipe and equipe_campeonato.campeonato_id_campeonato = id_campeonato order by pontos desc;
end
$$ delimiter ; 
Delimiter $$
create procedure partidas(id_campeonato int)
begin
select equipeCasa.nome_equipe as equipecasa,jogo.gol_casa,jogo.gol_fora,equipeFora.nome_equipe as equipeFora from equipe as equipeCasa,equipe as equipeFora,jogo,equipe_campeonato where jogo.equipe_id_casa = equipeCasa.id_equipe and jogo.equipe_id_fora = equipeFora.id_equipe and jogo.campeonato_id_campeonato = id_campeonato group by equipecasa,equipefora ;
end 
$$ Delimiter ;

