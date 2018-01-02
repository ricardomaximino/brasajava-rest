package com.brasajava;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.brasajava.model.CapoeiraMember;
import com.brasajava.model.CapoeiraMusic;
import com.brasajava.model.CapoeiraMusicPart;
import com.brasajava.service.CapoeiraMemberService;
import com.brasajava.service.CapoeiraMusicService;

@SpringBootApplication
public class BrasajavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrasajavaApplication.class, args);
	}
	

	@Bean
	public CommandLineRunner runner(CapoeiraMusicService musicService, CapoeiraMemberService memberService) {
		return args -> {

			List<CapoeiraMusicPart> musicPartsList = new ArrayList<>();
			CapoeiraMusicPart partOne = new CapoeiraMusicPart();
			partOne.setMusicPart("Historia de Lemba Lemba eu Lemba" + "História de Lemba Lemba eu Lemba");

			CapoeiraMusicPart partTwo = new CapoeiraMusicPart();
			partTwo.setMusicPart("Lemba fora mal tratado" + "como era de custume" + "o feitor matou ser Lemba"
					+ "por causa do seu ciumes");

			CapoeiraMusicPart partThree = new CapoeiraMusicPart();
			partThree.setMusicPart("Arrancaran sua lingua" + "tiraram a pele do negro" + "lhe deram um banho de mel"
					+ "e jogaron al formiguero");

			CapoeiraMusicPart partFour = new CapoeiraMusicPart();
			partFour.setMusicPart("Os antigos comentavam" + "não me canso de lembrar" + "no terrero de dona Ana"
					+ "lemba foi ressucitar");

			CapoeiraMusic music = new CapoeiraMusic();
			music.setAuthor("Boa Voz");
			music.setName("História de Lemba");
			music.setObservations(
					"Realmente Boa Voz não é o autor mas na minha opinião é o melhor interprete desta música.");
			music.setMusicParts(musicPartsList);
			music.setTags(Arrays.asList("Benguela", "História", "Lemba", "Ciúmes", "Terrero", "Ressucitar"));

			musicPartsList.addAll(Arrays.asList(partOne, partTwo, partThree, partFour));
			
			music.setMusicPartSequence(Arrays.asList(1,2,1,3,1,4));

			musicService.save(music);
			
			
			//CapoeiraMember
			
			CapoeiraMember farofa = new CapoeiraMember();
			CapoeiraMember linguiça = new CapoeiraMember();
			CapoeiraMember maizena = new CapoeiraMember();
			farofa.setCapoeiraName("Farofa");
			farofa.setDescription("Magrinho mas valente");
			farofa.setGraduation("Mestre");
			farofa.setGroup("Nação Cultural");
			farofa.setGroups(Arrays.asList("Grupo Africa","Abada Capoeira","C.I.C","Nação Cultural"));
			farofa.setImage("Armada com martelo");
			farofa.setStartDate(LocalDate.of(1995, 01, 10));
			farofa.setStudents(Arrays.asList(maizena,linguiça));
			farofa.setTeachers(Arrays.asList(linguiça));
			
			linguiça.setCapoeiraName("linguiça");
			linguiça.setDescription("Magrinho mas valente");
			linguiça.setGraduation("Mestre");
			linguiça.setGroup("Nação Cultural");
			linguiça.setGroups(Arrays.asList("Grupo Africa","Abada Capoeira","C.I.C","Nação Cultural"));
			linguiça.setImage("Armada com martelo");
			linguiça.setStartDate(LocalDate.of(1995, 01, 10));
			linguiça.setStudents(Arrays.asList(maizena,farofa));
			linguiça.setTeachers(Arrays.asList(farofa));
			
			maizena.setCapoeiraName("maizena");
			maizena.setDescription("Comigo o caldo engrossa");
			maizena.setGraduation("Mestre");
			maizena.setGroup("Nação Cultural");
			maizena.setGroups(Arrays.asList("Grupo Africa","Abada Capoeira","C.I.C","Nação Cultural"));
			maizena.setImage("Armada com martelo");
			maizena.setStartDate(LocalDate.of(2002, 01, 10));
			maizena.setStudents(Arrays.asList(maizena,linguiça));
			maizena.setTeachers(Arrays.asList(linguiça));
			
			memberService.save(farofa);
		};
	}
}
