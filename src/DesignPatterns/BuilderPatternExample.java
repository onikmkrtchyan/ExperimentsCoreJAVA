package DesignPatterns;

// Step 1: Product Class
class House {
    private int rooms;
    private int bathrooms;
    private boolean hasGarage;
    private boolean hasGarden;
    private boolean hasSwimmingPool;

    private House() {
    }

    // Private constructor to prevent direct instantiation
    private House(HouseBuilder builder) {
        this.rooms = builder.rooms;
        this.bathrooms = builder.bathrooms;
        this.hasGarage = builder.hasGarage;
        this.hasGarden = builder.hasGarden;
        this.hasSwimmingPool = builder.hasSwimmingPool;
    }

    public static House builder() {
        return new House();
    }

    public House setRooms(int rooms) {
        this.rooms = rooms;
        return this;
    }

    public House setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
        return this;
    }

    public House setGarage(boolean hasGarage) {
        this.hasGarage = hasGarage;
        return this;
    }

    public House setGarden(boolean hasGarden) {
        this.hasGarden = hasGarden;
        return this;
    }

    public House setSwimmingPool(boolean hasSwimmingPool) {
        this.hasSwimmingPool = hasSwimmingPool;
        return this;
    }

    @Override
    public String toString() {
        return "DesignPatterns.House with " + rooms + " rooms, " + bathrooms + " bathrooms, " +
                (hasGarage ? "Garage, " : "No Garage, ") +
                (hasGarden ? "Garden, " : "No Garden, ") +
                (hasSwimmingPool ? "Swimming Pool" : "No Swimming Pool");
    }

    // Step 2: Builder Class
    public static class HouseBuilder {
        private int rooms;
        private int bathrooms;
        private boolean hasGarage;
        private boolean hasGarden;
        private boolean hasSwimmingPool;

        // Setters for optional fields, returning the builder for chaining
        public HouseBuilder setRooms(int rooms) {
            this.rooms = rooms;
            return this;
        }

        public HouseBuilder setBathrooms(int bathrooms) {
            this.bathrooms = bathrooms;
            return this;
        }

        public HouseBuilder setGarage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this;
        }

        public HouseBuilder setGarden(boolean hasGarden) {
            this.hasGarden = hasGarden;
            return this;
        }

        public HouseBuilder setSwimmingPool(boolean hasSwimmingPool) {
            this.hasSwimmingPool = hasSwimmingPool;
            return this;
        }

        // Build method to create the final DesignPatterns.House object
        public House build() {
            return new House(this);
        }
    }
}

// Client Code
public class BuilderPatternExample {
    public static void main(String[] args) {
        // Building a house with the builder
        House house1 = new House.HouseBuilder()
                .setRooms(3)
                .setBathrooms(2)
                .setGarage(true)
                .setGarden(true)
                .setSwimmingPool(false).build();

        System.out.println(house1); // Output: DesignPatterns.House with 3 rooms, 2 bathrooms, Garage, Garden, No Swimming Pool

        // Building another house with different attributes
        House house2 = new House.HouseBuilder()
                .setRooms(5)
                .setBathrooms(4)
                .setGarage(true)
                .setSwimmingPool(true)
                .build();

        System.out.println(house2); // Output: DesignPatterns.House with 5 rooms, 4 bathrooms, Garage, No Garden, Swimming Pool

        // Building a house with static builder method
        House house3 = House.builder()
                .setRooms(2)
                .setBathrooms(1)
                .setGarage(false)
                .setGarden(true)
                .setSwimmingPool(false);

        System.out.println(house3); // Output: DesignPatterns.House with 2 rooms, 1 bathrooms, No Garage, Garden, No Swimming Pool
    }
}
