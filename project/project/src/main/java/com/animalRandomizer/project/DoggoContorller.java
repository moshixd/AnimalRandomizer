package com.animalRandomizer.project;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DoggoContorller {

    public static Dog dog;
    static int counter = 0;

    @ResponseBody
    @GetMapping("/generateRandomDog")
    public Dog dog(){

        counter++;
        Dog[] dogs = getDogs();
        // Skapar array of objects (hundar).

        int randomNumber = getRandomNumber();

        for (int i = 0; i < 10; i++) {
            if(dogs[i].id == randomNumber) {
                return dogs[i];
            }
        };
        // forloop för att matcha random nummer med id till rätt hund.

        return dogs[0];
        // default hun om inget matchas.
    }

    private Dog[] getDogs() {
        Dog dogObjects[] = new Dog[10];

        Dog amazingDog = new Dog(1, "https://images.unsplash.com/photo-1571772805064-207c8435df79?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=737&q=80",  "Amazing dog","This dog is amazing", counter );
        Dog blingblingDog = new Dog(2, "https://images.unsplash.com/photo-1598133894008-61f7fdb8cc3a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=688&q=80",  "Bling bling dog","This dog is fabolus", counter );
        Dog casanovaDog = new Dog(3, "https://images.unsplash.com/photo-1552053831-71594a27632d?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=662&q=80", "Casanova","This dog is romantic", counter );
        Dog pajamasDog = new Dog(4, "https://images.unsplash.com/photo-1583511655826-05700d52f4d9?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=688&q=80",  "Pyjamas dog","This dog is ready for bedd", counter );
        Dog pitbull = new Dog(5, "https://images.unsplash.com/photo-1600369671738-fa3a43efeced?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=764&q=80",  "Pitbull puppy","This dog is amazing", counter );
        Dog puppy = new Dog(6, "https://images.unsplash.com/photo-1537151625747-768eb6cf92b2?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=685&q=80",  "Puppy","This dog is amazing", counter );
        Dog siberianhusky = new Dog(7, "https://images.unsplash.com/photo-1563889362352-b0492c224f62?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=687&q=80",  "Siberian husky","This dog is amazing", counter );
        Dog studyDog = new Dog(8, "https://images.unsplash.com/photo-1535930749574-1399327ce78f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=736&q=80",  "Study dog","This dog is amazing", counter );
        Dog sussDog = new Dog(9, "https://images.unsplash.com/photo-1575425186775-b8de9a427e67?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80",  "What up dog","This dog is amazing", counter );
        Dog vacationDog = new Dog(10, "https://images.unsplash.com/photo-1565708097881-bbf4ecf47cc1?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1974&q=80",  "Pool side dog","This dog is amazing", counter );

        dogObjects[0] = amazingDog;
        dogObjects[1] = blingblingDog;
        dogObjects[2] = casanovaDog;
        dogObjects[3] = pajamasDog;
        dogObjects[4] = pitbull;
        dogObjects[5] = puppy;
        dogObjects[6] = siberianhusky;
        dogObjects[7] = studyDog;
        dogObjects[8] = sussDog;
        dogObjects[9] = vacationDog;

        return dogObjects;
        // en array av hundobjekt med deras egenskaper.
    };

    @GetMapping(value="/dogRandomizer")
    public String displayPage() {
        return "generateRandomDog";
    };
    // returnerar generateRandomDog.html.

    public int getRandomNumber() {
        int max = 10;
        int min = 1;
        int range = max - min + 1;

        int randomNumber = 0;
        for (int i = 0; i < 10; i++) {
            randomNumber = (int) (Math.random() * range) + min;

        };
        return randomNumber;
    };
    // Randomizer metod som slumpar en siffra mellan 1-10.
}