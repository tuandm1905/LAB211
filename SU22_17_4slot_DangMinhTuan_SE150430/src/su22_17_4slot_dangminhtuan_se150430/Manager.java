/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su22_17_4slot_dangminhtuan_se150430;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Dang Minh Tuan SE150430
 */
public class Manager {

    ArrayList<Candidate> candidates = new ArrayList<>();
    private static Validation v = new Validation();
    private static Candidate candidate = new Candidate();

    //display menu
    public int menu() {
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. Internship");
        System.out.println("4. Searching");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice = v.checkInputIntLimit(1, 5);
        return choice;
    }

    //allow user input information common of candidate
    public void createCandidate(int type) {
        //loop until user don't want to create new candidate
        while (true) {
            System.out.print("Enter id: ");
            String id = v.checkInputString();
            System.out.print("Enter first name: ");
            String firstName = v.checkInputString();
            System.out.print("Enter last name: ");
            String lastName = v.checkInputString();
            System.out.print("Enter birth date: ");
            int birthDate = v.checkInputIntLimit(1900,
                    Calendar.getInstance().get(Calendar.YEAR));
            System.out.print("Enter address: ");
            String address = v.checkInputString();
            System.out.print("Enter phone: ");
            String phone = v.checkInputPhone();
            System.out.print("Enter email: ");
            String email = v.checkInputEmail();
            Candidate candidate = new Candidate(id, firstName, lastName,
                    birthDate, address, phone, email, type);
            //check id exist or not
            if (v.checkIdExist(candidates, id)) {
                switch (type) {
                    case 0:
                        createExperience(candidate);
                        break;
                    case 1:
                        createFresher(candidate);
                        break;
                    case 2:
                        createInternship(candidate);
                        break;
                }
            } else {
                return;
            }
            System.out.print("Do you want to continue (Y/N): ");
            //check user want to create new candidate or not
            if (!v.checkInputYN()) {
                return;
            }
        }
    }
    //allow user create experience

    public void createExperience(Candidate candidate) {
        System.out.print("Enter year of experience: ");
        int yearExperience = v.checkInputExprience(candidate.getBirthDate());
        System.out.print("Enter professional skill: ");
        String professionalSkill = v.checkInputString();
        candidates.add(new Experience(yearExperience, professionalSkill,
                candidate.getId(), candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(), candidate.getTypeCandidate()));
        System.err.println("Create success.");
    }

    //allow user create fresher
    public void createFresher(Candidate candidate) {
        System.out.print("Enter graduation date: ");
        String graduationDate = v.checkInputString();
        System.out.print("Enter graduation rank: ");
        String graduationRank = v.checkInputGraduationRank();
        candidates.add(new Fresher(graduationDate, graduationRank, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(),
                candidate.getTypeCandidate()));
        System.err.println("Create success.");
    }

    //allow user create internship
    public void createInternship(Candidate candidate) {
        System.out.print("Enter major: ");
        String major = v.checkInputString();
        System.out.print("Enter semester: ");
        String semester = v.checkInputString();
        System.out.print("Enter university: ");
        String university = v.checkInputString();
        candidates.add(new Internship(major, semester, university, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(),
                candidate.getTypeCandidate()));
        System.err.println("Create success.");
    }

    //allow user search candidate by name
    public void searchCandidate() {
        printListNameCandidate();
        System.out.print("Enter andidate name (First name or Last name): ");
        String nameSearch = v.checkInputString();
        System.out.print("Enter type of candidate: ");
        int typeCandidate = v.checkInputIntLimit(0, 2);
        for (Candidate candidate : candidates) {
            if (candidate.getTypeCandidate() == typeCandidate
                    && candidate.getFirstName().contains(nameSearch)
                    || candidate.getLastName().contains(nameSearch)) {
                System.out.println(candidate.toString());
            }
        }
    }

    //display list name candidate
    public void printListNameCandidate() {
        System.err.println("Experience Candidate");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Experience) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
        System.err.println("Fresher Candidate");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Fresher) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
        System.err.println("Internship Candidate");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Internship) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
    }
}
