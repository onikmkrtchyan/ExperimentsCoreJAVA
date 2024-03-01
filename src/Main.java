class Animal {
    // Method to feed an animal
    public void feed() {
        System.out.println("Feeding the animal");
    }
}

class Cat extends Animal {
    // Method to feed a cat
    public void feed() {
        System.out.println("Feeding the cat");
    }
}

//class BengalCat extends Cat {
//    // Method to feed a Bengal cat
//    public void feed(BengalCat bengalCat) {
//        System.out.println("Feeding the Bengal cat");
//    }
//}

public class Main {

    public static void main(String[] args) {
        Animal genericAnimal = new Animal();
        Cat genericCat = new Cat();

//        BengalCat bengalCat = new BengalCat();
//
//        // Case 1: Good - Covariance
//        Animal animalReference = bengalCat; // Allowed, because BengalCat is a subclass of Cat
//        animalReference.feed(genericAnimal); // Calls Cat's feed method
//        animalReference.feed(genericCat);    // Calls Cat's feed method
//        animalReference.feed(bengalCat);     // Calls BengalCat's feed method

        // Case 2: Bad - Contravariance
//        genericCat.feed(genericAnimal); // Calls Cat's feed method
//        genericCat.feed(genericCat);    // Calls Cat's feed method
//        catReference.feed(bengalCat);     // Calls Cat's feed method, not BengalCat's

//        // Case 3: Bad - Covariance with explicit type
//        BengalCat bengalCatReference = new BengalCat();
//        Animal animalReference2 = (Animal) bengalCatReference; // Allowed, but can lead to issues
//        animalReference2.feed(genericAnimal); // Calls Cat's feed method
//        animalReference2.feed(genericCat);    // Calls Cat's feed method
//        animalReference2.feed(bengalCat);     // Calls BengalCat's feed method

        // Conclusion: It's important to understand and use covariance and contravariance carefully to avoid unexpected behavior.
    }
}
