package com.projectPS.demo;

import com.projectPS.demo.constants.SubscriptionType;
import com.projectPS.demo.model.*;
import com.projectPS.demo.repository.*;
import com.projectPS.demo.service.SubscriptionService;
import org.hibernate.cfg.annotations.NamedProcedureCallDefinition;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;

@EntityScan
@EnableJpaRepositories
@SpringBootApplication
public class FitnessClubApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitnessClubApplication.class, args);

	}

	@Bean
	CommandLineRunner init(UserRepository userRepository, GroupRepository groupRepository, SubscriptionRepository subscriptionRepository, AdminRepository adminRepository, TrainerRepository trainerRepository, ClientRepository clientRepository, PersonRepository personRepository, SubscriptionService subscriptionService){
		return args -> {
			Client client1 = new Client(null, "Victoria", "Cluj", null);
			Client client2 = new Client(null, "David", "Zalau", null);
			Client client3 = new Client(null, "Radu", "Suceava", null);
			Client client4 = new Client(null, "Marin", "Ploiesti", null);
			Client client5 = new Client(null, "George", "Alba", null);
			Client client6 = new Client(null, "Vlad", "Mures", null);
			Client client7 = new Client(null, "Valentin", "Suceava", null);
			UserAuth client8 = new Client(null, "lera123", "1234", "Valeria", "Cluj");
			UserAuth client9 = new Client(null, "angelamodringa", "123456", "Angela", "Cluj");
			clientRepository.save(client1);
			clientRepository.save(client2);
			clientRepository.save(client3);
			clientRepository.save(client4);
			clientRepository.save(client5);
			clientRepository.save(client6);
			clientRepository.save(client7);
			clientRepository.save((Client)client8);
			clientRepository.save((Client)client9);


			Subscription subscription1 = new Subscription(null, SubscriptionType.Fitness, null, null, "27.01.2021", 28);
			Subscription subscription2 = new Subscription(null, SubscriptionType.Aerobic, null, null, "10.01.2021", 20);
			Subscription subscription3 = new Subscription(null, SubscriptionType.Zumba, null, null, "17.01.2021", 30);
			Subscription subscription4 = new Subscription(null, SubscriptionType.Zumba, null, null, "18.01.2021", 30);
			Subscription subscription5 = new Subscription(null, SubscriptionType.Zumba, null, null, "19.01.2021", 30);
			Subscription subscription6 = new Subscription(null, SubscriptionType.Zumba, null, null, "20.01.2021", 30);
			Subscription subscription7 = new Subscription(null, SubscriptionType.Zumba, null, null, "21.01.2021", 30);
			Subscription subscription8 = new Subscription(null, SubscriptionType.Zumba, null, null, "23.01.2021", 30);
			Subscription subscription9 = new Subscription(null, SubscriptionType.Zumba, null, null, "01.04.2021", 30);
			subscriptionRepository.save(subscription1);
			subscriptionRepository.save(subscription2);
			subscriptionRepository.save(subscription3);
			subscriptionRepository.save(subscription4);
			subscriptionRepository.save(subscription5);
			subscriptionRepository.save(subscription6);
			subscriptionRepository.save(subscription7);
			subscriptionRepository.save(subscription8);
			subscriptionRepository.save(subscription9);


			Trainer trainer1 = new Trainer(null, "Popa Ion", "CLuj-Napoca", "L-V", 3000, null);
			Trainer trainer2 = new Trainer(null, "Groza Maria", "CLuj-Napoca", "L-M", 3100, null);
			Trainer trainer3 = new Trainer(null, "Pop Vasile", "CLuj-Napoca", "L-V", 2000, null);
			trainerRepository.save(trainer1);
			trainerRepository.save(trainer2);
			trainerRepository.save(trainer3);

			client1.setSubscriptions(subscription1);
			client2.setSubscriptions(subscription2);
			client3.setSubscriptions(subscription3);
			client4.setSubscriptions(subscription4);
			client5.setSubscriptions(subscription5);
			client6.setSubscriptions(subscription6);
			client7.setSubscriptions(subscription7);
			((Client) client9).setSubscriptions(subscription9);


			clientRepository.save(client1);
			clientRepository.save(client2);
			clientRepository.save(client3);
			clientRepository.save(client4);
			clientRepository.save(client5);
			clientRepository.save(client6);
			clientRepository.save(client7);
			clientRepository.save((Client)client9);

			//System.out.println(clientRepository.findClientByCNP(1L));

			FitnessGroup zumbaFitnessGroup = new FitnessGroup(null, null);
			groupRepository.save(zumbaFitnessGroup);

			List<Subscription> zumbaList = new ArrayList<>();
			zumbaList.add(subscription3);
			zumbaList.add(subscription4);
			zumbaList.add(subscription5);
			zumbaList.add(subscription6);
			zumbaList.add(subscription7);
			zumbaFitnessGroup.setSubscriptions(zumbaList);
			groupRepository.save(zumbaFitnessGroup);

			System.out.println("Inainte de modificare: " + subscription1.getData_inceput());
			subscription1 = subscriptionService.updateAbonament(subscription1, "01.03.2021");
			System.out.println("Dupa modificare:" + subscription1.getData_inceput());


		};

	}

}
