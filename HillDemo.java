class Hillstations {
    void famousfor() {
        System.out.println("Famous for scenic beauty");
    }

    void famousfood() {
        System.out.println("Famous food varies by location");
    }
}

// Subclass 1
class Manali extends Hillstations {
    void famousfor() {
        System.out.println("Manali is famous for snow and adventure sports");
    }

    void famousfood() {
        System.out.println("Manali is famous for Siddu");
    }
}

// Subclass 2
class Mussoorie extends Hillstations {
    void famousfor() {
        System.out.println("Mussoorie is famous for hills and waterfalls");
    }

    void famousfood() {
        System.out.println("Mussoorie is famous for Momos");
    }
}

// Subclass 3
class Darjeeling extends Hillstations {
    void famousfor() {
        System.out.println("Darjeeling is famous for tea gardens");
    }

    void famousfood() {
        System.out.println("Darjeeling is famous for Thukpa");
    }
}

class HillDemo {
    public static void main(String[] args) {

        Hillstations h;

        // Runtime Polymorphism
        h = new Manali();
        h.famousfor();
        h.famousfood();

        System.out.println();

        h = new Mussoorie();
        h.famousfor();
        h.famousfood();

        System.out.println();

        h = new Darjeeling();
        h.famousfor();
        h.famousfood();
    }
}