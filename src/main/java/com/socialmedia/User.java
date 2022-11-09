package com.socialmedia;

import java.util.Date;
import java.util.Scanner;

public class User {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		User1 crud = new UserCRUD();
		Details d1 = new Details();
		while (true) {
			System.out.println("Enter \n1 FOR SIGNUP \n2 FOR LOGIN \n3 FOR LOGOUT");
			int d = scanner.nextInt();
			switch (d) {
			case 1: {
				System.out.println("Enter Id");
				int id = scanner.nextInt();
				d1.setId(id);
				System.out.println("Enter your First Name");
				String first = scanner.next();
				d1.setFirst_name(first);
				System.out.println("Enter your Last Name");
				String last = scanner.nextLine();
				last += scanner.nextLine();
				d1.setLast_name(last);
				System.out.println("Enter your Gender");
				String gender = scanner.next();
				d1.setGender(gender);
				System.out.println("Enter your Phone Number");
				long phone = scanner.nextLong();
				d1.setPhone(phone);
				System.out.println("Enter your Date of Birth");
				String date_of_birth = scanner.next();
				d1.setDate_of_birth(date_of_birth);
				System.out.println("Enter your Email-Id for registration");
				String email = scanner.next();
				d1.setEmail(email);
				System.out.println("Enter a Strong password");
				String pwd = scanner.next();
				d1.setPassword(pwd);

				System.out.println("Enter 1 for submit and 2 for cancel");
				int a = scanner.nextInt();
				switch (a) {
				case 1:
					crud.signup(d1);
					break;

				case 2:
					break;
				}
				break;
			}

			case 2: {
				System.out.println("Enter you registered Email-Id");
				String email = scanner.next();
				System.out.println("Enter your password");
				String password = scanner.next();

				System.out.println("Enter 1 for submit and 2 for cancel");
				int a = scanner.nextInt();
				switch (a) {
				case 1:
					boolean x = crud.login(email, password);

					if (x == true) {
						System.out.println("Logged in Succesfully\n");
						System.out.println("Enter status");
						String status = scanner.nextLine();
						status += scanner.nextLine();
						crud.status(email, status);

					} else {
						System.out.println("Register with new Email");
					}
					break;

				case 2:
					break;
				}

			}
				break;

			case 3:
				System.out.println("Logged out succesfully");
				crud.logout();
				break;

			default:
				System.out.println("Enter a valid key"); System.exit(0);
			}
		}

	}

}
