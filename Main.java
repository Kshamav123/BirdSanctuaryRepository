package com.bl.birdsanctuary;

import java.util.EnumSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Main main = new Main();
		main.showUserMenu();
		System.out.println("Good Bye!!!");

		/*
		 * Parrot parrot = new Parrot(); parrot.id = "p001"; Duck duck = new Duck();
		 * duck.id = "d001"; Ostrich ostrich = new Ostrich(); ostrich.id = "ost001";
		 * Penguin penguin = new Penguin(); penguin.id = "pn001"; Penguin penguin2 = new
		 * Penguin(); penguin2.id = "pn001";
		 * 
		 * BirdSanctuaryRepository birdSanctuaryRepository = new
		 * BirdSanctuaryRepository(); birdSanctuaryRepository.add(parrot);
		 * birdSanctuaryRepository.add(duck); birdSanctuaryRepository.add(ostrich);
		 * birdSanctuaryRepository.add(penguin); birdSanctuaryRepository.add(penguin2);
		 * 
		 * System.out.println("Before deleting"); birdSanctuaryRepository.print();
		 * 
		 * birdSanctuaryRepository.remove(penguin);
		 * 
		 * System.out.println("\nAfter deleting"); birdSanctuaryRepository.print();
		 */

	}

	public void showUserMenu() {
		int option = 0;
		Scanner scanner = new Scanner(System.in);
		final int EXIT_VALUE = 10;
		ViewLayer viewLayer = new ViewLayer();

		while (option != EXIT_VALUE) {
			System.out.println("Enter your option");
			System.out.println("1. Add a bird\n2. Remove a Bird\n3. Print all the birds\n4. Print Swimable\n"
					+ "5. Print Flyable\n6. Print Eatable\n7. Edit Bird\n" + EXIT_VALUE + ". Exit");
			option = scanner.nextInt();
			switch (option) {
			case 1:
				addTemporaryBirds();
				addBird();

//			Parrot parrot = new Parrot();
//			parrot.id = "p001";
//			Duck duck = new Duck();
//			duck.id = "d001";
//			Ostrich ostrich = new Ostrich();
//			ostrich.id = "ost001";
//			Penguin penguin = new Penguin();
//			penguin.id = "pn001";	
//			
//			BirdSanctuaryRepository birdSanctuaryRepository = BirdSanctuaryRepository.getInstance();
//			birdSanctuaryRepository.add(parrot);
//			birdSanctuaryRepository.add(duck);
//			birdSanctuaryRepository.add(ostrich);
//			birdSanctuaryRepository.add(penguin);
				break;

			case 2:
				System.out.println("Enter the Bird name to be removed");
				Scanner reader = new Scanner(System.in);
				String name = reader.nextLine();
				 BirdSanctuaryRepository birdSanctuaryRepository = BirdSanctuaryRepository.getInstance();
				
				Bird bird1 = birdSanctuaryRepository.getBird(name);
				if (bird1 == null) {
					System.out.println("Bird doesn't exist");
				} else {
					birdSanctuaryRepository.remove(bird1);
					System.out.println(name + " removed");
				}
				break;

			case 3:
				viewLayer.print();
				break;

			case 4:
				viewLayer.printSwimmable();
				break;

			case 5:
				viewLayer.printFlyable();
				break;

			case 6:
				viewLayer.printEatable();
				break;

			case 7:
				editBird();
				break;
			}

		}

	}

	private void addBird() {

		Bird bird = new Bird();
		System.out.println("enter the id");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.nextLine();
		System.out.println("Enter the name");
		String name = scanner.nextLine();
		System.out.println("Choose the color");
		int count = 1;
		for (Bird.Color color : EnumSet.allOf(Bird.Color.class)) {
			System.out.println(count + ". " + color);
			count += 1;
		}
		int colorChoice = scanner.nextInt();
		int count1 = 1;
		for (Bird.Color color : EnumSet.allOf(Bird.Color.class)) {
			if (colorChoice == count1) {

				bird.color = color;
			}

			count1 += 1;

		}
		System.out.println("Can the bird fly?");
		Boolean canFly = scanner.nextBoolean();
		bird.canFly = canFly = scanner.nextBoolean();
		System.out.println("Can the bird swim?");
		Boolean canSwim = scanner.nextBoolean();
		bird.canSwim = canSwim;
		BirdSanctuaryRepository birdSanctuaryRepository = BirdSanctuaryRepository.getInstance();
		birdSanctuaryRepository.add(bird);
	}

	private void addTemporaryBirds() {

		Bird duck = new Bird();
		duck.id = "d001";
		duck.name = "Duck";
		duck.color = Bird.Color.BLACK;
		duck.canFly = false;
		duck.canSwim = true;
		BirdSanctuaryRepository.getInstance().add(duck);

		Bird penguin = new Bird();
		penguin.id = "p001";
		penguin.name = "Penguin";
		penguin.color = Bird.Color.WHITE;
		penguin.canFly = false;
		penguin.canSwim = true;
		BirdSanctuaryRepository.getInstance().add(penguin);

	}

	private void editBird() {

		System.out.println("Enter the bird name to edit");
		Scanner scanner = new Scanner(System.in);
		String birdname = scanner.nextLine();
		int choice = 0;
		Bird editBirdobj = BirdSanctuaryRepository.getInstance().getBird(birdname);

		while (choice != 4) {
			System.out.println("1. Edit Bird name\n2. Edit id\n3. Edit Color\n4. Exit");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the new name");
				scanner = new Scanner(System.in);
				String newName = scanner.nextLine();
				editBirdobj.name = newName;
				break;

			case 2:
				System.out.println("Enter the new id");
				scanner = new Scanner(System.in);
				String newID = scanner.nextLine();
				editBirdobj.id = newID;
				break;

			case 3:
				System.out.println("Choose the new color");
				scanner = new Scanner(System.in);
//				String newColor = scanner.nextLine();
//				editBirdobj.color = (Color)newColor;
//				EnumSet.allOf(Bird.Color.class)
//            .forEach(season -> System.out.println(season));
				int count = 1;
				for (Bird.Color color : EnumSet.allOf(Bird.Color.class)) {
					System.out.println(count + ". " + color);
					count += 1;
				}
				int colorChoice = scanner.nextInt();
				int count1 = 1;
				for (Bird.Color color : EnumSet.allOf(Bird.Color.class)) {
					if (colorChoice == count1) {
						editBirdobj.color = color;
					}

					count1 += 1;
				}
				break;

			}
		}
	}

}
