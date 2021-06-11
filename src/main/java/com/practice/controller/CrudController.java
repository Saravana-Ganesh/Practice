package com.practice.controller;

import java.util.Scanner;

import com.practice.bo.CrudBO;
import com.practice.dao.CrudDAO;


public class CrudController {
	/*
	 * author Saravana Ganesh
	 * created on 11-June-2021
	 */
	static CrudDAO crudDAO = new CrudDAO();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice\n1.Read\n2.Insert\n3.Update\n4.delete"
				+ "\n5.Read In File");
		int choice = sc.nextInt();
		CrudController.executeChoice(choice);
		System.exit(0);
	}
	private static void executeChoice(int choice) {
		CrudBO crudBO = new CrudBO();
		Scanner sc = new Scanner(System.in);
		switch(choice) {
			case 1:
				System.out.println("Performing Read Operation..\n");
				crudDAO.read();
				break;
			case 2:
				System.out.println("\nEnter Id, Name and Department to insert");				
				crudBO.setId(sc.nextInt());
				crudBO.setName(sc.next());
				crudBO.setDepartment(sc.next());
				crudDAO.insert(crudBO);
				break;
			case 3:
				System.out.println("\nChoose Name or Department or Both to update"
						+ "\n1.Name\n2.Department\n3.Both Name & Department");
				int subChoice = sc.nextInt();
			
				if(subChoice==1) {
					System.out.println("\nEnter the Name and Corresponding ID");
					crudBO.setName(sc.next());
					crudBO.setId(sc.nextInt());
				}
				else if(subChoice==2) {
					System.out.println("\nEnter the Department and Corresponding ID");
					crudBO.setDepartment(sc.next());
					crudBO.setId(sc.nextInt());
				}else if(subChoice==3) {
					System.out.println("\nEnter the Name, Department and ID");
					crudBO.setName(sc.next());
					crudBO.setDepartment(sc.next());
					crudBO.setId(sc.nextInt());					
				}else {
					System.out.println("\nInvalid Choice");
					break;
				}
				crudDAO.update(crudBO);
				break;
			case 4:
				System.out.println("Enter  the ID to delete");
				crudBO.setId(sc.nextInt());
				crudDAO.delete(crudBO);
				break;
			case 5:
				System.out.println("Writting In File\n");
				crudDAO.WriteInFile();
				break;
			default:
				System.out.println("\nInvalid Choice");
		}
	}

}
