import java.util.ArrayList;
import java.util.Scanner;

public class PetSpaClient {
    public static void main(String[] args) {
        ArrayList<Pets> pets = new ArrayList<>();
        ArrayList<Owners> owners = new ArrayList<>();
        Scanner kb = new Scanner(System.in);
        int ans;
        boolean stopper = false;
        owners.add(0, new Owners("tim", "555-555-555", "yeet way"));
        owners.add(new Owners("peter griffin", "777-777-7777", "some where on quohag"));
        owners.get(0).setPets("hue", 99);
        owners.get(0).setPets("mellow", 14);
        owners.get(1).setPets("Brian", 8);
        while (!stopper) {
            System.out.println("enter 1 to  check-in a pet\n" +
                    "enter 2 to check-out a pet\n" +
                    "enter 3 to wash a pet\n" +
                    "enter 4 to trim a pet\n" +
                    "enter 5 for a status report on checked in pets\n" +
                    "enter 6 to print customers bill\n" +
                    "enter 7 to add a customer\n" +
                    "enter 8 to quit");
            System.out.print("\nenter: ");
            ans = kb.nextInt();
            if (ans == 1) {
                System.out.println(printOwners(owners));
                System.out.print("which pet owner: ");
                ans = kb.nextInt();
                for (int i = 0; i < owners.get(ans).getPets().size(); i++) {
                    System.out.println(i + " " + owners.get(ans).getPets().get(i).getName());
                }
                System.out.print("which pet: ");
                int p = kb.nextInt();
                owners.get(ans).getPets().get(p).setIn(true);
                System.out.println(owners.get(ans).getPets().get(p).getName() + " has been checked in");

                System.out.println(petsInSpa(owners));
            } else if (ans == 2) {
                int count = 0;
                for (int i = 0; i < owners.size(); i++) {
                    for (int j = 0; j < owners.get(i).getPets().size(); j++) {
                        if (owners.get(i).getPets().get(j).isIn()) {
                            System.out.println(count + " " + owners.get(i).getPets().get(j).getName());
                            count++;
                        }
                    }
                }
                System.out.println(petsInSpa(owners));
                System.out.print("which dog:");
                count = kb.nextInt();
                boolean f = false;
                for (int i = 0; i < owners.size(); i++) {
                    for (int j = 0; j < owners.get(i).getPets().size(); j++) {
                        if (owners.get(i).getPets().get(j).isIn()) {
                            if (count == 0 && !f) {
                                owners.get(i).getPets().get(j).setIn(false);
                                f = true;
                            } else {
                                count--;
                            }
                        }
                    }
                }
                System.out.println(petsInSpa(owners));
            } else if (ans == 3) {
                int count = 0;
                System.out.print(printPets(owners));
                System.out.print("which dog:");
                count = kb.nextInt();
                boolean f = false;
                for (int i = 0; i < owners.size(); i++) {
                    for (int j = 0; j < owners.get(i).getPets().size(); j++) {
                        if (owners.get(i).getPets().get(j).isIn()) {
                            if (count == 0 && !f) {
                                owners.get(i).getPets().get(j).setClean(true);
                                owners.get(i).setBill(249.99);
                                f = true;
                            } else {
                                count--;
                            }
                        }
                    }
                }
                System.out.println(petsInSpa(owners));
            } else if (ans == 4) {
                int count = 0;
                System.out.print(printPets(owners));
                System.out.print("which dog:");
                count = kb.nextInt();
                boolean f = false;
                for (int i = 0; i < owners.size(); i++) {
                    for (int j = 0; j < owners.get(i).getPets().size(); j++) {
                        if (owners.get(i).getPets().get(j).isIn()) {
                            if (count == 0 && !f) {
                                owners.get(i).getPets().get(j).setTrim(false);
                                owners.get(i).setBill(327.50);
                                f = true;
                            } else {
                                count--;
                            }
                        }
                    }
                }
                System.out.println(petsInSpa(owners));
            } else if (ans == 5) {
                System.out.println(petsInSpa(owners));

            } else if (ans == 6) {
                for (int i = 0; i < owners.size(); i++) {
                    System.out.println(owners.get(i));
                }            System.out.println(petsInSpa(owners));
            } else if (ans == 7) {
                System.out.print("Name: ");
                String name = kb.next();
                kb.nextLine();
                System.out.print("number: ");
                String number = kb.nextLine();
                System.out.print("address: ");
                String address = kb.nextLine();
                owners.add(new Owners(name, number, address));
                System.out.print("number of pets");
                int num = kb.nextInt();
                for (int i = 0; i < num; i++) {
                    System.out.print("pet name");
                    name = kb.next();
                    System.out.print("age:");
                    int age = kb.nextInt();
                    owners.get(owners.size() - 1).setPets(name, age);

                }
                System.out.println(petsInSpa(owners));
            } else if (ans == 8) {
                stopper = true;
            }


        }
    }

    public static String printOwners(ArrayList<Owners> o) {
        String ans = "";
        for (int i = 0; i < o.size(); i++) {
            ans += i + " " + o.get(i).getName() + "\n";
        }
        return ans;
    }

    public static String printPets(ArrayList<Owners> o) {
        String ans = "";
        int count = 0;
        for (int i = 0; i < o.size(); i++) {
            for (int j = 0; j < o.get(i).getPets().size(); j++) {
                if (o.get(i).getPets().get(j).isIn()) {
                    ans += count + " " + o.get(i).getPets().get(j).getName() + "\n";
                    count++;
                }
            }
        }
        return ans;
    }

    public static String petsInSpa(ArrayList<Owners> owners) {
        String ans = "Pet spa guest\n";
        for (int i = 0; i < owners.size(); i++) {
            for (int j = 0; j < owners.get(i).getPets().size(); j++) {
                if (owners.get(i).getPets().get(j).isIn()) {
                    ans += owners.get(i).getPets().get(j) + "\n";
                    // count++;
                }
            }
        }
        return ans;
    }
}