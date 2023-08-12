package DesignPatterns.strategy;

interface Strategy {
    void move();
}

class RandomStrategy implements Strategy {
    @Override
    public void move() {
        System.out.println("Move the enemy randomly.");
    }
}

class PathfindingStrategy implements Strategy {
    @Override
    public void move() {
        System.out.println("Find the shortest path to the player and move the enemy along that path.");
    }
}

class SwarmStrategy implements Strategy {
    @Override
    public void move() {
        System.out.println("Move the enemy as part of a swarm.");
    }
}

class Enemy {
    private final Strategy strategy;

    public Enemy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void move() {
        strategy.move();
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        Enemy enemy = new Enemy(new RandomStrategy());
        enemy.move();

        enemy = new Enemy(new PathfindingStrategy());
        enemy.move();

        enemy = new Enemy(new SwarmStrategy());
        enemy.move();

        // This also same result, but we can't change object dynamic (this is just interface)
        Strategy strategy = new RandomStrategy();
        strategy.move();

        strategy = new PathfindingStrategy();
        strategy.move();

        strategy = new SwarmStrategy();
        strategy.move();
    }
}
