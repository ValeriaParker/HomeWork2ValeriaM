package com.company;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;
import java.util.Random;
import java.util.Arrays;


public class Car implements CarNames, CarMoves {
    private String carName;
    private String model;
    private int carYear;
    private int doors;
    private double engineVolume;

    public void goAhead() {
        System.out.println(" Go ahead ");
    }

    public void goBack() {
        System.out.println(" Go back ");
    }

    public void rightTurn() {
        System.out.println(" Right turn ");
    }

    public void leftTurn() {
        System.out.println(" Left turn ");
    }

    public void stop() {
        System.out.println(" Stop ");
    }


    public Car() {
        this.carName = names[(int) (Math.random() * names.length)];
        this.model = "X5";
        this.carYear = 2020;
        this.doors = 4;
        this.engineVolume = 1.6;
    }

    public Car(String carName, String model, int carYear, int doors, double engineVolume) {
        this.carName = carName;
        this.model = model;
        this.carYear = carYear;
        this.doors = doors;
        this.engineVolume = engineVolume;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCarYear() {
        return carYear;
    }

    public void setCarYear(int carYear) {
        this.carYear = carYear;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", model='" + model + '\'' +
                ", carYear=" + carYear +
                ", doors=" + doors +
                ", engineVolume=" + engineVolume +
                '}';
    }

    //@Override
    public boolean equals(Car o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        //Car car = (Car) o;
        return getCarYear() == o.getCarYear() && getDoors() == o.getDoors() && Double.compare(o.getEngineVolume(), getEngineVolume()) == 0 &&
                getCarName().equals(o.getCarName()) && getModel().equals(o.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCarName(), getModel(), getCarYear(), getDoors(), getEngineVolume());
    }
}

class SortByName implements Comparator<Car> {
    public int compare(Car a, Car b) {
        return a.getCarName().compareToIgnoreCase(b.getCarName());
    }
}

/*class SortByYear implements Comparator<Car>{
    public int compare(Car a, Car b){
        return a.getCarYear() - b.getCarYear();
    }
}*/
class SortByYearReverse implements Comparator<Car> {
    public int compare(Car a, Car b) {
        return b.getCarYear() - a.getCarYear();
    }
}


class Main {
    public static void main(String[] args) {
        Car[] cars = CarUtil.generateCars(5);
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i]);
        }
        System.out.println(" ");
        int number = (int) (Math.random() * CarNames.names.length);
        Car car1 = new Car(CarNames.names[number], "X5", 2010, 4, 3.0);
        System.out.println(car1);
        System.out.println();
        Arrays.sort(cars, new SortByName());
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i]);
        }
        System.out.println();
        cars[2].setCarYear(2010);
        //Arrays.sort(cars, new SortByYear());
        Arrays.sort(cars, new SortByYearReverse());
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i]);
        }
        CarMoves m1 = car1;
        m1.goAhead();
    }
}