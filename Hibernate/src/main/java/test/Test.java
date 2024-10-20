package test;

import entities.Machine;
import entities.Salle;
import services.MachineService;
import services.SalleService;

import java.util.Date;

public class Test {

    public static void main(String[] args) {

        SalleService salleService = new SalleService();
        MachineService machineService = new MachineService();

        //Création et insertion de salles
        Salle s1 = new Salle("C11");
        Salle s2 = new Salle("D12");
      //  salleService.create(s1);
     //   salleService.create(s2);

        //Création et insertion de machines
        Machine M1 = new Machine("Zer145",new Date(),salleService.findById(1));
        Machine M2 = new Machine("QA987",new Date(),salleService.findById(2));
       // machineService.create(M1);
      //  machineService.create(M2);

        // Affichage des salles et leurs machines
        System.out.println("***** Les codes des Salles *****");
      for(Salle salle : salleService.findAll()){
            System.out.println("Le code de la Salle: " + salle.getCode());
          System.out.println("***** Les references des Machines *****");
            for(Machine machine : salle.getMachines()){
                System.out.println("La reference de la Machine: " + machine.getRef());
            }
        }

        //Utlisation de la méthode findBetweenDate
        Date d1= new Date(110,0,1);
        Date d2 = new Date();
        System.out.println("Machine achetées entre "+d1+" et "+d2+" :");
        for(Machine m : machineService.findBetweenDate(d1,d2)){
            System.out.println(m.getRef()+" achetée le "+m.getDateAchat());
        }



    }






}
