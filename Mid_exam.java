import java.util.ArrayList;
import java.util.Scanner;

public class Mid_exam {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int chs, acc,gaji,pr;
        String name, username, pass;
        int chs2, chs3, temp = 0;
        String deks,tanggal,metode,c;
        String Y = "Yes";


        // Database 
        ArrayList<admin> Dlist = new ArrayList<>();
        ArrayList<clients> Clist = new ArrayList<>();
        ArrayList<freelancer> Flist = new ArrayList<>();
        ArrayList<project> Nproject = new ArrayList<>();
        ArrayList<project> Tproject = new ArrayList<>();

        // Contoh List database
        Dlist.add(new admin("Arvyn","Arvyn66","123123")); // akun admin
        Clist.add(new clients("Budi","Budi11","7654321")); // akun client
        Flist.add(new freelancer("Sophia","Rumah321","Sophia3")); // akun freelancer
        Nproject.add(new project("project 23", "12-03-2022", "Paypal", 1000000)); // list new project
        Tproject.add(new project("Budi", "membuat list", "01-01-2022", "Gopay", 400000)); // list project taken

        do{
            // menu masuk/pendaftaran
            System.out.println("");
            System.out.println("Menu");
            System.out.println("1. Login");
            System.out.println("2. Sign in");
            System.out.printf(">>> ");

            chs = input.nextInt();
            switch (chs){
                // masuk akun
                case 1:
                System.out.println("\nChoose Account");
                System.out.println("1. Admin");
                System.out.println("2. Clients");
                System.out.println("3. Freelancer");
                System.out.println("0. quit ");
                System.out.printf(">>> ");
                acc = input.nextInt();
                // akun admin
                if(acc == 1){
                    System.out.printf("masukan username : ");
                    username = input.next();
                    System.out.printf("masukan password : ");
                    pass = input.next();
                    for(int i=0;i<Dlist.size();i++){
                        if(username.equals(Dlist.get(i).getUname()))
                            if(pass.equals(Dlist.get(i).getPass())){
                                do{
                                    // hal-hal yang bisa dilakukan oleh admin
                                    System.out.println("\n====== Welcome =====");
                                    System.out.println("1. Available list");
                                    System.out.println("2. Remove ");
                                    System.out.println("0. quit ");
                                    System.out.printf(">>> ");
                                    chs2 = input.nextInt();
                                    switch(chs2){
                                        case 1:
                                        // List data dari Clients, Freelancer, Project yang tersedia
                                        System.out.println("List Clients:");
                                        if(Clist.size() == 0){
                                            System.out.println("Null\n");
                                        }else{
                                            for(clients cli :Clist){
                                                cli.display();
                                            }
                                        }
                                        System.out.println(" ");
                                        System.out.println("List Freelancer:");
                                        if(Flist.size() == 0){
                                            System.out.println("Null\n");
                                        }else{
                                            for(freelancer frl :Flist){
                                                frl.display();
                                            }
                                        }

                                        System.out.println(" ");
                                        System.out.println("List Project:");
                                        if(Nproject.size() == 0){
                                            System.out.println("Null\n");
                                        }else{
                                            for(project prj :Nproject){
                                                prj.display();
                                            }
                                        }
                                        break;

                                        case 2:
                                        // admin bisa memilih List data yang akan dihapus
                                        System.out.println(" ");
                                        System.out.println("1. Remove CLients");
                                        System.out.println("2. Remove Freelancer");
                                        System.out.println("3. Remove Project");
                                        System.out.printf(">>> ");
                                        chs3 = input.nextInt();
                                        if(chs3 == 1){
                                            System.out.printf("Tuliskan nama Clients : ");
                                            input.nextLine();
                                            name = input.nextLine();
                                            clients r = null;
                                            for(clients cli :Clist){
                                                if(name.equals(cli.getName())){
                                                    r = cli;
                                                    System.out.println("Clients berhasil dihapus");
                                                    temp = 1;
                                                    break;
                                                    
                                                }
                                            }
                                            Clist.remove(r);
                                            if(temp != 1){
                                                System.out.println("Nama Client tidak dapat ditemukan");
                                            }
                                        }else if(chs3 == 2){
                                            System.out.printf("Tuliskan nama Freelancer : ");
                                            input.nextLine();
                                            name = input.nextLine();
                                            freelancer r1 = null;
                                            for(freelancer frl :Flist){
                                                if(name.equals(frl.getName())){
                                                    r1 = frl;
                                                    System.out.println("Freelancer berhasil dihapus");
                                                    temp = 2;
                                                }
                                            }
                                            Flist.remove(r1);
                                            if(temp != 2){
                                                System.out.println("Nama Freelancer tidak dapat ditemukan");
                                            }
                                        }else if(chs3 == 3){
                                            System.out.printf("Pilih project berapa : ");
                                            pr = input.nextInt();
                                            pr -= 1;
                                            if(pr > Nproject.size() || pr < 0){
                                                System.out.println("Project tidak ada");
                                            }else{
                                                Nproject.remove(pr);
                                                System.out.println("Project berhasil dihapus");
                                            }
                                        }
                                        break;
                                    } 
                                }while(chs2 != 0);
                        }
                    }
                
                // Akun Clients
                }else if(acc == 2){
                    System.out.printf("masukan username : ");
                    username = input.next();
                    System.out.printf("masukan password : ");
                    pass = input.next();
                    for(clients cli :Clist){
                        if(username.equals(cli.getUname()))
                            if(pass.equals(cli.getPass())){
                                do{
                                    //hal-hal yang bisa dilakukan oleh seorang client
                                    System.out.println("\n====== Welcome =====");
                                    System.out.println("1. Add new project");
                                    System.out.println("2. List project");
                                    System.out.println("0. quit ");
                                    System.out.printf(">>> ");
                                    chs2 = input.nextInt();

                                    // menambahkan project ke dalam list untuk para freelancer
                                    if(chs2 == 1){
                                        System.out.printf("Deksripsi: ");
                                        input.nextLine();
                                        deks = input.nextLine(); 
                                        System.out.printf("Tenggat Waktu: ");
                                        tanggal = input.next();
                                        System.out.printf("Metode Pembayaran: ");
                                        input.nextLine();
                                        metode = input.nextLine();
                                        System.out.printf("Biaya/Fee: ");
                                        gaji = input.nextInt();
                                        System.out.printf("Apakah anda yakin upload project ini ? (Yes/No) ");
                                        input.nextLine();
                                        c = input.next();
                                        if(c.equals(Y)){
                                            Nproject.add(new project(deks, tanggal, metode, gaji));
                                            System.out.println("Project berhasil di upload");
                                        }
                                    
                                    // melihat list project yang ada
                                    }else if(chs2 == 2){
                                        int j = 1;
                                        System.out.println(" ");
                                        System.out.println("List Project:");
                                        if(Nproject.size() == 0){
                                            System.out.println("Null\n");
                                        }
                                        for(project prj :Nproject){
                                            System.out.println("Project ke-" + j);
                                            prj.display();
                                            j++;
                                        }
                                    }
                                }while(chs2 != 0);
                        }
                    }
                
                // akun freelancer
                }else if(acc == 3){
                    System.out.printf("masukan username : ");
                    username = input.next();
                    System.out.printf("masukan password : ");
                    pass = input.next();
                    for(freelancer fli :Flist){
                        if(username.equals(fli.getUname()))
                            if(pass.equals(fli.getPass())){
                                do{
                                    // hal-hal yang bisa dilakukan oleh freelancer
                                    System.out.println("\n====== Welcome =====");
                                    System.out.println("1. Take project");
                                    System.out.println("2. Available project");
                                    System.out.println("3. List Project taken");
                                    System.out.println("0. quit ");
                                    System.out.printf(">>> ");
                                    chs2 = input.nextInt();
                                    // mengambil project yang ada
                                    if(chs2 == 1){
                                        System.out.printf("Pilih project berapa : ");
                                        pr = input.nextInt();
                                        pr -= 1;
                                        if(pr >= Nproject.size() || pr < 0){
                                            System.out.println("Project tidak tersedia\n");
                                        }else{
                                            Tproject.add(new project(fli.getName(), Nproject.get(pr).getDeks(), Nproject.get(pr).getTanggal(), Nproject.get(pr).getMetode(), Nproject.get(pr).getGaji()));
                                            System.out.println("Project berhasil diambil");
                                            Nproject.remove(pr);
                                        }
                                    // melihat isi list yang masih bisa dikerjakan
                                    }else if(chs2 == 2){
                                        int i = 1;
                                        System.out.println(" ");
                                        System.out.println("List Project:");
                                        if(Nproject.size() == 0){
                                            System.out.println("Null\n");
                                        }else{
                                            for(project prj :Nproject){
                                                System.out.println("Project ke-" + i);
                                                prj.display();
                                                i++;
                                            }
                                        }
                                    // melihat isi list orang-orang yang sudah mengerjakan list tersebut
                                    }else if(chs2 == 3){
                                        int n = 1;
                                        System.out.println(" ");
                                        System.out.println("List Project:");
                                        if(Tproject.size() == 0){
                                            System.out.println("Null\n");
                                        }else{
                                            for(project prj :Tproject){
                                                System.out.println("Project: " + n);
                                                prj.display2();
                                                n++;
                                            }
                                        }
                                    }
                                }while(chs2 != 0);
                        }
                    }
                }
                break;
                
                // membuat akun baru
                case 2:
                do{
                System.out.println("");
                System.out.println("Anda Segabai : ");
                System.out.println("1. Clients");
                System.out.println("2. Freelancer");
                System.out.println("0. quit");
                System.out.printf(">>> ");
                acc = input.nextInt();
                    switch (acc){
                        // membuat akun client
                        case 1:
                        System.out.printf("Masukan nama anda: ");
                        input.nextLine();
                        name = input.nextLine();
                        System.out.printf("Buat username: ");
                        username = input.next();
                        System.out.printf("Buat password: ");
                        pass = input.next();
                        System.out.printf("Apakah anda yakin membuat akun ini ? (Yes/No) ");
                        c = input.next();
                        if(c.equals(Y)){
                            Clist.add(new clients(name, username, pass));
                            System.out.println("Akun anda telah berhasil dibuat, silahkan coba login");
                        }else{

                        }
                        break;

                        // membuat akun freelancer
                        case 2:
                        System.out.printf("Masukan nama anda: ");
                        input.nextLine();
                        name = input.nextLine();
                        System.out.printf("Buat username: ");
                        username = input.next();
                        System.out.printf("Buat password: ");
                        pass = input.next();
                        System.out.printf("Apakah anda yakin membuat akun ini ? (Yes/No) ");
                        c = input.next();
                        if(c.equals(Y)){
                            Flist.add(new freelancer(name, username, pass));
                            System.out.println("Akun anda telah berhasil dibuat, silahkan coba login");

                        }
                        break;
                    }
                }while(acc != 0);
                break;
            }
        }while(chs != 0);
        input.close();
    }
}

